package compiler;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import compiler.result.Result;
import compiler.result.Scope;

import grammar.lyBaseVisitor;
import grammar.lyParser;

import iloc.Simulator;
import iloc.model.Label;
import iloc.model.Num;
import iloc.model.Op;
import iloc.model.OpCode;
import iloc.model.Operand;
import iloc.model.Program;
import iloc.model.Reg;
import iloc.model.Str;

/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends lyBaseVisitor<Op> {
	/** The representation of the boolean value <code>false</code>. */
	public final static Num FALSE_VALUE = new iloc.model.Num(Simulator.FALSE);
	/** The representation of the boolean value <code>true</code>. */
	public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

	/** The base register. */
	private Reg arp = new Reg("r_arp");
	/** The outcome of the checker phase. */
	private Result checkResult;
	/** Association of statement nodes to labels. */
	private ParseTreeProperty<Label> labels;
	/** The program being built. */
	private Program prog;
	/** Register count, used to generate fresh registers. */
	private int regCount;
	/** Association of expression and target nodes to registers. */
	private ParseTreeProperty<Reg> regs;
	private Stack<Reg> emptyRegs;
	private Map<String, Reg> varRegs;
	/** The current scope **/
	private Scope scope;

	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		
		//TODO: Remove this (debugging);
		scope = new Scope();
		
		this.regs = new ParseTreeProperty<>();
		this.emptyRegs = new Stack<Reg>();
		this.varRegs = new HashMap<String, Reg>();
		
		this.labels = new ParseTreeProperty<>();
		this.regCount = 0;
		tree.accept(this);
		return this.prog;
	}	
	
	/* Function Related */
	/*
	 * METHOD CALL
	 */
	/*@Override public Op visitFuncExpr(lyParser.FuncExprContext ctx) { 
		Label call = createMethodLabel(ctx.ID().getText());
		Label back = createLabel(ctx, "return");
		
		Reg[] regBack = reserveRegs(1);
		Op opBack = emit(OpCode.loadI, new Num(-1), regBack[0]);
		emit(OpCode.push, regBack[0]);
		forgetRegs(regBack);
		
		if(this.scope.inFunction()) {
			pushFunction
		}
		
		//stack.push
		Parameter[] params = this.checkResult.getParameters(ctx);
		System.out.println(Arrays.toString(params));
		for(int i = 0; i < ctx.expr().size(); i++) {
			if(params[i].isReference()) {
				System.out.println("Thingie is reference!");
				Reg[] reg = reserveRegs(1);
				visit(ctx.expr(i));
				emit(OpCode.load, regs.get(ctx.expr(i)), reg[0]);
				emit(OpCode.push, reg[0]);
				forgetRegs(reg);
			}
			else {
				visit(ctx.expr(i));
				Reg toStack = this.regs.get(ctx.expr(i));
				emit(OpCode.push, toStack);
				forgetReg(ctx.expr(i));
			}
		}
		
		emit(OpCode.jumpI, call);
		
		if(this.checkResult.getType(ctx) != Type.VOID)
			emit(back, OpCode.pop, reserveReg(ctx));
		else
			emit(back, OpCode.nop);
		
		System.out.println(this.prog.prettyPrint());
		
		opBack.getArgs().remove(0);
		opBack.getArgs().add(0, new Num(prog.getLine(back)));		
		
		return null;
	}*/
	
	/* Compound */
	@Override public Op visitCompoundExpr(lyParser.CompoundExprContext ctx) { 
		visitChildren(ctx);
		if(ctx.expr() != null) {
			regs.put(ctx, regs.get(ctx.expr()));
		}		
		return null;
	}
	
	/* Declaration */
	@Override public Op visitDecl(lyParser.DeclContext ctx) {	
		if(scope.inFunction()) {
			for(int i = 0; i < ctx.declpart().size(); i++) {
				if(ctx.declpart(i).expr() != null) {
					visit(ctx.declpart(i).expr());
					Reg expr = this.regs.get(ctx.declpart(i).expr());
					emit(OpCode.i2i, expr, reg(ctx.declpart(i).ID().getText()));
					forgetReg(ctx.declpart(i).expr());
				}
				else
					emit(OpCode.loadI, new Num(0), reg(ctx.declpart(i).ID().getText()));
			}
		}
		else {
			for(int i = 0; i < ctx.declpart().size(); i++) {
				if(ctx.declpart(i).expr() != null) {
					visit(ctx.declpart(i).expr());
					Reg expr = this.regs.get(ctx.declpart(i).expr());
					System.out.println("reg: " + expr.getName());
					System.out.println("offset: " + offset(ctx.declpart(i)));
					emit(OpCode.storeAI, expr, arp, offset(ctx.declpart(i)));
					forgetReg(ctx.declpart(i).expr());
				}
				else
					emit(OpCode.storeAI, arp, arp, offset(ctx.declpart(i)));
			}
		}
		
		return null;
	}
	
	/* Assigment expression */
	@Override public Op visitAssStat(lyParser.AssStatContext ctx) { 
		visit(ctx.expr());
		
		Reg result = regs.get(ctx.expr());		
		if(this.scope.inFunction()) {
			Reg var = reg(ctx.ID().getText());			
			emit(OpCode.i2i, result, var);			
		}
		else {
			emit(OpCode.storeAI, result, arp, offset(ctx));
		}
		this.regs.put(ctx, result);
				
		return null;
	}
	
	/* If Else expression */
	@Override public Op visitIfStat(lyParser.IfStatContext ctx) {
		Label thenL = createLabel(ctx, "then");
		Label elseL = createLabel(ctx, "else");
		Label end	= createLabel(ctx, "end");
		Reg resultReg = null;
		if(checkResult.getType(ctx) != null)
			resultReg = reserveReg(ctx);
		
		visit(ctx.expr(0));
		
		if(ctx.ELSE() != null)
			emit(OpCode.cbr, this.regs.get(ctx.expr(0)), thenL, elseL);
		else
			emit(OpCode.cbr, this.regs.get(ctx.expr(0)), thenL, end);
		forgetReg(ctx.expr(0));
		
		
		int lastInstr = this.prog.getInstr().size();
		visit(ctx.expr(1));
		if(resultReg != null)
			emit(OpCode.i2i, regs.get(ctx.expr(1)), resultReg);
		forgetReg(ctx.expr(1));
		this.prog.getInstr().get(lastInstr).setLabel(thenL);
		
		emit(OpCode.jumpI, end);
		
		if(ctx.ELSE() != null) {
			lastInstr = this.prog.getInstr().size();
			visit(ctx.expr(2));
			if(resultReg != null)
				emit(OpCode.i2i, regs.get(ctx.expr(2)), resultReg);
			forgetReg(ctx.expr(2));
			this.prog.getInstr().get(lastInstr).setLabel(elseL);
		}
		
		emit(end, OpCode.nop);
		
		//return new Op(end, OpCode.nop);
		return null;
	}
	
	/* While Expression */
	@Override public Op visitWhileStat(lyParser.WhileStatContext ctx) {
		Label start = createLabel(ctx, "start");
		Label body = createLabel(ctx, "body");
		Label end = createLabel(ctx, "end");
		int labelInstr = this.prog.getInstr().size();
				
		//emit(start, OpCode.nop);
		visit(ctx.expr(0));	
		this.prog.getInstr().get(labelInstr).setLabel(start);
		emit(OpCode.cbr, this.regs.get(ctx.expr(0)), body, end);
		forgetReg(ctx.expr(0));
		labelInstr = this.prog.getInstr().size();
		
		//emit(body, OpCode.nop);		
		
		visit(ctx.expr(1));
		this.prog.getInstr().get(labelInstr).setLabel(body);
		
		emit(OpCode.jumpI, start);
		emit(end, OpCode.nop);
		
		forgetReg(ctx.expr(1));		
		//return new Op(end, OpCode.nop);
		return null;
	}
	
	/* Print and Read */
	@Override public Op visitPrintStat(lyParser.PrintStatContext ctx) { 
		visitChildren(ctx);
		if(ctx.expr().size() > 1) {
			for(int i = 0; i < ctx.expr().size(); i++) {
				emit(OpCode.out, new Str(""), regs.get(ctx.expr(i)));
			}
		}
		else {
			emit(OpCode.out, new Str(""), regs.get(ctx.expr(0)));
			this.regs.put(ctx, reserveReg(ctx.expr(0)));
		}
		
		return null;
	}
	
	@Override public Op visitReadStat(lyParser.ReadStatContext ctx) {
		Reg regIn = reserveReg(ctx);
		for(int i = 0; i < ctx.ID().size(); i++) {
			emit(OpCode.in, new Str(""), regIn);
			emit(OpCode.storeAI, regIn, arp, offset(ctx.ID(i)));
		}
		return null;
	}
	
	/* Expressions which do literally nothing (generator wise) */
	@Override public Op visitParExpr(lyParser.ParExprContext ctx) { 
		visit(ctx.expr());
		regs.put(ctx, regs.get(ctx.expr()));
		return null;
	}
	
	/* Expression that require two other expressions */
	@Override public Op visitPlusExpr(lyParser.PlusExprContext ctx) {
		visitChildren(ctx);
		
		Reg resultReg = reserveReg(ctx);
		Reg expr1 = regs.get(ctx.expr(0));
		Reg expr2 = regs.get(ctx.expr(1));
		Op result = visit(ctx.plusOp());
		
		emit(result.getOpCode(), expr1, expr2, resultReg);
		
		forgetReg(ctx.expr(0));
		forgetReg(ctx.expr(1));
		return null;
	}
	
	@Override public Op visitMultExpr(lyParser.MultExprContext ctx) { 
		visitChildren(ctx);
		
		Reg resultReg = reserveReg(ctx);
		Reg expr1 = regs.get(ctx.expr(0));
		Reg expr2 = regs.get(ctx.expr(1));
		Op result = visit(ctx.multOp());
		
		emit(result.getOpCode(), expr1, expr2, resultReg);	
		
		forgetReg(ctx.expr(0));
		forgetReg(ctx.expr(1));
		
		return null;
	}
	
	@Override public Op visitCompExpr(lyParser.CompExprContext ctx) { 
		visitChildren(ctx);
		
		Reg resultReg = reserveReg(ctx);
		Reg expr1 = regs.get(ctx.expr(0));
		Reg expr2 = regs.get(ctx.expr(1));
		Op result = visit(ctx.compOp());

		emit(result.getOpCode(), expr1, expr2, resultReg);	
		
		forgetReg(ctx.expr(0));
		forgetReg(ctx.expr(1));
		
		return null;
	}
	
	@Override public Op visitPrfExpr(lyParser.PrfExprContext ctx) { 
		visitChildren(ctx);
		
		Reg resultReg = reserveReg(ctx);
		Reg expr = regs.get(ctx.expr());
		Op result = visit(ctx.prfOp());
		
		emit(result.getOpCode(), expr, result.getArgs().get(1), resultReg);
		
		forgetReg(ctx.expr());
		return null; 
	}
	
	@Override public Op visitBoolExpr(lyParser.BoolExprContext ctx) { 
		visitChildren(ctx);
		
		Reg resultReg = reserveReg(ctx);
		Reg expr1 = regs.get(ctx.expr(0));
		Reg expr2 = regs.get(ctx.expr(1));
		Op result = visit(ctx.boolOp());
		
		emit(result.getOpCode(), expr1, expr2, resultReg);
		
		forgetReg(ctx.expr(0));
		forgetReg(ctx.expr(1));
		return null;
	}	
	
	/* Expressions that finish */
	@Override public Op visitNumExpr(lyParser.NumExprContext ctx) { 
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), reserveReg(ctx));		
		return null;
	}
	
	@Override public Op visitCharExpr(lyParser.CharExprContext ctx) { 
		emit(OpCode.loadI, new Num((int)(ctx.CHR().getText().charAt(1))), reserveReg(ctx));		
		return null;
	}
	
	@Override public Op visitIdExpr(lyParser.IdExprContext ctx) { 		
		this.emit(OpCode.loadAI, arp, offset(ctx), reserveReg(ctx));
		return null;
	}
	
	@Override public Op visitFalseExpr(lyParser.FalseExprContext ctx) { 
		emit(OpCode.loadI, FALSE_VALUE, reserveReg(ctx));		
		return null;
	}
	
	@Override public Op visitTrueExpr(lyParser.TrueExprContext ctx) { 
		emit(OpCode.loadI, TRUE_VALUE, reserveReg(ctx));		
		return null;
	}
	
	/*
	 * OPERATORS
	 */
	
	@Override public Op visitPrfOp(lyParser.PrfOpContext ctx) { 
		Op result = null;
		
		if(ctx.MINUS() != null) 	result = new Op(OpCode.multI, Reg.empty, new Num(-1), Reg.empty);
		else if(ctx.NOT() != null) 	result = new Op(OpCode.xorI, Reg.empty, new Num(0), Reg.empty);
		
		return result;
	}

	@Override public Op visitMultOp(lyParser.MultOpContext ctx) { 
		Op result = null;	
		
		if(ctx.SLASH() != null) 	result = new Op(OpCode.div, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.STAR() != null)	result = new Op(OpCode.mult, Reg.empty, Reg.empty, Reg.empty);
		
		return result;
	}

	@Override public Op visitPlusOp(lyParser.PlusOpContext ctx) { 
		Op result = null;
		
		if(ctx.PLUS() != null) 			result = new Op(OpCode.add, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.MINUS() != null) 	result = new Op(OpCode.sub, Reg.empty, Reg.empty, Reg.empty);
		
		return result;
	}
	
	@Override public Op visitBoolOp(lyParser.BoolOpContext ctx) { 
		Op result = null;
		
		if(ctx.OR() != null) 		result = new Op(OpCode.or, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.AND() != null) 	result = new Op(OpCode.and, Reg.empty, Reg.empty, Reg.empty);
		
		return result;
	}
	
	@Override public Op visitCompOp(lyParser.CompOpContext ctx) {
		Op result = null;
		
		if(ctx.EQ() != null) 		result = new Op(OpCode.cmp_EQ, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.GE() != null) 	result = new Op(OpCode.cmp_GE, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.GT() != null) 	result = new Op(OpCode.cmp_GT, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.LE() != null) 	result = new Op(OpCode.cmp_GE, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.LT() != null) 	result = new Op(OpCode.cmp_LT, Reg.empty, Reg.empty, Reg.empty);
		else if(ctx.NE() != null) 	result = new Op(OpCode.cmp_NE, Reg.empty, Reg.empty, Reg.empty);
			
		return result;
	}

	// Override the visitor methods
	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(Label label, OpCode opCode, Operand... args) {
		Op result = new Op(label, opCode, args);
		this.prog.addInstr(result);
		return result;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(OpCode opCode, Operand... args) {
		return emit((Label) null, opCode, args);
	}

	/** 
	 * Looks up the label for a given parse tree node,
	 * creating it if none has been created before.
	 * The label is actually constructed from the entry node
	 * in the flow graph, as stored in the checker result.
	 */
	private Label label(ParserRuleContext node) {
		Label result = this.labels.get(node);
		if (result == null) {
			ParserRuleContext entry = this.checkResult.getEntry(node);
			result = createLabel(entry, "n");
			this.labels.put(node, result);
		}
		return result;
	}

	/** Creates a label for a given parse tree node and prefix. */
	private Label createLabel(ParserRuleContext node, String prefix) {
		Token token = node.getStart();
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		String result = prefix + "_" + line + "_" + column;
		return new Label(result);
	}

	/** Retrieves the offset of a variable node from the checker result,
	 * wrapped in a {@link Num} operand. */
	private Num offset(ParseTree node) {
		return new Num(this.checkResult.getOffset(node));
	}

	/** Returns a register for a given parse tree node,
	 * creating a fresh register if there is none for that node. */	
	private Reg reserveReg(ParseTree node) {
		Reg result = this.regs.get(node);
		if (result == null) {
			if(emptyRegs.empty()) {
				result = new Reg("r_" + this.regCount++);
				this.regs.put(node, result);
			}
			else {
				result = emptyRegs.pop();
				this.regs.put(node, result);
			}
		}		
		
		return result;
	}

	private void forgetReg(ParseTree node) {	
		Reg reg = this.regs.get(node);
		
		if(reg != null) {
			this.regs.removeFrom(node);
			this.emptyRegs.push(reg);
		}
	}
	
	private Reg reg(String id) {
		String name = this.scope.getName() + "_" + id;
		if(!this.varRegs.containsKey(name))
			this.varRegs.put(name, new Reg("r_" + name));
		return this.varRegs.get(name);
		
	}
}

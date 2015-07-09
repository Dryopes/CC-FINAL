package grammar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.stringtemplate.v4.compiler.Bytecode.OperandType;

import pp.block4.cc.iloc.CalcParser.MinusContext;
import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.block5.cc.pascal.SimplePascalParser.AssStatContext;
import pp.block5.cc.pascal.SimplePascalParser.BlockContext;
import pp.block5.cc.pascal.SimplePascalParser.BlockStatContext;
import pp.block5.cc.pascal.SimplePascalParser.BodyContext;
import pp.block5.cc.pascal.SimplePascalParser.BoolExprContext;
import pp.block5.cc.pascal.SimplePascalParser.BoolOpContext;
import pp.block5.cc.pascal.SimplePascalParser.BoolTypeContext;
import pp.block5.cc.pascal.SimplePascalParser.CompExprContext;
import pp.block5.cc.pascal.SimplePascalParser.CompOpContext;
import pp.block5.cc.pascal.SimplePascalParser.FalseExprContext;
import pp.block5.cc.pascal.SimplePascalParser.IdExprContext;
import pp.block5.cc.pascal.SimplePascalParser.IdTargetContext;
import pp.block5.cc.pascal.SimplePascalParser.IfStatContext;
import pp.block5.cc.pascal.SimplePascalParser.InStatContext;
import pp.block5.cc.pascal.SimplePascalParser.IntTypeContext;
import pp.block5.cc.pascal.SimplePascalParser.MultExprContext;
import pp.block5.cc.pascal.SimplePascalParser.MultOpContext;
import pp.block5.cc.pascal.SimplePascalParser.NumExprContext;
import pp.block5.cc.pascal.SimplePascalParser.OutStatContext;
import pp.block5.cc.pascal.SimplePascalParser.ParExprContext;
import pp.block5.cc.pascal.SimplePascalParser.PlusExprContext;
import pp.block5.cc.pascal.SimplePascalParser.PlusOpContext;
import pp.block5.cc.pascal.SimplePascalParser.PrfExprContext;
import pp.block5.cc.pascal.SimplePascalParser.PrfOpContext;
import pp.block5.cc.pascal.SimplePascalParser.ProgramContext;
import pp.block5.cc.pascal.SimplePascalParser.TrueExprContext;
import pp.block5.cc.pascal.SimplePascalParser.VarContext;
import pp.block5.cc.pascal.SimplePascalParser.VarDeclContext;
import pp.block5.cc.pascal.SimplePascalParser.WhileStatContext;
import pp.iloc.Simulator;
import pp.iloc.model.Label;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
import pp.iloc.model.Str;
/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends SimplePascalBaseVisitor<Op> {
	/** The representation of the boolean value <code>false</code>. */
	public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
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

	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		this.regs = new ParseTreeProperty<>();
		this.labels = new ParseTreeProperty<>();
		this.regCount = 0;
		tree.accept(this);
		return this.prog;
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
	private Reg reg(ParseTree node) {
		Reg result = this.regs.get(node);
		if (result == null) {
			result = new Reg("r_" + this.regCount);
			this.regs.put(node, result);
			this.regCount++;
		}
		return result;
	}

	/** Assigns a register to a given parse tree node. */
	private void setReg(ParseTree node, Reg reg) {
		this.regs.put(node, reg);
	}

	@Override
	public Op visitProgram(ProgramContext ctx) {
		return visit(ctx.body());
	}

	@Override
	public Op visitBody(BodyContext ctx) {
		for( int i = 0;  i < ctx.decl().size(); i++ )
			visit(ctx.decl(i));
		return visit(ctx.block());
	}

	@Override
	public Op visitVarDecl(VarDeclContext ctx) {
		for( int i = 0; i < ctx.var().size(); i++ )
			visit(ctx.var(i));
		
		return null;
	}

	@Override
	public Op visitVar(VarContext ctx) {
		//Should I LoadAI all IDs to memory?
		return super.visitVar(ctx);
	}

	@Override
	public Op visitBlock(BlockContext ctx) {
		for( int i = 0; i < ctx.stat().size(); i++ )
			visit(ctx.stat(i));
		return null;
	}

	@Override
	public Op visitAssStat(AssStatContext ctx) {
		visit(ctx.expr());
		visit(ctx.target());
		Operand [] args = {reg(ctx.expr()), arp, offset(ctx.target())};
		
		return emit(OpCode.storeAI, args);
	}

	@Override
	public Op visitIfStat(IfStatContext ctx) {
		
		Label ifl = new Label("if");
		Label elsel = new Label("else");
		Label end = new Label("end_if");
		if( ctx.getChildCount() == 6 )
		{
			visit(ctx.expr());
			Operand [] args = {reg(ctx.expr()), ifl, elsel};
			emit(OpCode.cbr, args);
			emit(ifl, OpCode.nop);
			visit(ctx.stat(0));
			emit(OpCode.jumpI, end);
			emit(elsel, OpCode.nop);
			visit(ctx.stat(1));
			emit(end, OpCode.nop);
		}
		else {
			visit(ctx.expr());
			Operand [] args = {reg(ctx.expr()), ifl, end};
			emit(OpCode.cbr, args);
			emit(ifl, OpCode.nop);
			visit(ctx.stat(0));
			emit(end, OpCode.nop);
		}
		return null;
	}

	@Override
	public Op visitWhileStat(WhileStatContext ctx) {
		Label whilel = new Label("while");
		Label body = new Label("body");
		Label end = new Label("end_while");
		emit(whilel, OpCode.nop);
		visit(ctx.expr());
		Operand [] args = {reg(ctx.expr()), body, end};
		emit(OpCode.cbr, args);
		emit(body, OpCode.nop);
		visit(ctx.stat());
		emit(OpCode.jumpI, whilel);
		emit(end, OpCode.nop);
		return null;
	}

	@Override
	public Op visitInStat(InStatContext ctx) {
		//store input value in a target addr
		Operand [] args = {new Str(ctx.STR().getText()), reg(ctx)};
		emit(OpCode.in, args);
		Operand [] args1 = {reg(ctx), arp, offset(ctx.target())};
		
		return emit(OpCode.storeAI, args1);
	}

	@Override
	public Op visitOutStat(OutStatContext ctx) {
		visit(ctx.expr());
		Operand [] args1 = {new Str(ctx.STR().getText()), reg(ctx.expr())};
		
		return emit(OpCode.out, args1);
	}

	@Override
	public Op visitParExpr(ParExprContext ctx) {
		visit(ctx.expr());
		setReg(ctx, reg(ctx.expr()));
		return null;
	}

	@Override
	public Op visitTrueExpr(TrueExprContext ctx) {
		Operand [] args = { new Num(1), reg(ctx)};
		return emit(OpCode.loadI, args);
	}

	@Override
	public Op visitCompExpr(CompExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		if( ctx.compOp().getText().equalsIgnoreCase("<>") ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.cmp_NE, args);
		}
		else if( ctx.compOp().getText().equalsIgnoreCase("=") ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.cmp_EQ, args);
		}
		else if( ctx.compOp().getText().equalsIgnoreCase(">=") ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.cmp_GE, args);
		}
		else if( ctx.compOp().getText().equalsIgnoreCase(">") ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.cmp_GT, args);
		}
		else if( ctx.compOp().getText().equalsIgnoreCase("<=") ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.cmp_LE, args);
		}
		else if( ctx.compOp().getText().equalsIgnoreCase("<") ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.cmp_LT, args);
		}
		return null;
	}

	@Override
	public Op visitPrfExpr(PrfExprContext ctx) {
		visit(ctx.expr());
		if( ctx.prfOp().MINUS() != null ) {
			Operand [] args = {reg(ctx.expr()), new Num(0), reg(ctx)};
			emit(OpCode.rsubI, args);
		}
		else if( ctx.prfOp().NOT() != null) {
			Operand [] args = {reg(ctx.expr()), new Num(-1), reg(ctx)};
			emit(OpCode.rsubI, args);
		}
		else
			System.err.println("PrfExpr: prfOp: cannot be found.");
		return null;
	}

	@Override
	public Op visitFalseExpr(FalseExprContext ctx) {
		Operand [] args = { new Num(0), reg(ctx)};
		return emit(OpCode.loadI, args);
	}

	@Override
	public Op visitBoolExpr(BoolExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		if( ctx.boolOp().AND() != null ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.and, args);
		}
		else if( ctx.boolOp().OR() != null ) {
			Operand [] args = {reg(ctx.expr(0)),reg(ctx.expr(1)), reg(ctx)};
			return emit(OpCode.or, args);
		}
		return null;
	}

	@Override
	public Op visitMultExpr(MultExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		if( ctx.multOp().STAR() != null ) {
			Operand [] args = { reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx) };
			emit(OpCode.mult, args);
		}
		else if( ctx.multOp().SLASH() != null ) { 
			Operand [] args = { reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx) };
			emit(OpCode.div, args);
		}
		else
			System.err.println("visitPlusExpr: plusOp: cannot be found.");
		return null;
	}

	
	@Override
	public Op visitNumExpr(NumExprContext ctx) {
		Operand [] args = { new Num(Integer.parseInt(ctx.NUM().getText())), reg(ctx)};
		return emit(OpCode.loadI, args);
	}

	@Override
	public Op visitPlusExpr(PlusExprContext ctx) {
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		if( ctx.plusOp().MINUS() != null ) {
			Operand [] args = { reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx) };
			emit(OpCode.sub, args);
		}
		else if( ctx.plusOp().PLUS() != null ) { 
			Operand [] args = { reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx) };
			emit(OpCode.add, args);
		}
		else
			System.err.println("visitPlusExpr: plusOp: cannot be found.");
		return null;
	}

	@Override
	public Op visitIdExpr(IdExprContext ctx) {
		Operand [] args = { arp, offset(ctx), reg(ctx)};
		return emit(OpCode.loadAI, args);
	}

	@Override
	public Op visitIntType(IntTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIntType(ctx);
	}

	@Override
	public Op visitBoolType(BoolTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBoolType(ctx);
	}

}

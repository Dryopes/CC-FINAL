package grammar;


import grammar.lyParser.ArrayExprContext;
import grammar.lyParser.ArrayTypeContext;
import grammar.lyParser.AssigmentContext;
import grammar.lyParser.BodyContext;
import grammar.lyParser.BoolExprContext;
import grammar.lyParser.BoolOpContext;
import grammar.lyParser.BoolTypeContext;
import grammar.lyParser.CharTypeContext;
import grammar.lyParser.CompExprContext;
import grammar.lyParser.CompOpContext;
import grammar.lyParser.CompoundContext;
import grammar.lyParser.DeclContext;
import grammar.lyParser.FalseExprContext;
import grammar.lyParser.FuncExprContext;
import grammar.lyParser.FunctionContext;
import grammar.lyParser.IdExprContext;
import grammar.lyParser.IfContext;
import grammar.lyParser.IndexExprContext;
import grammar.lyParser.IntTypeContext;
import grammar.lyParser.MultExprContext;
import grammar.lyParser.MultOpContext;
import grammar.lyParser.NumExprContext;
import grammar.lyParser.ParExprContext;
import grammar.lyParser.PlusExprContext;
import grammar.lyParser.PlusOpContext;
import grammar.lyParser.PrfExprContext;
import grammar.lyParser.PrfOpContext;
import grammar.lyParser.PrintExprContext;
import grammar.lyParser.ReadExprContext;
import grammar.lyParser.TrueExprContext;
import grammar.lyParser.WhileContext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;


/** Class to type check and calculate flow entries and variable offsets. */
public class Checker extends lyBaseListener {
	/** Result of the latest call of {@link #check}. */
	private Result result;
	/** Variable scope for the latest call of {@link #check}. */
	private Scope scope;
	/** List of errors collected in the latest call of {@link #check}. */
	private List<String> errors;

	/** Runs this checker on a given parse tree,
	 * and returns the checker result.
	 * @throws ParseException if an error was found during checking.
	 */
	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.result = new Result();
		this.errors = new ArrayList<>();
		new ParseTreeWalker().walk(this, tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		return this.result;
	}

	// Override the listener methods for the statement nodes
	
	// body: (decl SEMI | expr SEMI | RETURN expr SEMI)+;
	//I don't know how to implement!!!
	@Override
	public void exitBody(BodyContext ctx) {
		// TODO Auto-generated method stub
		super.exitBody(ctx);
	}

	//decl: (CONST)? type ID (COMMA ID)*;
	//I am not sure about it!!!
	@Override
	public void exitDecl(DeclContext ctx) {
		Type t = getType(ctx.type());
		for (TerminalNode term: ctx.ID()) {
			String id  = term.getText();
			boolean freshvar = this.scope.put(id, t);
			if (!freshvar) {
				addError(term.getSymbol(), "Variable already declared: ", id);
				
			}
		}
	}

	//Why we said decl? and how to do exitFunction
	// function: ID LPAR (decl (COLON decl)*)? RPAR '~~' type expr;
	@Override
	public void exitFunction(FunctionContext ctx) {
		Type t = getType(ctx.type());
		String id  = ctx.ID().getText();
		boolean freshvar = this.scope.put(id, t);
		if (!freshvar) {
			addError(ctx.ID().getSymbol(), "Variable already declared: ", id);
			
		}
		
	}

	@Override
	public void exitFuncExpr(FuncExprContext ctx) {
		
	}
	
	
	//LBLOCK (expr (COMMA expr)*)? RBLOCK
	//there is not id or type in arrayExpr ???
	// I think we should check whether array components are in given type.
	@Override
	public void exitArrayExpr(ArrayExprContext ctx) {
//		Type t = getType(ctx.ID());
//		int i = 0;
//		for( ParseTree expr: ctx.expr() ) {
//			
//			if( !getType(expr).equals(t) ) {
//				addError(ctx.expr(i), "Component is not in array type: ", expr.getText() );
//			}
//			i++;
//		}
	}

	@Override
	public void exitTrueExpr(TrueExprContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);
	}

	@Override
	public void exitReadExpr(ReadExprContext ctx) {
		setEntry(ctx, entry(ctx.ID(0)));
	}

	
	//WHILE LPAR expr RPAR expr	
	@Override
	public void exitWhile(WhileContext ctx) {
		checkType(ctx.expr(0), Type.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	//LBRACE body expr SEMI RBRACE 
	//??? we can return multiple things which is weird
	@Override
	public void exitCompound(CompoundContext ctx) {
		setEntry(ctx, entry(ctx.body()));
	}

	@Override
	public void exitMultExpr(MultExprContext ctx) {
		checkType(ctx.expr(0), Type.INT);
		checkType(ctx.expr(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitNumExpr(NumExprContext ctx) {
		setType(ctx, Type.INT);
		setEntry(ctx, ctx);
	}

	@Override
	public void exitPlusExpr(PlusExprContext ctx) {
		checkType(ctx.expr(0), Type.INT);
		checkType(ctx.expr(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitAssigment(AssigmentContext ctx) {
	}

	@Override
	public void exitIndexExpr(IndexExprContext ctx) {
		// TODO Auto-generated method stub
		super.exitIndexExpr(ctx);
	}

	@Override
	public void exitParExpr(ParExprContext ctx) {
		setType(ctx, getType(ctx.expr()));
		setEntry(ctx, entry(ctx.expr()));
	}

	@Override
	public void exitCompExpr(CompExprContext ctx) {
		checkType(ctx.expr(0), Type.INT);
		checkType(ctx.expr(1), Type.INT);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitPrfExpr(PrfExprContext ctx) {
		Type type;
		if (ctx.prfOp().MINUS() != null) {
			type = Type.INT;
		} else {
			assert ctx.prfOp().NOT() != null;
			type = Type.BOOL;
		}
		checkType(ctx.expr(), type);
		setType(ctx, type);
		setEntry(ctx, entry(ctx.expr()));
	}

	@Override
	public void exitFalseExpr(FalseExprContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);
	}

	@Override
	public void exitBoolExpr(BoolExprContext ctx) {
		checkType(ctx.expr(0), Type.BOOL);
		checkType(ctx.expr(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	//IF LPAR expr RPAR expr (ELSE expr)?
	@Override
	public void exitIf(IfContext ctx) {
		checkType(ctx.expr(0), Type.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitPrintExpr(PrintExprContext ctx) {
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitIdExpr(IdExprContext ctx) {
		String id = ctx.ID().getText();
		Type type = this.scope.type(id);
		if (type == null) {
			addError(ctx, "Variable '%s' not declared", id);
		} else {
			setType(ctx, type);
			setOffset(ctx, this.scope.offset(id));
			setEntry(ctx, ctx);
		}
	}

	@Override
	public void exitPrfOp(PrfOpContext ctx) {
		// TODO Auto-generated method stub
		super.exitPrfOp(ctx);
	}

	@Override
	public void exitMultOp(MultOpContext ctx) {
		// TODO Auto-generated method stub
		super.exitMultOp(ctx);
	}

	@Override
	public void exitPlusOp(PlusOpContext ctx) {
		// TODO Auto-generated method stub
		super.exitPlusOp(ctx);
	}

	@Override
	public void exitBoolOp(BoolOpContext ctx) {
		// TODO Auto-generated method stub
		super.exitBoolOp(ctx);
	}

	@Override
	public void exitCompOp(CompOpContext ctx) {
		// TODO Auto-generated method stub
		super.exitCompOp(ctx);
	}

	@Override
	public void exitCharType(CharTypeContext ctx) {
		setType(ctx, Type.CHR);
	}

	@Override
	public void exitArrayType(ArrayTypeContext ctx) {
		setType(ctx, new Type.Array(0, 0, getType(ctx.type())));
	}

	@Override
	public void exitIntType(IntTypeContext ctx) {
		setType(ctx, Type.INT);
	}

	@Override
	public void exitBoolType(BoolTypeContext ctx) {
		setType(ctx, Type.BOOL);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		super.exitEveryRule(ctx);
	}

	/** Indicates if any errors were encountered in this tree listener. */
	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	/** Returns the list of errors collected in this tree listener. */
	public List<String> getErrors() {
		return this.errors;
	}

	/** Checks the inferred type of a given parse tree,
	 * and adds an error if it does not correspond to the expected type.
	 */
	private void checkType(ParserRuleContext node, Type expected) {
		Type actual = getType(node);
		if (actual == null) {
			throw new IllegalArgumentException("Missing inferred type of "
					+ node.getText());
		}
		if (!actual.equals(expected)) {
			addError(node, "Expected type '%s' but found '%s'", expected,
					actual);
		}
	}

	/** Records an error at a given parse tree node.
	 * @param ctx the parse tree node at which the error occurred
	 * @param message the error message
	 * @param args arguments for the message, see {@link String#format}
	 */
	private void addError(ParserRuleContext node, String message,
			Object... args) {
		addError(node.getStart(), message, args);
	}

	/** Records an error at a given token.
	 * @param token the token at which the error occurred
	 * @param message the error message
	 * @param args arguments for the message, see {@link String#format}
	 */
	private void addError(Token token, String message, Object... args) {
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		message = String.format(message, args);
		message = String.format("Line %d:%d - %s", line, column, message);
		this.errors.add(message);
	}

	/** Convenience method to add an offset to the result. */
	private void setOffset(ParseTree node, Integer offset) {
		this.result.setOffset(node, offset);
	}

	/** Convenience method to add a type to the result. */
	private void setType(ParseTree node, Type type) {
		this.result.setType(node, type);
	}

	/** Returns the type of a given expression or type node. */
	private Type getType(ParseTree node) {
		return this.result.getType(node);
	}

	/** Convenience method to add a flow graph entry to the result. */
	private void setEntry(ParseTree node, ParserRuleContext entry) {
		if (entry == null) {
			throw new IllegalArgumentException("Null flow graph entry");
		}
		this.result.setEntry(node, entry);
	}

	/** Returns the flow graph entry of a given expression or statement. */
	private ParserRuleContext entry(ParseTree node) {
		return this.result.getEntry(node);
	}
}

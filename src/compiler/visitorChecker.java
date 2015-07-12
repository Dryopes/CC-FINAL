package compiler;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import grammar.Type;
import grammar.TypeKind;
import grammar.Result;
import grammar.ParseException;
import grammar.Scope;
import grammar.lyBaseListener;
import grammar.lyBaseVisitor;
import grammar.lyParser.ArrayExprContext;
import grammar.lyParser.ArrayTypeContext;
import grammar.lyParser.AssStatContext;
import grammar.lyParser.BodyContext;
import grammar.lyParser.BodypartContext;
import grammar.lyParser.BoolExprContext;
import grammar.lyParser.BoolOpContext;
import grammar.lyParser.BoolTypeContext;
import grammar.lyParser.CharExprContext;
import grammar.lyParser.CharTypeContext;
import grammar.lyParser.CompExprContext;
import grammar.lyParser.CompOpContext;
import grammar.lyParser.CompoundExprContext;
import grammar.lyParser.DeclContext;
import grammar.lyParser.DeclpartContext;
import grammar.lyParser.FalseExprContext;
import grammar.lyParser.FuncBodyContext;
import grammar.lyParser.FuncExprContext;
import grammar.lyParser.FunctionContext;
import grammar.lyParser.IdExprContext;
import grammar.lyParser.IfStatContext;
import grammar.lyParser.IndexExprContext;
import grammar.lyParser.IntTypeContext;
import grammar.lyParser.MultExprContext;
import grammar.lyParser.MultOpContext;
import grammar.lyParser.NumExprContext;
import grammar.lyParser.ParExprContext;
import grammar.lyParser.ParamContext;
import grammar.lyParser.PlusExprContext;
import grammar.lyParser.PlusOpContext;
import grammar.lyParser.PrfExprContext;
import grammar.lyParser.PrfOpContext;
import grammar.lyParser.PrintStatContext;
import grammar.lyParser.ProcBodyContext;
import grammar.lyParser.ProcedureContext;
import grammar.lyParser.ProgramContext;
import grammar.lyParser.ReadStatContext;
import grammar.lyParser.StatExprContext;
import grammar.lyParser.TrueExprContext;
import grammar.lyParser.VoidTypeContext;
import grammar.lyParser.WhileStatContext;

public class visitorChecker extends lyBaseVisitor <Type> {

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
		visit(tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		return this.result;
	}
	
	@Override
	public Type visitProgram(ProgramContext ctx) {
		return visit( ctx.body() );
	}



	@Override
	public Type visitBody(BodyContext ctx) {
		for( int i = 0; i < ctx.bodypart().size(); i++ ) {
			visit(ctx.bodypart(i));
		}
		return Type.VOID;
	}

	@Override
	public Type visitFuncBody(FuncBodyContext ctx) {
		for( int i = 0; i < ctx.bodypart().size(); i++ ) {
			visit(ctx.bodypart(i));
		}
		
		return visit(ctx.expr());
	}

	@Override
	public Type visitProcBody(ProcBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProcBody(ctx);
	}



	@Override
	public Type visitBodypart(BodypartContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBodypart(ctx);
	}



	@Override
	public Type visitFunction(FunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunction(ctx);
	}



	@Override
	public Type visitProcedure(ProcedureContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProcedure(ctx);
	}



	@Override
	public Type visitParam(ParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam(ctx);
	}



	@Override
	public Type visitDecl(DeclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDecl(ctx);
	}



	@Override
	public Type visitDeclpart(DeclpartContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDeclpart(ctx);
	}



	@Override
	public Type visitCharExpr(CharExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCharExpr(ctx);
	}



	@Override
	public Type visitFuncExpr(FuncExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFuncExpr(ctx);
	}



	@Override
	public Type visitArrayExpr(ArrayExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArrayExpr(ctx);
	}



	@Override
	public Type visitCompoundExpr(CompoundExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCompoundExpr(ctx);
	}



	@Override
	public Type visitTrueExpr(TrueExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTrueExpr(ctx);
	}



	@Override
	public Type visitStatExpr(StatExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStatExpr(ctx);
	}



	@Override
	public Type visitMultExpr(MultExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultExpr(ctx);
	}



	@Override
	public Type visitNumExpr(NumExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNumExpr(ctx);
	}



	@Override
	public Type visitPlusExpr(PlusExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPlusExpr(ctx);
	}



	@Override
	public Type visitIndexExpr(IndexExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIndexExpr(ctx);
	}



	@Override
	public Type visitParExpr(ParExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParExpr(ctx);
	}



	@Override
	public Type visitCompExpr(CompExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCompExpr(ctx);
	}



	@Override
	public Type visitPrfExpr(PrfExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrfExpr(ctx);
	}



	@Override
	public Type visitFalseExpr(FalseExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFalseExpr(ctx);
	}



	@Override
	public Type visitBoolExpr(BoolExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBoolExpr(ctx);
	}



	@Override
	public Type visitIdExpr(IdExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdExpr(ctx);
	}



	@Override
	public Type visitAssStat(AssStatContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssStat(ctx);
	}



	@Override
	public Type visitIfStat(IfStatContext ctx) {
		openScope(ctx);
		Type e1;
		Type e2;
		if( visit(ctx.expr(0)).equals(Type.BOOL) ) {
			openScope(ctx.expr(1));
			e1 = visit(ctx.expr(1));
			closeScope();
			if( ctx.ELSE() == null ) {
				setType(ctx, Type.VOID);
			}
			else {
				openScope(ctx.expr(2));
				e2 = visit(ctx.expr(2));
				closeScope();
				if( e1.equals(e2) ) {
					setType(ctx, e1);						
				}	
				else {
					setType(ctx, Type.VOID );
				}			
			}
			setEntry(ctx, entry(ctx.expr(0)));
			closeScope();
		}
		else {
			closeScope();
			addError(ctx, "In if statement condition must be in boolean type" );
			checkType(ctx.expr(0), Type.BOOL);
		}
		
		return getType(ctx);
	}



	@Override
	public Type visitWhileStat(WhileStatContext ctx) {
		openScope(ctx);
		if( visit(ctx.expr(0)).equals(Type.BOOL) ) {
			setType(ctx, Type.VOID);
			setEntry(ctx, entry(ctx.expr(0)));
			closeScope();
		}
		else {
			closeScope();
			addError(ctx, "In while statement condition must be in boolean type" );
			checkType(ctx.expr(0), Type.BOOL);
		}
		return getType(ctx);
	}



	@Override
	public Type visitReadStat(ReadStatContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReadStat(ctx);
	}



	@Override
	public Type visitPrintStat(PrintStatContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrintStat(ctx);
	}



	@Override
	public Type visitPrfOp(PrfOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrfOp(ctx);
	}



	@Override
	public Type visitMultOp(MultOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultOp(ctx);
	}



	@Override
	public Type visitPlusOp(PlusOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPlusOp(ctx);
	}



	@Override
	public Type visitBoolOp(BoolOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBoolOp(ctx);
	}



	@Override
	public Type visitCompOp(CompOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCompOp(ctx);
	}



	@Override
	public Type visitCharType(CharTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCharType(ctx);
	}



	@Override
	public Type visitArrayType(ArrayTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArrayType(ctx);
	}



	@Override
	public Type visitIntType(IntTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIntType(ctx);
	}



	@Override
	public Type visitVoidType(VoidTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVoidType(ctx);
	}



	@Override
	public Type visitBoolType(BoolTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBoolType(ctx);
	}



	@Override
	protected Type aggregateResult(Type aggregate, Type nextResult) {
		// TODO Auto-generated method stub
		return super.aggregateResult(aggregate, nextResult);
	}



	@Override
	protected Type defaultResult() {
		// TODO Auto-generated method stub
		return super.defaultResult();
	}



	@Override
	protected boolean shouldVisitNextChild(RuleNode node, Type currentResult) {
		// TODO Auto-generated method stub
		return super.shouldVisitNextChild(node, currentResult);
	}



	@Override
	public Type visit(ParseTree tree) {
		// TODO Auto-generated method stub
		return super.visit(tree);
	}



	@Override
	public Type visitChildren(RuleNode arg0) {
		// TODO Auto-generated method stub
		return super.visitChildren(arg0);
	}



	@Override
	public Type visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		return super.visitErrorNode(node);
	}



	@Override
	public Type visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		return super.visitTerminal(node);
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}



	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
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
	
	/** Opens a new scope */
	private void openScope(ParseTree node) {
		this.scope = this.scope.openScope();
		this.result.setScope(node, this.scope);
	}
	
	/** Opens a new function scope (ID = function name) */
	private void openFunctionScope(ParseTree node, String id) {
		this.scope = this.scope.openFunctionScope(id);
		this.result.setScope(node, this.scope);
	}
	
	/** Closes this scopes and opens the previous one **/
	private void closeScope() {
		this.scope = this.scope.closeScope();
	}

}

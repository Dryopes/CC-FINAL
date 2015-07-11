package compiler;

import grammar.lyBaseListener;
import grammar.lyParser.*;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import compiler.exception.ParseException;
import compiler.result.Result;
import compiler.result.Scope;
import compiler.type.Type;
import compiler.type.TypeKind;


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
	
	@Override
	public void exitBody(BodyContext ctx) {
		setEntry(ctx, entry(ctx.bodypart(0)));
	}

	@Override
	public void exitFuncBody(FuncBodyContext ctx) {
		if( ctx.bodypart(0) != null )
			setEntry(ctx, entry(ctx.bodypart(0)));
		else
			setEntry(ctx, entry(ctx.expr()));
	}

	@Override
	public void exitBodypart(BodypartContext ctx) {
		if( ctx.decl() != null )
			setEntry(ctx, entry(ctx.decl()));
		else
			setEntry(ctx, entry(ctx.expr()));
	}

	@Override
	public void exitProcBody(ProcBodyContext ctx) {
		setEntry(ctx, entry(ctx.bodypart(0)));
	}
	
	@Override 
	public void enterProcedure(ProcedureContext ctx) {
		Type type = new Type.Void();
		String id = ctx.ID().getText();
		
		this.scope.putFunction(id, type);
		openScope(ctx);
	}

	@Override
	public void exitProcedure(ProcedureContext ctx) {
		setEntry(ctx, entry(ctx.param(0)));
	}
	
	@Override
	public void exitStatExpr(StatExprContext ctx) {
		setEntry(ctx, entry(ctx.stat()));
	}

	@Override
	public void exitDecl(DeclContext ctx) {
		Type type = getType(ctx.type());
		for(int i = 0; i < ctx.declpart().size(); i++) {
			String id = ctx.declpart(i).ID().getText();
			if(!this.scope.put(id, type)) {
				addError(ctx.declpart(i), "Variable %s was already declared!", id);
			}
			setOffset(ctx.declpart(i), this.scope.offset(id));
		}
		setEntry(ctx, ctx);
	}
 
	@Override
	public void enterFunction(FunctionContext ctx) {
		Type type = getType(ctx.type());
		String id = ctx.ID().getText();
		
		this.scope.putFunction(id, type);
		openScope(ctx);
	}
	
	@Override
	public void exitFunction(FunctionContext ctx) {
		Type t = getType(ctx.type());
		String id  = ctx.ID().getText();
		boolean freshvar = this.scope.put(id, t);
		if (!freshvar) {
			addError(ctx.ID().getSymbol(), "Variable already declared: ", id);
		}
		else {
			if( !getType(ctx.funcBody().expr()).equals(t) ) {
				addError(ctx, "Return type does not match : ", t);
			}
			else {
				setEntry(ctx, ctx.funcBody());
			}
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
		setType(ctx, new Type.Bool(false, true));
		setEntry(ctx, ctx);
	}

	@Override
	public void exitReadStat(ReadStatContext ctx) {
		setEntry(ctx, ctx);
		if(ctx.ID().size() > 1)
			setType(ctx, new Type.Void());
		else
			setType(ctx, this.scope.type(ctx.ID(0).getText()));
		
		for(TerminalNode node : ctx.ID()) {
			setOffset(node, this.scope.offset(node.getText()));
		}
	}

	@Override
	public void exitWhileStat(WhileStatContext ctx) {
		checkType(ctx.expr(0), TypeKind.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
		setType(ctx, new Type.Void());
	}

	public void enterCompoundExpr(CompoundExprContext ctx) {
		openScope(ctx);
	}
	
	@Override
	public void exitCompoundExpr(CompoundExprContext ctx) {
		closeScope();
		setEntry(ctx, entry(ctx.expr()));
		setType(ctx, getType(ctx.expr()));
	}

	@Override
	public void exitMultExpr(MultExprContext ctx) {
		checkType(ctx.expr(0), TypeKind.INT);
		checkType(ctx.expr(1), TypeKind.INT);
		setType(ctx, new Type.Int(false, true));
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitNumExpr(NumExprContext ctx) {
		setType(ctx, new Type.Int(false, true));
		System.out.println("Exit Num Expr: " + getType(ctx).getKind());
		setEntry(ctx, ctx);
	}
	
	@Override
	public void exitCharExpr(CharExprContext ctx) {
		setType(ctx, new Type.Char(false, true));
		setEntry(ctx, ctx);
	}

	@Override
	public void exitPlusExpr(PlusExprContext ctx) {
		checkType(ctx.expr(0), TypeKind.INT);
		checkType(ctx.expr(1), TypeKind.INT);
		setType(ctx, new Type.Int(false, true));
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitAssStat(AssStatContext ctx) {
		String id = ctx.ID().getText();
		Type type = this.scope.type(id);
		int offset = this.scope.offset(id);
		
		System.out.println(ctx.ID().getText() + ": " + type.getKind());
		System.out.println(ctx.expr().getClass().getName() + ": " + getType(ctx.expr()));
		System.out.println("--");
		
		checkType(ctx.expr(), type.getKind());
		setType(ctx, type);
		setOffset(ctx, offset);
		
		setEntry(ctx, entry(ctx.expr()));
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
		Type type = getType(ctx.expr(0));
		checkType(ctx.expr(1), type.getKind());
		setType(ctx, new Type.Bool(false, true));
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitPrfExpr(PrfExprContext ctx) {
		if (ctx.prfOp().MINUS() != null) {
			checkType(ctx.expr(), TypeKind.INT);
		} else {
			assert ctx.prfOp().NOT() != null;
			checkType(ctx.expr(), TypeKind.BOOL);
		}
		
		setType(ctx, getType(ctx.expr()));
		setEntry(ctx, entry(ctx.expr()));
	}

	@Override
	public void exitFalseExpr(FalseExprContext ctx) {
		setType(ctx, new Type.Bool(false, true));
		setEntry(ctx, ctx);
	}

	@Override
	public void exitBoolExpr(BoolExprContext ctx) {
		checkType(ctx.expr(0), TypeKind.BOOL);
		checkType(ctx.expr(1), TypeKind.BOOL);
		setType(ctx, new Type.Bool(false,true));
		setEntry(ctx, entry(ctx.expr(0)));
	}

	//IF LPAR expr RPAR expr (ELSE expr)?
	@Override
	public void exitIfStat(IfStatContext ctx) {
		checkType(ctx.expr(0), TypeKind.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitPrintStat(PrintStatContext ctx) {
		setEntry(ctx, entry(ctx.expr(0)));
		if(ctx.expr().size() > 1)
			setType(ctx, new Type.Void());
		else
			setType(ctx, getType(ctx.expr(0)));
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
	public void exitCharType(CharTypeContext ctx) {
		setType(ctx, new Type.Char(false, true));
	}

	@Override
	public void exitArrayType(ArrayTypeContext ctx) {
		setType(ctx, new Type.Array(0, 0, getType(ctx.type()), false, true));
	}

	@Override
	public void exitIntType(IntTypeContext ctx) {
		setType(ctx, new Type.Bool(false, true));
	}

	@Override
	public void exitBoolType(BoolTypeContext ctx) {
		setType(ctx, new Type.Bool(false, true));
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
	private void checkType(ParserRuleContext node, TypeKind expected) {
		Type actual = getType(node);
		if (actual == null) {
			throw new IllegalArgumentException("Missing inferred type of "
					+ node.getText());
		}
		if (!(actual.getKind() == expected)) {
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
	
	private void openFunctionScope(ParseTree node, String id) {
		this.scope = this.scope.openFunctionScope(id);
		this.result.setScope(node, this.scope);
	}
	
	/** Closes this scopes and opens the previous one **/
	private void closeScope() {
		this.scope = this.scope.closeScope();
	}
}

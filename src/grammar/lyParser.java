// Generated from ly.g4 by ANTLR 4.5
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FNCTYPE=1, PROGRAM=2, TRUE=3, FALSE=4, READ=5, PRINT=6, IF=7, ELSE=8, 
		WHILE=9, RETURN=10, CONST=11, VOID=12, INT=13, BOOL=14, CHAR=15, ASS=16, 
		AND=17, COLON=18, COMMA=19, DOT=20, DQUOTE=21, EQ=22, GE=23, GT=24, LE=25, 
		LBRACE=26, LPAR=27, LBLOCK=28, LT=29, MINUS=30, NE=31, NOT=32, PLUS=33, 
		RBLOCK=34, RBRACE=35, RPAR=36, SEMI=37, SLASH=38, REF=39, STAR=40, QUOTE=41, 
		OR=42, HT=43, ID=44, NUM=45, STR=46, CHR=47, COMMENT=48, MULTICOMMENT=49, 
		WS=50;
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_funcBody = 2, RULE_procBody = 3, 
		RULE_bodypart = 4, RULE_function = 5, RULE_procedure = 6, RULE_param = 7, 
		RULE_decl = 8, RULE_declpart = 9, RULE_expr = 10, RULE_stat = 11, RULE_prfOp = 12, 
		RULE_multOp = 13, RULE_plusOp = 14, RULE_boolOp = 15, RULE_compOp = 16, 
		RULE_type = 17;
	public static final String[] ruleNames = {
		"program", "body", "funcBody", "procBody", "bodypart", "function", "procedure", 
		"param", "decl", "declpart", "expr", "stat", "prfOp", "multOp", "plusOp", 
		"boolOp", "compOp", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'~~'", "'program'", "'true'", "'false'", "'read'", "'print'", "'if'", 
		"'else'", "'while'", "'return'", "'const'", "'void'", "'int'", "'bool'", 
		"'char'", "'<-'", "'&&'", "':'", "','", "'.'", "'\"'", "'='", "'>='", 
		"'>'", "'<='", "'{'", "'('", "'['", "'<'", "'-'", "'!='", "'!'", "'+'", 
		"']'", "'}'", "')'", "';'", "'/'", "'@'", "'*'", "'''", "'||'", "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FNCTYPE", "PROGRAM", "TRUE", "FALSE", "READ", "PRINT", "IF", "ELSE", 
		"WHILE", "RETURN", "CONST", "VOID", "INT", "BOOL", "CHAR", "ASS", "AND", 
		"COLON", "COMMA", "DOT", "DQUOTE", "EQ", "GE", "GT", "LE", "LBRACE", "LPAR", 
		"LBLOCK", "LT", "MINUS", "NE", "NOT", "PLUS", "RBLOCK", "RBRACE", "RPAR", 
		"SEMI", "SLASH", "REF", "STAR", "QUOTE", "OR", "HT", "ID", "NUM", "STR", 
		"CHR", "COMMENT", "MULTICOMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ly.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public lyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(lyParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public TerminalNode COLON() { return getToken(lyParser.COLON, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(PROGRAM);
			setState(37);
			match(ID);
			setState(38);
			match(COLON);
			setState(39);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public List<BodypartContext> bodypart() {
			return getRuleContexts(BodypartContext.class);
		}
		public BodypartContext bodypart(int i) {
			return getRuleContext(BodypartContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(lyParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(lyParser.SEMI, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(41);
					bodypart();
					setState(42);
					match(SEMI);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(46); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(lyParser.LBRACE, 0); }
		public TerminalNode RETURN() { return getToken(lyParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(lyParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(lyParser.SEMI, i);
		}
		public TerminalNode RBRACE() { return getToken(lyParser.RBRACE, 0); }
		public List<BodypartContext> bodypart() {
			return getRuleContexts(BodypartContext.class);
		}
		public BodypartContext bodypart(int i) {
			return getRuleContext(BodypartContext.class,i);
		}
		public FuncBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterFuncBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitFuncBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitFuncBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncBodyContext funcBody() throws RecognitionException {
		FuncBodyContext _localctx = new FuncBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(LBRACE);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << CONST) | (1L << VOID) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << LBRACE) | (1L << LPAR) | (1L << LBLOCK) | (1L << MINUS) | (1L << NOT) | (1L << ID) | (1L << NUM) | (1L << CHR))) != 0)) {
				{
				{
				setState(49);
				bodypart();
				setState(50);
				match(SEMI);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(RETURN);
			setState(58);
			expr(0);
			setState(59);
			match(SEMI);
			setState(60);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(lyParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(lyParser.RBRACE, 0); }
		public List<BodypartContext> bodypart() {
			return getRuleContexts(BodypartContext.class);
		}
		public BodypartContext bodypart(int i) {
			return getRuleContext(BodypartContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(lyParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(lyParser.SEMI, i);
		}
		public ProcBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterProcBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitProcBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitProcBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcBodyContext procBody() throws RecognitionException {
		ProcBodyContext _localctx = new ProcBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_procBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(LBRACE);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << CONST) | (1L << VOID) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << LBRACE) | (1L << LPAR) | (1L << LBLOCK) | (1L << MINUS) | (1L << NOT) | (1L << ID) | (1L << NUM) | (1L << CHR))) != 0)) {
				{
				{
				setState(63);
				bodypart();
				setState(64);
				match(SEMI);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodypartContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BodypartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodypart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterBodypart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitBodypart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitBodypart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodypartContext bodypart() throws RecognitionException {
		BodypartContext _localctx = new BodypartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bodypart);
		try {
			setState(75);
			switch (_input.LA(1)) {
			case CONST:
			case VOID:
			case INT:
			case BOOL:
			case CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				decl();
				}
				break;
			case TRUE:
			case FALSE:
			case READ:
			case PRINT:
			case IF:
			case WHILE:
			case LBRACE:
			case LPAR:
			case LBLOCK:
			case MINUS:
			case NOT:
			case ID:
			case NUM:
			case CHR:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public TerminalNode FNCTYPE() { return getToken(lyParser.FNCTYPE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ID);
			setState(78);
			match(LPAR);
			setState(87);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << VOID) | (1L << INT) | (1L << BOOL) | (1L << CHAR))) != 0)) {
				{
				setState(79);
				param();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(80);
					match(COMMA);
					setState(81);
					param();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(89);
			match(RPAR);
			setState(90);
			match(FNCTYPE);
			setState(91);
			type(0);
			setState(92);
			funcBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public ProcBodyContext procBody() {
			return getRuleContext(ProcBodyContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitProcedure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			setState(95);
			match(LPAR);
			setState(104);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << VOID) | (1L << INT) | (1L << BOOL) | (1L << CHAR))) != 0)) {
				{
				setState(96);
				param();
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(97);
					match(COMMA);
					setState(98);
					param();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(106);
			match(RPAR);
			setState(107);
			procBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<DeclpartContext> declpart() {
			return getRuleContexts(DeclpartContext.class);
		}
		public DeclpartContext declpart(int i) {
			return getRuleContext(DeclpartContext.class,i);
		}
		public TerminalNode CONST() { return getToken(lyParser.CONST, 0); }
		public TerminalNode REF() { return getToken(lyParser.REF, 0); }
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(109);
				match(CONST);
				}
			}

			setState(112);
			type(0);
			setState(114);
			_la = _input.LA(1);
			if (_la==REF) {
				{
				setState(113);
				match(REF);
				}
			}

			setState(116);
			declpart();
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					match(COMMA);
					setState(118);
					declpart();
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<DeclpartContext> declpart() {
			return getRuleContexts(DeclpartContext.class);
		}
		public DeclpartContext declpart(int i) {
			return getRuleContext(DeclpartContext.class,i);
		}
		public TerminalNode CONST() { return getToken(lyParser.CONST, 0); }
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(124);
				match(CONST);
				}
			}

			setState(127);
			type(0);
			setState(128);
			declpart();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(129);
				match(COMMA);
				setState(130);
				declpart();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclpartContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public TerminalNode ASS() { return getToken(lyParser.ASS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterDeclpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitDeclpart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitDeclpart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclpartContext declpart() throws RecognitionException {
		DeclpartContext _localctx = new DeclpartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declpart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(ID);
			setState(139);
			_la = _input.LA(1);
			if (_la==ASS) {
				{
				setState(137);
				match(ASS);
				setState(138);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharExprContext extends ExprContext {
		public TerminalNode CHR() { return getToken(lyParser.CHR, 0); }
		public CharExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterCharExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitCharExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitCharExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode LBLOCK() { return getToken(lyParser.LBLOCK, 0); }
		public TerminalNode RBLOCK() { return getToken(lyParser.RBLOCK, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompoundExprContext extends ExprContext {
		public TerminalNode LBRACE() { return getToken(lyParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(lyParser.SEMI, 0); }
		public TerminalNode RBRACE() { return getToken(lyParser.RBRACE, 0); }
		public CompoundExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterCompoundExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitCompoundExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitCompoundExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueExprContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(lyParser.TRUE, 0); }
		public TrueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitTrueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitTrueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatExprContext extends ExprContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public StatExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterStatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitStatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitStatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(lyParser.NUM, 0); }
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitNumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PlusOpContext plusOp() {
			return getRuleContext(PlusOpContext.class,0);
		}
		public PlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterPlusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitPlusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public TerminalNode LBLOCK() { return getToken(lyParser.LBLOCK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBLOCK() { return getToken(lyParser.RBLOCK, 0); }
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitIndexExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrfExprContext extends ExprContext {
		public PrfOpContext prfOp() {
			return getRuleContext(PrfOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrfExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterPrfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitPrfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitPrfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseExprContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(lyParser.FALSE, 0); }
		public FalseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitFalseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitFalseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new PrfExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(142);
				prfOp();
				setState(143);
				expr(16);
				}
				break;
			case 2:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(LPAR);
				setState(146);
				expr(0);
				setState(147);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(ID);
				setState(150);
				match(LPAR);
				setState(151);
				expr(0);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(152);
					match(COMMA);
					setState(153);
					expr(0);
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(159);
				match(RPAR);
				}
				break;
			case 4:
				{
				_localctx = new CompoundExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(LBRACE);
				setState(162);
				body();
				setState(163);
				expr(0);
				setState(164);
				match(SEMI);
				setState(165);
				match(RBRACE);
				}
				break;
			case 5:
				{
				_localctx = new IndexExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(ID);
				setState(168);
				match(LBLOCK);
				setState(169);
				expr(0);
				setState(170);
				match(RBLOCK);
				}
				break;
			case 6:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(LBLOCK);
				setState(181);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << LBRACE) | (1L << LPAR) | (1L << LBLOCK) | (1L << MINUS) | (1L << NOT) | (1L << ID) | (1L << NUM) | (1L << CHR))) != 0)) {
					{
					setState(173);
					expr(0);
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(174);
						match(COMMA);
						setState(175);
						expr(0);
						}
						}
						setState(180);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(183);
				match(RBLOCK);
				}
				break;
			case 7:
				{
				_localctx = new StatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				stat();
				}
				break;
			case 8:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(ID);
				}
				break;
			case 9:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(NUM);
				}
				break;
			case 10:
				{
				_localctx = new CharExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(CHR);
				}
				break;
			case 11:
				{
				_localctx = new TrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(TRUE);
				}
				break;
			case 12:
				{
				_localctx = new FalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(208);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(193);
						plusOp();
						setState(194);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(197);
						multOp();
						setState(198);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(201);
						compOp();
						setState(202);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(205);
						boolOp();
						setState(206);
						expr(13);
						}
						break;
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssStatContext extends StatContext {
		public TerminalNode ID() { return getToken(lyParser.ID, 0); }
		public TerminalNode ASS() { return getToken(lyParser.ASS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterAssStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitAssStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitAssStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode IF() { return getToken(lyParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public TerminalNode ELSE() { return getToken(lyParser.ELSE, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadStatContext extends StatContext {
		public TerminalNode READ() { return getToken(lyParser.READ, 0); }
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public List<TerminalNode> ID() { return getTokens(lyParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(lyParser.ID, i);
		}
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public ReadStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterReadStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitReadStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitReadStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(lyParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(lyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lyParser.COMMA, i);
		}
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(lyParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(lyParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(lyParser.RPAR, 0); }
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stat);
		int _la;
		try {
			setState(254);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AssStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(ID);
				setState(214);
				match(ASS);
				setState(215);
				expr(0);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(IF);
				setState(217);
				match(LPAR);
				setState(218);
				expr(0);
				setState(219);
				match(RPAR);
				setState(220);
				expr(0);
				setState(223);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(221);
					match(ELSE);
					setState(222);
					expr(0);
					}
					break;
				}
				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				match(WHILE);
				setState(226);
				match(LPAR);
				setState(227);
				expr(0);
				setState(228);
				match(RPAR);
				setState(229);
				expr(0);
				}
				break;
			case READ:
				_localctx = new ReadStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
				match(READ);
				setState(232);
				match(LPAR);
				setState(233);
				match(ID);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(234);
					match(COMMA);
					setState(235);
					match(ID);
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(241);
				match(RPAR);
				}
				break;
			case PRINT:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(242);
				match(PRINT);
				setState(243);
				match(LPAR);
				setState(244);
				expr(0);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(245);
					match(COMMA);
					setState(246);
					expr(0);
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(252);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrfOpContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(lyParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(lyParser.NOT, 0); }
		public PrfOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prfOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterPrfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitPrfOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitPrfOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrfOpContext prfOp() throws RecognitionException {
		PrfOpContext _localctx = new PrfOpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prfOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==NOT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultOpContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(lyParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(lyParser.SLASH, 0); }
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitMultOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitMultOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( !(_la==SLASH || _la==STAR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(lyParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(lyParser.MINUS, 0); }
		public PlusOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterPlusOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitPlusOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitPlusOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusOpContext plusOp() throws RecognitionException {
		PlusOpContext _localctx = new PlusOpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_plusOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==PLUS) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(lyParser.AND, 0); }
		public TerminalNode OR() { return getToken(lyParser.OR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitBoolOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitBoolOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode LE() { return getToken(lyParser.LE, 0); }
		public TerminalNode LT() { return getToken(lyParser.LT, 0); }
		public TerminalNode GE() { return getToken(lyParser.GE, 0); }
		public TerminalNode GT() { return getToken(lyParser.GT, 0); }
		public TerminalNode EQ() { return getToken(lyParser.EQ, 0); }
		public TerminalNode NE() { return getToken(lyParser.NE, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GE) | (1L << GT) | (1L << LE) | (1L << LT) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharTypeContext extends TypeContext {
		public TerminalNode CHAR() { return getToken(lyParser.CHAR, 0); }
		public CharTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterCharType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitCharType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBLOCK() { return getToken(lyParser.LBLOCK, 0); }
		public TerminalNode RBLOCK() { return getToken(lyParser.RBLOCK, 0); }
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode INT() { return getToken(lyParser.INT, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VoidTypeContext extends TypeContext {
		public TerminalNode VOID() { return getToken(lyParser.VOID, 0); }
		public VoidTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOL() { return getToken(lyParser.BOOL, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lyListener ) ((lyListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lyVisitor ) return ((lyVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(267);
				match(INT);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(BOOL);
				}
				break;
			case CHAR:
				{
				_localctx = new CharTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				match(CHAR);
				}
				break;
			case VOID:
				{
				_localctx = new VoidTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(273);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(274);
					match(LBLOCK);
					setState(275);
					match(RBLOCK);
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 17:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\64\u011c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\6\3/\n\3\r\3\16\3\60\3\4\3"+
		"\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\7\5E\n\5\f\5\16\5H\13\5\3\5\3\5\3\6\3\6\5\6N\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\7\7U\n\7\f\7\16\7X\13\7\5\7Z\n\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\7\bf\n\b\f\b\16\bi\13\b\5\bk\n\b\3\b\3\b\3\b\3\t\5\tq\n\t\3\t\3"+
		"\t\5\tu\n\t\3\t\3\t\3\t\7\tz\n\t\f\t\16\t}\13\t\3\n\5\n\u0080\n\n\3\n"+
		"\3\n\3\n\3\n\7\n\u0086\n\n\f\n\16\n\u0089\13\n\3\13\3\13\3\13\5\13\u008e"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009d\n"+
		"\f\f\f\16\f\u00a0\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u00b3\n\f\f\f\16\f\u00b6\13\f\5\f\u00b8\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c1\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00d3\n\f\f\f\16\f\u00d6\13\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e2\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ef\n\r\f\r\16\r\u00f2\13\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u00fa\n\r\f\r\16\r\u00fd\13\r\3\r\3\r\5\r\u0101\n\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0112\n\23\3\23\3\23\3\23\7\23\u0117\n\23\f\23\16\23\u011a"+
		"\13\23\3\23\2\4\26$\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\7"+
		"\4\2  \"\"\4\2((**\4\2  ##\4\2\23\23,,\5\2\30\33\37\37!!\u0134\2&\3\2"+
		"\2\2\4.\3\2\2\2\6\62\3\2\2\2\b@\3\2\2\2\nM\3\2\2\2\fO\3\2\2\2\16`\3\2"+
		"\2\2\20p\3\2\2\2\22\177\3\2\2\2\24\u008a\3\2\2\2\26\u00c0\3\2\2\2\30\u0100"+
		"\3\2\2\2\32\u0102\3\2\2\2\34\u0104\3\2\2\2\36\u0106\3\2\2\2 \u0108\3\2"+
		"\2\2\"\u010a\3\2\2\2$\u0111\3\2\2\2&\'\7\4\2\2\'(\7.\2\2()\7\24\2\2)*"+
		"\5\4\3\2*\3\3\2\2\2+,\5\n\6\2,-\7\'\2\2-/\3\2\2\2.+\3\2\2\2/\60\3\2\2"+
		"\2\60.\3\2\2\2\60\61\3\2\2\2\61\5\3\2\2\2\628\7\34\2\2\63\64\5\n\6\2\64"+
		"\65\7\'\2\2\65\67\3\2\2\2\66\63\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2"+
		"\2\29;\3\2\2\2:8\3\2\2\2;<\7\f\2\2<=\5\26\f\2=>\7\'\2\2>?\7%\2\2?\7\3"+
		"\2\2\2@F\7\34\2\2AB\5\n\6\2BC\7\'\2\2CE\3\2\2\2DA\3\2\2\2EH\3\2\2\2FD"+
		"\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7%\2\2J\t\3\2\2\2KN\5\22\n\2"+
		"LN\5\26\f\2MK\3\2\2\2ML\3\2\2\2N\13\3\2\2\2OP\7.\2\2PY\7\35\2\2QV\5\20"+
		"\t\2RS\7\25\2\2SU\5\20\t\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3"+
		"\2\2\2XV\3\2\2\2YQ\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7&\2\2\\]\7\3\2\2]^"+
		"\5$\23\2^_\5\6\4\2_\r\3\2\2\2`a\7.\2\2aj\7\35\2\2bg\5\20\t\2cd\7\25\2"+
		"\2df\5\20\t\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2"+
		"\2\2jb\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7&\2\2mn\5\b\5\2n\17\3\2\2\2oq\7"+
		"\r\2\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rt\5$\23\2su\7)\2\2ts\3\2\2\2tu\3"+
		"\2\2\2uv\3\2\2\2v{\5\24\13\2wx\7\25\2\2xz\5\24\13\2yw\3\2\2\2z}\3\2\2"+
		"\2{y\3\2\2\2{|\3\2\2\2|\21\3\2\2\2}{\3\2\2\2~\u0080\7\r\2\2\177~\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5$\23\2\u0082\u0087"+
		"\5\24\13\2\u0083\u0084\7\25\2\2\u0084\u0086\5\24\13\2\u0085\u0083\3\2"+
		"\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\23\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008d\7.\2\2\u008b\u008c\7\22\2"+
		"\2\u008c\u008e\5\26\f\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\25\3\2\2\2\u008f\u0090\b\f\1\2\u0090\u0091\5\32\16\2\u0091\u0092\5\26"+
		"\f\22\u0092\u00c1\3\2\2\2\u0093\u0094\7\35\2\2\u0094\u0095\5\26\f\2\u0095"+
		"\u0096\7&\2\2\u0096\u00c1\3\2\2\2\u0097\u0098\7.\2\2\u0098\u0099\7\35"+
		"\2\2\u0099\u009e\5\26\f\2\u009a\u009b\7\25\2\2\u009b\u009d\5\26\f\2\u009c"+
		"\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7&\2\2\u00a2"+
		"\u00c1\3\2\2\2\u00a3\u00a4\7\34\2\2\u00a4\u00a5\5\4\3\2\u00a5\u00a6\5"+
		"\26\f\2\u00a6\u00a7\7\'\2\2\u00a7\u00a8\7%\2\2\u00a8\u00c1\3\2\2\2\u00a9"+
		"\u00aa\7.\2\2\u00aa\u00ab\7\36\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\7"+
		"$\2\2\u00ad\u00c1\3\2\2\2\u00ae\u00b7\7\36\2\2\u00af\u00b4\5\26\f\2\u00b0"+
		"\u00b1\7\25\2\2\u00b1\u00b3\5\26\f\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3"+
		"\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00af\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00c1\7$\2\2\u00ba\u00c1\5\30\r\2\u00bb\u00c1\7.\2\2\u00bc"+
		"\u00c1\7/\2\2\u00bd\u00c1\7\61\2\2\u00be\u00c1\7\5\2\2\u00bf\u00c1\7\6"+
		"\2\2\u00c0\u008f\3\2\2\2\u00c0\u0093\3\2\2\2\u00c0\u0097\3\2\2\2\u00c0"+
		"\u00a3\3\2\2\2\u00c0\u00a9\3\2\2\2\u00c0\u00ae\3\2\2\2\u00c0\u00ba\3\2"+
		"\2\2\u00c0\u00bb\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00d4\3\2\2\2\u00c2\u00c3\f\21"+
		"\2\2\u00c3\u00c4\5\36\20\2\u00c4\u00c5\5\26\f\22\u00c5\u00d3\3\2\2\2\u00c6"+
		"\u00c7\f\20\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\5\26\f\21\u00c9\u00d3"+
		"\3\2\2\2\u00ca\u00cb\f\17\2\2\u00cb\u00cc\5\"\22\2\u00cc\u00cd\5\26\f"+
		"\20\u00cd\u00d3\3\2\2\2\u00ce\u00cf\f\16\2\2\u00cf\u00d0\5 \21\2\u00d0"+
		"\u00d1\5\26\f\17\u00d1\u00d3\3\2\2\2\u00d2\u00c2\3\2\2\2\u00d2\u00c6\3"+
		"\2\2\2\u00d2\u00ca\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\27\3\2\2\2\u00d6\u00d4\3\2\2"+
		"\2\u00d7\u00d8\7.\2\2\u00d8\u00d9\7\22\2\2\u00d9\u0101\5\26\f\2\u00da"+
		"\u00db\7\t\2\2\u00db\u00dc\7\35\2\2\u00dc\u00dd\5\26\f\2\u00dd\u00de\7"+
		"&\2\2\u00de\u00e1\5\26\f\2\u00df\u00e0\7\n\2\2\u00e0\u00e2\5\26\f\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u0101\3\2\2\2\u00e3\u00e4\7\13"+
		"\2\2\u00e4\u00e5\7\35\2\2\u00e5\u00e6\5\26\f\2\u00e6\u00e7\7&\2\2\u00e7"+
		"\u00e8\5\26\f\2\u00e8\u0101\3\2\2\2\u00e9\u00ea\7\7\2\2\u00ea\u00eb\7"+
		"\35\2\2\u00eb\u00f0\7.\2\2\u00ec\u00ed\7\25\2\2\u00ed\u00ef\7.\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u0101\7&\2\2\u00f4"+
		"\u00f5\7\b\2\2\u00f5\u00f6\7\35\2\2\u00f6\u00fb\5\26\f\2\u00f7\u00f8\7"+
		"\25\2\2\u00f8\u00fa\5\26\f\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fe\u00ff\7&\2\2\u00ff\u0101\3\2\2\2\u0100\u00d7\3\2\2\2\u0100"+
		"\u00da\3\2\2\2\u0100\u00e3\3\2\2\2\u0100\u00e9\3\2\2\2\u0100\u00f4\3\2"+
		"\2\2\u0101\31\3\2\2\2\u0102\u0103\t\2\2\2\u0103\33\3\2\2\2\u0104\u0105"+
		"\t\3\2\2\u0105\35\3\2\2\2\u0106\u0107\t\4\2\2\u0107\37\3\2\2\2\u0108\u0109"+
		"\t\5\2\2\u0109!\3\2\2\2\u010a\u010b\t\6\2\2\u010b#\3\2\2\2\u010c\u010d"+
		"\b\23\1\2\u010d\u0112\7\17\2\2\u010e\u0112\7\20\2\2\u010f\u0112\7\21\2"+
		"\2\u0110\u0112\7\16\2\2\u0111\u010c\3\2\2\2\u0111\u010e\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0118\3\2\2\2\u0113\u0114\f\3"+
		"\2\2\u0114\u0115\7\36\2\2\u0115\u0117\7$\2\2\u0116\u0113\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119%\3\2\2\2"+
		"\u011a\u0118\3\2\2\2\34\608FMVYgjpt{\177\u0087\u008d\u009e\u00b4\u00b7"+
		"\u00c0\u00d2\u00d4\u00e1\u00f0\u00fb\u0100\u0111\u0118";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from ly.g4 by ANTLR 4.5
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FNCTYPE=1, TRUE=2, FALSE=3, READ=4, PRINT=5, IF=6, ELSE=7, WHILE=8, RETURN=9, 
		CONST=10, INT=11, BOOL=12, CHAR=13, ASS=14, AND=15, COLON=16, COMMA=17, 
		DOT=18, DQUOTE=19, EQ=20, GE=21, GT=22, LE=23, LBRACE=24, LPAR=25, LBLOCK=26, 
		LT=27, MINUS=28, NE=29, NOT=30, PLUS=31, RBLOCK=32, RBRACE=33, RPAR=34, 
		SEMI=35, SLASH=36, STAR=37, OR=38, HT=39, ID=40, NUM=41, STR=42, COMMENT=43, 
		MULTICOMMENT=44, WS=45;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"FNCTYPE", "TRUE", "FALSE", "READ", "PRINT", "IF", "ELSE", "WHILE", "RETURN", 
		"CONST", "INT", "BOOL", "CHAR", "ASS", "AND", "COLON", "COMMA", "DOT", 
		"DQUOTE", "EQ", "GE", "GT", "LE", "LBRACE", "LPAR", "LBLOCK", "LT", "MINUS", 
		"NE", "NOT", "PLUS", "RBLOCK", "RBRACE", "RPAR", "SEMI", "SLASH", "STAR", 
		"OR", "HT", "ID", "NUM", "STR", "LETTER", "DIGIT", "COMMENT", "MULTICOMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'FunctionType'", "'true'", "'false'", "'read'", "'print'", "'if'", 
		"'else'", "'while'", "'return'", "'const'", "'int'", "'bool'", "'char'", 
		"'<-'", "'&&'", "':'", "','", "'.'", "'\"'", "'='", "'>='", "'>'", "'<='", 
		"'{'", "'('", "'['", "'<'", "'-'", "'!='", "'!'", "'+'", "']'", "'}'", 
		"')'", "';'", "'/'", "'*'", "'||'", "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FNCTYPE", "TRUE", "FALSE", "READ", "PRINT", "IF", "ELSE", "WHILE", 
		"RETURN", "CONST", "INT", "BOOL", "CHAR", "ASS", "AND", "COLON", "COMMA", 
		"DOT", "DQUOTE", "EQ", "GE", "GT", "LE", "LBRACE", "LPAR", "LBLOCK", "LT", 
		"MINUS", "NE", "NOT", "PLUS", "RBLOCK", "RBRACE", "RPAR", "SEMI", "SLASH", 
		"STAR", "OR", "HT", "ID", "NUM", "STR", "COMMENT", "MULTICOMMENT", "WS"
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


	public lyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ly.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2/\u0122\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3)\7)\u00eb\n)\f)\16"+
		")\u00ee\13)\3*\3*\7*\u00f2\n*\f*\16*\u00f5\13*\3+\3+\7+\u00f9\n+\f+\16"+
		"+\u00fc\13+\3+\3+\3,\3,\3-\3-\3.\3.\7.\u0106\n.\f.\16.\u0109\13.\3.\3"+
		".\3.\3.\3/\3/\3/\7/\u0112\n/\f/\16/\u0115\13/\3/\3/\3/\3/\3/\3\60\6\60"+
		"\u011d\n\60\r\60\16\60\u011e\3\60\3\60\5\u00fa\u0107\u0113\2\61\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y\2[-]._/\3\2\5\4\2C\\c|\3\2\62;\5\2\13\f\17"+
		"\17\"\"\u0126\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5n\3"+
		"\2\2\2\7s\3\2\2\2\ty\3\2\2\2\13~\3\2\2\2\r\u0084\3\2\2\2\17\u0087\3\2"+
		"\2\2\21\u008c\3\2\2\2\23\u0092\3\2\2\2\25\u0099\3\2\2\2\27\u009f\3\2\2"+
		"\2\31\u00a3\3\2\2\2\33\u00a8\3\2\2\2\35\u00ad\3\2\2\2\37\u00b0\3\2\2\2"+
		"!\u00b3\3\2\2\2#\u00b5\3\2\2\2%\u00b7\3\2\2\2\'\u00b9\3\2\2\2)\u00bb\3"+
		"\2\2\2+\u00bd\3\2\2\2-\u00c0\3\2\2\2/\u00c2\3\2\2\2\61\u00c5\3\2\2\2\63"+
		"\u00c7\3\2\2\2\65\u00c9\3\2\2\2\67\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00cf"+
		"\3\2\2\2=\u00d2\3\2\2\2?\u00d4\3\2\2\2A\u00d6\3\2\2\2C\u00d8\3\2\2\2E"+
		"\u00da\3\2\2\2G\u00dc\3\2\2\2I\u00de\3\2\2\2K\u00e0\3\2\2\2M\u00e2\3\2"+
		"\2\2O\u00e5\3\2\2\2Q\u00e7\3\2\2\2S\u00ef\3\2\2\2U\u00f6\3\2\2\2W\u00ff"+
		"\3\2\2\2Y\u0101\3\2\2\2[\u0103\3\2\2\2]\u010e\3\2\2\2_\u011c\3\2\2\2a"+
		"b\7H\2\2bc\7w\2\2cd\7p\2\2de\7e\2\2ef\7v\2\2fg\7k\2\2gh\7q\2\2hi\7p\2"+
		"\2ij\7V\2\2jk\7{\2\2kl\7r\2\2lm\7g\2\2m\4\3\2\2\2no\7v\2\2op\7t\2\2pq"+
		"\7w\2\2qr\7g\2\2r\6\3\2\2\2st\7h\2\2tu\7c\2\2uv\7n\2\2vw\7u\2\2wx\7g\2"+
		"\2x\b\3\2\2\2yz\7t\2\2z{\7g\2\2{|\7c\2\2|}\7f\2\2}\n\3\2\2\2~\177\7r\2"+
		"\2\177\u0080\7t\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083"+
		"\7v\2\2\u0083\f\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7h\2\2\u0086\16"+
		"\3\2\2\2\u0087\u0088\7g\2\2\u0088\u0089\7n\2\2\u0089\u008a\7u\2\2\u008a"+
		"\u008b\7g\2\2\u008b\20\3\2\2\2\u008c\u008d\7y\2\2\u008d\u008e\7j\2\2\u008e"+
		"\u008f\7k\2\2\u008f\u0090\7n\2\2\u0090\u0091\7g\2\2\u0091\22\3\2\2\2\u0092"+
		"\u0093\7t\2\2\u0093\u0094\7g\2\2\u0094\u0095\7v\2\2\u0095\u0096\7w\2\2"+
		"\u0096\u0097\7t\2\2\u0097\u0098\7p\2\2\u0098\24\3\2\2\2\u0099\u009a\7"+
		"e\2\2\u009a\u009b\7q\2\2\u009b\u009c\7p\2\2\u009c\u009d\7u\2\2\u009d\u009e"+
		"\7v\2\2\u009e\26\3\2\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2"+
		"\7v\2\2\u00a2\30\3\2\2\2\u00a3\u00a4\7d\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6"+
		"\7q\2\2\u00a6\u00a7\7n\2\2\u00a7\32\3\2\2\2\u00a8\u00a9\7e\2\2\u00a9\u00aa"+
		"\7j\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7t\2\2\u00ac\34\3\2\2\2\u00ad\u00ae"+
		"\7>\2\2\u00ae\u00af\7/\2\2\u00af\36\3\2\2\2\u00b0\u00b1\7(\2\2\u00b1\u00b2"+
		"\7(\2\2\u00b2 \3\2\2\2\u00b3\u00b4\7<\2\2\u00b4\"\3\2\2\2\u00b5\u00b6"+
		"\7.\2\2\u00b6$\3\2\2\2\u00b7\u00b8\7\60\2\2\u00b8&\3\2\2\2\u00b9\u00ba"+
		"\7$\2\2\u00ba(\3\2\2\2\u00bb\u00bc\7?\2\2\u00bc*\3\2\2\2\u00bd\u00be\7"+
		"@\2\2\u00be\u00bf\7?\2\2\u00bf,\3\2\2\2\u00c0\u00c1\7@\2\2\u00c1.\3\2"+
		"\2\2\u00c2\u00c3\7>\2\2\u00c3\u00c4\7?\2\2\u00c4\60\3\2\2\2\u00c5\u00c6"+
		"\7}\2\2\u00c6\62\3\2\2\2\u00c7\u00c8\7*\2\2\u00c8\64\3\2\2\2\u00c9\u00ca"+
		"\7]\2\2\u00ca\66\3\2\2\2\u00cb\u00cc\7>\2\2\u00cc8\3\2\2\2\u00cd\u00ce"+
		"\7/\2\2\u00ce:\3\2\2\2\u00cf\u00d0\7#\2\2\u00d0\u00d1\7?\2\2\u00d1<\3"+
		"\2\2\2\u00d2\u00d3\7#\2\2\u00d3>\3\2\2\2\u00d4\u00d5\7-\2\2\u00d5@\3\2"+
		"\2\2\u00d6\u00d7\7_\2\2\u00d7B\3\2\2\2\u00d8\u00d9\7\177\2\2\u00d9D\3"+
		"\2\2\2\u00da\u00db\7+\2\2\u00dbF\3\2\2\2\u00dc\u00dd\7=\2\2\u00ddH\3\2"+
		"\2\2\u00de\u00df\7\61\2\2\u00dfJ\3\2\2\2\u00e0\u00e1\7,\2\2\u00e1L\3\2"+
		"\2\2\u00e2\u00e3\7~\2\2\u00e3\u00e4\7~\2\2\u00e4N\3\2\2\2\u00e5\u00e6"+
		"\7%\2\2\u00e6P\3\2\2\2\u00e7\u00ec\5W,\2\u00e8\u00eb\5W,\2\u00e9\u00eb"+
		"\5Y-\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00edR\3\2\2\2\u00ee\u00ec\3\2\2\2"+
		"\u00ef\u00f3\5Y-\2\u00f0\u00f2\5Y-\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3"+
		"\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4T\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f6\u00fa\5\'\24\2\u00f7\u00f9\13\2\2\2\u00f8\u00f7\3\2\2\2"+
		"\u00f9\u00fc\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd"+
		"\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\5\'\24\2\u00feV\3\2\2\2\u00ff"+
		"\u0100\t\2\2\2\u0100X\3\2\2\2\u0101\u0102\t\3\2\2\u0102Z\3\2\2\2\u0103"+
		"\u0107\5O(\2\u0104\u0106\13\2\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u010a\u010b\7\f\2\2\u010b\u010c\3\2\2\2\u010c\u010d\b."+
		"\2\2\u010d\\\3\2\2\2\u010e\u010f\5O(\2\u010f\u0113\5O(\2\u0110\u0112\13"+
		"\2\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0114\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\5O"+
		"(\2\u0117\u0118\5O(\2\u0118\u0119\3\2\2\2\u0119\u011a\b/\2\2\u011a^\3"+
		"\2\2\2\u011b\u011d\t\4\2\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\b\60"+
		"\2\2\u0121`\3\2\2\2\n\2\u00ea\u00ec\u00f3\u00fa\u0107\u0113\u011e\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
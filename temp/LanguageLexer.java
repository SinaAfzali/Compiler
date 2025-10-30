// Generated from Language.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ABSTRACT=6, PUBLIC=7, PRIVATE=8, 
		PROTECTED=9, CLASS=10, INTERFACE=11, EXTENDS=12, IMPLEMENTS=13, STATIC=14, 
		VOID=15, IF=16, ELSE=17, WHILE=18, FOR=19, BREAK=20, CONTINUE=21, RETURN=22, 
		NEW=23, THIS=24, IMPORT=25, PACKAGE=26, SEMI=27, COMMA=28, LBRACE=29, 
		RBRACE=30, LBRACK=31, RBRACK=32, LPAREN=33, RPAREN=34, DOT=35, QUESTION=36, 
		COLON=37, BOOLEANLIT=38, NULLLIT=39, INTLIT=40, CHARLIT=41, STRINGLIT=42, 
		PLUS=43, MINUS=44, MULT=45, DIV=46, MOD=47, EQ=48, NEQ=49, LT=50, GT=51, 
		LE=52, GE=53, AND=54, OR=55, NOT=56, ASSIGN=57, IDENTIFIER=58, WS=59, 
		LINE_COMMENT=60, BLOCK_COMMENT=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "ABSTRACT", "PUBLIC", "PRIVATE", 
			"PROTECTED", "CLASS", "INTERFACE", "EXTENDS", "IMPLEMENTS", "STATIC", 
			"VOID", "IF", "ELSE", "WHILE", "FOR", "BREAK", "CONTINUE", "RETURN", 
			"NEW", "THIS", "IMPORT", "PACKAGE", "SEMI", "COMMA", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "LPAREN", "RPAREN", "DOT", "QUESTION", "COLON", "BOOLEANLIT", 
			"NULLLIT", "INTLIT", "CHARLIT", "STRINGLIT", "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "EQ", "NEQ", "LT", "GT", "LE", "GE", "AND", "OR", "NOT", 
			"ASSIGN", "IDENTIFIER", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'boolean'", "'char'", "'String'", "'@'", "'abstract'", 
			"'public'", "'private'", "'protected'", "'class'", "'interface'", "'extends'", 
			"'implements'", "'static'", "'void'", "'if'", "'else'", "'while'", "'for'", 
			"'break'", "'continue'", "'return'", "'new'", "'this'", "'import'", "'package'", 
			"';'", "','", "'{'", "'}'", "'['", "']'", "'('", "')'", "'.'", "'?'", 
			"':'", null, "'null'", null, null, null, "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", 
			"'!'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "ABSTRACT", "PUBLIC", "PRIVATE", 
			"PROTECTED", "CLASS", "INTERFACE", "EXTENDS", "IMPLEMENTS", "STATIC", 
			"VOID", "IF", "ELSE", "WHILE", "FOR", "BREAK", "CONTINUE", "RETURN", 
			"NEW", "THIS", "IMPORT", "PACKAGE", "SEMI", "COMMA", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "LPAREN", "RPAREN", "DOT", "QUESTION", "COLON", "BOOLEANLIT", 
			"NULLLIT", "INTLIT", "CHARLIT", "STRINGLIT", "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "EQ", "NEQ", "LT", "GT", "LE", "GE", "AND", "OR", "NOT", 
			"ASSIGN", "IDENTIFIER", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u01b6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0148"+
		"\n\'\3(\3(\3(\3(\3(\3)\6)\u0150\n)\r)\16)\u0151\3)\3)\6)\u0156\n)\r)\16"+
		")\u0157\7)\u015a\n)\f)\16)\u015d\13)\3*\3*\3*\3*\3+\3+\7+\u0165\n+\f+"+
		"\16+\u0168\13+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\7;\u0192\n;\f;\16;\u0195\13;\3<"+
		"\6<\u0198\n<\r<\16<\u0199\3<\3<\3=\3=\3=\3=\7=\u01a2\n=\f=\16=\u01a5\13"+
		"=\3=\3=\3>\3>\3>\3>\7>\u01ad\n>\f>\16>\u01b0\13>\3>\3>\3>\3>\3>\4\u0166"+
		"\u01ae\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w=y>{?\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\2\u01be\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3}\3\2\2\2\5\u0081\3\2\2\2"+
		"\7\u0089\3\2\2\2\t\u008e\3\2\2\2\13\u0095\3\2\2\2\r\u0097\3\2\2\2\17\u00a0"+
		"\3\2\2\2\21\u00a7\3\2\2\2\23\u00af\3\2\2\2\25\u00b9\3\2\2\2\27\u00bf\3"+
		"\2\2\2\31\u00c9\3\2\2\2\33\u00d1\3\2\2\2\35\u00dc\3\2\2\2\37\u00e3\3\2"+
		"\2\2!\u00e8\3\2\2\2#\u00eb\3\2\2\2%\u00f0\3\2\2\2\'\u00f6\3\2\2\2)\u00fa"+
		"\3\2\2\2+\u0100\3\2\2\2-\u0109\3\2\2\2/\u0110\3\2\2\2\61\u0114\3\2\2\2"+
		"\63\u0119\3\2\2\2\65\u0120\3\2\2\2\67\u0128\3\2\2\29\u012a\3\2\2\2;\u012c"+
		"\3\2\2\2=\u012e\3\2\2\2?\u0130\3\2\2\2A\u0132\3\2\2\2C\u0134\3\2\2\2E"+
		"\u0136\3\2\2\2G\u0138\3\2\2\2I\u013a\3\2\2\2K\u013c\3\2\2\2M\u0147\3\2"+
		"\2\2O\u0149\3\2\2\2Q\u014f\3\2\2\2S\u015e\3\2\2\2U\u0162\3\2\2\2W\u016b"+
		"\3\2\2\2Y\u016d\3\2\2\2[\u016f\3\2\2\2]\u0171\3\2\2\2_\u0173\3\2\2\2a"+
		"\u0175\3\2\2\2c\u0178\3\2\2\2e\u017b\3\2\2\2g\u017d\3\2\2\2i\u017f\3\2"+
		"\2\2k\u0182\3\2\2\2m\u0185\3\2\2\2o\u0188\3\2\2\2q\u018b\3\2\2\2s\u018d"+
		"\3\2\2\2u\u018f\3\2\2\2w\u0197\3\2\2\2y\u019d\3\2\2\2{\u01a8\3\2\2\2}"+
		"~\7k\2\2~\177\7p\2\2\177\u0080\7v\2\2\u0080\4\3\2\2\2\u0081\u0082\7d\2"+
		"\2\u0082\u0083\7q\2\2\u0083\u0084\7q\2\2\u0084\u0085\7n\2\2\u0085\u0086"+
		"\7g\2\2\u0086\u0087\7c\2\2\u0087\u0088\7p\2\2\u0088\6\3\2\2\2\u0089\u008a"+
		"\7e\2\2\u008a\u008b\7j\2\2\u008b\u008c\7c\2\2\u008c\u008d\7t\2\2\u008d"+
		"\b\3\2\2\2\u008e\u008f\7U\2\2\u008f\u0090\7v\2\2\u0090\u0091\7t\2\2\u0091"+
		"\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093\u0094\7i\2\2\u0094\n\3\2\2\2\u0095"+
		"\u0096\7B\2\2\u0096\f\3\2\2\2\u0097\u0098\7c\2\2\u0098\u0099\7d\2\2\u0099"+
		"\u009a\7u\2\2\u009a\u009b\7v\2\2\u009b\u009c\7t\2\2\u009c\u009d\7c\2\2"+
		"\u009d\u009e\7e\2\2\u009e\u009f\7v\2\2\u009f\16\3\2\2\2\u00a0\u00a1\7"+
		"r\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7d\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5"+
		"\7k\2\2\u00a5\u00a6\7e\2\2\u00a6\20\3\2\2\2\u00a7\u00a8\7r\2\2\u00a8\u00a9"+
		"\7t\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7x\2\2\u00ab\u00ac\7c\2\2\u00ac"+
		"\u00ad\7v\2\2\u00ad\u00ae\7g\2\2\u00ae\22\3\2\2\2\u00af\u00b0\7r\2\2\u00b0"+
		"\u00b1\7t\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4\7g\2\2"+
		"\u00b4\u00b5\7e\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8"+
		"\7f\2\2\u00b8\24\3\2\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7u\2\2\u00bd\u00be\7u\2\2\u00be\26\3\2\2\2\u00bf\u00c0"+
		"\7k\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7g\2\2\u00c3"+
		"\u00c4\7t\2\2\u00c4\u00c5\7h\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7e\2\2"+
		"\u00c7\u00c8\7g\2\2\u00c8\30\3\2\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7"+
		"z\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf"+
		"\7f\2\2\u00cf\u00d0\7u\2\2\u00d0\32\3\2\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3"+
		"\7o\2\2\u00d3\u00d4\7r\2\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7g\2\2\u00d6"+
		"\u00d7\7o\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7v\2\2"+
		"\u00da\u00db\7u\2\2\u00db\34\3\2\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7"+
		"v\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2"+
		"\7e\2\2\u00e2\36\3\2\2\2\u00e3\u00e4\7x\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6"+
		"\7k\2\2\u00e6\u00e7\7f\2\2\u00e7 \3\2\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea"+
		"\7h\2\2\u00ea\"\3\2\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee"+
		"\7u\2\2\u00ee\u00ef\7g\2\2\u00ef$\3\2\2\2\u00f0\u00f1\7y\2\2\u00f1\u00f2"+
		"\7j\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7g\2\2\u00f5"+
		"&\3\2\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7t\2\2\u00f9"+
		"(\3\2\2\2\u00fa\u00fb\7d\2\2\u00fb\u00fc\7t\2\2\u00fc\u00fd\7g\2\2\u00fd"+
		"\u00fe\7c\2\2\u00fe\u00ff\7m\2\2\u00ff*\3\2\2\2\u0100\u0101\7e\2\2\u0101"+
		"\u0102\7q\2\2\u0102\u0103\7p\2\2\u0103\u0104\7v\2\2\u0104\u0105\7k\2\2"+
		"\u0105\u0106\7p\2\2\u0106\u0107\7w\2\2\u0107\u0108\7g\2\2\u0108,\3\2\2"+
		"\2\u0109\u010a\7t\2\2\u010a\u010b\7g\2\2\u010b\u010c\7v\2\2\u010c\u010d"+
		"\7w\2\2\u010d\u010e\7t\2\2\u010e\u010f\7p\2\2\u010f.\3\2\2\2\u0110\u0111"+
		"\7p\2\2\u0111\u0112\7g\2\2\u0112\u0113\7y\2\2\u0113\60\3\2\2\2\u0114\u0115"+
		"\7v\2\2\u0115\u0116\7j\2\2\u0116\u0117\7k\2\2\u0117\u0118\7u\2\2\u0118"+
		"\62\3\2\2\2\u0119\u011a\7k\2\2\u011a\u011b\7o\2\2\u011b\u011c\7r\2\2\u011c"+
		"\u011d\7q\2\2\u011d\u011e\7t\2\2\u011e\u011f\7v\2\2\u011f\64\3\2\2\2\u0120"+
		"\u0121\7r\2\2\u0121\u0122\7c\2\2\u0122\u0123\7e\2\2\u0123\u0124\7m\2\2"+
		"\u0124\u0125\7c\2\2\u0125\u0126\7i\2\2\u0126\u0127\7g\2\2\u0127\66\3\2"+
		"\2\2\u0128\u0129\7=\2\2\u01298\3\2\2\2\u012a\u012b\7.\2\2\u012b:\3\2\2"+
		"\2\u012c\u012d\7}\2\2\u012d<\3\2\2\2\u012e\u012f\7\177\2\2\u012f>\3\2"+
		"\2\2\u0130\u0131\7]\2\2\u0131@\3\2\2\2\u0132\u0133\7_\2\2\u0133B\3\2\2"+
		"\2\u0134\u0135\7*\2\2\u0135D\3\2\2\2\u0136\u0137\7+\2\2\u0137F\3\2\2\2"+
		"\u0138\u0139\7\60\2\2\u0139H\3\2\2\2\u013a\u013b\7A\2\2\u013bJ\3\2\2\2"+
		"\u013c\u013d\7<\2\2\u013dL\3\2\2\2\u013e\u013f\7v\2\2\u013f\u0140\7t\2"+
		"\2\u0140\u0141\7w\2\2\u0141\u0148\7g\2\2\u0142\u0143\7h\2\2\u0143\u0144"+
		"\7c\2\2\u0144\u0145\7n\2\2\u0145\u0146\7u\2\2\u0146\u0148\7g\2\2\u0147"+
		"\u013e\3\2\2\2\u0147\u0142\3\2\2\2\u0148N\3\2\2\2\u0149\u014a\7p\2\2\u014a"+
		"\u014b\7w\2\2\u014b\u014c\7n\2\2\u014c\u014d\7n\2\2\u014dP\3\2\2\2\u014e"+
		"\u0150\t\2\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152\u015b\3\2\2\2\u0153\u0155\7a\2\2\u0154"+
		"\u0156\t\2\2\2\u0155\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0155\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u0153\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015cR\3\2\2\2"+
		"\u015d\u015b\3\2\2\2\u015e\u015f\7)\2\2\u015f\u0160\13\2\2\2\u0160\u0161"+
		"\7)\2\2\u0161T\3\2\2\2\u0162\u0166\7$\2\2\u0163\u0165\13\2\2\2\u0164\u0163"+
		"\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167"+
		"\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016a\7$\2\2\u016aV\3\2\2\2\u016b"+
		"\u016c\7-\2\2\u016cX\3\2\2\2\u016d\u016e\7/\2\2\u016eZ\3\2\2\2\u016f\u0170"+
		"\7,\2\2\u0170\\\3\2\2\2\u0171\u0172\7\61\2\2\u0172^\3\2\2\2\u0173\u0174"+
		"\7\'\2\2\u0174`\3\2\2\2\u0175\u0176\7?\2\2\u0176\u0177\7?\2\2\u0177b\3"+
		"\2\2\2\u0178\u0179\7#\2\2\u0179\u017a\7?\2\2\u017ad\3\2\2\2\u017b\u017c"+
		"\7>\2\2\u017cf\3\2\2\2\u017d\u017e\7@\2\2\u017eh\3\2\2\2\u017f\u0180\7"+
		">\2\2\u0180\u0181\7?\2\2\u0181j\3\2\2\2\u0182\u0183\7@\2\2\u0183\u0184"+
		"\7?\2\2\u0184l\3\2\2\2\u0185\u0186\7(\2\2\u0186\u0187\7(\2\2\u0187n\3"+
		"\2\2\2\u0188\u0189\7~\2\2\u0189\u018a\7~\2\2\u018ap\3\2\2\2\u018b\u018c"+
		"\7#\2\2\u018cr\3\2\2\2\u018d\u018e\7?\2\2\u018et\3\2\2\2\u018f\u0193\t"+
		"\3\2\2\u0190\u0192\t\4\2\2\u0191\u0190\3\2\2\2\u0192\u0195\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194v\3\2\2\2\u0195\u0193\3\2\2\2"+
		"\u0196\u0198\t\5\2\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\b<\2\2\u019c"+
		"x\3\2\2\2\u019d\u019e\7\61\2\2\u019e\u019f\7\61\2\2\u019f\u01a3\3\2\2"+
		"\2\u01a0\u01a2\n\6\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1"+
		"\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6"+
		"\u01a7\b=\2\2\u01a7z\3\2\2\2\u01a8\u01a9\7\61\2\2\u01a9\u01aa\7,\2\2\u01aa"+
		"\u01ae\3\2\2\2\u01ab\u01ad\13\2\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01b0\3"+
		"\2\2\2\u01ae\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b1\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b1\u01b2\7,\2\2\u01b2\u01b3\7\61\2\2\u01b3\u01b4\3\2"+
		"\2\2\u01b4\u01b5\b>\2\2\u01b5|\3\2\2\2\f\2\u0147\u0151\u0157\u015b\u0166"+
		"\u0193\u0199\u01a3\u01ae\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
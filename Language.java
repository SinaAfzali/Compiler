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
public class Language extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENTIFIER=1, PLUS=2, MINUS=3, MULT=4, DIV=5, MOD=6, POWER=7, EQ=8, NEQ=9, 
		LT=10, GT=11, LE=12, GE=13, AND=14, OR=15, NOT=16, ASSIGN=17, DOT=18, 
		WS=19, LINE_COMMENT=20, BLOCK_COMMENT=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENTIFIER", "PLUS", "MINUS", "MULT", "DIV", "MOD", "POWER", "EQ", "NEQ", 
			"LT", "GT", "LE", "GE", "AND", "OR", "NOT", "ASSIGN", "DOT", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", "'!='", 
			"'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'!'", "'='", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IDENTIFIER", "PLUS", "MINUS", "MULT", "DIV", "MOD", "POWER", "EQ", 
			"NEQ", "LT", "GT", "LE", "GE", "AND", "OR", "NOT", "ASSIGN", "DOT", "WS", 
			"LINE_COMMENT", "BLOCK_COMMENT"
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


	public Language(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\7\2\60\n\2\f\2\16\2\63"+
		"\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\6\24_\n\24\r\24"+
		"\16\24`\3\24\3\24\3\25\3\25\3\25\3\25\7\25i\n\25\f\25\16\25l\13\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\7\26t\n\26\f\26\16\26w\13\26\3\26\3\26\3\26"+
		"\3\26\3\26\3u\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\6\5\2C\\aac|\6\2"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0080\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\64\3\2\2\2\7\66\3\2\2\2\t"+
		"8\3\2\2\2\13:\3\2\2\2\r<\3\2\2\2\17>\3\2\2\2\21A\3\2\2\2\23D\3\2\2\2\25"+
		"G\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33N\3\2\2\2\35Q\3\2\2\2\37T\3\2\2\2"+
		"!W\3\2\2\2#Y\3\2\2\2%[\3\2\2\2\'^\3\2\2\2)d\3\2\2\2+o\3\2\2\2-\61\t\2"+
		"\2\2.\60\t\3\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62"+
		"\4\3\2\2\2\63\61\3\2\2\2\64\65\7-\2\2\65\6\3\2\2\2\66\67\7/\2\2\67\b\3"+
		"\2\2\289\7,\2\29\n\3\2\2\2:;\7\61\2\2;\f\3\2\2\2<=\7\'\2\2=\16\3\2\2\2"+
		">?\7,\2\2?@\7,\2\2@\20\3\2\2\2AB\7?\2\2BC\7?\2\2C\22\3\2\2\2DE\7#\2\2"+
		"EF\7?\2\2F\24\3\2\2\2GH\7>\2\2H\26\3\2\2\2IJ\7@\2\2J\30\3\2\2\2KL\7>\2"+
		"\2LM\7?\2\2M\32\3\2\2\2NO\7@\2\2OP\7?\2\2P\34\3\2\2\2QR\7(\2\2RS\7(\2"+
		"\2S\36\3\2\2\2TU\7~\2\2UV\7~\2\2V \3\2\2\2WX\7#\2\2X\"\3\2\2\2YZ\7?\2"+
		"\2Z$\3\2\2\2[\\\7\60\2\2\\&\3\2\2\2]_\t\4\2\2^]\3\2\2\2_`\3\2\2\2`^\3"+
		"\2\2\2`a\3\2\2\2ab\3\2\2\2bc\b\24\2\2c(\3\2\2\2de\7\61\2\2ef\7\61\2\2"+
		"fj\3\2\2\2gi\n\5\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2"+
		"lj\3\2\2\2mn\b\25\2\2n*\3\2\2\2op\7\61\2\2pq\7,\2\2qu\3\2\2\2rt\13\2\2"+
		"\2sr\3\2\2\2tw\3\2\2\2uv\3\2\2\2us\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7,\2"+
		"\2yz\7\61\2\2z{\3\2\2\2{|\b\26\2\2|,\3\2\2\2\7\2\61`ju\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
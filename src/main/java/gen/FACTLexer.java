package gen;// Generated from D:/diplom/FormalizedAutomatedContractTool/FACT/src/main/java\FACT.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FACTLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NUMBER=12, CHAR=13, WHITESPACE=14, NEWLINE=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "DIGIT", "NUMBER", "CHAR", "WHITESPACE", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' OWES '", "' '", "' HAS '", "' INCLUDES '", "'PARTY '", "'AMOUNT '", 
			"'WHEN '", "'TERM '", "'SERVICE '", "'EVENT '", "'PROPERTY '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"NUMBER", "CHAR", "WHITESPACE", "NEWLINE"
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


	public FACTLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FACT.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\6\16v\n\16\r\16\16"+
		"\16w\3\16\3\16\6\16|\n\16\r\16\16\16}\5\16\u0080\n\16\3\17\6\17\u0083"+
		"\n\17\r\17\16\17\u0084\3\20\3\20\3\20\3\20\3\21\5\21\u008c\n\21\3\21\3"+
		"\21\6\21\u0090\n\21\r\21\16\21\u0091\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\2\33\16\35\17\37\20!\21\3\2\6\3\2\62;\4\2."+
		".\60\60\5\2C\\aac|\4\2\13\13\"\"\2\u0098\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5*\3\2\2\2\7,\3\2\2\2\t\62\3\2\2\2\13="+
		"\3\2\2\2\rD\3\2\2\2\17L\3\2\2\2\21R\3\2\2\2\23X\3\2\2\2\25a\3\2\2\2\27"+
		"h\3\2\2\2\31r\3\2\2\2\33u\3\2\2\2\35\u0082\3\2\2\2\37\u0086\3\2\2\2!\u008f"+
		"\3\2\2\2#$\7\"\2\2$%\7Q\2\2%&\7Y\2\2&\'\7G\2\2\'(\7U\2\2()\7\"\2\2)\4"+
		"\3\2\2\2*+\7\"\2\2+\6\3\2\2\2,-\7\"\2\2-.\7J\2\2./\7C\2\2/\60\7U\2\2\60"+
		"\61\7\"\2\2\61\b\3\2\2\2\62\63\7\"\2\2\63\64\7K\2\2\64\65\7P\2\2\65\66"+
		"\7E\2\2\66\67\7N\2\2\678\7W\2\289\7F\2\29:\7G\2\2:;\7U\2\2;<\7\"\2\2<"+
		"\n\3\2\2\2=>\7R\2\2>?\7C\2\2?@\7T\2\2@A\7V\2\2AB\7[\2\2BC\7\"\2\2C\f\3"+
		"\2\2\2DE\7C\2\2EF\7O\2\2FG\7Q\2\2GH\7W\2\2HI\7P\2\2IJ\7V\2\2JK\7\"\2\2"+
		"K\16\3\2\2\2LM\7Y\2\2MN\7J\2\2NO\7G\2\2OP\7P\2\2PQ\7\"\2\2Q\20\3\2\2\2"+
		"RS\7V\2\2ST\7G\2\2TU\7T\2\2UV\7O\2\2VW\7\"\2\2W\22\3\2\2\2XY\7U\2\2YZ"+
		"\7G\2\2Z[\7T\2\2[\\\7X\2\2\\]\7K\2\2]^\7E\2\2^_\7G\2\2_`\7\"\2\2`\24\3"+
		"\2\2\2ab\7G\2\2bc\7X\2\2cd\7G\2\2de\7P\2\2ef\7V\2\2fg\7\"\2\2g\26\3\2"+
		"\2\2hi\7R\2\2ij\7T\2\2jk\7Q\2\2kl\7R\2\2lm\7G\2\2mn\7T\2\2no\7V\2\2op"+
		"\7[\2\2pq\7\"\2\2q\30\3\2\2\2rs\t\2\2\2s\32\3\2\2\2tv\5\31\r\2ut\3\2\2"+
		"\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\177\3\2\2\2y{\t\3\2\2z|\5\31\r\2{z\3"+
		"\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177y\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\34\3\2\2\2\u0081\u0083\t\4\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\36\3\2\2"+
		"\2\u0086\u0087\t\5\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\20\2\2\u0089"+
		" \3\2\2\2\u008a\u008c\7\17\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008d\3\2\2\2\u008d\u0090\7\f\2\2\u008e\u0090\7\17\2\2\u008f\u008b"+
		"\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\"\3\2\2\2\n\2w}\177\u0084\u008b\u008f\u0091\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
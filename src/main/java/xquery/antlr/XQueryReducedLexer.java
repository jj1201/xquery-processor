// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQueryReduced.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryReducedLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, DOC=21, QUOTED_STRING=22, STRING=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "DOC", "QUOTED_STRING", "INNER_STRING", "STRING", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'for'", "'in'", "','", "'where'", "'return'", "'('", "')'", "'node()'", 
		"'text()'", "'<'", "'>'", "'{'", "'}'", "'/'", "'eq'", "'='", "'and'", 
		"'AND'", "'$'", "'//'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "DOC", "QUOTED_STRING", 
		"STRING", "WS"
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


	public XQueryReducedLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XQueryReduced.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u009c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0085\n\26\3\27\3\27\3\27\3\27\3\30\7\30\u008c"+
		"\n\30\f\30\16\30\u008f\13\30\3\31\6\31\u0092\n\31\r\31\16\31\u0093\3\32"+
		"\6\32\u0097\n\32\r\32\16\32\u0098\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\2\61\31\63\32\3\2\5\3\2$$\6\2\62;C\\aac|\5\2\13\f\17"+
		"\17\"\"\u009e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\59\3\2\2\2\7<\3\2\2\2\t>\3\2"+
		"\2\2\13D\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2\21O\3\2\2\2\23V\3\2\2\2\25]\3"+
		"\2\2\2\27_\3\2\2\2\31a\3\2\2\2\33c\3\2\2\2\35e\3\2\2\2\37g\3\2\2\2!j\3"+
		"\2\2\2#l\3\2\2\2%p\3\2\2\2\'t\3\2\2\2)v\3\2\2\2+\u0084\3\2\2\2-\u0086"+
		"\3\2\2\2/\u008d\3\2\2\2\61\u0091\3\2\2\2\63\u0096\3\2\2\2\65\66\7h\2\2"+
		"\66\67\7q\2\2\678\7t\2\28\4\3\2\2\29:\7k\2\2:;\7p\2\2;\6\3\2\2\2<=\7."+
		"\2\2=\b\3\2\2\2>?\7y\2\2?@\7j\2\2@A\7g\2\2AB\7t\2\2BC\7g\2\2C\n\3\2\2"+
		"\2DE\7t\2\2EF\7g\2\2FG\7v\2\2GH\7w\2\2HI\7t\2\2IJ\7p\2\2J\f\3\2\2\2KL"+
		"\7*\2\2L\16\3\2\2\2MN\7+\2\2N\20\3\2\2\2OP\7p\2\2PQ\7q\2\2QR\7f\2\2RS"+
		"\7g\2\2ST\7*\2\2TU\7+\2\2U\22\3\2\2\2VW\7v\2\2WX\7g\2\2XY\7z\2\2YZ\7v"+
		"\2\2Z[\7*\2\2[\\\7+\2\2\\\24\3\2\2\2]^\7>\2\2^\26\3\2\2\2_`\7@\2\2`\30"+
		"\3\2\2\2ab\7}\2\2b\32\3\2\2\2cd\7\177\2\2d\34\3\2\2\2ef\7\61\2\2f\36\3"+
		"\2\2\2gh\7g\2\2hi\7s\2\2i \3\2\2\2jk\7?\2\2k\"\3\2\2\2lm\7c\2\2mn\7p\2"+
		"\2no\7f\2\2o$\3\2\2\2pq\7C\2\2qr\7P\2\2rs\7F\2\2s&\3\2\2\2tu\7&\2\2u("+
		"\3\2\2\2vw\7\61\2\2wx\7\61\2\2x*\3\2\2\2yz\7f\2\2z{\7q\2\2{\u0085\7e\2"+
		"\2|}\7f\2\2}~\7q\2\2~\177\7e\2\2\177\u0080\7w\2\2\u0080\u0081\7o\2\2\u0081"+
		"\u0082\7g\2\2\u0082\u0083\7p\2\2\u0083\u0085\7v\2\2\u0084y\3\2\2\2\u0084"+
		"|\3\2\2\2\u0085,\3\2\2\2\u0086\u0087\7$\2\2\u0087\u0088\5/\30\2\u0088"+
		"\u0089\7$\2\2\u0089.\3\2\2\2\u008a\u008c\n\2\2\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\60\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\u0090\u0092\t\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\62\3\2\2\2\u0095"+
		"\u0097\t\4\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\b\32\2\2\u009b"+
		"\64\3\2\2\2\7\2\u0084\u008d\u0093\u0098\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
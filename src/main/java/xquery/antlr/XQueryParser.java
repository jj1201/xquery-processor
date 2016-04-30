// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQuery.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		STRING=39, WS=40;
	public static final int
		RULE_xq = 0, RULE_var = 1, RULE_flwr = 2, RULE_lwr = 3, RULE_let = 4, 
		RULE_where = 5, RULE_ret = 6, RULE_cond = 7, RULE_some_cond = 8, RULE_ap = 9, 
		RULE_rp = 10, RULE_f = 11, RULE_file_name = 12, RULE_tag_name = 13, RULE_att_name = 14, 
		RULE_str_const = 15;
	public static final String[] ruleNames = {
		"xq", "var", "flwr", "lwr", "let", "where", "ret", "cond", "some_cond", 
		"ap", "rp", "f", "file_name", "tag_name", "att_name", "str_const"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\"'", "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", 
		"'}'", "'</'", "'for'", "'$'", "'in'", "'let'", "':='", "'where'", "'return'", 
		"'='", "'eq'", "'=='", "'is'", "'empty('", "'some'", "'and'", "'or'", 
		"'not'", "'satisfies'", "'doc'", "'(\"'", "'\")'", "'*'", "'.'", "'..'", 
		"'text()'", "'@'", "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "STRING", "WS"
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
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAsXqContext extends XqContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarAsXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterVarAsXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitVarAsXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitVarAsXq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TagNameXqContext extends XqContext {
		public List<Tag_nameContext> tag_name() {
			return getRuleContexts(Tag_nameContext.class);
		}
		public Tag_nameContext tag_name(int i) {
			return getRuleContext(Tag_nameContext.class,i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TagNameXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTagNameXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTagNameXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitTagNameXq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisXqContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ParenthesisXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterParenthesisXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitParenthesisXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitParenthesisXq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlwrXqContext extends XqContext {
		public FlwrContext flwr() {
			return getRuleContext(FlwrContext.class,0);
		}
		public FlwrXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFlwrXq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqSlashSlashRpContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqSlashSlashRpContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqSlashSlashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqSlashSlashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqSlashSlashRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetXqContext extends XqContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public LetXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterLetXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitLetXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLetXq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAsXqContext extends XqContext {
		public Str_constContext str_const() {
			return getRuleContext(Str_constContext.class,0);
		}
		public StringAsXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterStringAsXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitStringAsXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitStringAsXq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqSlashRpContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqSlashRpContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqSlashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqSlashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqSlashRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqCommaXqContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XqCommaXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqCommaXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqCommaXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqCommaXq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApAsXqContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public ApAsXqContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterApAsXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitApAsXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitApAsXq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			switch (_input.LA(1)) {
			case T__14:
				{
				_localctx = new LetXqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(33);
				let();
				setState(34);
				xq(1);
				}
				break;
			case T__12:
				{
				_localctx = new VarAsXqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				var();
				}
				break;
			case T__0:
				{
				_localctx = new StringAsXqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(T__0);
				setState(38);
				str_const();
				setState(39);
				match(T__0);
				}
				break;
			case T__28:
				{
				_localctx = new ApAsXqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				ap();
				}
				break;
			case T__1:
				{
				_localctx = new ParenthesisXqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(T__1);
				setState(43);
				xq(0);
				setState(44);
				match(T__2);
				}
				break;
			case T__6:
				{
				_localctx = new TagNameXqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(T__6);
				setState(47);
				tag_name();
				setState(48);
				match(T__7);
				setState(49);
				match(T__8);
				setState(50);
				xq(0);
				setState(51);
				match(T__9);
				setState(52);
				match(T__10);
				setState(53);
				tag_name();
				setState(54);
				match(T__7);
				}
				break;
			case T__11:
				{
				_localctx = new FlwrXqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(T__11);
				setState(57);
				flwr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(69);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new XqCommaXqContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(60);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(61);
						match(T__3);
						setState(62);
						xq(7);
						}
						break;
					case 2:
						{
						_localctx = new XqSlashRpContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(63);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(64);
						match(T__4);
						setState(65);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XqSlashSlashRpContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(66);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(67);
						match(T__5);
						setState(68);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__12);
			setState(75);
			match(STRING);
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

	public static class FlwrContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public LwrContext lwr() {
			return getRuleContext(LwrContext.class,0);
		}
		public FlwrContext flwr() {
			return getRuleContext(FlwrContext.class,0);
		}
		public FlwrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFlwr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlwrContext flwr() throws RecognitionException {
		FlwrContext _localctx = new FlwrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_flwr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			var();
			setState(78);
			match(T__13);
			setState(79);
			xq(0);
			setState(83);
			switch (_input.LA(1)) {
			case T__14:
			case T__16:
			case T__17:
				{
				setState(80);
				lwr();
				}
				break;
			case T__3:
				{
				{
				setState(81);
				match(T__3);
				setState(82);
				flwr();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LwrContext extends ParserRuleContext {
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public LwrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lwr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterLwr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitLwr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLwr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LwrContext lwr() throws RecognitionException {
		LwrContext _localctx = new LwrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lwr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(85);
				let();
				}
			}

			setState(89);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(88);
				where();
				}
			}

			setState(91);
			ret();
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

	public static class LetContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_let);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__14);
			setState(98); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(94);
					var();
					setState(95);
					match(T__15);
					setState(96);
					xq(0);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class WhereContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitWhere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__16);
			setState(103);
			cond(0);
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

	public static class RetContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__17);
			setState(106);
			xq(0);
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

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XqValueEqualCondContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XqValueEqualCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqValueEqualCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqValueEqualCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqValueEqualCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public OrCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterOrCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitOrCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitOrCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqIdEqualCondContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XqIdEqualCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqIdEqualCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqIdEqualCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqIdEqualCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public AndCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAndCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAndCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAndCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public NotCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterNotCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitNotCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitNotCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqSomeCondContext extends CondContext {
		public Some_condContext some_cond() {
			return getRuleContext(Some_condContext.class,0);
		}
		public XqSomeCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqSomeCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqSomeCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqSomeCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqEmptyCondContext extends CondContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqEmptyCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqEmptyCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqEmptyCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqEmptyCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public ParenthesisCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterParenthesisCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitParenthesisCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitParenthesisCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new NotCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(109);
				match(T__26);
				setState(110);
				cond(1);
				}
				break;
			case 2:
				{
				_localctx = new XqValueEqualCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				xq(0);
				setState(112);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(113);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new XqIdEqualCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				xq(0);
				setState(116);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(117);
				xq(0);
				}
				break;
			case 4:
				{
				_localctx = new XqEmptyCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(T__22);
				setState(120);
				xq(0);
				setState(121);
				match(T__2);
				}
				break;
			case 5:
				{
				_localctx = new XqSomeCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(T__23);
				setState(124);
				some_cond();
				}
				break;
			case 6:
				{
				_localctx = new ParenthesisCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(T__1);
				setState(126);
				cond(0);
				setState(127);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new AndCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(131);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(132);
						match(T__24);
						setState(133);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new OrCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(134);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(135);
						match(T__25);
						setState(136);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class Some_condContext extends ParserRuleContext {
		public Some_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_some_cond; }
	 
		public Some_condContext() { }
		public void copyFrom(Some_condContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SomeCondContext extends Some_condContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public Some_condContext some_cond() {
			return getRuleContext(Some_condContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public SomeCondContext(Some_condContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterSomeCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitSomeCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitSomeCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Some_condContext some_cond() throws RecognitionException {
		Some_condContext _localctx = new Some_condContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_some_cond);
		try {
			_localctx = new SomeCondContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			var();
			setState(143);
			match(T__13);
			setState(144);
			xq(0);
			setState(148);
			switch (_input.LA(1)) {
			case T__27:
				{
				{
				setState(145);
				match(T__27);
				setState(146);
				cond(0);
				}
				}
				break;
			case T__12:
				{
				setState(147);
				some_cond();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DocSlashRpContext extends ApContext {
		public File_nameContext file_name() {
			return getRuleContext(File_nameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DocSlashRpContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDocSlashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDocSlashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitDocSlashRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DocSlashSlashRpContext extends ApContext {
		public File_nameContext file_name() {
			return getRuleContext(File_nameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DocSlashSlashRpContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDocSlashSlashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDocSlashSlashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitDocSlashSlashRp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ap);
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new DocSlashRpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(T__28);
				setState(151);
				match(T__29);
				setState(152);
				file_name();
				setState(153);
				match(T__30);
				setState(154);
				match(T__4);
				setState(155);
				rp(0);
				}
				break;
			case 2:
				_localctx = new DocSlashSlashRpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(T__28);
				setState(158);
				match(T__29);
				setState(159);
				file_name();
				setState(160);
				match(T__30);
				setState(161);
				match(T__5);
				setState(162);
				rp(0);
				}
				break;
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

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RpSlashRpContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RpSlashRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpSlashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpSlashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpSlashRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttNameContext extends RpContext {
		public Att_nameContext att_name() {
			return getRuleContext(Att_nameContext.class,0);
		}
		public AttNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAttName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAttName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TagNameContext extends RpContext {
		public Tag_nameContext tag_name() {
			return getRuleContext(Tag_nameContext.class,0);
		}
		public TagNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StarContext extends RpContext {
		public StarContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitStar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpSlashSlashRpContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RpSlashSlashRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpSlashSlashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpSlashSlashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpSlashSlashRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpWithFilterContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public RpWithFilterContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpWithFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpWithFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpWithFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DotContext extends RpContext {
		public DotContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitDot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpCommaRpContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RpCommaRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpCommaRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpCommaRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpCommaRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextContext extends RpContext {
		public TextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleDotContext extends RpContext {
		public DoubleDotContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDoubleDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDoubleDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitDoubleDot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisRpContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ParenthesisRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterParenthesisRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitParenthesisRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitParenthesisRp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			switch (_input.LA(1)) {
			case STRING:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(167);
				tag_name();
				}
				break;
			case T__31:
				{
				_localctx = new StarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(T__31);
				}
				break;
			case T__32:
				{
				_localctx = new DotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__32);
				}
				break;
			case T__33:
				{
				_localctx = new DoubleDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(T__33);
				}
				break;
			case T__34:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(T__34);
				}
				break;
			case T__35:
				{
				_localctx = new AttNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(T__35);
				setState(173);
				att_name();
				}
				break;
			case T__1:
				{
				_localctx = new ParenthesisRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(T__1);
				setState(175);
				rp(0);
				setState(176);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(194);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new RpSlashRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(180);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(181);
						match(T__4);
						setState(182);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RpSlashSlashRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(183);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(184);
						match(T__5);
						setState(185);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RpCommaRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(186);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(187);
						match(T__3);
						setState(188);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RpWithFilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(189);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(190);
						match(T__36);
						setState(191);
						f(0);
						setState(192);
						match(T__37);
						}
						break;
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public AndFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAndFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAndFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAndFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDEqualFilterContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public IDEqualFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterIDEqualFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitIDEqualFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitIDEqualFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public NotFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterNotFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitNotFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitNotFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueEqualFilterContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ValueEqualFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterValueEqualFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitValueEqualFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitValueEqualFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public OrFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterOrFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitOrFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitOrFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpFilterContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public ParenthesisFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterParenthesisFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitParenthesisFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitParenthesisFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(200);
				match(T__26);
				setState(201);
				f(1);
				}
				break;
			case 2:
				{
				_localctx = new RpFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new ValueEqualFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				rp(0);
				setState(204);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(205);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new IDEqualFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				rp(0);
				setState(208);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(209);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new ParenthesisFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(T__1);
				setState(212);
				f(0);
				setState(213);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(217);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(218);
						match(T__24);
						setState(219);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(220);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(221);
						match(T__25);
						setState(222);
						f(3);
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class File_nameContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(XQueryParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(XQueryParser.STRING, i);
		}
		public File_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFile_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFile_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFile_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final File_nameContext file_name() throws RecognitionException {
		File_nameContext _localctx = new File_nameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_file_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(STRING);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(229);
				match(T__32);
				setState(230);
				match(STRING);
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(236);
				match(T__4);
				setState(237);
				match(STRING);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__32) {
					{
					{
					setState(238);
					match(T__32);
					setState(239);
					match(STRING);
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(249);
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

	public static class Tag_nameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
		public Tag_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTag_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTag_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitTag_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tag_nameContext tag_name() throws RecognitionException {
		Tag_nameContext _localctx = new Tag_nameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tag_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(STRING);
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

	public static class Att_nameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
		public Att_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_att_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAtt_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAtt_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAtt_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Att_nameContext att_name() throws RecognitionException {
		Att_nameContext _localctx = new Att_nameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_att_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(STRING);
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

	public static class Str_constContext extends ParserRuleContext {
		public Str_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_const; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterStr_const(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitStr_const(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitStr_const(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Str_constContext str_const() throws RecognitionException {
		Str_constContext _localctx = new Str_constContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_str_const);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << STRING) | (1L << WS))) != 0)) {
				{
				{
				setState(254);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__0) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(259);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 7:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 10:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 11:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u0107\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2=\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\7\2H\n\2\f\2\16\2K\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4V\n\4"+
		"\3\5\5\5Y\n\5\3\5\5\5\\\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\6\6e\n\6\r\6\16"+
		"\6f\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0084\n\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\7\t\u008c\n\t\f\t\16\t\u008f\13\t\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0097\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00a7\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00b5\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u00c5\n\f\f\f\16\f\u00c8\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00da\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\7\r\u00e2\n\r\f\r\16\r\u00e5\13\r\3\16\3\16\3\16\7\16\u00ea\n\16"+
		"\f\16\16\16\u00ed\13\16\3\16\3\16\3\16\3\16\7\16\u00f3\n\16\f\16\16\16"+
		"\u00f6\13\16\7\16\u00f8\n\16\f\16\16\16\u00fb\13\16\3\17\3\17\3\20\3\20"+
		"\3\21\7\21\u0102\n\21\f\21\16\21\u0105\13\21\3\21\2\6\2\20\26\30\22\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\5\3\2\25\26\3\2\27\30\3\2\3\3"+
		"\u0120\2<\3\2\2\2\4L\3\2\2\2\6O\3\2\2\2\bX\3\2\2\2\n_\3\2\2\2\fh\3\2\2"+
		"\2\16k\3\2\2\2\20\u0083\3\2\2\2\22\u0090\3\2\2\2\24\u00a6\3\2\2\2\26\u00b4"+
		"\3\2\2\2\30\u00d9\3\2\2\2\32\u00e6\3\2\2\2\34\u00fc\3\2\2\2\36\u00fe\3"+
		"\2\2\2 \u0103\3\2\2\2\"#\b\2\1\2#$\5\n\6\2$%\5\2\2\3%=\3\2\2\2&=\5\4\3"+
		"\2\'(\7\3\2\2()\5 \21\2)*\7\3\2\2*=\3\2\2\2+=\5\24\13\2,-\7\4\2\2-.\5"+
		"\2\2\2./\7\5\2\2/=\3\2\2\2\60\61\7\t\2\2\61\62\5\34\17\2\62\63\7\n\2\2"+
		"\63\64\7\13\2\2\64\65\5\2\2\2\65\66\7\f\2\2\66\67\7\r\2\2\678\5\34\17"+
		"\289\7\n\2\29=\3\2\2\2:;\7\16\2\2;=\5\6\4\2<\"\3\2\2\2<&\3\2\2\2<\'\3"+
		"\2\2\2<+\3\2\2\2<,\3\2\2\2<\60\3\2\2\2<:\3\2\2\2=I\3\2\2\2>?\f\b\2\2?"+
		"@\7\6\2\2@H\5\2\2\tAB\f\7\2\2BC\7\7\2\2CH\5\26\f\2DE\f\6\2\2EF\7\b\2\2"+
		"FH\5\26\f\2G>\3\2\2\2GA\3\2\2\2GD\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2"+
		"\2J\3\3\2\2\2KI\3\2\2\2LM\7\17\2\2MN\7)\2\2N\5\3\2\2\2OP\5\4\3\2PQ\7\20"+
		"\2\2QU\5\2\2\2RV\5\b\5\2ST\7\6\2\2TV\5\6\4\2UR\3\2\2\2US\3\2\2\2V\7\3"+
		"\2\2\2WY\5\n\6\2XW\3\2\2\2XY\3\2\2\2Y[\3\2\2\2Z\\\5\f\7\2[Z\3\2\2\2[\\"+
		"\3\2\2\2\\]\3\2\2\2]^\5\16\b\2^\t\3\2\2\2_d\7\21\2\2`a\5\4\3\2ab\7\22"+
		"\2\2bc\5\2\2\2ce\3\2\2\2d`\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\13\3"+
		"\2\2\2hi\7\23\2\2ij\5\20\t\2j\r\3\2\2\2kl\7\24\2\2lm\5\2\2\2m\17\3\2\2"+
		"\2no\b\t\1\2op\7\35\2\2p\u0084\5\20\t\3qr\5\2\2\2rs\t\2\2\2st\5\2\2\2"+
		"t\u0084\3\2\2\2uv\5\2\2\2vw\t\3\2\2wx\5\2\2\2x\u0084\3\2\2\2yz\7\31\2"+
		"\2z{\5\2\2\2{|\7\5\2\2|\u0084\3\2\2\2}~\7\32\2\2~\u0084\5\22\n\2\177\u0080"+
		"\7\4\2\2\u0080\u0081\5\20\t\2\u0081\u0082\7\5\2\2\u0082\u0084\3\2\2\2"+
		"\u0083n\3\2\2\2\u0083q\3\2\2\2\u0083u\3\2\2\2\u0083y\3\2\2\2\u0083}\3"+
		"\2\2\2\u0083\177\3\2\2\2\u0084\u008d\3\2\2\2\u0085\u0086\f\5\2\2\u0086"+
		"\u0087\7\33\2\2\u0087\u008c\5\20\t\6\u0088\u0089\f\4\2\2\u0089\u008a\7"+
		"\34\2\2\u008a\u008c\5\20\t\5\u008b\u0085\3\2\2\2\u008b\u0088\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\21\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\u0090\u0091\5\4\3\2\u0091\u0092\7\20\2\2\u0092"+
		"\u0096\5\2\2\2\u0093\u0094\7\36\2\2\u0094\u0097\5\20\t\2\u0095\u0097\5"+
		"\22\n\2\u0096\u0093\3\2\2\2\u0096\u0095\3\2\2\2\u0097\23\3\2\2\2\u0098"+
		"\u0099\7\37\2\2\u0099\u009a\7 \2\2\u009a\u009b\5\32\16\2\u009b\u009c\7"+
		"!\2\2\u009c\u009d\7\7\2\2\u009d\u009e\5\26\f\2\u009e\u00a7\3\2\2\2\u009f"+
		"\u00a0\7\37\2\2\u00a0\u00a1\7 \2\2\u00a1\u00a2\5\32\16\2\u00a2\u00a3\7"+
		"!\2\2\u00a3\u00a4\7\b\2\2\u00a4\u00a5\5\26\f\2\u00a5\u00a7\3\2\2\2\u00a6"+
		"\u0098\3\2\2\2\u00a6\u009f\3\2\2\2\u00a7\25\3\2\2\2\u00a8\u00a9\b\f\1"+
		"\2\u00a9\u00b5\5\34\17\2\u00aa\u00b5\7\"\2\2\u00ab\u00b5\7#\2\2\u00ac"+
		"\u00b5\7$\2\2\u00ad\u00b5\7%\2\2\u00ae\u00af\7&\2\2\u00af\u00b5\5\36\20"+
		"\2\u00b0\u00b1\7\4\2\2\u00b1\u00b2\5\26\f\2\u00b2\u00b3\7\5\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00a8\3\2\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00ab\3\2"+
		"\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4"+
		"\u00b0\3\2\2\2\u00b5\u00c6\3\2\2\2\u00b6\u00b7\f\6\2\2\u00b7\u00b8\7\7"+
		"\2\2\u00b8\u00c5\5\26\f\7\u00b9\u00ba\f\5\2\2\u00ba\u00bb\7\b\2\2\u00bb"+
		"\u00c5\5\26\f\6\u00bc\u00bd\f\3\2\2\u00bd\u00be\7\6\2\2\u00be\u00c5\5"+
		"\26\f\4\u00bf\u00c0\f\4\2\2\u00c0\u00c1\7\'\2\2\u00c1\u00c2\5\30\r\2\u00c2"+
		"\u00c3\7(\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00b6\3\2\2\2\u00c4\u00b9\3\2"+
		"\2\2\u00c4\u00bc\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\27\3\2\2\2\u00c8\u00c6\3\2\2"+
		"\2\u00c9\u00ca\b\r\1\2\u00ca\u00cb\7\35\2\2\u00cb\u00da\5\30\r\3\u00cc"+
		"\u00da\5\26\f\2\u00cd\u00ce\5\26\f\2\u00ce\u00cf\t\2\2\2\u00cf\u00d0\5"+
		"\26\f\2\u00d0\u00da\3\2\2\2\u00d1\u00d2\5\26\f\2\u00d2\u00d3\t\3\2\2\u00d3"+
		"\u00d4\5\26\f\2\u00d4\u00da\3\2\2\2\u00d5\u00d6\7\4\2\2\u00d6\u00d7\5"+
		"\30\r\2\u00d7\u00d8\7\5\2\2\u00d8\u00da\3\2\2\2\u00d9\u00c9\3\2\2\2\u00d9"+
		"\u00cc\3\2\2\2\u00d9\u00cd\3\2\2\2\u00d9\u00d1\3\2\2\2\u00d9\u00d5\3\2"+
		"\2\2\u00da\u00e3\3\2\2\2\u00db\u00dc\f\5\2\2\u00dc\u00dd\7\33\2\2\u00dd"+
		"\u00e2\5\30\r\6\u00de\u00df\f\4\2\2\u00df\u00e0\7\34\2\2\u00e0\u00e2\5"+
		"\30\r\5\u00e1\u00db\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\31\3\2\2\2\u00e5\u00e3\3\2\2"+
		"\2\u00e6\u00eb\7)\2\2\u00e7\u00e8\7#\2\2\u00e8\u00ea\7)\2\2\u00e9\u00e7"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00f9\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\7\2\2\u00ef\u00f4\7)"+
		"\2\2\u00f0\u00f1\7#\2\2\u00f1\u00f3\7)\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f7\u00ee\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\33\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd"+
		"\7)\2\2\u00fd\35\3\2\2\2\u00fe\u00ff\7)\2\2\u00ff\37\3\2\2\2\u0100\u0102"+
		"\n\4\2\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104!\3\2\2\2\u0105\u0103\3\2\2\2\30<GIUX[f\u0083\u008b"+
		"\u008d\u0096\u00a6\u00b4\u00c4\u00c6\u00d9\u00e1\u00e3\u00eb\u00f4\u00f9"+
		"\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
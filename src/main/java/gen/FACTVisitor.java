package gen;// Generated from D:/diplom/FormalizedAutomatedContractTool/FACT/src/main/java\FACT.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FACTParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FACTVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FACTParser#contract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContract(FACTParser.ContractContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(FACTParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#owes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOwes(FACTParser.OwesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#has}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHas(FACTParser.HasContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#includes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludes(FACTParser.IncludesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#party}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParty(FACTParser.PartyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#amount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmount(FACTParser.AmountContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#conditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditions(FACTParser.ConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(FACTParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(FACTParser.ServiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(FACTParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link FACTParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(FACTParser.PropertyContext ctx);
}
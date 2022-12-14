package kut.compiler.parser.ast;

import java.io.IOException;

import kut.compiler.compiler.CodeGenerator;
import kut.compiler.exception.CompileErrorException;
import kut.compiler.lexer.Token;

public class AstReturn extends AstNode 
{
	/**
	 * 
	 */
	protected Token t;
	
	protected AstNode	expr;
	
	/**
	 * @param t
	 */
	public AstReturn(AstNode expr, Token t)
	{
		this.expr 	= expr		;
		this.t 		= t			;
	}
	
	/**
	 *
	 */
	public void printTree(int indent) {
		this.println(indent, "return:" + t);
		if (expr == null) {
			this.println(indent + 1, "no expr");
		}
		else {
			expr.printTree(indent + 1);
		}
	}


	/**
	 *
	 */
	@Override
	public void cgen(CodeGenerator gen) throws IOException, CompileErrorException
	{			
		if (this.expr != null) {
			this.expr.cgen(gen);
		}
	
		gen.printCode("jmp " + gen.getExitSysCallLabel());
	}
	

	/**
	 *
	 */
	public void preprocessLocalVariables(CodeGenerator gen) throws CompileErrorException
	{
		if (expr != null) {
			expr.preprocessLocalVariables(gen);
		}
	}

}

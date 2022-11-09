package kut.compiler.parser.ast;

import java.io.IOException;

import kut.compiler.compiler.CodeGenerator;
import kut.compiler.lexer.Token;

public class AstStringLiteral extends AstNode 
{
	/**
	 * 
	 */
	protected Token t;
	
	/**
	 * @param t
	 */
	public AstStringLiteral(Token t)
	{
		this.t = t;
	}
	

	/**
	 *
	 */
	public void printTree(int indent) {
		this.println(indent, "string literal:" + t);
	}

	/**
	 *
	 */
	@Override
	public void cgen(CodeGenerator gen) throws IOException
	{	
		throw new RuntimeException("not implemented yet.");
	}
	

}

package dsaSession2Part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertInfixToPostfixTest {

	@Test
	public void testConvertInfixToPostfixWithParenthesesIncluded() 
	{
		ConvertInfixToPostfix convertInfixToPrifixInstance = new ConvertInfixToPostfix
		        ("2 + ( 3 * 3 ) / a % 4");
		assertEquals("233*a/4%+",
				convertInfixToPrifixInstance.convertInfixToPostfix());
		
		convertInfixToPrifixInstance = new ConvertInfixToPostfix
		        ("2 + ( 3 * ( 4 >= 1 ) * 3 ) / a % 4");
		assertEquals("2341>=*3*a/4%+",
				convertInfixToPrifixInstance.convertInfixToPostfix());
	}

	@Test
	public void testConvertInfixToPostfixWithParenthesesNotIncluded() 
	{
		ConvertInfixToPostfix convertInfixToPrifixInstance = new ConvertInfixToPostfix
		        ("2 + 3 == 3 / a > 4");
		assertEquals("23+3a/4>==",
				convertInfixToPrifixInstance.convertInfixToPostfix());
		
		convertInfixToPrifixInstance = new ConvertInfixToPostfix
		        ("2 + 3 * 4 >= 1 && 3 % a % 4");
		assertEquals("234*+1>=3a%4%&&",
				convertInfixToPrifixInstance.convertInfixToPostfix());
	}

	@Test(expected = AssertionError.class)
	public void testConvertInfixToPostfixWithWrongExpression() 
	{
		ConvertInfixToPostfix convertInfixToPrifixInstance = new ConvertInfixToPostfix
		        ("2 + 3 * ) 4 >= 1");
		convertInfixToPrifixInstance.convertInfixToPostfix();
		
		convertInfixToPrifixInstance = new ConvertInfixToPostfix
		        ("2 + 3 * s3 / a >");
		convertInfixToPrifixInstance.convertInfixToPostfix();
		
		convertInfixToPrifixInstance = new ConvertInfixToPostfix
		        ("2 + 3 s3 / a > 3");
		convertInfixToPrifixInstance.convertInfixToPostfix();
	}
}
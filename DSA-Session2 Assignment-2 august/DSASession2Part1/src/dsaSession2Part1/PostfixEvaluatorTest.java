package dsaSession2Part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest
{

    @Test
    public void testPostfixEvaluation() 
    {
        PostfixEvaluator postfixEvaluatorInstanceOne = new PostfixEvaluator
                ("3 2 * 2 ^ 5 3 - 8 4 / * -");
        assertEquals(32, postfixEvaluatorInstanceOne.postfixEvaluation());
        
        PostfixEvaluator postfixEvaluatorInstanceTwo = new PostfixEvaluator
                ("9 3 / 5 + 7 2 - *");
        assertEquals(40, postfixEvaluatorInstanceTwo.postfixEvaluation());
    }

    @Test(expected = AssertionError.class)
    public void testPostfixEvaluationWithWrongExpression()
    {
        PostfixEvaluator postfixEvaluatorInstance = new PostfixEvaluator
                ("3 2 * 2 ^ 5 3 - 8 4 / *");
        postfixEvaluatorInstance.postfixEvaluation();
    }
}

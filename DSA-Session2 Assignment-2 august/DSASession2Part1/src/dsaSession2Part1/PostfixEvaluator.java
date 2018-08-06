package dsaSession2Part1;

import java.util.Stack;

public class PostfixEvaluator 
{
    private final String[] postfixExpression;
    private Stack<String> stackInstance;

    /**
     * Initializes PostfixEvaluator with post-fix expression
     * @param expression post-fix expression
     */
    public PostfixEvaluator(String expression) 
    {
        postfixExpression = expression.split(" ");
        stackInstance = new Stack<String>();
    }
    
    /**
     * Evaluates post-fix expression
     * @return result of post-fix expression evaluation
     * @throws AssertionError
     */
    public int postfixEvaluation() throws AssertionError 
    {
        //throws exception if size of expression is less than 3
        if (postfixExpression.length < 3) 
        {
            throw new AssertionError("Wrong expression");
        }
        int resultOfExpression = 0;
        int operandOne;
        int operandTwo;
        for (int index = 0; index < postfixExpression.length; index++) 
        {
            //push if element is a digit
            if (EvaluatorUtility.isDigit(postfixExpression[index])) 
            {
                stackInstance.push(postfixExpression[index]);
            } 
            //if element is an operator, pop top 2 operands ,perform operation
            //and the add result back to to stack
            else if (EvaluatorUtility.isArithmeticOperator(postfixExpression[index])) 
            {
                operandTwo = Integer.parseInt(stackInstance.pop());
                operandOne = Integer.parseInt(stackInstance.pop());
                stackInstance.push("" + 
                evaluateExpression(operandOne, operandTwo,postfixExpression[index]));
            } 
            else 
            {
                throw new AssertionError("Wrong expression");
            }
        }
        
        resultOfExpression = Integer.parseInt(stackInstance.pop());
        
        if (stackInstance.isEmpty()) 
        {
            return resultOfExpression;
        }
        throw new AssertionError("Wrong expression");
    }
    
    /**
     * Performs operation between operand one and operand two on the basis of operator
     * @param operandOne first operand
     * @param operandTwo second operand
     * @param operator operator
     * @return result after operation between operands on the basis of operator
     * @throws AssertionError
     */
    private int evaluateExpression(int operandOne, int operandTwo,String operator) 
            throws AssertionError 
    {
        if ("+".equals(operator)) 
        {
            return operandOne + operandTwo;
        } 
        else if ("-".equals(operator)) 
        {
            return operandOne - operandTwo;
        } 
        else if ("*".equals(operator)) 
        {
            return operandOne * operandTwo;
        } 
        else if ("/".equals(operator))
        {
            return operandOne / operandTwo;
        } 
        else if ("%".equals(operator)) 
        {
            return operandOne % operandTwo;
        }
        else if ("^".equals(operator)) 
        {
            return (int) Math.pow(operandOne, operandTwo);
        }
        else 
        {
            throw new AssertionError("Wrong expression");
        }
    }
}

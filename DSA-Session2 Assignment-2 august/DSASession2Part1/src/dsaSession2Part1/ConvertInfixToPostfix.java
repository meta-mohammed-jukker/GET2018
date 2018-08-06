package dsaSession2Part1;

import java.util.Stack;

public class ConvertInfixToPostfix 
{
    private final String[] expressionArray;
    private Stack<String> expressionStack;
    
    /**
     * Initializes ConvertInfixToPostfix object with infix expression
     * @param infixExpression input infix expression
     * @throws AssertionError
     */
    public ConvertInfixToPostfix(String infixExpression) throws AssertionError 
    {
        if (infixExpression == null) 
        {
            throw new AssertionError("Expression is null");
        }
        this.expressionArray = infixExpression.split(" ");
        this.expressionStack = new Stack<String>();
        if(!EvaluatorUtility.isDigitOrAlphabet(expressionArray[expressionArray.length - 1]))
        {
            throw new AssertionError("Invalid expression");
        }
    }

    /**
     * Converts infix to postfix 
     * @return postfix expression
     * @throws AssertionError if wrong infix expression is given
     */
    public String convertInfixToPostfix() throws AssertionError 
    {
        //throws error if expression length is less than 2
        if (expressionArray.length < 2) 
        {
            throw new AssertionError("Invalid expression");
        }
        
        boolean isDigitOrAlphabetAppearFirstTime = true;
        StringBuilder posfixExpression = new StringBuilder();
        
        for (int index = 0; index < expressionArray.length; index++) 
        {
            // Checks if string is an operand
            if (EvaluatorUtility.isDigitOrAlphabet(expressionArray[index])) 
            {
                if(!isDigitOrAlphabetAppearFirstTime)
                {
                    throw new AssertionError("Invalid expression");
                }
                posfixExpression.append(expressionArray[index]);
                isDigitOrAlphabetAppearFirstTime = false;
            } 
            // Checks if input is (
            else if ("(".equals(expressionArray[index])) 
            {
                expressionStack.push(expressionArray[index]);
                isDigitOrAlphabetAppearFirstTime = true;
            }
            // Checks if input is )
            else if (")".equals(expressionArray[index])) 
            {
                isDigitOrAlphabetAppearFirstTime = true;
                //Loop while ( is encountered or stack is empty
                while (!expressionStack.isEmpty()
                        && !("(".equals(expressionStack.peek()))) 
                {
                    posfixExpression.append(expressionStack.pop());
                }
                //Pops stack if ( is at top, else throws exception
                if (!expressionStack.isEmpty() && ( "(".equals(expressionStack.peek())))
                {
                    expressionStack.pop();
                }// invalid expression                
                else
                {
                    throw new AssertionError("Invalid expression");
                }
                    
            }
            else 
            {
                isDigitOrAlphabetAppearFirstTime = true;
                //Appends according to precedence
                while ((!expressionStack.isEmpty())
                        && ((EvaluatorUtility
                                .getPrecedence(expressionArray[index])) <= (EvaluatorUtility
                                .getPrecedence(expressionStack.peek())))) 
                {
                    posfixExpression.append(expressionStack.pop());
                }
                expressionStack.push(expressionArray[index]);
            }
        }
        // pops all operators present in stack
        while (!expressionStack.isEmpty()) 
        {
            //throws exception, if ( encountered
            if("(".equals(expressionStack.peek()))
            {
                throw new AssertionError("Invalid expression");
            }
            posfixExpression.append(expressionStack.pop());
        }
        
        return posfixExpression.toString();
    }
}
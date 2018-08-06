package dsaSession2Part1;

public class EvaluatorUtility 
{
    
    /**
     * Checks whether string contains only digits or not
     * @param value
     * @return true if string contains only digits, otherwise false
     */
    public static boolean isDigit(String value) 
    {
        for (int index = 0; index < value.length(); index++) 
        {
            if (!((value.charAt(index) >= '0') && (value.charAt(index) <= '9'))) 
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks whether string is Arithmetic Operator or not
     * @param value
     * @return true if string is Arithmetic Operator or not, otherwise false
     */
    public static boolean isArithmeticOperator(String value) 
    {
        if (value.length() == 1) 
        {
            char operator = value.charAt(0);
            return (operator == '+' || operator == '-' || operator == '*'
                    || operator == '/' || operator == '^' || operator == '%');
        }
        return false;
    }

    /**
     * Checks whether string contains only alpha-numerics or not
     * @param value
     * @return true if string contains only alpha-numerics, otherwise false
     */
    public static boolean isDigitOrAlphabet(String value) 
    {
        String valueInUpperCase = value;
        for (int index = 0; index < valueInUpperCase.length(); index++) 
        {
            if (!(isDigit(""+value.charAt(index)) || Character.isAlphabetic(value.charAt(index))))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns integer according to Precedence 
     * @param operator
     * @return
     */
    public static int getPrecedence(String operator) 
    {
        if ("||".equals(operator)) 
        {
            return 1;
        }
        else if ("&&".equals(operator)) 
        {
            return 2;
        }
        else if ("!=".equals(operator) || "==".equals(operator)) 
        {
            return 3;
        }
        else if (">=".equals(operator) || "<=".equals(operator)
                || "<".equals(operator) || ">".equals(operator)) 
        {
            return 4;
        }
        else if ("+".equals(operator) || "-".equals(operator)) 
        {
            return 5;
        }
        else if ("*".equals(operator) || "%".equals(operator)
                || "/".equals(operator)) 
        {
            return 6;
        }
        else 
        {
            return -1;
        }
    }
}

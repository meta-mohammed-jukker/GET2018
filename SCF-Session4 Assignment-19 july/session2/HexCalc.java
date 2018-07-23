package session2;

class HexCalc extends CalcUtil implements Calculator
{
    /**
    * Adds hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after addition
    */
    public String add(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1+n2);
    }
    
    /**
    * Subtracts hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after subtraction
    */
    public String subtract(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1-n2);
    }
    
    /**
    * Multiplies hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after multiplication
    */
    public String multiply(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1*n2);
    }
    
    /**
    * Divides hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after division
    */
    public String divide(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1/n2);
    }
    
    /**
    * Finds if 2 hexadecimal values are equal without converting 
    * them into decimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal values are equal or not 
    */
    public boolean equalTo(String number1, String number2)
    {
        String num1 = removeZeros(number1);
        String num2 = removeZeros(number2);
        num1 = num1.toUpperCase();
        num2 = num2.toUpperCase();
        if(num1.length() != num2.length())
        {
            return false;
        }
        return num1.equals(num2);
    }
    
    /**
    * Finds if first hexadecimal values is greater than second 
    * without converting them into decimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return first hexadecimal values is greater than second or not 
    */
    public boolean greaterThan(String number1, String number2)
    {
        if (equalTo(number1, number2))
        {
            return false;
        }
        
        String num1 = removeZeros(number1);
        String num2 = removeZeros(number2);
        num1 = num1.toUpperCase();
        num2 = num2.toUpperCase();
        
        if (num1.length() > num2.length())
        {
            return true;
        }
        
        if (num1.length() < num2.length())
        {
            return false;
        }
        
        for(int i=0; i<num1.length(); i++)
        {
            if (num1.charAt(i) > num2.charAt(i))
            {
                return true;
            }
            else if(num1.charAt(i) < num2.charAt(i))
            {
                return false;
            }
        }
        
        return false;
    }
    
    /**
    * Finds if first hexadecimal values is less than second 
    * without converting them into decimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return first hexadecimal values is less than second or not 
    */
    public boolean lessThan(String number1, String number2)
    {
        if (equalTo(number1, number2))
        {
            return false;
        }
        
        String num1 = removeZeros(number1);
        String num2 = removeZeros(number2);
        num1 = num1.toUpperCase();
        num2 = num2.toUpperCase();
        
        if (num1.length() < num2.length())
        {
            return true;
        }
        
        if (num1.length() > num2.length())
        {
            return false;
        }
        
        for(int i=0; i<num1.length(); i++)
        {
            if (num1.charAt(i) < num2.charAt(i))
            {
                return true;
            }
        
            else if(num1.charAt(i) > num2.charAt(i))
            {
                return false;
            }
        }
        
        return false;
    }
}
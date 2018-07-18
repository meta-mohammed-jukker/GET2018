import java.util.*;

class CalcUtil
{
    /**
    * Convert hexadecimal string to decimal number.
    * @param hexval string containing hexadecimal value
    * @return decimal representation of hexadecimal value
    */
    static Long hexStringToDecimal(String hexval)
    {
        hexval="0x"+hexval;
        Long number = Long.decode(hexval);
        return number;
    }
    
    /**
    * Convert decimal number to hexadecimal string.
    * @param number long number containing decimal value
    * @return hexadecimal string representating decimal value
    */
    static String decimalToHexString(Long number)
    {
        return Long.toHexString(number).toUpperCase();
    }
    
    /**
    * Remove zeros from the starting of hexadecimal string. 
    * @param hexval string containing hexadecimal value
    * @return hexadecimal string without zeros at starting
    */
    static String removeZeros(String hexval)
    {
        int i=0;
        while(hexval.charAt(i)=='0' && i<hexval.length())
        {
            i++;
        }
        return hexval.substring(i, hexval.length());
    }
}

interface Calculator
{
    String addition(String number1, String number2);
    String subtraction(String number1, String number2);
    String multiplication(String number1, String number2);
    String division(String number1, String number2);
    boolean equalTo(String number1, String number2);
    boolean greaterThan(String number1, String number2);
    boolean lessThan(String number1, String number2);
}

class HexCalc extends CalcUtil implements Calculator
{
    /**
    * Addition of 2 hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after addition
    */
    public String addition(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1+n2);
    }
    
    /**
    * Subtraction of 2 hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after subtraction
    */
    public String subtraction(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1-n2);
    }
    
    /**
    * Multiplication of 2 hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after multiplication
    */
    public String multiplication(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1*n2);
    }
    
    /**
    * Division of 2 hexadecimal values.
    * @param number1 first hexadecimal value
    * @param number2 second hexadecimal value
    * @return hexadecimal string obtained after division
    */
    public String division(String number1, String number2)
    {
        Long n1 = hexStringToDecimal(number1);
        Long n2 = hexStringToDecimal(number2);
        return decimalToHexString(n1/n2);
    }
    
    /**
    * Find if 2 hexadecimal values are equal without converting 
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
    * Find if first hexadecimal values is greater than second 
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
        }
        
        return false;
    }
    
    /**
    * Find if first hexadecimal values is less than second 
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
        }
        
        return false;
    }
}

class HexCalcMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        HexCalc hexCalc = new HexCalc();
        
        while(true)
		{
			System.out.println("Enter the operation to be performed:");
            System.out.println("1. addition");
            System.out.println("2. subtraction");
            System.out.println("3. multiplication");
            System.out.println("4. division");
            System.out.println("5. equal to");            
            System.out.println("6. greater than");
            System.out.println("7. less than");
            System.out.println("8. hexadecimal to decimal");
            System.out.println("9. decimal to hexadecimal");
			System.out.println("10. exit");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter first number: ");
					String a1 = scan.next();
                    System.out.println("Enter second number: ");
					String a2 = scan.next();
                    System.out.println("Addition Result: " + hexCalc.addition(a1, a2));
                    break;
                case 2:
                    System.out.println("Enter first number: ");
					String s1 = scan.next();
                    System.out.println("Enter second number: ");
					String s2 = scan.next();
                    System.out.println("Subtraction Result: " + hexCalc.subtraction(s1, s2));
                    break;
                case 3:
                    System.out.println("Enter first number: ");
					String m1 = scan.next();
                    System.out.println("Enter second number: ");
					String m2 = scan.next();
                    System.out.println("Multiplication Result: " + hexCalc.multiplication(m1, m2));
                    break;
                case 4:
                    System.out.println("Enter first number: ");
					String d1 = scan.next();
                    System.out.println("Enter second number: ");
					String d2 = scan.next();
                    System.out.println("Division Result: " + hexCalc.division(d1, d2));
                    break;
                case 5:
                    System.out.println("Enter first number: ");
					String e1 = scan.next();
                    System.out.println("Enter second number: ");
					String e2 = scan.next();
                    if (hexCalc.equalTo(e1, e2))
                    {
                        System.out.println(e1 + " is equal to " + e2);
                    }
                    break;
                case 6:
                    System.out.println("Enter first number: ");
					String g1 = scan.next();
                    System.out.println("Enter second number: ");
					String g2 = scan.next();
                    if (hexCalc.greaterThan(g1, g2))
                    {
                        System.out.println(g1 + " is greater than " + g2);
                    }
                    else
                    {
                        System.out.println(g1 + " is not greater than " + g2);
                    }
                    break;
                case 7:
                    System.out.println("Enter first number: ");
					String l1 = scan.next();
                    System.out.println("Enter second number: ");
					String l2 = scan.next();
                    if (hexCalc.lessThan(l1, l2))
                    {
                        System.out.println(l1 + " is less than " + l2);
                    }
                    else
                    {
                        System.out.println(l1 + " is not less than " + l2);
                    }
                    break;
                case 8:
                    System.out.println("Enter hexadecimal number: ");
					String hex = scan.next();
                    System.out.println("Decimal representation: " + hexCalc.hexStringToDecimal(hex));
                    break;
                case 9:
                    System.out.println("Enter decimal number: ");
                    Long dec = scan.nextLong();
                    System.out.println("Hexadecimal representation: " + hexCalc.decimalToHexString(dec));
                    break;
                case 10:
                    System.exit(0);
					break;  
				default:
					System.out.println("Wrong Entry");
					break;
            }
        }
    }
}
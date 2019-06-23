import java .util.*;
import java.io.*;

class StringOperation
{
    /**
	 * This method checks if given strings are equal
	 * @param string1 is first string passed by user
	 * @param string2 is second string passed by user
	 * @return 1 if equal strings else 0
	 */
    int compareString(String string1, String string2)
    {
        if(string1.length() != string2.length())
        {
            return 0;
            
        }
        for(int i=0; i<string1.length(); i++)
        {
            if(string1.charAt(i) != string2.charAt(i))
            {
                return 0;
            }
        }
        return 1;
    }
    
    /**
	 * This method reverse given string
	 * @param string is string passed by user
	 * @return string after reversing it
	 */
    String reverseString(String string)
    {
        String reverseString = "";
        for(int i=(string.length() - 1); i>=0; i--)
        {
            reverseString += string.charAt(i);
        }
        return reverseString;
    }
    
    /**
	 * This method changes upper case to lower case and vice versa
	 * @param string is string passed by user
	 * @return string by changing case
	 */
    String changeCase(String string)
    {
        String reverseCase = "";
        for(int i=0; i<string.length(); i++)
        {
            if (string.charAt(i) >= 'a' && string.charAt(i)<='z')
            {
                reverseCase += (char)(string.charAt(i) - 32);
            }
            else if (string.charAt(i) >= 'A' && string.charAt(i)<='Z')
            {
                reverseCase += (char)(string.charAt(i) + 32);
            }
            else
            {
                reverseCase += string.charAt(i);
            }
        }
        return reverseCase;
    }
    
    /**
	 * This method finds largest word of a string, 
     * if two words are of same length then it return last word
	 * @param string is string passed by user
	 * @return last largest string
	 */
    String largestWord(String string)
    {
		String largestString = "";
		String checklarge;
		int len = string.length();
		for(int i=0; i < len; i++)
        {
            checklarge = "";
            if(string.charAt(i) == ' ')
            {
                for(int temp=i-1; temp>=0 && string.charAt(temp)!=' ';temp--)
                {
                    checklarge = string.charAt(temp) + checklarge;
                }
                if(checklarge.length() >= largestString.length())
                {
                    largestString = checklarge;
                }
            }
            if(i+1 == len)
            {
                for(int temp=i; temp>=0 && string.charAt(temp)!=' ';temp--)
                {
                    checklarge = string.charAt(temp) + checklarge;
                }
                if(checklarge.length() >= largestString.length())
                {
                    largestString = checklarge;
                }
            }
        }
        return largestString;
    }
}

class StringOperationMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        StringOperation so = new StringOperation();
        
        while(true)
		{
			System.out.println("Enter the operation to be performed:");
            System.out.println("1. compare strings");
            System.out.println("2. string reversal");
            System.out.println("3. change case in string");
            System.out.println("4. find largest word");
            System.out.println("5. exit");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter first string: ");
                    String string1 = scan.next(); 
                    System.out.println("Enter second string: ");
                    String string2 = scan.next(); 
                    if(so.compareString(string1, string2) == 1)
                    {
                        System.out.println(string1 + " is equal to " + string2);
                    }
                    else
                    {
                        System.out.println(string1 + " is not equal to " + string2);
                    }
                    break;
                case 2:
                    System.out.println("Enter the string: ");
                    String string3 = scan.next(); 
                    System.out.println("Reversed string: " + so.reverseString(string3));
                    break;
                case 3:
                    System.out.println("Enter the string: ");
                    String string4 = scan.next(); 
                    System.out.println("Reversed case string: " + so.changeCase(string4));
                    break;
                case 4:
                    System.out.println("Enter the string: ");
                    String string5 = scan.next();
                    string5 += scan.nextLine();                    
                    String output = so.largestWord(string5);
                    System.out.println("Largest word: " + output);
                    break;
                case 5:
                    System.exit(0);
					break;  
				default:
					System.out.println("Wrong Entry");
					break;
            }
        }
    }
}

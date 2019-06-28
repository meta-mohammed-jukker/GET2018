package session3;

public class StringOperation
{
    /**
     * Checks if given strings are equal
     * @param string1 is first string passed by user
     * @param string2 is second string passed by user
     * @return 1 if equal strings else 0
     */
    int comparingString(String string1, String string2)
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
     * Reverses given string
     * @param string is string passed by user
     * @return string after reversing it
     */
    String reversingString(String string)
    {
        String reversedString = "";
        for(int i=(string.length() - 1); i>=0; i--)
        {
            reversedString += string.charAt(i);
        }
        return reversedString;
    }
    
    /**
     * Changes upper case to lower case and vice versa
     * @param string is string passed by user
     * @return string by changing case
     */
    String changingCase(String string)
    {
        String reversedCase = "";
        for(int i=0; i<string.length(); i++)
        {
            if (string.charAt(i) >= 'a' && string.charAt(i)<='z')
            {
                reversedCase += (char)(string.charAt(i) - 32);
            }
            else if (string.charAt(i) >= 'A' && string.charAt(i)<='Z')
            {
                reversedCase += (char)(string.charAt(i) + 32);
            }
            else
            {
                reversedCase += string.charAt(i);
            }
        }
        return reversedCase;
    }
    
    /**
     * Finds largest word in a string, 
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

package session2;
import java.util.HashMap;
import java.util.Map;

class CalcUtil
{
    static Map<Character, Long> hexMap = new HashMap<Character, Long>()
        {{
            put('0', 0L);
            put('1', 1L);
            put('2', 2L);
            put('3', 3L);
            put('4', 4L);
            put('5', 5L);
            put('6', 6L);
            put('7', 7L);
            put('8', 8L);
            put('9', 9L);
            put('A', 10L);
            put('B', 11L);
            put('C', 12L);
            put('D', 13L);
            put('E', 14L);
            put('F', 15L);
        }};
    
    /**
     * Returns key for Map values
     * @param map Map object containing key, values 
     * @param value value for which corresponding key is to be returned
     * @return key corresponding to to Map value
     */
    public static Object getKeyFromValue(Map map, Object value)
    {
        for (Object object : map.keySet())
        {
            if (map.get(object).equals(value))
            {
                return object;
            }
        }
        return null;
    }
    
    /**
     * Reverse given string
     * @param string is string passed by user
     * @return string after reversing it
     */
    public static String reverseString(String string)
    {
        String reverseString = "";
        for(int i=(string.length() - 1); i>=0; i--)
        {
            reverseString += string.charAt(i);
        }
        return reverseString;
    }
    
    /**
    * Converts hexadecimal string to decimal number.
    * @param hexval string containing hexadecimal value
    * @return decimal representation of hexadecimal value
    */
    static Long hexStringToDecimal(String hexval)
    {
        String hexadecimal =  hexval.toUpperCase();
        Long number = 0L;
        for(int i=(hexadecimal.length() - 1); i>=0; i--)
        {
            Long multiplier = (long) Math.pow(16, (hexadecimal.length() - 1 - i));
            number += hexMap.get(hexadecimal.charAt(i)) * multiplier;
        }
        return number;
    }
    
    /**
    * Converts decimal number to hexadecimal string.
    * @param number long number containing decimal value
    * @return hexadecimal string representing decimal value
    */
    static String decimalToHexString(Long number)
    {
        String hexadecimal = "";
        Long decimalValue = number;
        //return Long.toHexString(number).toUpperCase();
        while(decimalValue >= 16)
        {
            Long remainder = decimalValue % 16;
            hexadecimal += getKeyFromValue(hexMap,remainder);
            decimalValue /= 16;
        } 
        hexadecimal += getKeyFromValue(hexMap,decimalValue);
        return reverseString(hexadecimal);
    }
    
    /**
    * Removes zeros from the starting of hexadecimal string. 
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
package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationTest
{
    StringOperation stringOperation = new StringOperation();

    //Tests for comparingString()
    @Test
    public void testComparingStringWithEqualArguments()
    {
        String expectedString1 = "Mohammed";
        String expectedString2 = "Mohammed";
        int expectedOutput = 1;
        assertEquals(expectedOutput, stringOperation.comparingString(expectedString1, expectedString2));
    }
    
    @Test
    public void testComparingStringWithNotEqualArguments()
    {
        String expectedString1 = "Mohammed";
        String expectedString2 = "Jukker";
        int expectedOutput = 0;
        assertEquals(expectedOutput, stringOperation.comparingString(expectedString1, expectedString2));
    }
    
    @Test
    public void testComparingStringWithCaseSensitiveArguments()
    {
        String expectedString1 = "Mohammed";
        String expectedString2 = "mohammed";
        int expectedOutput = 0;
        assertEquals(expectedOutput, stringOperation.comparingString(expectedString1, expectedString2));
    }
    
    //Tests for reversingString()
    @Test
    public void testReversingString()
    {
        String expectedString = "Mohammed";
        String expectedOutput = "demmahoM";
        assertEquals(expectedOutput, stringOperation.reversingString(expectedString));
    }
    
    //Tests for changingCase()
    @Test
    public void testChangingCase()
    {
        String expectedString = "Mohammed29";
        String expectedOutput = "mOHAMMED29";
        assertEquals(expectedOutput, stringOperation.changingCase(expectedString));
    }
    
    //Tests for largestWord()
    @Test
    public void testlargestWord()
    {
        String expectedString = "abc de fghi jkl mnop";
        String expectedOutput = "mnop";
        assertEquals(expectedOutput, stringOperation.largestWord(expectedString));
    }
    
    @Test
    public void testlargestWordWithNoWords()
    {
        String expectedString = "    ";
        String expectedOutput = "";
        assertEquals(expectedOutput, stringOperation.largestWord(expectedString));
    }
}

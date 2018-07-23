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
        assertEquals(1, stringOperation.comparingString("Mohammed", "Mohammed"));
    }
    
    @Test
    public void testComparingStringWithNotEqualArguments()
    {
        assertEquals(0, stringOperation.comparingString("Mohammed", "Jukker"));
    }
    
    @Test
    public void testComparingStringWithCaseSensitiveArguments()
    {
        assertEquals(0, stringOperation.comparingString("Mohammed", "mohammed"));
    }
    
    //Tests for reversingString()
    @Test
    public void testReversingString()
    {
        assertEquals("demmahoM", stringOperation.reversingString("Mohammed"));
    }
    
    //Tests for changingCase()
    @Test
    public void testChangingCase()
    {
        assertEquals("mOHAMMED29", stringOperation.changingCase("Mohammed29"));
    }
    
    //Tests for largestWord()
    @Test
    public void testlargestWord()
    {
        assertEquals("mnop", stringOperation.largestWord("abc de fghi jkl mnop"));
    }
    
    @Test
    public void testlargestWordWithNoWords()
    {
        assertEquals("", stringOperation.largestWord("   "));
    }
}

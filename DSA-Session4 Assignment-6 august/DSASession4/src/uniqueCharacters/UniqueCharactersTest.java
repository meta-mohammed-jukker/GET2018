package uniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniqueCharactersTest
{
    UniqueCharacters uniqueCharacters = new UniqueCharacters();
    
    @Before
    public void initialize()
    {
        uniqueCharacters.findNumberOfUniqueCharacters("mohammed");
    }
    
    @Test
    public void testFindNumberOfUniqueCharactersWithStringNotPreviouslyOccured()
    {
        int expectedOutput = 4;
        int actualOutput = uniqueCharacters.findNumberOfUniqueCharacters("jukker");
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testFindNumberOfUniqueCharactersWithStringPreviouslyOccured()
    {
        int expectedOutput = 5;
        int actualOutput = uniqueCharacters.findNumberOfUniqueCharacters("mohammed");
        assertEquals(expectedOutput, actualOutput);
    }

}

package dictionary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeDictionaryTest
{
    BinarySearchTreeDictionary<Character> binarySearchTreeDictionary =
            new BinarySearchTreeDictionary<Character>();
    
    @Before
    public void initialize()
    {
        binarySearchTreeDictionary.add("d", 'a');
        binarySearchTreeDictionary.add("b", 's');
        binarySearchTreeDictionary.add("a", 'h');
    }
    
    @Test
    public void testAdd()
    {
        binarySearchTreeDictionary.add("c", 'd');
        binarySearchTreeDictionary.add("e", 'q');
        
        String[] expectedOutput = {"a h","b s", "c d", "d a", "e q"};
        int i = 0;
        for(Item item: binarySearchTreeDictionary.sort())
        {
            String actualOutput = item.getKey() + " " + item.getValue();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test
    public void testDelete()
    {
        binarySearchTreeDictionary.delete("a");
        
        String[] expectedOutput = {"b s", "d a"};
        int i = 0;
        for(Item item: binarySearchTreeDictionary.sort())
        {
            String actualOutput = item.getKey() + " " + item.getValue();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }

    @Test
    public void testSort()
    {        
        String[] expectedOutput = {"a h","b s", "d a"};
        int i = 0;
        for(Item item: binarySearchTreeDictionary.sort())
        {
            String actualOutput = item.getKey() + " " + item.getValue();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test
    public void testSortBetween()
    {        
        String[] expectedOutput = {"b s", "d a"};
        int i = 0;
        for(Item item: binarySearchTreeDictionary.sortBetween("b", "f"))
        {
            String actualOutput = item.getKey() + " " + item.getValue();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test
    public void testGet()
    {
        char expectedOutput = 's';
        char actualOutput = binarySearchTreeDictionary.get("b");
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = AssertionError.class)
    public void testGetWithNoSuchKey()
    {
        char actualOutput = binarySearchTreeDictionary.get("f");
    }
}

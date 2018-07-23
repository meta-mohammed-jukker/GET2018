package session5;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest
{
    Search search = new Search();

    //Tests for linearSearch()
    @Test
    public void testLinearSearch()
    {
        int[] expectedInputArray = {1, 3, 4, 2, 6, 9};
        int expectedInput = 2;
        int firstIndex = 0;
        int expectedOutputIndex = 3;
        assertEquals(expectedOutputIndex, search.linearSearch(expectedInputArray, expectedInput, firstIndex));
    }
    
    @Test
    public void testLinearSearchWithSame2Elements()
    {
        int[] expectedInputArray = {1, 3, 4, 2, 2, 6, 9};
        int expectedInput = 2;
        int firstIndex = 0;
        int expectedOutputIndex = 3;
        assertEquals(expectedOutputIndex, search.linearSearch(expectedInputArray, expectedInput, firstIndex));
    }
    
    @Test
    public void testLinearSearchWithNoElementsFound()
    {
        int[] expectedInputArray = {1, 3, 4, 6, 9};
        int expectedInput = 2;
        int firstIndex = 0;
        int expectedOutputIndex = -1;
        assertEquals(expectedOutputIndex, search.linearSearch(expectedInputArray, expectedInput, firstIndex));
    }
    
    @Test
    public void testLinearSearchWithEmptyArray()
    {
        int[] expectedInputArray = {};
        int expectedInput = 2;
        int firstIndex = 0;
        int expectedOutputIndex = -1;
        assertEquals(expectedOutputIndex, search.linearSearch(expectedInputArray, expectedInput, firstIndex));
    }

    
  //Tests for binarySearch()
    @Test
    public void testBinarySearch()
    {
        int[] expectedInputArray = {1, 2, 3, 4, 6, 9};
        int expectedInput = 2;
        int firstIndex = 0;
        int lastIndex = expectedInputArray.length-1;
        int expectedOutputIndex = 1;
        assertEquals(expectedOutputIndex, search.binarySearch(expectedInputArray, expectedInput, firstIndex, lastIndex));
    }
    
    @Test
    public void testBinarySearchWithSame2Elements()
    {
        int[] expectedInputArray = {1, 2, 2, 3, 6, 9};
        int expectedInput = 2;
        int firstIndex = 0;
        int lastIndex = expectedInputArray.length-1;
        int expectedOutputIndex = 2;
        assertEquals(expectedOutputIndex, search.binarySearch(expectedInputArray, expectedInput, firstIndex, lastIndex));
    }
    
    @Test
    public void testBinarySearchWithNoElementsFound()
    {
        int[] expectedInputArray = {1, 3, 4, 6, 9};
        int expectedInput = 21;
        int firstIndex = 0;
        int lastIndex = expectedInputArray.length-1;
        int expectedOutputIndex = -1;
        assertEquals(expectedOutputIndex, search.binarySearch(expectedInputArray, expectedInput, firstIndex, lastIndex));
    }
    
    @Test
    public void testBinarySearchWithEmptyArray()
    {
        int[] expectedInputArray = {};
        int expectedInput = 2;
        int firstIndex = 0;
        int lastIndex = expectedInputArray.length-1;
        int expectedOutputIndex = -1;
        assertEquals(expectedOutputIndex, search.binarySearch(expectedInputArray, expectedInput, firstIndex, lastIndex));
    }
}

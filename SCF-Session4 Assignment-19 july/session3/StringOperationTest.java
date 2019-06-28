package session4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest
{
	
	ArrOperation arrOperation = new ArrOperation();
	
	
	// Tests for splitListOfNumbers()
	@Test
	public void testSplitListOfNumbersWithSplitAtIndex3()
	{
	    int[] inputArray = {1, 1, 1, 2, 1};
	    int expectedOutput = 3;
		assertEquals(expectedOutput, arrOperation.splitListOfNumbers(inputArray));
	}
	
	@Test
    public void testSplitListOfNumbersWithNoSplit()
    {
        int[] inputArray = {2, 1, 1, 2, 1};
        int expectedOutput = -1;
        assertEquals(expectedOutput, arrOperation.splitListOfNumbers(inputArray));
    }
	
	@Test
    public void testSplitListOfNumbersWithSplitAtIndex1()
    {
        int[] inputArray = {10, 10};
        int expectedOutput = 1;
        assertEquals(expectedOutput, arrOperation.splitListOfNumbers(inputArray));
    }
	
	/**
     * to test if array is empty
     */
	@Test(expected = AssertionError.class )
    public void testSpLitlistOfNumbersWithEmptyArray()
    {
        int[] inputArray = {};
        arrOperation.splitListOfNumbers(inputArray);
    }
	
	
	//Tests for fixXY()
	@Test
	public void testFixXY1()
	{
	    int[] inputArray = {5, 4, 9, 4, 9, 5};
	    int[] expectedArray = {9, 4, 5, 4, 5, 9};
	    assertArrayEquals(expectedArray, arrOperation.fixXY(inputArray, 4, 5));
	}
	
	@Test
    public void testFixXY2()
    {
        int[] inputArray = {1, 3, 1, 2};
        int[] expectedArray = {1, 3, 2, 1};
        assertArrayEquals(expectedArray, arrOperation.fixXY(inputArray, 3, 2));
    }
	
	@Test
    public void testFixXY3()
    {
        int[] inputArray = {1, 0, 1, 9, 9, 0, 1};
        int[] expectedArray = {1, 0, 9, 1, 1, 0, 9};
        assertArrayEquals(expectedArray, arrOperation.fixXY(inputArray, 0, 9));
    }
	
	/**
	 * to test if occurrences of X and Y are equal
	 */
	@Test(expected = AssertionError.class )
    public void testFixXYWithEqualNumberOfXY()
    {
	    int[] inputArray = {1,3,1,3,1,2,5,2,2};
	    arrOperation.fixXY(inputArray, 3, 2);
    }
	
	/**
	 * to test if array is empty
	 */
	@Test(expected = AssertionError.class )
    public void testFixXYWithEmptyArray()
    {
        int[] inputArray = {};
        arrOperation.fixXY(inputArray, 3, 2);
    }
	
	/**
	 * to test if X element is at the end
	 */
	@Test(expected = AssertionError.class )
    public void testFixXYWithXAtEnd()
    {
        int[] inputArray = {1,3,2,3,2,1};
        arrOperation.fixXY(inputArray, 1, 2);
    }
	
	
	// Tests for countClumps()
    @Test
    public void testCountClumpsWith2Clumps()
    {
        int[] inputArray = {1, 2, 2, 3, 4, 4};
        int expectedOutput = 2;
        assertEquals(expectedOutput, arrOperation.countClumps(inputArray));
    }
    
    @Test
    public void testCountClumpsWith3Clumps()
    {
        int[] inputArray = {1, 1, 2, 2, 1, 1, 2};
        int expectedOutput = 3;
        assertEquals(expectedOutput, arrOperation.countClumps(inputArray));
    }
    
    @Test
    public void testCountClumpsWith1Clump()
    {
        int[] inputArray = {1, 1, 1, 1, 1};
        int expectedOutput = 1;
        assertEquals(expectedOutput, arrOperation.countClumps(inputArray));
    }
    
    @Test
    public void testCountClumpsWithNoClump()
    {
        int[] inputArray = {1, 2, 3, 4, 5};
        int expectedOutput = 0;
        assertEquals(expectedOutput, arrOperation.countClumps(inputArray));
    }
    
    /**
     * to test if array is empty
     */
    @Test(expected = AssertionError.class )
    public void testCountClumpsWithEmptyArray()
    {
        int[] inputArray = {};
        arrOperation.countClumps(inputArray);
    }
    
    
    // Tests for findMaxMirror()
    @Test
    public void testFindMaxMirror1()
    {
        int[] inputArray = {1, 2, 3, 8, 9, 3, 2, 1};
        int expectedOutput = 3;
        assertEquals(expectedOutput, arrOperation.findMaxMirror(inputArray));
    }
    
    @Test
    public void testFindMaxMirror2()
    {
        int[] inputArray = {7, 1, 4, 9, 7, 4, 1};
        int expectedOutput = 2;
        assertEquals(expectedOutput, arrOperation.findMaxMirror(inputArray));
    }
    
    @Test
    public void testFindMaxMirror3()
    {
        int[] inputArray = {1, 2, 1, 4};
        int expectedOutput = 3;
        assertEquals(expectedOutput, arrOperation.findMaxMirror(inputArray));
    }
    
    @Test
    public void testFindMaxMirror4()
    {
        int[] inputArray = {1, 4, 5, 3, 5, 4, 1};
        int expectedOutput = 7;
        assertEquals(expectedOutput, arrOperation.findMaxMirror(inputArray));
    }
    
    @Test
    public void testFindMaxMirror5()
    {
        int[] inputArray = {1, 2, 3, 4, 5, 6};
        int expectedOutput = 0;
        assertEquals(expectedOutput, arrOperation.findMaxMirror(inputArray));
    }
    
    /**
     * to test if array is empty
     */
    @Test(expected = AssertionError.class )
    public void testFindMaxMirrorWithEmptyArray()
    {
        int[] inputArray = {};
        arrOperation.findMaxMirror(inputArray);
    }
}

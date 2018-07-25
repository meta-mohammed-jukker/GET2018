package session6;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest
{

    //Test cases for isMember()
    @Test
    public void testIsMemberWithIntegerPresentInList()
    {
        int[] InputArray = {1, 2, 3, 4, 5, 6};
        IntSet intSet = new IntSet(InputArray);
        int inputElement = 3;
        boolean expectedOutput = true;
        assertEquals(expectedOutput, intSet.isMember(inputElement));
    }
    
    @Test
    public void testIsMemberWithIntegerNotPresentInList()
    {
        int[] InputArray = {1, 2, 3, 4, 5, 6};
        IntSet intSet = new IntSet(InputArray);
        int inputElement = 7;
        boolean expectedOutput = false;
        assertEquals(expectedOutput, intSet.isMember(inputElement));
    }
    
    @Test
    public void testIsMemberWithEmptyArray()
    {
        int[] InputArray = {};
        IntSet intSet = new IntSet(InputArray);
        int inputElement = 7;
        boolean expectedOutput = false;
        assertEquals(expectedOutput, intSet.isMember(inputElement));
    }
    
    
    //Test cases for size()
    @Test
    public void testSize()
    {
        int[] InputArray = {1, 2, 3, 4, 5, 6};
        IntSet intSet = new IntSet(InputArray);
        int expectedOutput = 6;
        assertEquals(expectedOutput, intSet.size());
    }
    
    @Test
    public void testSizeWithEmptyArray()
    {
        int[] InputArray = {};
        IntSet intSet = new IntSet(InputArray);
        int expectedOutput = 0;
        assertEquals(expectedOutput, intSet.size());
    }
    
    
    //Test cases for subSet()
    @Test
    public void testSubSetWithWithAllIntegersOfInputArrayPresentInBaseArray()
    {
        int[] InputArray = {1, 2, 3, 4, 5, 6};
        IntSet intSet = new IntSet(InputArray);
        int[] expectedInputArrayForSubSet = {3, 4, 6};
        IntSet intSubSet = new IntSet(expectedInputArrayForSubSet);
        boolean expectedOutput = true;
        assertEquals(expectedOutput, intSet.subSet(intSubSet));
    }

    @Test
    public void testSubSetWithAllIntegersOfInputArrayNotPresentInBaseArray()
    {
        int[] InputArray = {1, 2, 3, 4, 5, 6};
        IntSet intSet = new IntSet(InputArray);
        int[] expectedInputArrayForSubSet = {3, 4, 7};
        IntSet intSubSet = new IntSet(expectedInputArrayForSubSet);
        boolean expectedOutput = false;
        assertEquals(expectedOutput, intSet.subSet(intSubSet));
    }
    
    @Test
    public void testSubSetWithEmptyBaseArray()
    {
        int[] InputArray = {};
        IntSet intSet = new IntSet(InputArray);
        int[] expectedInputArrayForSubSet = {3, 4, 6};
        IntSet intSubSet = new IntSet(expectedInputArrayForSubSet);
        boolean expectedOutput = false;
        assertEquals(expectedOutput, intSet.subSet(intSubSet));
    }
    
    @Test
    public void testSubSetWithEmptySubSetArray()
    {
        int[] InputArray = {1, 2, 3, 4, 5, 6};
        IntSet intSet = new IntSet(InputArray);
        int[] expectedInputArrayForSubSet = {};
        IntSet intSubSet = new IntSet(expectedInputArrayForSubSet);
        boolean expectedOutput = true;
        assertEquals(expectedOutput, intSet.subSet(intSubSet));
    }
    
    @Test
    public void testSubSetWithBothArraysEmpty()
    {
        int[] InputArray = {};
        IntSet intSet = new IntSet(InputArray);
        int[] expectedInputArrayForSubSet = {};
        IntSet intSubSet = new IntSet(expectedInputArrayForSubSet);
        boolean expectedOutput = true;
        assertEquals(expectedOutput, intSet.subSet(intSubSet));
    }
    
    
    //Test cases for getComplement()
    @Test
    public void testGetComplement()
    {
        int[] inputArray = new int[990];
        for(int i=11; i<=1000; i++)
        {
            inputArray[i-11] = i;
        }
        IntSet intSet = new IntSet(inputArray);
        
        Integer[] actualOutput = new Integer[intSet.getComplement().size()];
        actualOutput = intSet.getComplement().toArray(actualOutput);
        Arrays.sort(actualOutput);
        
        Integer[] expectedOutput = new Integer[10];
        for(int i=1; i<=10; i++)
        {
            expectedOutput[i-1] = i;
        }
        
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetComplementWithEmptyArray()
    {
        int[] inputArray = new int[0];
        IntSet intSet = new IntSet(inputArray);
        
        Integer[] actualOutput = new Integer[intSet.getComplement().size()];
        actualOutput = intSet.getComplement().toArray(actualOutput);
        Arrays.sort(actualOutput);
        
        Integer[] expectedOutput = new Integer[1000];
        for(int i=1; i<=1000; i++)
        {
            expectedOutput[i-1] = i;
        }
        
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetComplementWithArraySetEqualsToUniversalSet()
    {
        int[] inputArray = new int[1000];
        for(int i=1; i<=1000; i++)
        {
            inputArray[i-1] = i;
        }
        IntSet intSet = new IntSet(inputArray);
        
        Integer[] actualOutput = new Integer[intSet.getComplement().size()];
        actualOutput = intSet.getComplement().toArray(actualOutput);
        Arrays.sort(actualOutput);
        
        Integer[] expectedOutput = new Integer[0];
        
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    
    //Test cases for union()
    @Test
    public void testUnion()
    {
        int[] inputArray1 = {1, 3, 5, 6};
        IntSet intSet1 = new IntSet(inputArray1);
        
        int[] inputArray2 = {2, 3, 4, 5, 6};
        IntSet intSet2 = new IntSet(inputArray2);
        
        List<Integer> expectedOutputArray = new ArrayList<Integer>(6);
        expectedOutputArray.add(1);
        expectedOutputArray.add(3);
        expectedOutputArray.add(5);
        expectedOutputArray.add(6);
        expectedOutputArray.add(2);
        expectedOutputArray.add(4);
        
        Integer[] expectedOutput = new Integer[expectedOutputArray.size()];
        expectedOutput = expectedOutputArray.toArray(expectedOutput);
        Arrays.sort(expectedOutput);
        
        Integer[] actualOutput = new Integer[intSet1.union(intSet2).size()];
        actualOutput = intSet1.union(intSet2).toArray(actualOutput);
        Arrays.sort(actualOutput);
        
        assertArrayEquals(expectedOutputArray.toArray(), intSet1.union(intSet2).toArray());
        
    }
}

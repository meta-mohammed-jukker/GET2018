package dsaSession2Part2;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class IntegerNestedListTest
{
    IntegerNestedList integerNestedList = new IntegerNestedList();
    
    @Before
    public void Initialize() throws NestedListException 
    {
        //{1, 2, {1, {1, 20}, 3, 4, 5}}
        integerNestedList.add
        (Arrays.asList(1, 2, Arrays.asList(1, Arrays.asList(1, 20), 3, 4, 5)));
    }
    
    @Test
    public void testSum() throws NestedListException 
    {
        int sum = integerNestedList.sum(integerNestedList.getList());
        assertEquals(37, sum);
    }
    
    @Test
    public void testGetLargestValue() throws NestedListException 
    {
        int largestValue = integerNestedList.getLargestValue(integerNestedList.getList());
        assertEquals(20, largestValue);
    }
    
    @Test
    public void testIsPresentWithValuePresent() throws NestedListException 
    {
        boolean isPresent = integerNestedList.isPresent(integerNestedList.getList(), 20);
        assertEquals(true, isPresent);
    }
    
    @Test
    public void testIsPresentWithValueNotPresent() throws NestedListException 
    {
        boolean isPresent = integerNestedList.isPresent(integerNestedList.getList(), 200);
        assertEquals(false, isPresent);
    }
}

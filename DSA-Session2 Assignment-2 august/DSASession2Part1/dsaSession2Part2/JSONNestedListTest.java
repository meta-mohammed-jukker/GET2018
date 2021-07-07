package dsaSession2Part2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class JSONNestedListTest
{
    JSONNestedList jsonNestedList = new JSONNestedList("data.json");
    
    @Test
    public void testSum() throws NestedListException 
    {
        int sum = jsonNestedList.sum(jsonNestedList.getList());
        assertEquals(99, sum);
    }
    
    @Test
    public void testGetLargestValue() throws NestedListException 
    {
        int largestValue = jsonNestedList.getLargestValue(jsonNestedList.getList());
        assertEquals(23, largestValue);
    }
    
    @Test
    public void testIsPresentWithValuePresent() throws NestedListException 
    {
        boolean isPresent = jsonNestedList.isPresent(jsonNestedList.getList(), 23);
        assertEquals(true, isPresent);
    }
    
    @Test
    public void testIsPresentWithValueNotPresent() throws NestedListException 
    {
        boolean isPresent = jsonNestedList.isPresent(jsonNestedList.getList(), 203);
        assertEquals(false, isPresent);
    }

}

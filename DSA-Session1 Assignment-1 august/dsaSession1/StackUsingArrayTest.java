package dsaSession1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingArrayTest
{
    //Test cases for integer type
    StackUsingArray<Integer> intArray = new StackUsingArray<Integer>(4); 
    
    //Test cases for pushElement()
    @Test
    public void testIntegerPushElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.pushElement(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.pushElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.pushElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.pushElement(3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerPushElementWhenStackFull()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.pushElement(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.pushElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.pushElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.pushElement(3);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.pushElement(32);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testIntegerPushElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.pushElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for popElement()
    @Test
    public void testIntegerPopElement()
    {
        intArray.pushElement(12);
        int expectedOutput = 12;
        int actualOutput = intArray.popElement();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerPopElementWhenStackEmpty()
    {
        intArray.pushElement(12);
        int expectedOutput = 12;
        int actualOutput = intArray.popElement();
        actualOutput = intArray.popElement();
    }
    
    //Test cases for topElement()
    @Test
    public void testIntegerTopElement()
    {
        intArray.pushElement(12);
        int expectedOutput = 12;
        int actualOutput = intArray.topElement();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerTopElementWhenStackEmpty()
    {
        int actualOutput = intArray.topElement();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testIntegerIsEmpty()
    {
        intArray.pushElement(12);
        boolean expectedOutput = false;
        boolean actualOutput = intArray.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIntegerIsEmptyWhenStackEmpty()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
    
    
    
    //Test cases for double type
    StackUsingArray<Double> doubleArray = new StackUsingArray<Double>(4);
    
    //Test cases for pushElement()
    @Test
    public void testDoublePushElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleArray.pushElement(12.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.pushElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.pushElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.pushElement(3.0);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoublePushElementWhenStackFull()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleArray.pushElement(12.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.pushElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.pushElement(23.0);
        assertEquals(expectedOutput, actualOutput);        
        
        expectedOutput = true;
        actualOutput = doubleArray.pushElement(3.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.pushElement(32.5);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testDoublePushElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleArray.pushElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for popElement()
    @Test
    public void testDoublePopElement()
    {
        doubleArray.pushElement(12.8);
        double expectedOutput = 12.8;
        double actualOutput = doubleArray.popElement();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoublePopElementWhenStackEmpty()
    {
        doubleArray.pushElement(12.0);
        double expectedOutput = 12.0;
        double actualOutput = doubleArray.popElement();
        actualOutput = doubleArray.popElement();
    }
    
    //Test cases for topElement()
    @Test
    public void testDoubleTopElement()
    {
        doubleArray.pushElement(12.0);
        double expectedOutput = 12.0;
        double actualOutput = doubleArray.popElement();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoubleTopElementWhenStackEmpty()
    {
        double actualOutput = doubleArray.popElement();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testDoubleIsEmpty()
    {
        doubleArray.pushElement(12.0);
        boolean expectedOutput = false;
        boolean actualOutput = doubleArray.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testDoubleIsEmptyWhenStackEmpty()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleArray.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
}  
    
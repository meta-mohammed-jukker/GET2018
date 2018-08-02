package dsaSession1;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingArrayTest
{
    //Test cases for integer type
    QueueUsingArray<Integer> intArray = new QueueUsingArray<Integer>(4); 
    
    //Test cases for enqueueElement()
    @Test
    public void testIntegerEnqueueElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.enqueueElement(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueueElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueueElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueueElement(3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerEnqueueElementWhenStackFull()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.enqueueElement(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueueElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueueElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueueElement(3);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueueElement(32);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testIntegerEnqueueElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.enqueueElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for dequeueElement()
    @Test
    public void testIntegerDequeueElement()
    {
        intArray.enqueueElement(12);
        int expectedOutput = 12;
        int actualOutput = intArray.dequeueElement();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerDequeueElementWhenStackEmpty()
    {
        int expectedOutput = 12;
        int actualOutput = intArray.dequeueElement();
        actualOutput = intArray.dequeueElement();
    }
    
    //Test cases for peek()
    @Test
    public void testIntegerPeek()
    {
        intArray.enqueueElement(12);
        int expectedOutput = 12;
        int actualOutput = intArray.peek();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerTopElementWhenStackEmpty()
    {
        int actualOutput = intArray.peek();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testIntegerIsEmpty()
    {
        intArray.enqueueElement(12);
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
    
    //Test cases for isFull()
    @Test
    public void testIntegerIsFullWithFullQueue()
    {
        boolean expectedOutput = true;
        
        intArray.enqueueElement(12);
        intArray.enqueueElement(23);
        intArray.enqueueElement(23);
        intArray.enqueueElement(3);
        
        assertEquals(expectedOutput, intArray.isFull());
    }
    
    @Test
    public void testIntegerIsFullWithQueueNotFull()
    {
        boolean expectedOutput = false;
        
        intArray.enqueueElement(12);
        intArray.enqueueElement(23);
        intArray.enqueueElement(23);
        
        assertEquals(expectedOutput, intArray.isFull());
    }
    
    
    
    //Test cases for double type
    QueueUsingArray<Double> doubleArray = new QueueUsingArray<Double>(4);
    
    //Test cases for enqueueElement()
    @Test
    public void testDoubleEnqueueElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleArray.enqueueElement(12.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.enqueueElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.enqueueElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.enqueueElement(3.0);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoubleEnqueueElementWhenStackFull()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleArray.enqueueElement(12.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.enqueueElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.enqueueElement(23.0);
        assertEquals(expectedOutput, actualOutput);        
        
        expectedOutput = true;
        actualOutput = doubleArray.enqueueElement(3.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleArray.enqueueElement(32.5);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testDoubleEnqueueElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleArray.enqueueElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for dequeueElement()
    @Test
    public void testDoubleDequeueElement()
    {
        doubleArray.enqueueElement(12.8);
        double expectedOutput = 12.8;
        double actualOutput = doubleArray.dequeueElement();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoubleDequeueElementWhenStackEmpty()
    {
        double expectedOutput = 12.0;
        double actualOutput = doubleArray.dequeueElement();
        actualOutput = doubleArray.dequeueElement();
    }
    
    //Test cases for peek()
    @Test
    public void testDoublePeek()
    {
        doubleArray.enqueueElement(12.0);
        double expectedOutput = 12.0;
        double actualOutput = doubleArray.peek();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoublePeekWhenStackEmpty()
    {
        double actualOutput = doubleArray.peek();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testDoubleIsEmpty()
    {
        doubleArray.enqueueElement(12.0);
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
    
    //Test cases for isFull()
    @Test
    public void testDoubleIsFullWithFullQueue()
    {
        boolean expectedOutput = true;
        
        doubleArray.enqueueElement(12.12);
        doubleArray.enqueueElement(23.99);
        doubleArray.enqueueElement(23.3);
        doubleArray.enqueueElement(3.5);
        
        assertEquals(expectedOutput, doubleArray.isFull());
    }
    
    @Test
    public void testDoubleIsFullWithQueueNotFull()
    {
        boolean expectedOutput = false;
        
        doubleArray.enqueueElement(12.3);
        doubleArray.enqueueElement(23.6);
        doubleArray.enqueueElement(23.6);
        
        assertEquals(expectedOutput, doubleArray.isFull());
    }
}  
    

package dsaSession2Part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueUsingArrayTest
{
  //Test cases for integer type
    CircularQueueUsingArray<Integer> intArray = new CircularQueueUsingArray<Integer>(4); 
    
    //Test cases for enqueueElement()
    @Test
    public void testIntegerEnqueueElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.enqueue(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(3);
        assertEquals(expectedOutput, actualOutput);
        
        int dequeuedElement = intArray.dequeue();
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(37);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIntegerEnqueueElementWhenStackFull()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.enqueue(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(3);
        assertEquals(expectedOutput, actualOutput);
        
        int dequeuedElement = intArray.dequeue();
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(32);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intArray.enqueue(234);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testIntegerEnqueueElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intArray.enqueue(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for dequeueElement()
    @Test
    public void testIntegerDequeueElement()
    {
        intArray.enqueue(12);
        int expectedOutput = 12;
        int actualOutput = intArray.dequeue();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerDequeueElementWhenStackEmpty()
    {
        int expectedOutput = 12;
        int actualOutput = intArray.dequeue();
        actualOutput = intArray.dequeue();
    }
    
    //Test cases for peek()
    @Test
    public void testIntegerPeek()
    {
        intArray.enqueue(12);
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
        intArray.enqueue(12);
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
        
        intArray.enqueue(12);
        intArray.enqueue(23);
        intArray.enqueue(23);
        intArray.enqueue(3);
        
        assertEquals(expectedOutput, intArray.isFull());
    }
    
    @Test
    public void testIntegerIsFullWithQueueNotFull()
    {
        boolean expectedOutput = false;
        
        intArray.enqueue(12);
        intArray.enqueue(23);
        intArray.enqueue(23);
        
        assertEquals(expectedOutput, intArray.isFull());
    }
}

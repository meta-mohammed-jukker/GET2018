package dsaSession1;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingLinkedListTest
{
  //Test cases for integer type
    QueueUsingLinkedList<Integer> intLinkedList = new QueueUsingLinkedList<Integer>(); 
    
    //Test cases for enqueueElement()
    @Test
    public void testIntegerPushElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intLinkedList.enqueueElement(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intLinkedList.enqueueElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intLinkedList.enqueueElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intLinkedList.enqueueElement(3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testIntegerPushElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intLinkedList.enqueueElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for dequeueElement()
    @Test
    public void testIntegerPopElement()
    {
        intLinkedList.enqueueElement(12);
        int expectedOutput = 12;
        int actualOutput = intLinkedList.dequeueElement();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerPopElementWhenStackEmpty()
    {
        intLinkedList.enqueueElement(12);
        int expectedOutput = 12;
        int actualOutput = intLinkedList.dequeueElement();
        actualOutput = intLinkedList.dequeueElement();
    }
    
    //Test cases for peek()
    @Test
    public void testIntegerPeek()
    {
        intLinkedList.enqueueElement(12);
        int expectedOutput = 12;
        int actualOutput = intLinkedList.peek();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerTopElementWhenStackEmpty()
    {
        int actualOutput = intLinkedList.peek();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testIntegerIsEmpty()
    {
        intLinkedList.enqueueElement(12);
        boolean expectedOutput = false;
        boolean actualOutput = intLinkedList.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIntegerIsEmptyWhenStackEmpty()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intLinkedList.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for isFull()
    @Test
    public void testIntegerIsFull()
    {
        boolean expectedOutput = false;
        
        intLinkedList.enqueueElement(12);
        intLinkedList.enqueueElement(23);
        intLinkedList.enqueueElement(23);
        intLinkedList.enqueueElement(3);
        
        assertEquals(expectedOutput, intLinkedList.isFull());
    }
    
    
    
    //Test cases for double type
    QueueUsingLinkedList<Double> doubleLinkedList = new QueueUsingLinkedList<Double>();
    
    //Test cases for enqueueElement()
    @Test
    public void testDoublePushElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleLinkedList.enqueueElement(12.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleLinkedList.enqueueElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleLinkedList.enqueueElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleLinkedList.enqueueElement(3.0);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testDoublePushElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleLinkedList.enqueueElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for dequeueElement()
    @Test
    public void testDoublePopElement()
    {
        doubleLinkedList.enqueueElement(12.8);
        double expectedOutput = 12.8;
        double actualOutput = doubleLinkedList.dequeueElement();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoublePopElementWhenStackEmpty()
    {
        doubleLinkedList.enqueueElement(12.0);
        double expectedOutput = 12.0;
        double actualOutput = doubleLinkedList.dequeueElement();
        actualOutput = doubleLinkedList.dequeueElement();
    }
    
    //Test cases for peek()
    @Test
    public void testDoublePeek()
    {
        doubleLinkedList.enqueueElement(12.0);
        double expectedOutput = 12.0;
        double actualOutput = doubleLinkedList.peek();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoublePeekWhenStackEmpty()
    {
        double actualOutput = doubleLinkedList.peek();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testDoubleIsEmpty()
    {
        doubleLinkedList.enqueueElement(12.0);
        boolean expectedOutput = false;
        boolean actualOutput = doubleLinkedList.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testDoubleIsEmptyWhenStackEmpty()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleLinkedList.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for isFull()
    @Test
    public void testDoubleIsFull()
    {
        boolean expectedOutput = false;
        
        doubleLinkedList.enqueueElement(12.12);
        doubleLinkedList.enqueueElement(23.99);
        doubleLinkedList.enqueueElement(23.3);
        doubleLinkedList.enqueueElement(3.5);
        
        assertEquals(expectedOutput, doubleLinkedList.isFull());
    }
}

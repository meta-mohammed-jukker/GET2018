package dsaSession1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingLinkedListTest
{
  //Test cases for integer type
    StackUsingLinkedList<Integer> intLinkedList = new StackUsingLinkedList<Integer>(); 
    
    //Test cases for pushElement()
    @Test
    public void testIntegerPushElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intLinkedList.pushElement(12);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intLinkedList.pushElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intLinkedList.pushElement(23);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = intLinkedList.pushElement(3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testIntegerPushElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = intLinkedList.pushElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for popElement()
    @Test
    public void testIntegerPopElement()
    {
        intLinkedList.pushElement(12);
        int expectedOutput = 12;
        int actualOutput = intLinkedList.popElement();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerPopElementWhenStackEmpty()
    {
        int expectedOutput = 12;
        int actualOutput = intLinkedList.popElement();
        actualOutput = intLinkedList.popElement();
    }
    
    //Test cases for topElement()
    @Test
    public void testIntegerTopElement()
    {
        intLinkedList.pushElement(12);
        int expectedOutput = 12;
        int actualOutput = intLinkedList.topElement();
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerTopElementWhenStackEmpty()
    {
        int actualOutput = intLinkedList.topElement();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testIntegerIsEmpty()
    {
        intLinkedList.pushElement(12);
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
    
    
    
    //Test cases for double type
    StackUsingLinkedList<Double> doubleLinkedList = new StackUsingLinkedList<Double>();
    
    //Test cases for pushElement()
    @Test
    public void testDoublePushElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleLinkedList.pushElement(12.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleLinkedList.pushElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleLinkedList.pushElement(23.0);
        assertEquals(expectedOutput, actualOutput);
        
        expectedOutput = true;
        actualOutput = doubleLinkedList.pushElement(3.0);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = NullPointerException.class)
    public void testDoublePushElementWithNullElement()
    {
        boolean expectedOutput = true;
        boolean actualOutput = doubleLinkedList.pushElement(null);
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for popElement()
    @Test
    public void testDoublePopElement()
    {
        doubleLinkedList.pushElement(12.8);
        double expectedOutput = 12.8;
        double actualOutput = doubleLinkedList.popElement();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoublePopElementWhenStackEmpty()
    {
        double expectedOutput = 12.0;
        double actualOutput = doubleLinkedList.popElement();
        actualOutput = doubleLinkedList.popElement();
    }
    
    //Test cases for topElement()
    @Test
    public void testDoubleTopElement()
    {
        doubleLinkedList.pushElement(12.0);
        double expectedOutput = 12.0;
        double actualOutput = doubleLinkedList.popElement();
        assertEquals(expectedOutput, actualOutput, 0.1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDoubleTopElementWhenStackEmpty()
    {
        double actualOutput = doubleLinkedList.popElement();
    }
    
    //Test cases for isEmpty()
    @Test
    public void testDoubleIsEmpty()
    {
        doubleLinkedList.pushElement(12.0);
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
}

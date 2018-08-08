package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayPriorityQueueTest
{
    PriorityQueue<Integer> arrayPriorityQueue = new ArrayPriorityQueue<Integer>(3);
    
    @Before
    public void Initialize()
    {
        arrayPriorityQueue.enqueue(12, 2);
        arrayPriorityQueue.enqueue(3, 2);
    }
    
    //Test enqueue
    @Test
    public void testEnqueue()
    {
        arrayPriorityQueue.enqueue(23, 1);
        assertEquals(false, arrayPriorityQueue.isEmpty());
    }
    
    @Test(expected = NullPointerException.class)
    public void testEnqueueWithNullValue()
    {
        arrayPriorityQueue.enqueue(null, 1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEnqueueWithFullArray()
    {
        arrayPriorityQueue.enqueue(12, 1);
        arrayPriorityQueue.enqueue(52, 1);
    }
    
    //Test dequeue
    @Test
    public void testDequeue()
    {
        arrayPriorityQueue.enqueue(87, 12);
        assertEquals((int)87, (int)arrayPriorityQueue.dequeue());
    }
    
    //Test isFull
    @Test
    public void testIsFull()
    {
        assertEquals(false, arrayPriorityQueue.isFull());
    }
    
  //Test isEmpty
    @Test
    public void testIsEmpty()
    {
        assertEquals(false, arrayPriorityQueue.isEmpty());
    }
}

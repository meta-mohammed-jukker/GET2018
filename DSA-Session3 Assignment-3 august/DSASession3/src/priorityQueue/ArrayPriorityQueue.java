package priorityQueue;

public class ArrayPriorityQueue<E> implements PriorityQueue<E>
{
    private final int MAX;
    private Item[] priorityQueueArray;
    int rear;
    
    /**
     * Initializes ArrayPriorityQueue with maximum size
     * @param MAX maximum size of array
     */
    public ArrayPriorityQueue(int MAX)
    {
        this.MAX = MAX;
        this.priorityQueueArray = new Item[MAX];
        this.rear = -1;
    }
    
    /**
     * Adds an element to the queue
     */
    @Override
    public void enqueue(E value, int priority) throws NullPointerException, IndexOutOfBoundsException
    {
        if(value == "" || value == null) 
        {
            throw new NullPointerException("Null value entered");
        }
        if(isFull())
        {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        
        Item newItem = new Item(value, priority);
        ++rear;
        priorityQueueArray[rear] = newItem;
    }
    
    /**
     * Removes an element from the queue on the basis of priority
     */
    @Override
    public E dequeue() throws IndexOutOfBoundsException
    {
        if(isEmpty())
        {
            throw new IndexOutOfBoundsException("Underflow Exception");
        }
        
        int highestPriorityIndex =  getHighestPriorityIndex();
        
        E valueDequeued = (E) priorityQueueArray[highestPriorityIndex].getValue();
        
        if(highestPriorityIndex == rear)
        {
            --rear;
        }
        else
        {
            for(int i=highestPriorityIndex; i<=rear; i++)
            {
                priorityQueueArray[i-1] = priorityQueueArray[i];
            }
            --rear;
        }
        
            
        return valueDequeued;
    }
    
    /**
     * Checks if queue is full or not
     */
    @Override
    public boolean isFull()
    {
        if(rear + 1 == MAX)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if queue is empty or not
     */
    @Override
    public boolean isEmpty()
    {
        if(rear == -1)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns index of item having highest priority
     * @return
     */
    public int getHighestPriorityIndex()
    {
        int highestPriorityIndex = 0;
        for(int i=0; i<priorityQueueArray.length; i++)
        {
            if(priorityQueueArray[i].getPriority() > 
               priorityQueueArray[highestPriorityIndex].getPriority())
            {
               highestPriorityIndex = i;
            }
        }
        return highestPriorityIndex;
    }

}

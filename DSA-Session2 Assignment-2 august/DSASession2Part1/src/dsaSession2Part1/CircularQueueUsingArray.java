package dsaSession2Part1;

public class CircularQueueUsingArray<E>
{
    private E[] queueArray;
    private int front, rear;
    private final int MAX;
    
    /**
     * Initializes circular queue with some maximum size
     * @param MAX maximum size of queue
     */
    public CircularQueueUsingArray(int MAX)
    {
        this.queueArray = (E[])new Object[MAX];
        this.MAX = MAX;
        this.front = -1;
        this.rear = -1;
    }
    
    /**
     * Push an element to circular queue queue
     * @param elementToPush element to be pushed
     * @return true if element pushed successfully
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    public boolean enqueue(E elementToPush) throws NullPointerException, IndexOutOfBoundsException
    {
        if(elementToPush == "" || elementToPush == null) 
        {
            throw new NullPointerException("Null value inserted");
        }
        if(isFull())
        {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            queueArray[rear] = elementToPush;
            return true;
        }
        if (rear + 1 == MAX)
        {
            rear = 0;
            queueArray[rear] = elementToPush;
            return true;
        }
        if ( rear + 1 < MAX)
        {
            queueArray[++rear] = elementToPush;
            return true;
        }
        return false;
    }
    
    /**
     * Removes an element from circular queue
     * @return element that is removed
     * @throws IndexOutOfBoundsException
     */
    public E dequeue() throws IndexOutOfBoundsException
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Underflow Exception");
        }
        
        E dequeuedElement = queueArray[front];
        if ( front == rear)
        {
            front = -1;
            rear = -1;
        }
        else if (front + 1 == MAX)
        {
            front = 0;
        }
        else
        {
            front++;
        }                
        return dequeuedElement;             
    }
    
    /**
     * Returns element at the front of circular queue
     * @return element that is at the front of circular queue
     * @throws IndexOutOfBoundsException
     */
    public E peek() throws IndexOutOfBoundsException
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Underflow Exception");
        }              
        return queueArray[front];
    }
    
    /**
     * Checks if circular queue is empty or not
     * @return true if circular queue is empty, else false
     */
    public boolean isEmpty()
    {
        return front == -1;
    }
    
    /**
     * Checks if circular queue is full or not
     * @return true if circular queue is full, else false
     */
    public boolean isFull()
    {
        if(rear + 1 == front)
        {
            return true;
        }
        if(front == 0 && rear == MAX - 1)
        {
            return true;
        }
        return false;
    }
}


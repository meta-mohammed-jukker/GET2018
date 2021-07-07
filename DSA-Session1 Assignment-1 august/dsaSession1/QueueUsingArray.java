package dsaSession1;

public class QueueUsingArray<E> implements Queue<E>
{

    private E[] queueArray;
    private int front, rear;
    private final int MAX;
    
    /**
     * Initializes QueueUsingArray
     * @param MAX
     */
    public QueueUsingArray(int MAX)
    {
        this.queueArray = (E[])new Object[MAX];
        this.MAX = MAX;
        this.front = -1;
        this.rear = -1;
    }
    

    /**
     * Adds element at the end (rear) of the queue.
     * @param data  data that you want to insert in queue
     */
    @Override
    public boolean enqueueElement(E elementToPush) throws NullPointerException, IndexOutOfBoundsException
    {
        if(elementToPush == "" || elementToPush == null) 
        {
            throw new NullPointerException("Null value inserted");
        }
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            queueArray[rear] = elementToPush;
        }
        else if (rear + 1 >= MAX)
        {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        else if ( rear + 1 < MAX)
        {
            queueArray[++rear] = elementToPush;    
        }
        return true;
    }


    /**
     * Removes an element from the front of the queue
     * @return data value which is remove from queue
     */
    @Override
    public E dequeueElement() throws IndexOutOfBoundsException
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
        else
        {
            front++;
        }                
        return dequeuedElement;             
    }


    /**
     * Shows an element from the front of the queue
     * @return data value which is remove from queue
     */
    @Override
    public E peek() throws IndexOutOfBoundsException
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Underflow Exception");
        }              
        return queueArray[front];
    }


    /**
     * Checks whether the queue is empty or not
     * @return boolean true if queue is empty, otherwise false
     */
    @Override
    public boolean isEmpty()
    {
        return front == -1;
    }


    /**
     * Checks whether the queue is full or not
     * @return boolean true if queue is full, otherwise false
     */
    @Override
    public boolean isFull()
    {
        if(front == 0 && rear == MAX - 1)
        {
            return true;
        }
        return false;
    }

}

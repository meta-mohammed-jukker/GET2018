package dsaSession1;

public class QueueUsingArray<E> implements Queue<E>
{

    private E[] queueArray;
    private int front, rear;
    private final int MAX;
    
    public QueueUsingArray(int MAX)
    {
        this.queueArray = (E[])new Object[MAX];
        this.MAX = MAX;
        this.front = -1;
        this.rear = -1;
    }
    
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

    @Override
    public E peek() throws IndexOutOfBoundsException
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Underflow Exception");
        }              
        return queueArray[front];
    }

    @Override
    public boolean isEmpty()
    {
        return front == -1;
    }

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

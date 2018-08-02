package dsaSession1;

public class QueueUsingLinkedList<E> implements Queue<E>
{
    private Node front;
    private Node rear; 
    private int currentSize;
    
    public QueueUsingLinkedList()
    {
        this.front = new Node();
        this.rear = null;
        this.currentSize = 0;
    }
    
    /**
     * this method adds element at the end (rear) of the queue.
     * @param data  data that you want to insert in queue
     */
    @Override
    public boolean enqueueElement(E data) throws NullPointerException
    {
        if(data == "" || data == null) 
        {
            throw new NullPointerException("Null value inserted");
        }
        Node previousRear = rear;
        rear = new Node(data, null);
        if (isEmpty())
        {
            front = rear;
        }
        else
        {
            previousRear.setLink(rear);
        }
        currentSize++;
        return true;
    }
    
    /**
     * this method removes an element from the front of the queue
     * @return data value which is remove from queue
     */
    @Override
    public E dequeueElement() throws IndexOutOfBoundsException
    {
        if(isEmpty())
        {
            rear = null;
            throw new IndexOutOfBoundsException("Underflow Exception");
        }
        E data = (E) front.getData();
        front = front.getLink();
        currentSize--;
        return data;
    }
    
    /**
     * This method checks whether the queue is full or not
     * @return boolean true if queue is full, otherwise false
     */
    @Override
    public boolean isFull()
    {
        return false;
    }
    
    /**
     * This method checks whether the queue is empty or not
     * @return boolean true if queue is empty, otherwise false
     */
    @Override
    public boolean isEmpty()
    {
        if(currentSize == 0)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public E peek() throws IndexOutOfBoundsException
    {
        if(isEmpty())
        {
            rear = null;
            throw new IndexOutOfBoundsException("Underflow Exception");
        }
        return (E) front.getData();
    }
}

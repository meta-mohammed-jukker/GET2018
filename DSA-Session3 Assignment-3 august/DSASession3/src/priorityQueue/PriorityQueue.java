package priorityQueue;

public interface PriorityQueue<E>
{
    public void enqueue(E value, int priority);
    
    public E dequeue();
    
    public boolean isFull();
    
    public boolean isEmpty();
}

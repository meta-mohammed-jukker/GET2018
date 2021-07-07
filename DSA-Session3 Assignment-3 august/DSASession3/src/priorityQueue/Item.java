package priorityQueue;

public class Item<E>
{
    private E value;
    private int priority;
    
    /**
     * Initializes Item with value and priority
     * @param value
     * @param priority
     */
    public Item(E value, int priority)
    {
        this.value = value;
        this.priority = priority;
    }
    
    /**
     * Returns value stored in queue
     * @return value
     */
    public E getValue()
    {
        return value;
    }
    
    /**
     * Returns priority of object
     * @return priority
     */
    public int getPriority()
    {
        return priority;
    }
}

package dsaSession1;

public interface Queue<E> 
{

    public boolean enqueueElement(E elementToPush);

    public E dequeueElement();   
    
    public E peek();
    
    public boolean isEmpty();
    
    public boolean isFull();
    
}

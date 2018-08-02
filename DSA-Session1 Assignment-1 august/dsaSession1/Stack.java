package dsaSession1;

public interface Stack<E>
{
    public boolean pushElement(E elementToPush);

    public E popElement();   
    
    public E topElement();
    
    public boolean isEmpty();
}

package dsaSession1;

class StackUsingLinkedList<E> implements Stack<E>
{
    private Node<E> top ;
    private int size ;
 
    /**
     * Initializes stack using linked list
     */
    public StackUsingLinkedList()
    {
        top = null;
        size = 0;
    }    
    
    /**
     * Checks if stack is empty or not
     */
    public boolean isEmpty()
    {
        if(top == null)
        {
            return true;
        }
        return false;
    }    
    
    /**
     * Returns size of stack
     * @return
     */
    public int getSize()
    {
        return size;
    }    
    
    /**
     * Adds element to the stack
     */
    public boolean pushElement(E data)
    {
        if(data == "" || data == null) 
        {
            throw new NullPointerException("Null value inserted");
        }
        Node<E> nptr = new Node<E> (data, null);
        if (top == null)
        {
            top = nptr;
        }
        else
        {
            nptr.setLink(top);
            top = nptr;
        }
        size++ ;
        return true;
    }    
    
    /**
     * Returns top element from stack and remove that element 
     */
    public E popElement() throws IndexOutOfBoundsException
    {
        if (isEmpty() )
        {
            throw new IndexOutOfBoundsException("Underflow Exception") ;
        }
        Node<E> ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }    
    
    /**
     * Returns top element from stack and but does not remove that element
     */
    public E topElement() throws IndexOutOfBoundsException
    {
        if (isEmpty() )
        {
            throw new IndexOutOfBoundsException("Underflow Exception") ;
        }
        return top.getData();
    }    
}

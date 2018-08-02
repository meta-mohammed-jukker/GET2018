package dsaSession1;

class StackUsingLinkedList<E> implements Stack<E>
{
    Node<E> top ;
    int size ;
 
    /**
     * Initializes stack using linked list
     */
    StackUsingLinkedList()
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
    int getSize()
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

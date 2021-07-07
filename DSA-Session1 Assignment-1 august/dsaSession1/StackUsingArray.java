package dsaSession1;

public class StackUsingArray<E> implements Stack<E>
{

    private E[] stackArray;
    private int top;
    
    /**
     * Initializes stack using arrays
     * @param MAX
     */
    public StackUsingArray(int MAX)
    {
        this.stackArray = (E[]) new Object[MAX];
        this.top = -1;
    }
    
    /**
     * Adds element to the stack
     */
    @Override
    public boolean pushElement(E elementToPush) throws IndexOutOfBoundsException, NullPointerException
    {
        if (top == stackArray.length - 1)
        {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        
        if(elementToPush == "" || elementToPush == null) 
        {
            throw new NullPointerException("Null value inserted");
        }
        
        stackArray[++top] = elementToPush;
        return true;
    }
    
    /**
     * Returns top element from stack and remove that element 
     */
    @Override
    public E popElement()
    {
        if (top < 0) 
        {
            throw new IndexOutOfBoundsException("Underflow Exception");
        }
        
        return stackArray[top--];
    }
    
    /**
     * Returns top element from stack and but does not remove that element
     */
    @Override
    public E topElement()
    {
        if (top < 0) 
        {
            throw new IndexOutOfBoundsException("Underflow Exception");
        }
        
        return stackArray[top];
    }
    
    /**
     * Checks if stack is empty or not
     */
    @Override
    public boolean isEmpty()
    {
        if(top == -1) 
        {
            return true;
        }
        return false;
    }

}

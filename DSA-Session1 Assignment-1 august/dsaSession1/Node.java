package dsaSession1;

public class Node<E>
{
    private E data;
    private Node<E> link;  
    
    /**
     * Initializes node with null values
     */
    public Node()
    {
        link = null;
        data = null;
    }
    
    /**
     * Initializes node with parameters
     * @param d data
     * @param nprevious node
     */
    public Node(E d,Node<E> n)
    {
        data = d;
        link = n;
    }
    
    /**
     * Sets link to previous node
     * @param n previous node 
     */
    public void setLink(Node<E> n)
    {
        link = n;
    }    
    
    /**
     * Sets data
     * @param d data
     */
    public void setData(E d)
    {
        data = d;
    }    
    
    /**
     * Returns previous node
     * @return link to previous node
     */
    public Node<E> getLink()
    {
        return link;
    }    
    
    /**
     * Returns data
     * @return data
     */
    public E getData()
    {
        return data;
    }
}

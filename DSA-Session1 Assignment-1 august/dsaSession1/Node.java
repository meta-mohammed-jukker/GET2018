package dsaSession1;

public class Node<E>
{
    private E data;
    Node<E> link;  
    
    /**
     * Initializes node with null values
     */
    Node()
    {
        link = null;
        data = null;
    }
    
    /**
     * Initializes node with parameters
     * @param d data
     * @param nprevious node
     */
    Node(E d,Node<E> n)
    {
        data = d;
        link = n;
    }
    
    /**
     * Sets link to previous node
     * @param n previous node 
     */
    void setLink(Node<E> n)
    {
        link = n;
    }    
    
    /**
     * Sets data
     * @param d data
     */
    void setData(E d)
    {
        data = d;
    }    
    
    /**
     * Returns previous node
     * @return link to previous node
     */
    Node<E> getLink()
    {
        return link;
    }    
    
    /**
     * Returns data
     * @return data
     */
    E getData()
    {
        return data;
    }
}

package dictionary;

@SuppressWarnings("rawtypes")
public class Item<V>
{
    private String key;
    private V value;
    private Item left, right;
    
    /**
     * Initializes Item class
     * @param item
     * @param value
     */
    public Item(String item, V value) 
    {
        setKey(item);
        setValue(value);
        setLeft(setRight(null));
    }

    /**
     * Returns item key
     * @return key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Sets item key
     */
    public void setKey(String key)
    {
        this.key = key;
    }
    
    /**
     * Returns right item 
     * @return right item
     */
    public Item getRight()
    {
        return right;
    }
    
    /**
     * Sets right item 
     */
    public Item setRight(Item right)
    {
        this.right = right;
        return right;
    }

    /**
     * Returns left item 
     * @return left item
     */
    public Item getLeft()
    {
        return left;
    }

    /**
     * Sets left item 
     */
    public void setLeft(Item left)
    {
        this.left = left;
    }

    /**
     * Returns item value
     * @return value
     */
    public V getValue()
    {
        return value;
    }

    /**
     * Sets item value
     */
    public void setValue(V value)
    {
        this.value = value;
    }
}

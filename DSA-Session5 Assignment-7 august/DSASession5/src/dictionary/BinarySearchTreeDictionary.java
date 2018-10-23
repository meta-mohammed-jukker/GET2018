package dictionary;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class BinarySearchTreeDictionary<V> implements Dictionary<V>
{
    private BinarySearchTree<V> binarySearchTree ;
    
    public BinarySearchTreeDictionary()
    {
        binarySearchTree = new BinarySearchTree<V>();
    }

    /**
     * Adds key, value to the dictionary
     */
    @Override
    public void add(String key, V value)
    {
        binarySearchTree.insert(key, value);
    }

    /**
     * Deletes dictionary entry with corresponding key
     */
    @Override
    public void delete(String key)
    {
        binarySearchTree.deleteKey(key);
    }

    /**
     * Returns dictionary value corresponding to key
     */
    @SuppressWarnings("unchecked")
    @Override
    public V get(String key) throws AssertionError
    {
        Item item = binarySearchTree.search(key);
        if(item == null)
        {
            throw new AssertionError("Key not present");
        }
        return (V)item.getValue();
    }

    /**
     * Sort all dictionary entries in ascending order according to key 
     */
    @Override
    public List<Item> sort()
    {
        return binarySearchTree.inorder();
    }

    /**
     * Sort all dictionary entries between key1 and key2, in ascending order
     */
    @Override
    public List<Item> sortBetween(String key1, String key2)
    {
        List<Item> rangedSortedList = new ArrayList<Item>();
        for(Item item: binarySearchTree.inorder())
        {
            if((item.getKey().compareToIgnoreCase(key1) >= 0) && 
               (item.getKey().compareToIgnoreCase(key2) <= 0))
            {
                rangedSortedList.add(item);
            }
        }
        
        return rangedSortedList;
    }

}

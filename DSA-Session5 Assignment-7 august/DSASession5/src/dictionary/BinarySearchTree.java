package dictionary;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
class BinarySearchTree<V>
{
    private Item root;
    private List<Item> itemList;
    
    /**
     * Initializes Binary Search Tree
     */
    BinarySearchTree() 
    { 
        root = null; 
        itemList = new ArrayList<Item>();
    }

    /**
     * Calls insertRecursively() 
     * @param key key   
     * @param value value
     * @return true if item added, else false
     */
    void insert(String key, V value) 
    {
        root = insertRecursively(root, key, value);
    }
    
    /**
     * Inserts item to binary search tree
     * @param root root item
     * @param key key
     * @param value value
     * @return return root item
     */
    Item insertRecursively(Item root, String key, V value) 
    {
        //if root is null then add key to root
        if (root == null) 
        {
            root = new Item(key, value);
            return root;
        }
        
        //if key is less than key of root Item then go left
        if (root.getKey().compareToIgnoreCase(key) > 0)
        {
            root.setLeft(insertRecursively(root.getLeft(), key, value));
        }
        //else if key is more than key of root Item then go right
        else if (root.getKey().compareToIgnoreCase(key) < 0)
        {
            root.setRight(insertRecursively(root.getRight(), key, value));
        }
        
        return root;
    }
    
    /**
     * Returns a list with all items arranged in inorder format
     * @return list of items
     */
    public List<Item> inorder() 
    {
        itemList.clear();
        inorderRecursively(root);
        return itemList;
    }

    /**
     * Traverses through tree inorder format
     * @param root root item
     */
    public void inorderRecursively(Item root) 
    {
        if (root != null) 
        {
            inorderRecursively(root.getLeft());
            itemList.add(root);
            inorderRecursively(root.getRight());
        }
    }
    
    /**
     * Calls deleteRecursively()
     * @param key key of item that is to be deleted
     * @return 
     */
    void deleteKey(String key)
    {
        root = deleteRecursively(root, key);
    }
    
    /**
     * Deletes an item from binary search tree
     * @param root root item
     * @param key key of item that is to be deleted
     */
    Item deleteRecursively(Item root, String key)
    {
        //Return null  if tree is empty
        if (root == null)
        {
            return root;
        }

        //if key is less than key of root Item then go left
        if (root.getKey().compareToIgnoreCase(key) > 0)
        {
            root.setLeft(deleteRecursively(root.getLeft(), key));
        }
        //else if key is more than key of root Item then go right
        else if (root.getKey().compareToIgnoreCase(key) < 0)
        {
            root.setRight(deleteRecursively(root.getRight(), key));
        }
        // if key is same as root's key then This is the Item to be deleted
        else
        {
            // Item with only one child or no child
            if (root.getLeft() == null)
            {
                return root.getRight();
            }
            else if (root.getRight() == null)
            {
                return root.getLeft();
            }
            
            // Item with two children
            root.setKey(getLeftmostItem(root.getRight()).getKey());
            root.setValue(getLeftmostItem(root.getRight()).getValue());

            // Delete the inorder successor
            root.setRight(deleteRecursively(root.getRight(), root.getKey()));
        }

        return root;
    }

    /**
     * Returns key of leftmost leaf item
     * @param root root item
     */
    Item getLeftmostItem(Item root)
    {
        Item leftmostItem = root;
        while (root.getLeft() != null)
        {
            leftmostItem = root.getLeft();
            root = root.getLeft();
        }
        return leftmostItem;
    }
    
    /**
     * Calls searchRecursively()
     * @param key key of item that is to be searched
     * @return item with corresponding key
     */
    public Item search(String key)
    {
        return searchRecursively(root, key);
    }
    
    /**
     * Searches the item with corresponding key
     * @param root root item
     * @param key key of item that is to be searched
     * @return item corresponding to that key, else if no such item found then return null
     */
    public Item searchRecursively(Item root, String key)
    {
        //if root is null or root is desired item, return root
        if (root==null || root.getKey()==key)
        {
            return root;
        }
        // if key is less than root's key, go left
        if (root.getKey().compareToIgnoreCase(key) > 0)
        {
            return searchRecursively(root.getLeft(), key);
        }
        // if key is greater than root's key, go right
        return searchRecursively(root.getRight(), key);
    }
}

package dsaSession2Part2;

import java.util.ArrayList;
import java.util.List;

public class IntegerNestedList implements NestedList
{
    private List<Object> nestedList;
    
    /**
     * Initializes InntegerNestedList
     */
    public IntegerNestedList()
    {
        nestedList = new ArrayList<Object>();
    }
    
    /**
     * Adds object to the list
     */
    @Override
    public void add(Object object) throws NestedListException
    {
        if(object instanceof List || object instanceof Integer) 
        {
            nestedList.add(object);
        }
        else 
        {
            throw new NestedListException("Wrong object Type");
        }
    }

    /**
     * Returns sum of all the integers in the list
     */
    @Override
    public int sum(Object object) throws NestedListException 
    {
        int sum = 0;
        if(object instanceof Integer) 
        {
            sum = (Integer) object;
        }
        else if(object instanceof List) 
        {
            for(Object iterator: (List)object) 
            {
                sum += sum(iterator);
            }
        } 
        else
        {
            throw new NestedListException("Wrong object Type");
        }
        return sum;
    }
    
    /**
     * Returns largest integer from the list
     */
    @Override
    public int getLargestValue(Object object) throws NestedListException 
    {
        int largestValue = 0;
        boolean isFirstValue = true;
        if(object instanceof Integer) 
        {
            largestValue = (Integer) object;
        }
        else if(object instanceof List) 
        {
            for(Object iterator: (List)object) 
            {
                if(isFirstValue) 
                {
                    largestValue = getLargestValue(iterator);
                    isFirstValue = false;
                }
                largestValue = Math.max(largestValue, getLargestValue(iterator));
            }
        } 
        else 
        {
            throw new NestedListException("Wrong object Type");
        }
        return largestValue;
    }
    
    /**
     * Checks if value is present in nested list or not
     */
    @Override
    public boolean isPresent(Object object, int value) throws NestedListException 
    {
        boolean search = false;
        if(object instanceof Integer) 
        {
            if((Integer) object == value)
            search = true;
        }
        else if(object instanceof List) 
        {
            for(Object iterator: (List)object) 
            {
                if(!search && isPresent(iterator, value)) 
                {
                    search = true;
                }
            }
        } 
        else
        {
            throw new NestedListException("Wrong object Type");
        }
        return search;
    }
    
    /**
     * Returns nestedList
     * @return
     */
    public List<Object> getList() 
    {
        return nestedList;
    }
}

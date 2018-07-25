package session6;

import java.util.*;
public final class IntSet
{
    private List<Integer> array;
    private List<Integer> universalArray;
    
    /**
     * Initializes universalArray for integers 1 to 1000
     */
    private void setUniversalArray()
    {
        this.universalArray = new ArrayList<Integer>(1000);
        for(int i=1; i<=1000; i++)
        {
            this.universalArray.add(i);
        }
    }
    
    /**
     * Initializes array from input array
	 * Requires: All elements should be unique
     * @param inputArray list of integers
     */
    IntSet(int[] inputArray)
    {
        this.array = new ArrayList<Integer>(inputArray.length);
        for(int value: inputArray)
        {
            this.array.add(value);
        }
    }
    
    /**
     * Checks if the integer is present in array or not.
     * @param x integer that is to be searched
     * @return true if integer is present else false
     */
    boolean isMember(int x)
    {
        if (this.array.indexOf(x) >= 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns size of array
     * @return size of array
     */
    int size()
    {
        return this.array.size();
    }
    
    /**
     * Checks if a set is subset of the list.
     * @param s IntSet class object that holds the subset
     * @return true if it is sub set else false
     */
    boolean subSet(IntSet s)
    {
        for(int value: s.array)
        {
            if(isMember(value) == false)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns list of integers from 1 to 1000 except ones present in array
     * @return list of integers
     */
    List<Integer> getComplement()
    {
        setUniversalArray();
        List<Integer> complementedArray = this.universalArray;
        complementedArray.removeAll(this.array);
        return complementedArray;
    }
    
    /**
     * Returns union of 2 arrays
     * @param set object of class IntSet 
     * @return list of integers
     */
    List<Integer> union(IntSet set)
    {
        List<Integer> union = new ArrayList<Integer>(this.array.size() + set.array.size());
        union = this.array;
        for(int value: set.array)
        {
            if(union.indexOf(value) >= 0)
            {
                continue;
            }
            union.add(value);
        }
        return union;
    }
    
    
}

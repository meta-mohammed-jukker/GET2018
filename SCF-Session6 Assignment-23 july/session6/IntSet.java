package session6;

import java.util.*;
public final class IntSet
{
    private int[] array;
    
    /**
     * Initializes array from input array
     * Requires: All the elements should be unique and should be between 1 and 1000 
     * @param inputArray list of integers
     */
    IntSet(int[] inputArray)
    {
        array = removeDuplicateAndSetRange(inputArray);
        Arrays.sort(array);
    }
    
    /**
     * Removes duplicate values and checks if value lies between 1 and 1000 
     * @param inputArray input set given by user
     * @return set without duplicate values and values outside range 1 to 1000
     * @throws IndexOutOfBoundsException
     */
    int[] removeDuplicateAndSetRange(int[] inputArray) throws IndexOutOfBoundsException
    {
        if(inputArray.length == 0)
        {
            throw new IndexOutOfBoundsException("Array Empty");
        }
        Arrays.sort(inputArray);
        int[] temporaryArray = new int[inputArray.length];
        int temporaryArrayCounter = 1;
        temporaryArray[0] = inputArray[0];
        for(int i=1; i<inputArray.length; i++)
        {
            if(inputArray[i] >= 1 && inputArray[i] <= 1000 && inputArray[i] != inputArray[i-1])
            {
                temporaryArray[temporaryArrayCounter] = inputArray[i];
                temporaryArrayCounter++;
            }
        }
        int[] outputArray = new int[temporaryArrayCounter];
        for(int i=0; i<temporaryArrayCounter; i++)
        {
            outputArray[i] = temporaryArray[i];
        }
        return outputArray;
    }
    
    
    /**
     * Checks if the integer is present in array or not.
     * @param x integer that is to be searched
     * @return true if integer is present else false
     */
    boolean isMember(int x)
    {
        for(int i=0; i<array.length; i++)
        {
            if(array[i] == x)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns size of array
     * @return size of array
     */
    int size()
    {
        return this.array.length;
    }
    
    /**
     * Checks if a set is subset of the list.
     * @param s IntSet class object that holds the subset
     * @return true if it is sub set else false
     */
    boolean subSet(IntSet s)
    {
        for(int i=0; i<s.array.length; i++)
        {
            if(isMember(s.array[i]) == false)
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
    int[] getComplement()
    {
        int[] arrayComplement = new int[1000 - array.length];
        int arrayComplementCounter = 0;
        for(int i=1; i<=1000; i++)
        {
            if(! isMember(i))
            {
                arrayComplement[arrayComplementCounter] = i;
                arrayComplementCounter++;
            }
        }
        return arrayComplement;
    }
    
    /**
     * Returns union of 2 arrays
     * @param set object of class IntSet 
     * @return list of integers
     */
    int[] union(IntSet set)
    {
        int arrayCounter = 0;
        int setArrayCounter = 0;
        int[] temporaryUnionArray = new int[array.length + set.array.length];
        int temporaryArrayCounter = 0;
        
        while(arrayCounter != array.length && setArrayCounter != set.array.length)
        {
            if(array[arrayCounter] < set.array[setArrayCounter])
            {
                temporaryUnionArray[temporaryArrayCounter] = array[arrayCounter];
                temporaryArrayCounter++;
                arrayCounter++;
            }
            if(array[arrayCounter] > set.array[setArrayCounter])
            {
                temporaryUnionArray[temporaryArrayCounter] = set.array[setArrayCounter];
                temporaryArrayCounter++;
                setArrayCounter++;
            }
            else
            {
                temporaryUnionArray[temporaryArrayCounter] = array[arrayCounter];
                temporaryArrayCounter++;
                arrayCounter++;
                setArrayCounter++;
            }
        }
        
        if(arrayCounter == array.length)
        {
            while(setArrayCounter != set.array.length)
            {
                temporaryUnionArray[temporaryArrayCounter] = set.array[setArrayCounter];
                temporaryArrayCounter++;
                setArrayCounter++;
            }
        }
        else if(setArrayCounter == set.array.length)
        {
            while(arrayCounter != array.length)
            {
                temporaryUnionArray[temporaryArrayCounter] = array[arrayCounter];
                temporaryArrayCounter++;
                arrayCounter++;
            }
        }
        
        int[] unionArray = new int[temporaryArrayCounter];
        for(int i=0; i<temporaryArrayCounter; i++)
        {
            unionArray[i] = temporaryUnionArray[i];
        }
        
        return unionArray;
    }
    
    
}

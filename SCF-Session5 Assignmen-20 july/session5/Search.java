package session5;

public class Search
{
    /**
     * Finds a target value within an array 
     * by sequentially checking each element of the array for the target value 
     * @param inputArray Array in which the element is to be searched
     * @param elementToBeSearched element that is to be searched
     * @param index starting index
     * @return index at which the element is found, otherwise -1
     */
    public int linearSearch(int[] inputArray, int elementToBeSearched, int index)
    {
        if(index == inputArray.length)
        {
            return -1;
        }
        if(inputArray[index] == elementToBeSearched)
        {
            return index;
        }
        return linearSearch(inputArray, elementToBeSearched, (index+1));
    }
    
    /**
     * Finds the position of a target value within a sorted array with O(log n) efficiency
     * Requires: inputArray should be arranged in ascending order
     * @param inputArray Array in which the element is to be searched
     * @param elementToBeSearched element that is to be searched
     * @param index starting index
     * @return index at which the element is found, otherwise -1
     */
    public int binarySearch(int[] inputArray, int elementToBeSearched, int firstIndex, int lastIndex)
    {
        if(inputArray.length == 0)
        {
            return -1;
        }
        
        if (lastIndex >= firstIndex)
        {
             int middleIndex = firstIndex + (lastIndex - firstIndex)/2;
      
             if (inputArray[middleIndex] == elementToBeSearched)
             {
                 return middleIndex;
             }
             
             if (inputArray[middleIndex] > elementToBeSearched)
             {
                 return binarySearch(inputArray, elementToBeSearched, firstIndex, middleIndex-1);
             }
             
             return binarySearch(inputArray, elementToBeSearched, middleIndex+1, lastIndex);
        }
        
        return -1;
    }
}

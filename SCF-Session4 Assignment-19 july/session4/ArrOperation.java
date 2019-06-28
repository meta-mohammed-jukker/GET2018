package session4;

public class ArrOperation
{
    
    /**
     * Returns the index for which the sum of numbers before that index
     * is equal to sum of numbers from that index to the end.
     * @param listOfNumbers contains list of numbers
     * @return index at which split occurred else -1
     */
    public int splitListOfNumbers(int[] listOfNumbers) throws AssertionError
    {
        if(listOfNumbers.length == 0)
        {
            throw new AssertionError("Array cannot be empty");
        }
        int rightSum = 0;
        int leftSum = 0;
        for(int i=0; i<listOfNumbers.length; i++)
        {
            rightSum += listOfNumbers[i]; 
        }
        for(int i=0; i<listOfNumbers.length; i++)
        {
            leftSum += listOfNumbers[i];
            rightSum -= listOfNumbers[i];
            if(leftSum == rightSum)
            {
                return i+1;
            }
        }
        return -1;
    }
    
    /**
     * Checks if 2 elements have equal number of occurrences in an array
     * @param inputArray list of numbers
     * @param firstElement first number
     * @param secondElement second number
     * @return true if occurrence of both elements are equal, else false
     */
    public static boolean checkingEqualOccurrence(int[] inputArray, 
            int firstElement, int secondElement)
    {
        int occurrenceOfFirstElement = 0, occurrenceOfSecondElement = 0;
        for(int i=0; i<inputArray.length; i++)
        {
            if(inputArray[i] == firstElement)
            {
                occurrenceOfFirstElement += 1;
            }
            if(inputArray[i] == secondElement)
            {
                occurrenceOfSecondElement += 1;
            }
        }
        if (occurrenceOfFirstElement == occurrenceOfSecondElement)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns an array that contains exactly the same numbers as the input array, 
     * but rearranged so that every X is immediately followed by a Y. 
     * Do not move X within array, but every other number may move.
     * @param array list of numbers
     * @param x X element
     * @param y Y element
     * @return an array where each X element is followed by Y element
     * @throws AssertionError
     */
    public int[] fixXY(int[] array, int x, int y) throws AssertionError
    {
        int[] inputArray = array;
        if(inputArray.length == 0)
        {
            throw new AssertionError("Array cannot be empty");
        }
        if(inputArray[inputArray.length - 1] == x)
        {
            throw new AssertionError(x + "cannot be at last");
        }
        if(!checkingEqualOccurrence(inputArray, x, y))
        {
            throw new AssertionError("occurrences of " + x + " and " + y +" are not equal.");
        }
        int indexOfY = -1;
        for(int i=0; i<inputArray.length; i++)
        {
            if(inputArray[i] == y)
            {
                indexOfY = i;
                break;
            }
        }
        for(int i=0; i<(inputArray.length - 1); i++)
        {
            if(inputArray[i] == x)
            {
                i++;
                if(inputArray[i] == x)
                {
                    throw new AssertionError("2 " + x + " cannot be adjacent.");
                }
                int temporaryIndexOfY = indexOfY;
                for(int j=(indexOfY + 1); j<inputArray.length; j++)
                {
                    if(inputArray[j] == y)
                    {
                        indexOfY = j;
                        break;
                    }
                }
                inputArray[temporaryIndexOfY] = inputArray[i];
                inputArray[i] = y;
            }
        }
        
        return inputArray;
    }
    
    /**
     * Counts number of clumps in the input array.
     * Clump in an array is a series of 2 or more adjacent elements of the same value.
     * @param array list of numbers
     * @return number of clumps
     */
    public int countClumps(int[] array) throws AssertionError
    {
        if(array.length == 0)
        {
            throw new AssertionError("Array cannot be empty");
        }
        int[] inputArray = array;
        int clumpCount = 0;
        for(int i=0; i<(inputArray.length - 1); i++)
        {
            if(inputArray[i] == inputArray[i+1])
            {
                clumpCount += 1;
                i++;
                while(i <= (inputArray.length - 2) && inputArray[i] == inputArray[i+1])
                {
                    i++;
                }
            }
        }
        return clumpCount;
    }
    
    /**
     * Returns the size of the largest mirror section found in the input array.
     * Mirror section in an array is a group of contiguous elements 
     * such that somewhere in the array, the same group appears in reverse order.
     * @param inputArray list of numbers
     * @return the size of the largest mirror section found in the input array.
     */
    public int findMaxMirror(int[] inputArray) throws AssertionError
    {
        if(inputArray.length == 0)
        {
            throw new AssertionError("Array cannot be empty");
        }
        int maxMirrorLength = 0;
        int currentMirrorLength;
        
        for(int i=0; i<(inputArray.length-1); i++)
        {
            currentMirrorLength = 0;

            for(int j=(inputArray.length-1); j>i; j--)
            {
                int front, back;
                front = i;
                back = j;
                
                while(back != -1 && front != inputArray.length 
                        && inputArray[front] == inputArray[back])
                {
                    currentMirrorLength++;
                    front++;
                    back--;
                }
                if(currentMirrorLength > maxMirrorLength)
                {
                    maxMirrorLength = currentMirrorLength;
                }
            }
        }       
        return maxMirrorLength;
    }
    
}

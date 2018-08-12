package dsaSession2Part2;

public class NestedListException extends Exception
{
    String exception;
    
    /**
     * Initiates nested list exception
     * @param exception
     */
    public NestedListException(String exception)
    {
        this.exception = exception;
    }
    
    /**
     * Returns message given when exception occurs
     */
    public String getMessage() 
    {
        return exception;
    }
}
package dsaSession2Part1;

public class Program
{
    private String name;
    private int capacity;
    private int numberOfAllocatedStudents;
    
    /**
     * Initializes program object
     * @param name
     * @param capacity
     */
    public Program(String name, int capacity)
    {
        this.name = name;
        this.capacity = capacity;
        this.numberOfAllocatedStudents = 0;
    }
    
    /**
     * Returns program name
     * @return program name
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * Sets program name
     * @param name  program name
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * Returns program capacity
     * @return program capacity
     */
    public int getCapacity() 
    {
        return capacity;
    }
    
    /**
     * Sets program capacity
     * @param capacity program capacity
     */
    public void setCapacity(int capacity) 
    {
        this.capacity = capacity;
    }
    
    /**
     * Returns number of students already allocated to the program
     * @return number of students already allocated
     */
    public int getNumberOfAllocatedStudents() 
    {
        return numberOfAllocatedStudents;
    }
    
    /**
     * Increases number of students already allocated by 1
     */
    public void increaseNumberOfAllocatedStudents() 
    {
        this.numberOfAllocatedStudents += 1;
    }
}

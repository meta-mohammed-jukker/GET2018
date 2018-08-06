package dsaSession2Part1;

public class Student
{
    private int id;
    private String name;
    private String[] preferences=new String[5];
    private String programAllocated;
    
    /**
     * Initializes student objects
     * @param id student ID
     * @param name student name
     * @param preferences list of subject preferences
     */
    public Student(int id, String name, String[] preferences)
    {
        this.id = id;
        this.name = name;
        this.preferences = preferences;
        this.programAllocated = null;
    }
    
    /**
     * Returns name of student
     * @return student name
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * Sets name of student
     * @param name student name
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * Returns list of program preferences of student
     * @return list of preferences
     */
    public String[] getPreferences() 
    {
        return preferences;
    }
    
    /**
     * Sets list of program preferences of student
     * @param preferences list of preferences
     */
    public void setPreferences(String[] preferences) 
    {
        this.preferences = preferences;
    }
    
    /**
     * Returns student ID
     * @return
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Sets student ID
     * @param id student ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Returns program allocated to the student
     * @return program name
     */
    public String getProgramAllocated()
    {
        return programAllocated;
    }
    
    /**
     * Sets program allocated to the student
     * @param programAllocated program name
     */
    public void setProgramAllocated(String programAllocated)
    {
        this.programAllocated = programAllocated;
    }
}

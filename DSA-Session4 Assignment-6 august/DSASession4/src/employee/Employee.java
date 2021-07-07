package employee;

public class Employee implements Comparable<Employee>
{
    private final int id;
    private String name;
    private String address;
    
    /**
     * Initializes Employee object
     * @param id employee id
     * @param name 
     * @param address
     */
    public Employee(int id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    /**
     * Returns employee id
     * @return employee id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Returns employee name
     * @return employee name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns employee address
     * @return employee address
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * Compares employee id
     */
    @Override
    public int compareTo(Employee employee)
    {
        if(id ==employee.getId())
        {
            return 0;
        }
        else if(id > employee.getId())
        {
            return 1;
        }
        else  
        {
            return -1;
        }
    }
}

package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeOperations
{
    List<Employee> employeeList;
    
    /**
     * Initializes EmployeeOperations
     */
    public EmployeeOperations()
    {
        employeeList = new ArrayList<Employee>();
    }
    
    /**
     * Adds employee 
     * @param id unique employee id
     * @param name employee name
     * @param address employee address
     * @return
     */
    public boolean addEmployee(int id, String name, String address)
    {
        for(Employee employee: employeeList)
        {
            if(employee.getId() == id)
            {
                return false;
            }
        }
        Employee newEmployee = new Employee(id, name, address);
        employeeList.add(newEmployee);
        return true;
    }
    
    /**
     * Returns list of employee sorted by name
     * @return list of employee
     */
    public List<Employee> sortByName()
    {
        List<Employee> sortedEmployeeList = employeeList;
        Collections.sort(sortedEmployeeList, new SortByName());
        return sortedEmployeeList;
    }
    
    /**
     * Returns list of employee sorted by id
     * @return list of employee
     */
    public List<Employee> sortById()
    {
        List<Employee> sortedEmployeeList = employeeList;
        Collections.sort(sortedEmployeeList);
        return sortedEmployeeList;
    }
}

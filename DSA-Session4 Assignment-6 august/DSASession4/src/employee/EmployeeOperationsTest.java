package employee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeOperationsTest
{
    EmployeeOperations employeeOperations = new EmployeeOperations();
    
    @Before
    public void initialize()
    {
        employeeOperations.addEmployee(1, "mj", "abc");
        employeeOperations.addEmployee(5, "cj", "c");
        employeeOperations.addEmployee(2, "dj", "ac");
        employeeOperations.addEmployee(3, "j", "ab");
        employeeOperations.addEmployee(4, "jj", "abc");
    }
    
    @Test
    public void testAddEmployee()
    {
        boolean expectedOutput = true;
        boolean actualOutput = employeeOperations.addEmployee(6, "aj", "bc");
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testAddEmployeeWithDuplicateID()
    {
        boolean expectedOutput = false;
        boolean actualOutput = employeeOperations.addEmployee(2, "aj", "bc");
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testSortByName()
    {
        String[] expectedOutput = {"cj", "dj", "j", "jj", "mj"};
        int i=0;
        for(Employee employee: employeeOperations.sortByName())
        {
            assertEquals(expectedOutput[i],employee.getName());
            i++;
        }
    }
    
    @Test
    public void testSortByID()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5};
        int i=0;
        for(Employee employee: employeeOperations.sortById())
        {
            assertEquals(expectedOutput[i],employee.getId());
            i++;
        }
    }

}

package employee;

public class DriverClass
{
    public static void main(String[] args)
    {
        EmployeeOperations employeeOperations = new EmployeeOperations();
        employeeOperations.addEmployee(1, "mj", "abc");
        employeeOperations.addEmployee(5, "cj", "c");
        employeeOperations.addEmployee(2, "dj", "ac");
        employeeOperations.addEmployee(3, "j", "ab");
        employeeOperations.addEmployee(4, "jj", "abc");
        
        System.out.println("Sorted by name: ");
        for(Employee emp: employeeOperations.sortByName())
        {
            System.out.println(emp.getId() + "\t" +
                               emp.getName() + "\t" +
                               emp.getAddress());
        }
        
        System.out.println("Sorted by ID: ");
        for(Employee emp: employeeOperations.sortById())
        {
            System.out.println(emp.getId() + "\t" +
                               emp.getName() + "\t" +
                               emp.getAddress());
        }
    }
}

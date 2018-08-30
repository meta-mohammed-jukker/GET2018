package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunQueries
{
    private Connection connection;
    
    public RunQueries()
    {
        connection = JDBCConnectivity.getMysqlConnection("root", "mohammed", "workplace");
    }
    
    /**
     * Adds employee details
     * @param employee employee object
     * @return true if details added, else false
     */
    public boolean addDetails(Employee employee)
    {
        int employeesAdded = 0;
        String query = Queries.addEmployee;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setInt(4, employee.getAge());
            employeesAdded = preparedStatement.executeUpdate();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        finally
        {
            dispose();
        }
        
        if(employeesAdded > 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Searches all employee with given name
     * @param name employee name
     * @return list of employees
     */
    public List<Employee> searchEmployee(String name)
    {
        List<Employee> employeeList = new ArrayList<Employee>();
        
        String query = Queries.searchEmployee;           
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                int employeeID = resultSet.getInt("employeeID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String emailID = resultSet.getString("emailID");
                int age = resultSet.getInt("age");
                
                Employee employee = new Employee(employeeID, firstName, lastName, emailID, age);
                employeeList.add(employee);
            }
            resultSet.close();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        finally
        {
            dispose();
        }
        return employeeList;
    }
    
    /**
     * Returns list of all employee details
     * @return list of all employee
     */
    public List<Employee> showAllEmployeeDetails()
    {
        List<Employee> employeeList = new ArrayList<Employee>();
        String query = Queries.showAllEmployees;
        
        try
        (
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {   
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                int employeeID = resultSet.getInt("employeeID");
                String emailID = resultSet.getString("emailID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                
                Employee employee = new Employee(employeeID, firstName, lastName, emailID, age);
                employeeList.add(employee);
            }
            resultSet.close();
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        finally
        {
            dispose();
        }
        return employeeList;
    }
    
    /**
     * Closes connection
     */
    public void dispose()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
    }
}

package com.dao;

public class Queries
{
    static final String addEmployee = "INSERT INTO employee(firstName, lastName, emailID, age) " + 
                                      "VALUES(?, ?, ?, ?)";
    
    static final String showAllEmployees = "SELECT employeeID, firstName, lastName, emailID, age " +
                                           "FROM employee ";
    
    static final String searchEmployee = "SELECT employeeID, firstName, lastName, emailID, age " +
                                         "FROM employee " +
                                         "WHERE CONCAT(firstName,' ',lastName) like CONCAT('%',?,'%') " + 
                                         "OR CONCAT(lastName,' ',firstName) like CONCAT('%',?,'%')";
    
    static final String updateEmployee = "Update employee " + 
                                         "SET firstName = ?, " + 
                                             "lastName = ?, " + 
                                             "emailID = ?, " +
                                             "age = ? " + 
                                         "WHERE employeeID = ? ;";
    
    static final String showEmployeeDetailsByID = "SELECT employeeID, firstName, lastName, emailID, age " + 
                                                  "FROM employee " + 
                                                  "WHERE employeeID = ? ;";
}

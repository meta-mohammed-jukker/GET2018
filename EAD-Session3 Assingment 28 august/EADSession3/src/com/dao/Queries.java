package com.dao;

public class Queries
{
    static String addEmployee = "INSERT INTO employee(firstName, lastName, emailID, age) " + 
                                "VALUES(?, ?, ?, ?)";
    
    static String showAllEmployees = "SELECT employeeID, firstName, lastName, emailID, age " +
                                     "FROM employee ";
}

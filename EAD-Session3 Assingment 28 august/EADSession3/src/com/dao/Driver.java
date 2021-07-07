package com.dao;

public class Driver
{

    public static void main(String[] args)
    {
        Employee employee = new Employee("moha", "juker", "mj@gm.com", 32);
        RunQueries q = new RunQueries();
        q.addDetails(employee);

    }

}

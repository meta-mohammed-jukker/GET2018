package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.adminEmployeePortal.dao.EmployeeDAO;
import com.metacube.training.adminEmployeePortal.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDAO employeeDAO;

    /**
     * returns employee by email
     */
    @Override
    public Employee getByEmail(String email)
    {
        if (employeeDAO.getByEmail(email) == null)
        {
            return null;
        }
        return employeeDAO.getByEmail(email);
    }

    /**
     * returns employee by id
     */
    @Override
    public Employee getById(int id)
    {
        if (employeeDAO.getById(id) == null)
        {
            return null;
        }
        return employeeDAO.getById(id);
    }

    /**
     * returns list of all employees
     */
    @Override
    public List<Employee> getAll()
    {
        return employeeDAO.getAll();
    }

    /**
     * deletes employee
     */
    @Override
    public boolean delete(int id)
    {
        Employee employee = employeeDAO.getById(id);
        return employeeDAO.delete(employee);
    }

    /**
     * updates employee
     */
    @Override
    public boolean update(Employee employee)
    {
        return employeeDAO.update(employee);
    }

    /**
     * adds employee
     */
    @Override
    public boolean create(Employee employee)
    {
        return employeeDAO.create(employee);
    }
}

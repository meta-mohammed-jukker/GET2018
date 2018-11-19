package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringData.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    public EmployeeRepository<Employee> employeeRepository;

    /**
     * returns employee by email
     */
    @Override
    public Employee getByEmail(String email)
    {
        return employeeRepository.findByEmail(email);
    }

    /**
     * returns employee by id
     */
    @Override
    public Employee getById(int id)
    {
        return employeeRepository.findOne(id);
    }

    /**
     * returns list of all employees
     */
    @Override
    public List<Employee> getAll()
    {
        return employeeRepository.findAll();
    }

    /**
     * deletes employee
     */
    @Override
    public boolean delete(int id)
    {
        employeeRepository.delete(id);
        return true;
    }

    /**
     * updates employee
     */
    @Override
    public boolean update(Employee employee)
    {
        employeeRepository.saveAndFlush(employee);
        return true;
    }

    /**
     * adds employee
     */
    @Override
    public boolean create(Employee employee)
    {
        employeeRepository.save(employee);
        return true;
    }
}

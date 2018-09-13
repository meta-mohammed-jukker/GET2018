package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Employee;

public interface EmployeeDAO
{
    Employee getByEmail(String email);

    Employee getById(int id);

    List<Employee> getAll();

    boolean delete(Employee employee);

    boolean update(Employee employee);

    boolean create(Employee employee);
}

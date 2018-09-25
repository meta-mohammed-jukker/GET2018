package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Employee;

public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer>
{
    /**
     * get employee by email
     * 
     * @param email
     * @return
     */
    public Employee findByEmail(String email);
    
    public List<Employee> findByIdIn(List<Integer> ids);
}

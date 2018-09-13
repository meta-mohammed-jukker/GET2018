package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Employee;
import com.metacube.training.AdminEmployeePortalWithHibernate.model.EmployeeSkillMapping;


public interface EmployeeSkillMappingDAO
{
    boolean create(EmployeeSkillMapping employeeSkillMapping);
    
    List<EmployeeSkillMapping> getAll();
    
    List<Employee> getEmployeesWithSameSkill(int id);
}

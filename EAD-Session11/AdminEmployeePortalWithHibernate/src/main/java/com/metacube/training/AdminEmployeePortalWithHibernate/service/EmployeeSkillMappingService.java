package com.metacube.training.AdminEmployeePortalWithHibernate.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Employee;
import com.metacube.training.AdminEmployeePortalWithHibernate.model.EmployeeSkillMapping;

public interface EmployeeSkillMappingService
{
boolean create(EmployeeSkillMapping employeeSkillMapping);
    
    List<EmployeeSkillMapping> getAll();
    
    List<Employee> getEmployeesWithSameSkill(int id);
}

package com.metacube.training.AdminEmployeePortalWithSpringSecurity.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity.model.EmployeeSkillMapping;

public interface EmployeeSkillMappingService
{
boolean create(EmployeeSkillMapping employeeSkillMapping);
    
    List<EmployeeSkillMapping> getAll();
    
    List<Employee> getEmployeesWithSameSkill(int id);
}

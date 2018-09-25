package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.EmployeeSkillMapping;

public interface EmployeeSkillMappingService
{
boolean create(EmployeeSkillMapping employeeSkillMapping);
    
    List<EmployeeSkillMapping> getAll();
    
    List<Employee> getEmployeesWithSameSkill(int id);
}

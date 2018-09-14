package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringData.model.EmployeeSkillMapping;

public interface EmployeeSkillMappingService
{
boolean create(EmployeeSkillMapping employeeSkillMapping);
    
    List<EmployeeSkillMapping> getAll();
    
    List<Employee> getEmployeesWithSameSkill(int id);
}

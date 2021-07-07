package com.metacube.training.AdminEmployeePortalWithHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithHibernate.dao.EmployeeSkillMappingDAO;
import com.metacube.training.AdminEmployeePortalWithHibernate.model.Employee;
import com.metacube.training.AdminEmployeePortalWithHibernate.model.EmployeeSkillMapping;

@Service
public class EmployeeSkillMappingServiceImpl implements EmployeeSkillMappingService
{
    @Autowired
    private EmployeeSkillMappingDAO employeeSkillMappingDAO;

    /**
     * Adds employee skill mappings
     */
    public boolean create(EmployeeSkillMapping employeeSkillMapping)
    {
        return employeeSkillMappingDAO.create(employeeSkillMapping);
    }

    /**
     * returns list of all employee skill mappings
     */
    public List<EmployeeSkillMapping> getAll()
    {
        return employeeSkillMappingDAO.getAll();
    }

    /**
     * Return list of employees with same skill
     */
    @Override
    public List<Employee> getEmployeesWithSameSkill(int id)
    {
        return employeeSkillMappingDAO.getEmployeesWithSameSkill(id);
    }

}

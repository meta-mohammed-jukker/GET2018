package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringData.model.EmployeeSkillMapping;
import com.metacube.training.AdminEmployeePortalWithSpringData.repository.EmployeeRepository;
import com.metacube.training.AdminEmployeePortalWithSpringData.repository.EmployeeSkillMappingRepository;

@Service
public class EmployeeSkillMappingServiceImpl implements EmployeeSkillMappingService
{
    @Autowired
    private EmployeeSkillMappingRepository<EmployeeSkillMapping> employeeSkillMappingRepository;
    
    @Autowired
    private EmployeeRepository<Employee> employeeRepository;

    /**
     * Adds employee skill mappings
     */
    public boolean create(EmployeeSkillMapping employeeSkillMapping)
    {
        employeeSkillMappingRepository.save(employeeSkillMapping);
        return false;
    }

    /**
     * returns list of all employee skill mappings
     */
    public List<EmployeeSkillMapping> getAll()
    {
        return employeeSkillMappingRepository.findAll();
    }

    /**
     * Return list of employees with same skill
     */
    @Override
    public List<Employee> getEmployeesWithSameSkill(int id)
    {
        List<EmployeeSkillMapping> employeeSkillMappingList = employeeSkillMappingRepository.findBySkillId(id);
        List<Integer> employeeIdList = new ArrayList<Integer>();
        for (EmployeeSkillMapping employeeSkillMapping : employeeSkillMappingList)
        {
            employeeIdList.add(employeeSkillMapping.getEmployeeId());
        }
        return employeeRepository.findByIdIn(employeeIdList);
    }

}

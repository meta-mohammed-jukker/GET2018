package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.EmployeeSkillMapping;

public interface EmployeeSkillMappingRepository<E> extends JpaRepository<EmployeeSkillMapping, Integer>
{
    public List<EmployeeSkillMapping> findBySkillId(int skillId);
}

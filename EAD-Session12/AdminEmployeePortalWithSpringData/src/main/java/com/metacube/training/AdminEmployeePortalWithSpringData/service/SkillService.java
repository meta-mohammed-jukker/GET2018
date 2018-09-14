package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringData.model.Skill;

public interface SkillService
{
    Skill getById(int id);

    List<Skill> getAll();

    boolean delete(int id);

    boolean update(Skill skill);

    boolean create(Skill skill);
}

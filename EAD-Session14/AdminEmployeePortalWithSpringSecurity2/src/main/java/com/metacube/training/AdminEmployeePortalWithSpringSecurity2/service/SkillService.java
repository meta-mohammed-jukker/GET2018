package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Skill;

public interface SkillService
{
    Skill getById(int id);

    List<Skill> getAll();

    boolean delete(int id);

    boolean update(Skill skill);

    boolean create(Skill skill);
}

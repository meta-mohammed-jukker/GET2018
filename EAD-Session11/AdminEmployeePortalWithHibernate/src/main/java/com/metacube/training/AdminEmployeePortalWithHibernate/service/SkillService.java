package com.metacube.training.AdminEmployeePortalWithHibernate.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Employee;
import com.metacube.training.AdminEmployeePortalWithHibernate.model.Skill;

public interface SkillService
{
    Skill getById(int id);

    List<Skill> getAll();

    boolean delete(int id);

    boolean update(Skill skill);

    boolean create(Skill skill);
}

package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringData.model.Skill;
import com.metacube.training.AdminEmployeePortalWithSpringData.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService
{
    @Autowired
    private SkillRepository<Skill> skillRepository;

    /**
     * returns skill by id
     */
    @Override
    public Skill getById(int id)
    {
        return skillRepository.findOne(id);
    }

    /**
     * returns list of all skills
     */
    @Override
    public List<Skill> getAll()
    {
        return skillRepository.findAll();
    }

    /**
     * deletes skill
     */
    @Override
    public boolean delete(int id)
    {
        skillRepository.delete(id);
        return true;
    }

    /**
     * updates skill
     */
    @Override
    public boolean update(Skill skill)
    {
        skillRepository.saveAndFlush(skill);
        return true;
    }

    /**
     * adds skill
     */
    @Override
    public boolean create(Skill skill)
    {
        skillRepository.save(skill);
        return true;
    }
}

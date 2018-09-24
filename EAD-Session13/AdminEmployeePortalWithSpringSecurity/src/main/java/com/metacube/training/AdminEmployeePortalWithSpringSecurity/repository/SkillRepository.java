package com.metacube.training.AdminEmployeePortalWithSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity.model.Skill;


public interface SkillRepository<S> extends JpaRepository<Skill, Integer>
{

}

package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Skill;


public interface SkillRepository<S> extends JpaRepository<Skill, Integer>
{

}

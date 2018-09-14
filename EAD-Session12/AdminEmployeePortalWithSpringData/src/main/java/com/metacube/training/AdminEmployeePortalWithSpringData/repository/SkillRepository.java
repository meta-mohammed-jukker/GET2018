package com.metacube.training.AdminEmployeePortalWithSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Skill;


public interface SkillRepository<S> extends JpaRepository<Skill, Integer>
{

}

package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Project;

public interface ProjectRepository<P> extends JpaRepository<Project, Integer>
{
    
}

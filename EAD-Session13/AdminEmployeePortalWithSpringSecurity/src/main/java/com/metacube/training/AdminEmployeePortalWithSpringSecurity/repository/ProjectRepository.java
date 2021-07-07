package com.metacube.training.AdminEmployeePortalWithSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity.model.Project;

public interface ProjectRepository<P> extends JpaRepository<Project, Integer>
{
    
}

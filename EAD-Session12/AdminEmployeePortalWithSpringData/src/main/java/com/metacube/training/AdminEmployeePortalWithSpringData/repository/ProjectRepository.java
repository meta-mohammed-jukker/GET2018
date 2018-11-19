package com.metacube.training.AdminEmployeePortalWithSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Project;

public interface ProjectRepository<P> extends JpaRepository<Project, Integer>
{
    
}

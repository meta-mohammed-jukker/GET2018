package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Project;

public interface ProjectService
{

    Project getById(int id);

    List<Project> getAll();

    boolean delete(int id);

    boolean update(Project project);

    boolean create(Project project);

}

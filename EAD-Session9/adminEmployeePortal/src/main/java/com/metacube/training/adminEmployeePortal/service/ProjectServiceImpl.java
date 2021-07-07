package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.adminEmployeePortal.dao.ProjectDAO;
import com.metacube.training.adminEmployeePortal.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService
{

    @Autowired
    private ProjectDAO projectDAO;

    /**
     * returns project by id
     */
    @Override
    public Project getById(int id)
    {

        return projectDAO.getById(id);
    }

    /**
     * returns list of all projects 
     */
    @Override
    public List<Project> getAll()
    {
        return projectDAO.getAll();
    }

    /**
     * deletes project
     */
    @Override
    public boolean delete(int id)
    {
        Project project = projectDAO.getById(id);
        return projectDAO.delete(project);
    }

    /**
     * updates project
     */
    @Override
    public boolean update(Project project)
    {
        return projectDAO.update(project);
    }

    /**
     * adds project
     */
    @Override
    public boolean create(Project project)
    {
        return projectDAO.create(project);
    }

}

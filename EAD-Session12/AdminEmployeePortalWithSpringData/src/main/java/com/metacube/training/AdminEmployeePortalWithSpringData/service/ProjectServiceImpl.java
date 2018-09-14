package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Project;
import com.metacube.training.AdminEmployeePortalWithSpringData.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService
{
    
    @Autowired
    private ProjectRepository<Project> projectRepository;

    /**
     * returns project by id
     */
    @Override
    public Project getById(int id)
    {
        return projectRepository.findOne(id);
        
    }

    /**
     * returns list of all projects 
     */
    @Override
    public List<Project> getAll()
    {
        return projectRepository.findAll();
    }

    /**
     * deletes project
     */
    @Override
    public boolean delete(int id)
    {
        projectRepository.delete(id);
        return true;
    }

    /**
     * updates project
     */
    @Override
    public boolean update(Project project)
    {
        projectRepository.saveAndFlush(project);
        return false;
    }

    /**
     * adds project
     */
    @Override
    public boolean create(Project project)
    {
        projectRepository.save(project);
        return true;
    }

}

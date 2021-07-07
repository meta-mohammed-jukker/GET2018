package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.JobDetails;

public interface JobDetailsService
{
    JobDetails getById(int id);

    List<JobDetails> getAll();

    boolean delete(int id);

    boolean update(JobDetails jobDetails);

    boolean create(JobDetails jobDetails);
    
    List<JobDetails> getAllByProjectId(int projectId);
    
    List<Employee> getAllByProjectIdAndFirstName(int projectId, String firstName);
}

package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringData.model.JobDetails;
import com.metacube.training.AdminEmployeePortalWithSpringData.repository.JobDetailsRepository;

@Service
public class JobDetailsServiceImpl implements JobDetailsService
{
    @Autowired
    private JobDetailsRepository<JobDetails> jobDetailsRepository;

    /**
     * returns job by id
     */
    @Override
    public JobDetails getById(int id)
    {
        return jobDetailsRepository.findOne(id);
    }

    /**
     * returns list of all jobs
     */
    @Override
    public List<JobDetails> getAll()
    {
        return jobDetailsRepository.findAll();
    }

    /**
     * deletes job
     */
    @Override
    public boolean delete(int id)
    {
        jobDetailsRepository.delete(id);
        return true;
    }

    /**
     * updates job
     */
    @Override
    public boolean update(JobDetails jobDetails)
    {
        jobDetailsRepository.saveAndFlush(jobDetails);
        return true;
    }

    /**
     * adds job
     */
    @Override
    public boolean create(JobDetails jobDetails)
    {
        jobDetailsRepository.save(jobDetails);
        return true;
    }

    @Override
    public List<JobDetails> getAllByProjectId(int projectId)
    {
        return jobDetailsRepository.findByProjectId(projectId);
    }

    @Override
    public List<Employee> getAllByProjectIdAndFirstName(int projectId,
            String firstName)
    {
        return jobDetailsRepository.findByprojectIdAndFirstName(projectId, firstName);
    }
}

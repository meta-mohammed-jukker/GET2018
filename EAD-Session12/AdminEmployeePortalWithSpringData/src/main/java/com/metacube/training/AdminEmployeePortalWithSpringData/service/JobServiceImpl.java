package com.metacube.training.AdminEmployeePortalWithSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Job;
import com.metacube.training.AdminEmployeePortalWithSpringData.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService
{
    @Autowired
    private JobRepository<Job> jobRepository;

    /**
     * returns job by id
     */
    @Override
    public Job getById(int id)
    {
        return jobRepository.findOne(id);
    }

    /**
     * returns list of all jobs
     */
    @Override
    public List<Job> getAll()
    {
        return jobRepository.findAll();
    }

    /**
     * deletes job
     */
    @Override
    public boolean delete(int id)
    {
        jobRepository.delete(id);
        return true;
    }

    /**
     * updates job
     */
    @Override
    public boolean update(Job job)
    {
        jobRepository.saveAndFlush(job);
        return true;
    }

    /**
     * adds job
     */
    @Override
    public boolean create(Job job)
    {
        jobRepository.save(job);
        return true;
    }
}

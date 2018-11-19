package com.metacube.training.AdminEmployeePortalWithSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Job;


public interface JobRepository<J> extends JpaRepository<Job, Integer>
{

}

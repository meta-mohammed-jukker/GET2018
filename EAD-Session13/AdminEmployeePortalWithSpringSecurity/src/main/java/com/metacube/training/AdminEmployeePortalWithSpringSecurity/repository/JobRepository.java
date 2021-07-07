package com.metacube.training.AdminEmployeePortalWithSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity.model.Job;


public interface JobRepository<J> extends JpaRepository<Job, Integer>
{

}

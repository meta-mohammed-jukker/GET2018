package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Job;


public interface JobRepository<J> extends JpaRepository<Job, Integer>
{

}

package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Job;

public interface JobDAO
{
    Job getById(int id);

    List<Job> getAll();

    boolean delete(Job Job);

    boolean update(Job Job);

    boolean create(Job Job);
}

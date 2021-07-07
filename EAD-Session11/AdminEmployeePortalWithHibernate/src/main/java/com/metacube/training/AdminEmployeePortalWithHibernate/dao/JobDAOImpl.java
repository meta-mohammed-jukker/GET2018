package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Job;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class JobDAOImpl implements JobDAO
{
    @Autowired
    SessionFactory sessionFactory;

    private final String SQL_FIND_JOB = "from Job where job_code = :id";
    private final String SQL_DELETE_JOB = "delete from Job where job_code = :id";
    private final String SQL_UPDATE_JOB = "update Job set job_title = :title where job_code = :id";
    private final String SQL_GET_ALL = "from Job";

    /**
     * returns job by id
     */
    public Job getById(int id)
    {
        TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery(
                SQL_FIND_JOB);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * returns list of all jobs
     */
    public List<Job> getAll()
    {
        TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery(
                SQL_GET_ALL);
        return query.getResultList();
    }

    /**
     * deletes job
     */
    public boolean delete(Job job)
    {
        try
        {
            TypedQuery<Job> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_DELETE_JOB);
            query.setParameter("id", job.getId());
            return query.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * updates job
     */
    public boolean update(Job job)
    {
        try
        {
            TypedQuery<Job> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_UPDATE_JOB);
            query.setParameter("title", job.getTitle());
            query.setParameter("id", job.getId());
            return query.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * adds job
     */
    public boolean create(Job job)
    {
        try
        {
            sessionFactory.getCurrentSession().save(job);
            return true;
        } catch (Exception e)
        {
            return false;
        }

    }
}

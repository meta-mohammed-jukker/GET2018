package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Project;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ProjectDAOImpl implements ProjectDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    private final String SQL_FIND_PROJECT = "from Project where project_id = :projectID";
    private final String SQL_DELETE_PROJECT = "delete from Project where project_id = :projectID";
    private final String SQL_UPDATE_PROJECT = "update Project set project_name = :name, description = :description, start_date  = :startDate, end_date  = :endDate where project_id = :projectID";
    private final String SQL_GET_ALL = "from Project";

    /**
     * returns project by id
     */
    public Project getById(int id)
    {
        TypedQuery<Project> query = sessionFactory.getCurrentSession()
                .createQuery(SQL_FIND_PROJECT);
        query.setParameter("projectID", id);
        return query.getSingleResult();
    }

    /**
     * returns list of all projects
     */
    public List<Project> getAll()
    {
        TypedQuery<Project> query = sessionFactory.getCurrentSession()
                .createQuery(SQL_GET_ALL);
        return query.getResultList();
    }

    /**
     * deletes project
     */
    public boolean delete(Project project)
    {
        try
        {
            TypedQuery<Project> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_DELETE_PROJECT);
            query.setParameter("projectID", project.getId());
            return query.executeUpdate() > 0;

        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * updates project
     */
    public boolean update(Project project)
    {
        try
        {
            TypedQuery<Project> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_UPDATE_PROJECT);
            query.setParameter("name", project.getName());
            query.setParameter("description", project.getDescription());
            query.setParameter("startDate", project.getStartDate());
            query.setParameter("endDate", project.getEndDate());
            query.setParameter("projectID", project.getId());
            return query.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * adds project
     */
    public boolean create(Project project)
    {
        try
        {
            // return jdbcTemplate.update(SQL_INSERT_PROJECT, project.getName(),
            // project.getDescription(), project.getStartDate(),
            // project.getEndDate()) > 0;
            sessionFactory.getCurrentSession().save(project);
            return true;
        } catch (Exception e)
        {
            return false;
        }

    }

}
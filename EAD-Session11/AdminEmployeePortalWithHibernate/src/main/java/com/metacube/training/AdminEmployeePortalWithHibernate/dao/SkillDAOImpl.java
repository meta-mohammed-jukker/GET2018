package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Skill;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SkillDAOImpl implements SkillDAO
{
    @Autowired
    SessionFactory sessionFactory;

    private final String SQL_FIND_SKILL = "from Skill where skill_id = :id";
    private final String SQL_DELETE_SKILL = "delete from Skill where skill_id = :id";
    private final String SQL_UPDATE_SKILL = "update Skill set skill_name = :name where skill_id = :id";
    private final String SQL_GET_ALL = "from Skill";

    /**
     * returns skill by id
     */
    public Skill getById(int id)
    {
        TypedQuery<Skill> query = sessionFactory.getCurrentSession()
                .createQuery(SQL_FIND_SKILL);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * returns list of all skills
     */
    public List<Skill> getAll()
    {
        TypedQuery<Skill> query = sessionFactory.getCurrentSession()
                .createQuery(SQL_GET_ALL);
        return query.getResultList();
    }

    /**
     * deletes skill
     */
    public boolean delete(Skill skill)
    {
        try
        {
            TypedQuery<Skill> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_DELETE_SKILL);
            query.setParameter("id", skill.getId());
            return query.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * updates skill
     */
    public boolean update(Skill skill)
    {
        try
        {
            TypedQuery<Skill> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_UPDATE_SKILL);
            query.setParameter("name", skill.getName());
            query.setParameter("id", skill.getId());
            return query.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * adds skill
     */
    public boolean create(Skill skill)
    {
        try
        {
            sessionFactory.getCurrentSession().save(skill);
            return true;
        } catch (Exception e)
        {
            return false;
        }

    }
}

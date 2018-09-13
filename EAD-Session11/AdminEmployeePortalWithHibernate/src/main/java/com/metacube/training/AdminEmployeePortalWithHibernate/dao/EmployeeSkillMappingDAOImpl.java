package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Employee;
import com.metacube.training.AdminEmployeePortalWithHibernate.model.EmployeeSkillMapping;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeSkillMappingDAOImpl implements EmployeeSkillMappingDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    private final String SQL_GET_ALL = "from EmployeeSkillMapping";
    private final String SQL_GET_ALL_BY_SKILL = "from EmployeeSkillMapping where skill_code = :skillID";
    private final String SQL_GET_EMPLOYEES = "from Employee where emp_code in (:id)";

    /**
     * adds employee skill mappings
     */
    public boolean create(EmployeeSkillMapping employeeSkillMapping)
    {
        try
        {
            sessionFactory.getCurrentSession().save(employeeSkillMapping);
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * returns all employee skill mappings
     */
    public List<EmployeeSkillMapping> getAll()
    {
        TypedQuery<EmployeeSkillMapping> query = sessionFactory
                .getCurrentSession().createQuery(SQL_GET_ALL);
        return query.getResultList();
    }

    /**
     * Returns list of employees with same skill
     */
    public List<Employee> getEmployeesWithSameSkill(int id)
    {
        TypedQuery<EmployeeSkillMapping> query = sessionFactory
                .getCurrentSession().createQuery(SQL_GET_ALL_BY_SKILL);
        query.setParameter("skillID", id);
        List<EmployeeSkillMapping> employeeSkillMappingList = query
                .getResultList();
        List<Integer> employeeIdList = new ArrayList<Integer>();
        for (EmployeeSkillMapping employeeSkillMapping : employeeSkillMappingList)
        {
            employeeIdList.add(employeeSkillMapping.getEmployeeId());
        }
        TypedQuery<Employee> query2 = sessionFactory.getCurrentSession()
                .createQuery(SQL_GET_EMPLOYEES);
        query2.setParameter("id", employeeIdList);
        return query2.getResultList();
    }

}

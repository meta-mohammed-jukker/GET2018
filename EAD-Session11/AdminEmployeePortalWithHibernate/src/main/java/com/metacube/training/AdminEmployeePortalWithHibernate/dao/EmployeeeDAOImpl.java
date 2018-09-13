package com.metacube.training.AdminEmployeePortalWithHibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.AdminEmployeePortalWithHibernate.model.Employee;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeeDAOImpl implements EmployeeDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    private final String SQL_FIND_EMPLOYEE = "from Employee where emp_code = :id";
    private final String SQL_DELETE_EMPLOYEE = "delete from Employee where emp_code = :id";
    private final String SQL_UPDATE_EMPLOYEE = "update Employee set first_name = :firstName, middle_name = :middleName, last_name  = :lastName, dob  = :dateOfBirth, gender = :gender, email_id = :email, password = :password where emp_code = :id";
    private final String SQL_GET_ALL = "from Employee";
    private final String SQL_GET_EMPLOYEE_BY_EMAIL = "from Employee where email_id = :email";

    /**
     * gets employee by email
     */
    public Employee getByEmail(String email)
    {
        try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_GET_EMPLOYEE_BY_EMAIL);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    /**
     * gets employee employee id
     */
    public Employee getById(int id)
    {
        try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_FIND_EMPLOYEE);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }

    }

    /**
     * returns list of all employees
     */
    public List<Employee> getAll()
    {
        TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                .createQuery(SQL_GET_ALL);
        return query.getResultList();
    }

    /**
     * deletes employee
     */
    public boolean delete(Employee employee)
    {
        try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_DELETE_EMPLOYEE);
            query.setParameter("id", employee.getId());
            return query.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * updates employee
     */
    public boolean update(Employee employee)
    {
        try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SQL_UPDATE_EMPLOYEE);
            query.setParameter("firstName", employee.getFirstName());
            query.setParameter("middleName", employee.getMiddleName());
            query.setParameter("lastName", employee.getLastName());
            query.setParameter("dateOfBirth", employee.getDateOfBirth());
            query.setParameter("gender", employee.getGender());
            query.setParameter("email", employee.getEmail());
            query.setParameter("password", employee.getPassword());
            query.setParameter("id", employee.getId());
            return query.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * adds employee
     */
    public boolean create(Employee employee)
    {
        try
        {
            sessionFactory.getCurrentSession().save(employee);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}

package com.metacube.training.AdminEmployeePortalWithHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkillMapping
{
    @Id
    @Column(name="emp_skill_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    @Column(name="emp_code")
    int employeeId;
    
    @Column(name="skill_code")
    int skillId;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public int getSkillId()
    {
        return skillId;
    }

    public void setSkillId(int skillId)
    {
        this.skillId = skillId;
    }
    
    
}

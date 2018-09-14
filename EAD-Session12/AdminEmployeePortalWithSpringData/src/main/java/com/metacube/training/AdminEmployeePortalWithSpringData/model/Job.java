package com.metacube.training.AdminEmployeePortalWithSpringData.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_title_master")
public class Job
{
    @Id
    @Column(name="job_code")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    @Column(name="job_title")
    String title;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}

package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="job_details")
public class JobDetails
{
    @Id
    @Column(name="job_detail_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    @Column(name="emp_code")
    int employeeId;
    
    @Column(name="date_of_joining")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    Date dateOfJoining;
    
    @Column(name="total_exp")
    int experience;
    
    @Column(name="job_code")
    int jobId;
    
    @Column(name="reproting_mgr")
    int reportingManager;
    
    @Column(name="team_lead")
    int teamLead;
    
    @Column(name="curr_proj_id")
    int projectId;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "emp_code", insertable=false, updatable=false)
    private Employee employee;

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

    public Date getDateOfJoining()
    {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining)
    {
        this.dateOfJoining = dateOfJoining;
    }

    public int getExperience()
    {
        return experience;
    }

    public void setExperience(int experience)
    {
        this.experience = experience;
    }

    public int getJobId()
    {
        return jobId;
    }

    public void setJobId(int jobId)
    {
        this.jobId = jobId;
    }

    public int getReportingManager()
    {
        return reportingManager;
    }

    public void setReportingManager(int reportingManager)
    {
        this.reportingManager = reportingManager;
    }

    public int getTeamLead()
    {
        return teamLead;
    }

    public void setTeamLead(int teamLead)
    {
        this.teamLead = teamLead;
    }

    public int getProjectId()
    {
        return projectId;
    }

    public void setProjectId(int projectId)
    {
        this.projectId = projectId;
    }
    
    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
    
    
}

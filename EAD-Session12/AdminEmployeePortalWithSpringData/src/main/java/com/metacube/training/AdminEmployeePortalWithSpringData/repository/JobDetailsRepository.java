package com.metacube.training.AdminEmployeePortalWithSpringData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.AdminEmployeePortalWithSpringData.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringData.model.JobDetails;

public interface JobDetailsRepository<J> extends
        JpaRepository<JobDetails, Integer>
{
    public List<JobDetails> findByProjectId(int projectId);

    @Query("select e FROM  JobDetails jd INNER JOIN jd.employee e WHERE jd.projectId = :projectId and e.firstName = :firstName")
    List<Employee> findByprojectIdAndFirstName(@Param("projectId") int projectId, @Param("firstName") String firstName);
}

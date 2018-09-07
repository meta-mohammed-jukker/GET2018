package com.metacube.training.employeePortal.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController
{
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String userName,
            @RequestParam(value = "password") String password)
    {
        System.out.println(userName);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject()
    {
        return "admin/project";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProject(
            @RequestParam(value = "projectDescription") String projectDescription,
            // @RequestParam(value="projectStartDate") Date projectStartDate,
            // @RequestParam(value="projectEndDate") Date projectEndDate,
            @RequestParam(value = "upload") String imagePath)
    {
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public String addJob()
    {
        return "admin/job";
    }

    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public String addJob(@RequestParam(value = "jobTitle") String jobTitle)
    {
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/addSkill", method = RequestMethod.GET)
    public String addSkill()
    {
        return "admin/skills";
    }

    @RequestMapping(value = "/addSkill", method = RequestMethod.POST)
    public String addSkill(@RequestParam(value = "skillName") String skillName)
    {
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee()
    {
        return "admin/addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "middleName") String middleName,
            @RequestParam(value = "lastName") String lastName,
            // @RequestParam(value="dateOfBirth") Date dateOfBirth,
            // @RequestParam(value="gender") String gender,
            // @RequestParam(value="dateOfJoining") Date dateOfJoining,
            // @RequestParam(value="reportingManager") String reportingManager,
            // @RequestParam(value="teamLead") String teamLead,
            // @RequestParam(value="projectId") String projectId,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password)
    {
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard()
    {
        return "admin/dashboard";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "redirect:/";
    }
}

package com.metacube.training.adminEmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.adminEmployeePortal.model.Employee;
import com.metacube.training.adminEmployeePortal.model.Job;
import com.metacube.training.adminEmployeePortal.model.Project;
import com.metacube.training.adminEmployeePortal.model.Skill;
import com.metacube.training.adminEmployeePortal.service.EmployeeService;
import com.metacube.training.adminEmployeePortal.service.JobService;
import com.metacube.training.adminEmployeePortal.service.ProjectService;
import com.metacube.training.adminEmployeePortal.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController
{

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private JobService jobService;
    @Autowired
    private EmployeeService employeeService;

    /**
     * Goto admin login window
     * 
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    /**
     * login into admin dashboard
     * 
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String userName,
            @RequestParam(value = "password") String password)
    {
        return "redirect:/admin/dashboard";
    }

    /**
     * goto add project form
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject(Model model)
    {
        model.addAttribute("project", new Project());
        return "admin/addProject";
    }

    /**
     * adds project
     * 
     * @param project
     * @return
     */
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project)
    {
        if (project.getId() == 0 && project != null)
        {
            projectService.create(project);
        } else
        {
            projectService.update(project);
        }
        return "redirect:/admin/showAllProjects";
    }

    /**
     * deletes project
     * 
     * @param id
     *            project id
     * @return
     */
    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam(value = "id") String id)
    {
        projectService.delete(Integer.parseInt(id));
        return "redirect:/admin/showAllProjects";
    }

    /**
     * shows all projects
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAllProjects", method = RequestMethod.GET)
    public String showAllProjects(Model model)
    {
        model.addAttribute("projects", projectService.getAll());
        return "admin/projects";
    }

    /**
     * updates project
     * 
     * @param projectId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject(@RequestParam(value = "id") int projectId,
            Model model)
    {
        Project project = projectService.getById(projectId);
        model.addAttribute("project", project);
        return "admin/addProject";
    }

    /**
     * goto add employee form
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "admin/addEmployee";
    }

    /**
     * adds employee
     * 
     * @param employee
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee)
    {
        if (employee.getId() == 0 && employee != null)
        {
            employeeService.create(employee);
        } else
        {
            employeeService.update(employee);
        }
        return "redirect:/admin/showAllEmployees";
    }

    /**
     * deletes employee
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(@RequestParam(value = "id") String id)
    {
        employeeService.delete(Integer.parseInt(id));
        return "redirect:/admin/showAllEmployees";
    }

    /**
     * shows all employees
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAllEmployees", method = RequestMethod.GET)
    public String showAllEmployees(Model model)
    {
        model.addAttribute("employees", employeeService.getAll());
        return "admin/employees";
    }

    /**
     * updates employee
     * 
     * @param employeeId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public String updateEmployee(@RequestParam(value = "id") int employeeId,
            Model model)
    {
        Employee employee = employeeService.getById(employeeId);
        model.addAttribute("employee", employee);
        return "admin/addEmployee";
    }

    /**
     * goto add job form
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public String addJob(Model model)
    {
        model.addAttribute("job", new Job());
        return "admin/addJob";
    }

    /**
     * adds job
     * 
     * @param job
     * @return
     */
    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public String addJob(@ModelAttribute("job") Job job)
    {
        if (job.getId() == 0 && job != null)
        {
            jobService.create(job);
        } else
        {
            jobService.update(job);
        }
        return "redirect:/admin/showAllJobs";
    }

    /**
     * deletes job
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteJob", method = RequestMethod.POST)
    public String deleteJob(@RequestParam(value = "id") String id)
    {
        jobService.delete(Integer.parseInt(id));
        return "redirect:/admin/showAllJobs";
    }

    /**
     * shows all jobs
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAllJobs", method = RequestMethod.GET)
    public String showAllJobs(Model model)
    {
        model.addAttribute("jobs", jobService.getAll());
        return "admin/jobs";
    }

    /**
     * updates job
     * 
     * @param jobId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateJob", method = RequestMethod.GET)
    public String updateJob(@RequestParam(value = "id") int jobId, Model model)
    {
        Job job = jobService.getById(jobId);
        model.addAttribute("job", job);
        return "admin/addJob";
    }

    /**
     * goto add skill window
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addSkill", method = RequestMethod.GET)
    public String addSkill(Model model)
    {
        model.addAttribute("skill", new Skill());
        return "admin/addSkill";
    }

    /**
     * adds skill
     * 
     * @param skill
     * @return
     */
    @RequestMapping(value = "/addSkill", method = RequestMethod.POST)
    public String addSkill(@ModelAttribute("skill") Skill skill)
    {
        if (skill.getId() == 0 && skill != null)
        {
            skillService.create(skill);
        } else
        {
            skillService.update(skill);
        }
        return "redirect:/admin/showAllSkills";
    }

    /**
     * deletes skill
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteSkill", method = RequestMethod.POST)
    public String deleteSkill(@RequestParam(value = "id") String id)
    {
        skillService.delete(Integer.parseInt(id));
        return "redirect:/admin/showAllSkills";
    }

    /**
     * shows all skills
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAllSkills", method = RequestMethod.GET)
    public String showAllSkills(Model model)
    {
        model.addAttribute("skills", skillService.getAll());
        return "admin/skills";
    }

    /**
     * updates skill
     * 
     * @param skillId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateSkill", method = RequestMethod.GET)
    public String updateSkill(@RequestParam(value = "id") int skillId,
            Model model)
    {
        Skill skill = skillService.getById(skillId);
        model.addAttribute("skill", skill);
        return "admin/addSkill";
    }

    /**
     * goto admin dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard()
    {
        return "admin/dashboard";
    }

    /**
     * logs out from admin dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "redirect:/";
    }

}

package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.controller;

//import javax.mail.MessagingException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Employee;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.JobDetails;
//import com.metacube.training.AdminEmployeePortalWithSpringData.service.EmailService;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service.EmployeeService;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service.JobDetailsService;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JobDetailsService jobDetailsService;

    // @Autowired
    // private EmailService emailService;

    /**
     * goto employee login window
     * 
     * @return
     */
    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }*/

    /**
     * logs into employee dashboard
     * 
     * @param userName
     * @param password
     * @return
     */
    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String userName,
            @RequestParam(value = "password") String password)
    {
        if (employeeService.getByEmail(userName) == null
                || !employeeService.getByEmail(userName).getPassword()
                        .equals(password))
        {
            return "redirect:/";
        }
        return "redirect:/employee/dashboard";
    }*/

    /**
     * searches employee
     * 
     * @param id
     *            employee id
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
    public String searchEmployee(@RequestParam(value = "id") int id, Model model)
    {
        model.addAttribute("employees", employeeService.getById(id));
        return "employee/searchEmployee";
    }

    /**
     * searches employee in project
     * 
     * @param id
     *            employee id
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchEmployeeInProject", method = RequestMethod.POST)
    public String searchEmployeeInProject(
            @RequestParam(value = "projectId") int projectId,
            @RequestParam(value = "employeeFirstName") String employeeFirstName,
            Model model)
    {
        List<Employee> employeeList = jobDetailsService.getAllByProjectIdAndFirstName(projectId, employeeFirstName);
        /*List<Employee> employeeList = new ArrayList<Employee>();
        System.out.println(jobDetailsList.size());
        for (JobDetails jobDetail : jobDetailsList)
        {
            employeeList.add(jobDetail.getEmployee());
        }*/
        
        model.addAttribute("employees", employeeList);
        return "employee/searchEmployee";
    }

    /**
     * goto employee dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard()
    {
        return "employee/dashboard";
    }

    /**
     * logs out from employee dashboard
     * 
     * @return
     */
    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "redirect:/";
    }*/

    /**
     * goto forgot password page
     * 
     * @return
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPassword()
    {
        return "forgotPassword";
    }
}

package com.metacube.training.adminEmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.adminEmployeePortal.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    /**
     * goto employee login window
     * 
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    /**
     * logs into employee dashboard
     * 
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
    }

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
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "redirect:/";
    }

}

package com.metacube.training.AdminEmployeePortalWithSpringSecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController
{

    /**
     * goto home page
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model)
    {
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorPage()
    {
        return "error";
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String afterLogin(HttpServletRequest request)
    {
        if (request.isUserInRole("ROLE_ADMIN"))
        {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/error";
    }
}
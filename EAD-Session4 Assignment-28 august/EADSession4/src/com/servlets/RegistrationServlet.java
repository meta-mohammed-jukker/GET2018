package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.facade.UserFacade;
import com.model.UserPOJO;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet 
{	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        Date dateOfBirth = null;
        try
        {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
            System.out.println(dateOfBirth);
        }        
        catch(java.text.ParseException pe)
        {
            pe.printStackTrace();
            System.exit(1);
        }
        String contactNumber = request.getParameter("age");
        String organization = request.getParameter("organization");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserPOJO user = new UserPOJO(firstName, lastName, age, dateOfBirth, 
                                     contactNumber, organization, email, password);
        
        UserFacade register = new UserFacade();
        
        boolean registerUser = register.registerUser(user);
        
        PrintWriter out = response.getWriter();
        
        if(registerUser)
        {
            out.println("<script>alert(\"User added successfully!\")</script>");
            
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("login.html");

            requestdispatch.include(request, response);
        }
        else
        {
            out.println("<script>alert(\"User not added!\")</script>");
            
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("registration.html");

            requestdispatch.include(request, response);
        }

        
	}

}

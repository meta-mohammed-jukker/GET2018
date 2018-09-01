package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.UserPOJO;

/**
 * Servlet implementation class SetUpdatedDetails
 */
public class SetDetails extends HttpServlet 
{
	/**
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
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
        }        
        catch(java.text.ParseException pe)
        {
            pe.printStackTrace();
            System.exit(1);
        }
        String contactNumber = request.getParameter("contactNumber");
        String organization = request.getParameter("organization");
        
        UserPOJO user = new UserPOJO();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setDateOfBirth(dateOfBirth);
        user.setContactNumber(contactNumber);
        user.setOrganization(organization);
        
        HttpSession session = request.getSession();
        user.setEmail((String)session.getAttribute("email"));
        
        UserDAO userOperation = new UserDAO();
        
        PrintWriter out = response.getWriter();
        
        if(userOperation.updateUserDetails(user))
        {
            out.println("<script>alert(\"User updated successfully!\")</script>");
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("LoginServlet");

            requestdispatch.include(request, response);
        }
        else
        {
            out.println("<script>alert(\"User not updated!\")</script>");
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("LoginServlet");

            requestdispatch.include(request, response);
        }
	}

}

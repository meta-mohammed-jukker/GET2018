package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee;
import com.dao.RunQueries;

/**
 * Servlet implementation class AddDetailServlet
 */
public class AddDetailServlet extends HttpServlet 
{
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String email = request.getParameter("email");
	    int age = Integer.parseInt(request.getParameter("age"));
	    
	    Employee employee = new Employee(firstName, lastName, email, age);
        RunQueries runQueries = new RunQueries();
        boolean isEmployeeDetailsAdded = runQueries.addDetails(employee);
        
        PrintWriter out = response.getWriter();
        
        if(isEmployeeDetailsAdded)
        {
            out.println("<script>alert(\"successful!\")</script>");
        }
        else
        {
            out.println("<script>alert(\"not successful!\")</script>");
        }

        RequestDispatcher requestdispatch = request
                .getRequestDispatcher("addDetail.html");

        requestdispatch.include(request, response);
	}
	
	
}

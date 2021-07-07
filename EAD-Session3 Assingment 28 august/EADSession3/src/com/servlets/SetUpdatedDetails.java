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
 * Servlet implementation class SetUpdatedDetails
 */
public class SetUpdatedDetails extends HttpServlet 
{
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    int employeeID = Integer.parseInt(request.getParameter("employeeID"));
	    String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        
        Employee employee = new Employee(employeeID, firstName, lastName, email, age);
        RunQueries runQueries = new RunQueries();
        boolean isEmployeeDetailsUpdated = runQueries.updateEmployeeDetails(employee);
        
        PrintWriter out = response.getWriter();
        
        if(isEmployeeDetailsUpdated)
        {
            out.println("<script>alert(\"successful!\")</script>");
        }
        else
        {
            out.println("<script>alert(\"not successful!\")</script>");
        }

        RequestDispatcher requestdispatch = request
                .getRequestDispatcher("index.html");

        requestdispatch.include(request, response);
	}

}

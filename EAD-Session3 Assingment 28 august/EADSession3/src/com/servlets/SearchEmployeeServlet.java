package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee;
import com.dao.RunQueries;

/**
 * Servlet implementation class SearchEmployeeServlet
 */
public class SearchEmployeeServlet extends HttpServlet 
{

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    RunQueries runQueries = new RunQueries();
	    String name = request.getParameter("name");
	    
	    List<Employee> employeeList = runQueries.searchEmployee(name);
	    /*
	    for(Employee e: employeeList)
	    {
	        System.out.println(e.getId());
	    }
	    */
	    
	    PrintWriter out = response.getWriter();
	    
	    if(employeeList.size() == 0)
	    {
	        out.println("<script>alert(\"No such employee found!\")</script>");
	        RequestDispatcher requestdispatch = request
	                .getRequestDispatcher("searchEmployee.html");

	        requestdispatch.include(request, response);
	        return;
	    }
	    
	    out.print("<h1 align='center'>Searched Employee Details</h1><br>");
	    out.print("<table align='center' cellpadding=10 cellspacing=5>");
	    
	        out.print("<tr>");
	            out.print("<th>Employee ID</th>");
	            out.print("<th>First Name</th>");
	            out.print("<th>Last Name</th>");
	            out.print("<th>Email ID</th>");
	            out.print("<th>Age</th>");
	        out.print("</tr>");
	        
	        for(Employee employee: employeeList)
	        {
	            out.print("<tr>");
                    out.print("<td>" + employee.getId() + "</td>");
                    out.print("<td>" + employee.getFirstName() + "</td>");
                    out.print("<td>" + employee.getLastName() + "</td>");
                    out.print("<td>" + employee.getEmail() + "</td>");
                    out.print("<td>" + employee.getAge() + "</td>");
                out.print("</tr>");
	        }
	    
	    out.print("<table>");
	}

}

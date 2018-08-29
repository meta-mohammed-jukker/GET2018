package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee;
import com.dao.RunQueries;

/**
 * Servlet implementation class ShowAllEmployeeDetails
 */
public class ShowAllEmployeeDetails extends HttpServlet 
{
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    RunQueries runQueries = new RunQueries();
	    
	    List<Employee> employeeList = runQueries.showAllEmployeeDetails();
	    /*
        for(Employee e: employeeList)
        {
            System.out.println(e.getId());
        }
        */
	    PrintWriter out = response.getWriter();
        
        out.print("<h1 align='center'>All Employee Details</h1><br>");
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
                    out.print("<td>");
                        out.print("<form name=\"editEmployeeForm\" method=\"post\" action=\"UpdateEmployeeServlet\" >");
                            out.print("<input type=\"hidden\" id=\"employeeID\" " + 
                                    "name=\"employeeID\" value=\"" + employee.getId() + "\" >");
                            out.print("<input type=\"submit\" id=\"editEmployee\" " + 
                                    "name=\"editEmployee\" value=\"edit\" >");
                        out.print("</form>");
                    out.print("</td>");
                out.print("</tr>");
            }
        
        out.print("<table>");
	}

}

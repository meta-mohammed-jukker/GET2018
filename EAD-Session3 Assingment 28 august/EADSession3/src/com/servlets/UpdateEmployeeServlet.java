package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee;
import com.dao.RunQueries;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet 
{
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    int employeeID = Integer.parseInt(request.getParameter("employeeID"));
	    RunQueries runQueries = new RunQueries();
	    Employee currentEmployee = runQueries.getEmployeeByID(employeeID);
	    
	    PrintWriter out = response.getWriter();
	    
	    out.print("<h1 align='center'>Update Employee Details<h1><br>");
        
	    out.print("<div align=\"center\">");
	        out.print("<form method=\"post\" action='SetUpdatedDetails'>");
	            out.print("<table>");
	                out.print("<tr>");
	                    out.print("<td>");
	                        out.print("<input type=\"hidden\" name=\"employeeID\" value=\"" + employeeID + "\" />");
	                    out.print("</td>");
	                out.print("</tr>");
	            
	                out.print("<tr>");
	                    out.print("<td>");
	                        out.print("First Name:");
	                    out.print("</td>");
	                    out.print("<td>");
	                        out.print("<input type=\"text\" name=\"firstName\" value=\"" + currentEmployee.getFirstName() + "\" />");
	                    out.print("</td>");
	                out.print("</tr>");
                
                    out.print("<tr>");
                        out.print("<td>");
                            out.print("Last Name:");
                        out.print("</td>");
                        out.print("<td>");
                            out.print("<input type=\"text\" name=\"lastName\" value=\"" + currentEmployee.getLastName() + "\" />");
                        out.print("</td>");
                    out.print("</tr>");
	                
	                out.print("<tr>");
                        out.print("<td>");
                            out.print("Email:");
                        out.print("</td>");
                        out.print("<td>");
                            out.print("<input type=\"text\" name=\"email\" value=\"" + currentEmployee.getEmail() + "\" />");
                        out.print("</td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                        out.print("<td>");
                            out.print("Age:");
                        out.print("</td>");
                        out.print("<td>");
                            out.print("<input type=\"text\" name=\"age\" value=\"" + currentEmployee.getAge() + "\" />");
                        out.print("</td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                        out.print("<td>");
                            out.print("<input type=\"submit\" value=\"submit\">");
                        out.print("</td>");
                    out.print("</tr>");
                out.print("</table>");
	        out.print("</form>");
	    out.print("</div>");

	}

}

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.UserPOJO;

/**
 * Servlet implementation class UpdateDetailsServlet
 */
public class UpdateDetailsServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    HttpSession session=request.getSession();
	    
	    String email = (String) session.getAttribute("email");
	    
	    UserDAO userOperation = new UserDAO();
	    UserPOJO user = userOperation.getUserDetails(email);
	    
	    PrintWriter out = response.getWriter();
	    
	    out.print("<table width='75%' align='center'>");
            out.print("<tr>");
                out.print("<td>");
                    out.print("<img src='images/html5Logo.png' alt='HTML 5 image' height='50px'/>");
                out.print("</td>");
                out.print("<td align='right'>");
                    out.print(user.getFirstName() + " " + user.getLastName() + "  ");
                    out.print("<a href='LogoutServlet'>Logout</a>");
                    out.print("  <a href='#'> <img src='" + user.getImageURL() + "' alt='user icon' height='50px'/> </a>");
                out.print("</td>");
            out.print("</tr>");
        out.print("</table>");
    
        out.print("<hr/>");
        
	    out.print("<div align=\"center\">");
        out.print("<form method=\"post\" action='SetDetails'>");
            out.print("<table>");
            
                out.print("<tr>");
                    out.print("<td>");
                        out.print("First Name:");
                    out.print("</td>");
                    out.print("<td>");
                        out.print("<input type=\"text\" name=\"firstName\" value=\"" + user.getFirstName() + "\" />");
                    out.print("</td>");
                out.print("</tr>");
            
                out.print("<tr>");
                    out.print("<td>");
                        out.print("Last Name:");
                    out.print("</td>");
                    out.print("<td>");
                        out.print("<input type=\"text\" name=\"lastName\" value=\"" + user.getLastName() + "\" />");
                    out.print("</td>");
                out.print("</tr>");
                
                out.print("<tr>");
                    out.print("<td>");
                        out.print("Age:");
                    out.print("</td>");
                    out.print("<td>");
                        out.print("<input type=\"number\" name=\"age\" value=\"" + user.getAge() + "\" />");
                    out.print("</td>");
                out.print("</tr>");
                
                out.print("<tr>");
                    out.print("<td>");
                        out.print("Date Of Birth:");
                    out.print("</td>");
                    out.print("<td>");
                        out.print("<input type=\"date\" name=\"dateOfBirth\" value=\"" + user.getDateOfBirth() + "\" />");
                    out.print("</td>");
                out.print("</tr>");
                
                out.print("<tr>");
                    out.print("<td>");
                        out.print("Contact Number:");
                    out.print("</td>");
                    out.print("<td>");
                        out.print("<input type=\"number\" name=\"contactNumber\" value=\"" + user.getContactNumber() + "\" />");
                    out.print("</td>");
                out.print("</tr>");
                
                out.print("<tr>");
                    out.print("<td>");
                        out.print("Organization:");
                    out.print("</td>");
                    out.print("<td>");
                        out.print("<select name='organization'>");
                        out.print("<option>Metacube</option>");
                        out.print("<option>TCS</option>");
                        out.print("<option>Infosys</option>");
                        out.print("<option>Cognizant</option>");
                        out.print("<option>Apple</option>");
                    out.print("</td>");
                out.print("</tr>");
                
                out.print("<tr>");
                    out.print("<td>");
                        out.print("<input type=\"submit\" value=\"submit\">");
                    out.print("</td>");
                    out.print("<td>");
                        out.print("<input type=\"reset\" value=\"reset\">");
                    out.print("</td>");
                out.print("</tr>");
            out.print("</table>");
        out.print("</form>");
    out.print("</div>");
	    
	}

}

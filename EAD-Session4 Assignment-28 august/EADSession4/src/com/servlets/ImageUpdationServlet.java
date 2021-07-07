package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;
import com.model.UserPOJO;

/**
 * Servlet implementation class ImageUpdationServlet
 */
public class ImageUpdationServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException 
	{
	    HttpSession session=request.getSession();
        
        String email = (String) session.getAttribute("email");
        
        UserFacade userFacade = new UserFacade();
        UserPOJO user = userFacade.getDetails(email);
        
        PrintWriter out = response.getWriter();
        
        out.print("<table width='75%' align='center'>");
        out.print("<tr>");
            out.print("<td>");
                out.print("<img src='images/html5Logo.png' alt='HTML 5 image' height='50px'/>");
            out.print("</td>");
            out.print("<td align='right'>");
                out.print("<a href='LoginServlet'>" + user.getFirstName() + " " + user.getLastName() + "</a>  ");
                out.print("<a href='FriendsServlet'>Friends </a>");
                out.print("<a href='LogoutServlet'>Logout </a>");
                out.print("  <a href='ImageUpdationServlet'> <img src='" + user.getImageURL() + "' alt='user icon' height='50px'/> </a>");
            out.print("</td>");
        out.print("</tr>");
        out.print("</table>");
    
        out.print("<hr/>");
        
        out.print("<div align='center'>");
            out.print("<form action='SetImageServlet'>");
                out.print("<img src='" + user.getImageURL() + "' height='150px'/><br/>");
                out.print("<input type='file' name='upload'/><br/><br/>");
                out.print("<input type='submit' value='Upload image'/>");
            out.print("</form>");
        out.print("</div>");
        
         
	}
}

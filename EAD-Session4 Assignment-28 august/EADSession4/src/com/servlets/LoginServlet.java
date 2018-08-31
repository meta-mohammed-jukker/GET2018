package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserPOJO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet
{	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    /*
	    String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserPOJO user = new UserPOJO();
        
        user.setEmail(email);
        user.setPassword(password);
        
        System.out.println(email + password);
        */
	    String email = request.getParameter("email");
	    
	    HttpSession session=request.getSession();  
        session.setAttribute("name",email);
        
        PrintWriter out = response.getWriter();
        
        out.print("<table width='75%' align='center'>");
            out.print("<tr>");
                out.print("<td>");
                    out.print("<img src='" + "images/html5Logo.png" + "' alt='HTML 5 image' width='50px'/></td>");
                out.print("</td>");
                out.print("<td align='right'>");
                out.print("</td>");
            out.print("</tr>");
        out.print("</table>");
        out.print("<hr/>");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        out.print("");
        
	}

}

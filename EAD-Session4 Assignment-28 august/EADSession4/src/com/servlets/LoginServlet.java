package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.facade.UserFacade;
import com.facade.Validation;
import com.model.UserPOJO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet
{
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        HttpSession session=request.getSession();
        
        showUserDetails(request, response, session);
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
	    HttpSession session=request.getSession();
	    
	    String email = (String) session.getAttribute("email");
        String password = request.getParameter("password");
        Validation validate = new Validation();
        
        if(email != null && password != null && (!(validate.isEmailAlreadyPresent(email)) || !(validate.isPasswordMatched(email, password))))
        {
            PrintWriter out = response.getWriter();
            if(!(validate.isEmailAlreadyPresent(email)))
            {
                out.println("<script>alert(\"Email not registered!\")</script>");
            }
            if(!(validate.isPasswordMatched(email, password)))
            {
                out.println("<script>alert(\"Incorrect Password!\")</script>");
            }
            
            session.invalidate();
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("login.html");

            requestdispatch.include(request, response);
        }
	    else
	    {
	        showUserDetails(request, response, session);
	    }
	}
	
	public void showUserDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
            throws ServletException, IOException
	{
	    PrintWriter out = response.getWriter();
        UserFacade userFacade = new UserFacade();
        System.out.println("ffcdsfcdfc" + (String) session.getAttribute("email"));
        UserPOJO user = userFacade.getDetails((String) session.getAttribute("email"));
        
        out.print("<table width='75%' align='center'>");
            out.print("<tr>");
                out.print("<td>");
                    out.print("<img src='images/html5Logo.png' alt='HTML 5 image' height='50px'/>");
                out.print("</td>");
                out.print("<td align='right'>");
                    out.print("<a href='LoginServlet'>" + user.getFirstName() + " " + user.getLastName() + "</a>  ");
                    out.print("<a href='FriendsServlet'>Friends</a>");
                    out.print("<a href='LogoutServlet'>Logout</a>");
                    out.print("  <a href='ImageUpdationServlet'> <img src='" + user.getImageURL() + "' alt='user icon' height='50px'/> </a>");
                out.print("</td>");
            out.print("</tr>");
        out.print("</table>");
        
        out.print("<hr/>");
        
        out.print("<table align='center' cellpadding=10 cellspacing=5 >");
            out.print("<tr>");
                out.print("<td align='right'>");
                    out.print("First Name: ");
                out.print("</td>");
                out.print("<td>");
                    out.print(user.getFirstName());
                out.print("</td>");
            out.print("</tr>");
            
            out.print("<tr>");
                out.print("<td align='right'>");
                    out.print("Last Name: ");
                out.print("</td>");
                out.print("<td>");
                    out.print(user.getLastName());
                out.print("</td>");
            out.print("</tr>");
            
            out.print("<tr>");
                out.print("<td align='right'>");
                    out.print("Age: ");
                out.print("</td>");
                out.print("<td>");
                    out.print(user.getAge());
                out.print("</td>");
            out.print("</tr>");
            
            out.print("<tr>");
                out.print("<td align='right'>");
                    out.print("Date of Birth: ");
                out.print("</td>");
                out.print("<td>");
                    out.print(user.getDateOfBirth());
                out.print("</td>");
            out.print("</tr>");
            
            out.print("<tr>");
                out.print("<td align='right'>");
                    out.print("ContactNumber: ");
                out.print("</td>");
                out.print("<td>");
                    out.print(user.getContactNumber());
                out.print("</td>");
            out.print("</tr>");
            
            out.print("<tr>");
                out.print("<td align='right'>");
                    out.print("Organization: ");
                out.print("</td>");
                out.print("<td>");
                    out.print(user.getOrganization());
                out.print("</td>");
            out.print("</tr>");
            
        out.print("</table>");
        out.print("<form align='center' action='UpdateDetailsServlet'>");
            out.print("<input type='submit' value='Update Details'>");
        out.print("<form>");
	}

}

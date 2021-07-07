package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;
import com.model.UserPOJO;

/**
 * Servlet implementation class SetImageServlet
 */
public class SetImageServlet extends HttpServlet 
{

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException 
	{
		String imageName = request.getParameter("upload");
		
		HttpSession session = request.getSession();
		UserPOJO user = new UserPOJO();
		
        user.setEmail((String)session.getAttribute("email"));
        user.setImageURL(imageName);
        
        UserFacade userFacade = new UserFacade();
        userFacade.changeImage(user);
        
        RequestDispatcher requestdispatch = request
                .getRequestDispatcher("LoginServlet");

        requestdispatch.include(request, response);
	}
}

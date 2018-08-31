package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.facade.Validation;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter 
{
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException 
	{
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    Validation validate = new Validation();
        
        if(!(validate.isEmailAlreadyPresent(email)))
        {
            PrintWriter out = response.getWriter();
            out.println("<script>alert(\"Email not registered!\")</script>");
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("login.html");

            requestdispatch.include(request, response);
        }
        if(!(validate.isPasswordMatched(email, password)))
        {
            PrintWriter out = response.getWriter();
            out.println("<script>alert(\"Incorrect Password!\")</script>");
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("login.html");
        }
        else
        {
            chain.doFilter(request, response);
        }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

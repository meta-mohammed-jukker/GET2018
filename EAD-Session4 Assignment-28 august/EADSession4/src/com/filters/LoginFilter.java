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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	    String email = request.getParameter("email").trim();
	    String password = request.getParameter("password");
        
        if(email.length() == 0 || password.length() == 0)
        {
            PrintWriter out = response.getWriter();
            if(email.length() == 0)
            {
                out.println("<script>alert(\"Email not entered!\")</script>");
            }
            if(password.length() == 0)
            {
                out.println("<script>alert(\"Password not entered!\")</script>");
            }
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("login.html");

            requestdispatch.include(request, response);
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

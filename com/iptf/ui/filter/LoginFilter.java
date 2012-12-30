package com.iptf.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.iptf.db.UserDAO;
import com.iptf.db.model.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	
	static Logger logger = Logger.getLogger(LoginFilter.class);

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("USER");
		String message = "Please login with your email/password";
		//logger.error("start Filter");
		if(user == null )
		{
			if(req.getRequestURI().endsWith("/login.jsp")){
		
					String submitted = req.getParameter("submitted");
					String email = null;
					String password = null;
		
					if (submitted != null && submitted.equals("true"))
					{
						email = request.getParameter("email");
						password = request.getParameter("password");
						
						logger.info("Authenticating user: " + email + " and password " + password);
						
											
						try{
							UserDAO udao = new UserDAO();
							user = udao.validateUser(email,password);
						}
						catch(Exception e)
						{
							e.printStackTrace();
							logger.error("Caught Exception while logging in: ", e);
							message =  "Error:: " + e.getMessage();
						}
						
						if(user != null)
						{
							logger.info("Authenticated user: " + user.getEmail());
							session.setAttribute("USER",user);
							res.sendRedirect("index.jsp");
						}
						else
						{
							logger.error("Can't find user: " + email + " and password " + password);
							message = "Invalid ID/Password";
						}
					}
	
				}
				else
					{
						res.sendRedirect("login.jsp");
					}
			
			request.setAttribute("message", message);
		}
			
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
		
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

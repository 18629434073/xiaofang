package com.ht.filter;

import com.ht.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
	final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

	private String excludedRegex;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession(true);

		Object object = session.getAttribute(Constants.SESSION_USER);
		if (request.getServletPath().matches(excludedRegex) || null != object) {
			arg2.doFilter(arg0, arg1); 
			
		} else {
			response.sendRedirect(request.getContextPath()+"");
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		excludedRegex = arg0.getInitParameter("excludedRegex");

	}

}

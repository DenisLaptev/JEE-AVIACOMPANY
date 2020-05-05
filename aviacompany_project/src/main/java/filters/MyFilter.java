package main.java.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.model.User;




public class MyFilter implements Filter {
	
	private ServletContext context;

    
    public MyFilter() {
    	
    	System.out.println("filter constructor");
    	
    }

    public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		System.out.println("filter init");
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("filter doFilter");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		User registeredUser = null;
		
		if (session.getAttribute("registeredUser") != null) {
			registeredUser = (User) session.getAttribute("registeredUser");
		}
		
		if(registeredUser.getRole().equals("admin")){
			System.out.println("You can go to admin page!!!!!!!!!!!!");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/adminPage.jsp");
			requestDispatcher.forward(request, response);
		}else {
			res.sendRedirect("views/myAccount.jsp");
		}
		

		chain.doFilter(request, response);
		
		
	
	}

	
	public void destroy() {
		
		System.out.println("filter destroy");
		
	}

}

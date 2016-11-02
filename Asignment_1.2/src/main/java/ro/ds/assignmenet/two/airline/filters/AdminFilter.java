package ro.ds.assignmenet.two.airline.filters;

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

public class AdminFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Admin Filter.");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		
		HttpSession session = httpRequest.getSession();
		
		
		boolean isUserAdmin = session != null
                && (session.getAttribute("admin") == Boolean.TRUE);
		
		if(isUserAdmin){
				chain.doFilter(request, response);	
		}
		else{
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/not-allowed.html");
			return;
			//request.getRequestDispatcher("notAllowed.html").forward(httpRequest, httpResponse);
		}
	}
		
		/*boolean isUserAdmin = session != null
                && (session.getAttribute("admin") == Boolean.TRUE);
		
		if(isUserAdmin){
			System.out.println("Intra aici");
				chain.doFilter(request, response);	
		}
		else{
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/not-allowed.html");
			return;
			//request.getRequestDispatcher("notAllowed.html").forward(httpRequest, httpResponse);
		}*/
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

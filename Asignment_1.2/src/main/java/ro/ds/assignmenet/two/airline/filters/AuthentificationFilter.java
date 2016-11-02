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

public class AuthentificationFilter implements Filter {

	private HttpServletRequest httpRequest;
	private HttpServletResponse httpResponse;
	private HttpSession session;
	private String url;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("\n\nAuthentication Filter.");
		httpRequest = (HttpServletRequest) request;
		httpResponse = (HttpServletResponse) response;
		session = httpRequest.getSession();
		url = httpRequest.getRequestURI();

		boolean isUserLoggedIn = session != null && session.getAttribute("username") != null;
		boolean isLoginPage = url.indexOf("/login.html") >= 0;
		boolean isLoginServlet = url.indexOf("/login") >= 0;
		boolean isNotAllowedPage = url.indexOf("/not-allowed.html") >= 0;
		boolean isResource = url.startsWith("/airline/resources/");

		if (isUserLoggedIn || isLoginPage || isNotAllowedPage || isLoginServlet  || isResource ) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
			return;
		}
		
		
		
		
	//	System.out.println(isLoggedIn() + "-" + isPage("login.html") +"-"+ isPage("login"));
		
		/*if (isLoggedIn() || isPage("login.html") || isPage("logout") || isPage("login") || isPage("airline/resources/")) {
			System.out.println("Hello chain");
			chain.doFilter(request, response);
		} else {
			System.out.println("Redirect");
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
			return;
		}*/
	/*	System.out.println("Session1:"+session.getAttribute("username"));
		if(session == null || session.getAttribute("username")==null || url.endsWith("login") || url.endsWith("css")
			|| url.endsWith("logout")	){
			System.out.println("Session2:"+session);
			httpResponse.sendRedirect("login");
		}else{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}*/

	}

	private boolean isLoggedIn() {
		if (null != session && null != session.getAttribute("username")) {
			return true;
		}
		return false;
	}

	private boolean isPage(String name) {
		if (url.indexOf("/" + name) >= 0) {
			return true;
		}
		return false;
	}
}

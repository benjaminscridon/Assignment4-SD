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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		httpRequest = (HttpServletRequest) request;
		httpResponse = (HttpServletResponse) response;
		session = httpRequest.getSession();
		url = httpRequest.getRequestURI();

		boolean isUserLoggedIn = session != null && session.getAttribute("username") != null;
		boolean isLoginPage = url.indexOf("/login.html") >= 0;
		boolean isLoginServlet = url.indexOf("/login") >= 0;
		boolean isNotAllowedPage = url.indexOf("/not-allowed.html") >= 0;
		boolean isResource = url.startsWith("/airline/resources/");
		boolean isGeneralErrorPage = url.indexOf("/general-error.html") >=0;

		if (isUserLoggedIn || isLoginPage || isNotAllowedPage || isLoginServlet || isResource || isGeneralErrorPage) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
			return;
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}

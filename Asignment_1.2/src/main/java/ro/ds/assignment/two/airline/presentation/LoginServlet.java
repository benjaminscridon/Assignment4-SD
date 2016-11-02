package ro.ds.assignment.two.airline.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ro.ds.assignment.two.airline.businesslogic.AccountService;
import ro.ds.assignment.two.airline.domain.Account;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AccountService accountService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("LoginServlet> -Session" + session);
		/*
		 * if(session!=null ){ System.out.println("nothing to tdo ");
		 * response.sendRedirect("login.html");
		 * 
		 * }else{ response.sendRedirect("login.html"); }
		 */
		response.sendRedirect("login.html");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String role = getAccountService().isValidAccount(new Account(username, password));
		System.out.println("LoginServlet> role:" + role);
		if (null != role) {

			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);

			if (role.equals("admin")) {
				response.sendRedirect("admin/home");
				session.setAttribute("admin", Boolean.TRUE);

			}
			else{
				response.sendRedirect("user");
			}
		} else {
			response.sendRedirect("login.html");
		}
	}

	private AccountService getAccountService() {
		if (null == accountService) {
			accountService = new AccountService();
		}
		return accountService;
	}
}
package ro.ds.assignment.two.airline.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import ro.ds.assignment.two.airline.businesslogic.AccountService;
import ro.ds.assignment.two.airline.domain.Account;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AccountService accountService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String role = null;
		try {
			role = getAccountService().isValidAccount(new Account(username, password));
		} catch (ServiceException e) {
			response.sendRedirect("general-error.html");
		}
		
		if (null != role) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);

			if (role.equals("admin")) {
				response.sendRedirect("admin/home");
				session.setAttribute("admin", Boolean.TRUE);

			} else {
				response.sendRedirect("user");
			}
		} else {
			response.sendRedirect("general-error.html");
		}
	}

	private AccountService getAccountService() {
		if (null == accountService) {
			accountService = new AccountService();
		}
		return accountService;
	}
}
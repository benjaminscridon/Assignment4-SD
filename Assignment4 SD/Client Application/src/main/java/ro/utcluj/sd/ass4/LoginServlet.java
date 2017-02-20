package ro.utcluj.sd.ass4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ro.utcluj.sd.ass4.net.service.login.LoginServiceSoapProxy;
import ro.utcluj.sd.ass4.net.service.login.UserModel;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginServiceSoapProxy loginService = new LoginServiceSoapProxy();

		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		UserModel u = null;
		try {
			u = loginService.getUser(email, pass);
			if (u != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);

				if (u.getUserType() == 1) {
					response.sendRedirect("admin/home");
					//response.sendRedirect("user");
					session.setAttribute("admin", Boolean.TRUE);
				} else
					response.sendRedirect("user");
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			doGet(request, response);
		}

	}

}
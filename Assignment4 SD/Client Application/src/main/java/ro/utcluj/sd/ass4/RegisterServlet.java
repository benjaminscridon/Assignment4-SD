package ro.utcluj.sd.ass4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.utcluj.sd.ass4.net.service.login.LoginServiceSoapProxy;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginServiceSoapProxy loginService = new LoginServiceSoapProxy();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		
		if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()){
			request.setAttribute("isErrorMessage", true);
			request.setAttribute("errorMessage", "All fields must be filed");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		if(!password.equals(password2)){
			request.setAttribute("isErrorMessage", true);
			request.setAttribute("errorMessage", "Passwords don't match!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		try {
			loginService.addUser(firstName, lastName, password2, email, 0);
		} catch (Exception e) {
			request.setAttribute("isErrorMessage", true);
			request.setAttribute("errorMessage", "There were errors during register, Try again!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		request.setAttribute("isSuccessMessage", true);
		request.setAttribute("successMessage", "Register succesfulls!");
		request.getRequestDispatcher("register.jsp").forward(request, response);
		return;
	}
	

}

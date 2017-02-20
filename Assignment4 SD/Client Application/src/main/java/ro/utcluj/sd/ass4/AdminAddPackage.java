package ro.utcluj.sd.ass4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.utcluj.sd.ass4.java.PackageDTO;
import ro.utcluj.sd.ass4.java.PackageServiceBeanProxy;
import ro.utcluj.sd.ass4.java.UserDTO;

/**
 * Servlet implementation class AdminAddPackage
 */
@WebServlet("/admin/addPackage")
public class AdminAddPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("addPackage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName1 = request.getParameter("firstName1");
		String lastName1 = request.getParameter("lastName1");
		String email1 = request.getParameter("email1");
		
		String firstName2 = request.getParameter("firstName2");
		String lastName2 = request.getParameter("lastName2");
		String email2 = request.getParameter("email2");
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String senderCity = request.getParameter("senderCity");
		String destinationCity = request.getParameter("destinationCity");
		
		
		
		if(email2.isEmpty() || email1.isEmpty() || name.isEmpty() || description.isEmpty() || senderCity.isEmpty()|| destinationCity.isEmpty()){
			request.setAttribute("isErrorMessage", true);
			request.setAttribute("errorMessage", "All fields marked with * must be filed");
			request.getRequestDispatcher("addPackage.jsp").forward(request, response);
			return;
		}
		
		UserDTO sender = new UserDTO();
		sender.setEmail(email1);
		sender.setFirstName(firstName1);
		sender.setLastName(lastName1);
		sender.setPassword("123456");
		
		UserDTO receiver = new UserDTO();
		receiver.setEmail(email2);
		receiver.setFirstName(firstName2);
		receiver.setLastName(lastName2);
		receiver.setPassword("123456");

		PackageDTO pack = new PackageDTO();
		pack.setDescription(description);
		pack.setDestinationCity(destinationCity);
		pack.setName(name);
		pack.setReceiver(receiver);
		pack.setTacking(false);
		pack.setSenderCity(senderCity);
		pack.setSender(sender);
		
		PackageServiceBeanProxy packageServiceBean = new PackageServiceBeanProxy();
		
		try {
			packageServiceBean.addPackage(pack);
		} catch (Exception e) {
			request.setAttribute("isErrorMessage", true);
			request.setAttribute("errorMessage", "There were errors during adding package, Try again!");
			request.getRequestDispatcher("addPackage.jsp").forward(request, response);
			return;
		}
		request.setAttribute("isSuccessMessage", true);
		request.setAttribute("successMessage", "The package was succesfully added!");
		request.getRequestDispatcher("addPackage.jsp").forward(request, response);
		return;
	}
}

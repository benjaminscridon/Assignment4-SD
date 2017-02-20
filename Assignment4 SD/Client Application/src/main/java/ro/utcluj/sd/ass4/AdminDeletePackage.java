package ro.utcluj.sd.ass4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.utcluj.sd.ass4.java.PackageDTO;
import ro.utcluj.sd.ass4.java.PackageServiceBeanProxy;

/**
 * Servlet implementation class AdminDeletePackage
 */
@WebServlet("/admin/deletePackage")
public class AdminDeletePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		long id = Long.parseLong(idString);
		
		PackageServiceBeanProxy packageServiceBeanProxy = new PackageServiceBeanProxy();
		PackageDTO p = new PackageDTO();
		p.setId(id);
		try {
			packageServiceBeanProxy.deletePackage(p);
		} catch (Exception e) {
			request.setAttribute("isErrorMessage", true);
			request.setAttribute("errorMessage", "There were errors during deleting the package, Try again!");
			request.getRequestDispatcher("packageServlet?id="+id).forward(request, response);
			return;
		}
		request.setAttribute("isSuccessMessage", true);
		request.setAttribute("successMessage", "The package was succesfully deleted!");
		response.sendRedirect("home");
		return;
	}
}

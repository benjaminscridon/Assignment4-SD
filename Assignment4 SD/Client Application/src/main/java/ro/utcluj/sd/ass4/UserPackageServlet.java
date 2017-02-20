package ro.utcluj.sd.ass4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.utcluj.sd.ass4.net.service.client.ClientServiceSoapProxy;
import ro.utcluj.sd.ass4.net.service.client.PackageModel;

/**
 * Servlet implementation class UserPackageServlet
 */
@WebServlet("/userPackageServlet")
public class UserPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchText = request.getParameter("id");
		long id = Long.parseLong(searchText);

		String email = (String) request.getSession().getAttribute("email");

		ClientServiceSoapProxy clientService = new ClientServiceSoapProxy();

		PackageModel[] packages = null;
		try {
			packages = clientService.getAllPackagesByUserEmailAndId(email, id, searchText);
		} catch (Exception e2) {

		}
		PackageModel p = null;
		if(packages!=null && packages.length > 0){
			p = packages[0];
		}
		
		List<String> routee = new ArrayList<String>();
		for(int i= 0;i<p.getRoute().length;i++){
			routee.add(p.getRoute()[i].getCity() + ": "+ p.getRoute()[i].getDate().getTime().toString());
		}
		
		request.setAttribute("packagee", p);
		request.setAttribute("routee", routee);

		request.getRequestDispatcher("userPackage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

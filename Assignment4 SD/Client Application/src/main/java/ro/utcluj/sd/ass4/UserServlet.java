package ro.utcluj.sd.ass4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ro.utcluj.sd.ass4.net.service.client.ClientServiceSoapProxy;
import ro.utcluj.sd.ass4.net.service.client.PackageModel;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchText = request.getParameter("idOrName");
		
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		
		ClientServiceSoapProxy clientService = new ClientServiceSoapProxy();
		
		List<PackageModel> sPkgs = new ArrayList<>();
		List<PackageModel> rPkgs = new ArrayList<>();
		
		PackageModel[] packages = null;
		if (searchText == null) {
			try {
				packages = clientService.getAllPackagesByUserEmail(email);
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		else {
			request.setAttribute("searchText", searchText);
			request.setAttribute("search", true);
			try {
				packages = clientService.getAllPackagesByUserEmailAndId(email, Long.parseLong(searchText), searchText);
			} catch (NumberFormatException e) {
				try {
					packages = clientService.getAllPackagesByUserEmailAndId(email,0 , searchText);
				} catch (Exception e2) {
					
				}
			}
		}
		
		for (int i = 0; i < packages.length; i++) {
			if (packages[i].getSender().getEmail().equals(email))
				sPkgs.add(packages[i]);
			if (packages[i].getReceiver().getEmail().equals(email))
				rPkgs.add(packages[i]);
		}
		request.setAttribute("sentPackages", sPkgs);
		request.setAttribute("receivedPackages", rPkgs);
		
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

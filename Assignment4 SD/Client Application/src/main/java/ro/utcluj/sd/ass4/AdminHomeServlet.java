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

import ro.utcluj.sd.ass4.java.PackageDTO;
import ro.utcluj.sd.ass4.java.PackageServiceBeanProxy;
import ro.utcluj.sd.ass4.net.service.client.PackageModel;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/admin/home")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchText = request.getParameter("idOrName");

		PackageServiceBeanProxy packageService = new PackageServiceBeanProxy();

		PackageDTO[] packages = null;

		if (searchText == null) {
			try {
				packages = packageService.getAllPackages();
			} catch (Exception e) {
				System.out.println("error");
			}
		} else {
			request.setAttribute("searchText", searchText);
			request.setAttribute("search", true);
			try {
				packages = packageService.getPackagesByNameOrId(searchText, Long.parseLong(searchText));
			} catch (NumberFormatException e) {
				try {
					packages = packageService.getPackagesByNameOrId(searchText, 0);
				} catch (Exception e2) {

				}
			}
		}
		List<PackageDTO> sPkgs = new ArrayList<>();
		if (null != packages) {
			for (int i = 0; i < packages.length; i++) {
				sPkgs.add(packages[i]);
			}
		}
		request.setAttribute("packs", sPkgs);

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

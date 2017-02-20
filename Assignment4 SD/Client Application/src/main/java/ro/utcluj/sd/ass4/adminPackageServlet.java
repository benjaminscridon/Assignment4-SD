package ro.utcluj.sd.ass4;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.utcluj.sd.ass4.java.PackageDTO;
import ro.utcluj.sd.ass4.java.PackageServiceBeanProxy;
import ro.utcluj.sd.ass4.java.RouteItem;

/**
 * Servlet implementation class adminPackageServlet
 */
@WebServlet("/admin/packageServlet")
public class adminPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchText = request.getParameter("id");
		long id = Long.parseLong(searchText);

		PackageServiceBeanProxy packageService = new PackageServiceBeanProxy();

		PackageDTO[] packages = null;
		try {
			packages = packageService.getPackagesByNameOrId(searchText, id);
		} catch (Exception e2) {

		}
		PackageDTO p = null;
		if (packages != null && packages.length > 0) {
			p = packages[0];
		}

		List<String> routee = new ArrayList<String>();
		for (int i = 0; i < p.getRoute().length; i++) {
			routee.add(p.getRoute()[i].getCity() + ": " + p.getRoute()[i].getDate().getTime().toString());
		}

		request.setAttribute("packagee", p);
		request.setAttribute("routee", routee);

		request.getRequestDispatcher("package.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PackageServiceBeanProxy packageService = new PackageServiceBeanProxy();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date = null;
		long id = 0;
		RouteItem routeItem = new RouteItem();
		String city = request.getParameter("city");
		try {
			String datee = request.getParameter("date");
			date = format.parse(datee);
			id = Long.parseLong(request.getParameter("packageId"));

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			routeItem.setCity(city);
			routeItem.setDate(cal);

			packageService.addRouteItemToPackage(routeItem, id);

		} catch (Exception e) {
			request.setAttribute("isErrorMessage", true);
			request.setAttribute("errorMessage", "There were errors during adding route item, Try again!");
			request.getRequestDispatcher("packageServlet?id=" + id).forward(request, response);
			return;
		}

		response.sendRedirect("packageServlet?id=" + id);
		return;
	}

}

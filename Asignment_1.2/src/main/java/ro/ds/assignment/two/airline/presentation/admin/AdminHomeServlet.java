package ro.ds.assignment.two.airline.presentation.admin;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ro.ds.assignment.two.airline.businesslogic.FlightService;
import ro.ds.assignment.two.airline.domain.Flight;
import ro.ds.assignment.two.airline.exceptions.ServiceException;

public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightService flightService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("flights", getFlightService().getAllFlights());
			request.setAttribute("dateFormat", new SimpleDateFormat("MMMM dd, YYYY"));
			request.setAttribute("timeFormat", new SimpleDateFormat("hh:mm a"));
			request.setAttribute("error", request.getParameter("error"));
			request.setAttribute("success", request.getParameter("success"));
		} catch (ServiceException exc) {
			response.sendRedirect(request.getContextPath() + "/not-allowed.html");
			return;
		}

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Flight flight = new Flight();
			flight.setId(Integer.parseInt(request.getParameter("flightId")));
			getFlightService().deleteFlight(flight);

			response.sendRedirect("home?success=" + URLEncoder.encode("Flight was successfully deleted.", "UTF-8"));
		} catch (ServiceException exc) {
			response.sendRedirect("home?error=" + URLEncoder.encode("There was a problem to delete selected flight.", "UTF-8"));
		}
	}

	private FlightService getFlightService() {
		if (null == flightService) {
			flightService = new FlightService();
		}
		return flightService;
	}

}

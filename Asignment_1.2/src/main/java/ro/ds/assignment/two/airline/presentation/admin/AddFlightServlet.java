package ro.ds.assignment.two.airline.presentation.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ro.ds.assignment.two.airline.businesslogic.CityService;
import ro.ds.assignment.two.airline.exceptions.ServiceException;

public class AddFlightServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CityService cityService;

	public AddFlightServlet() {
		super();
		cityService = new CityService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("cities", cityService.getAllCities());

			request.getRequestDispatcher("add-flight.jsp").forward(request, response);
		} catch (ServiceException | ServletException | IOException e) {
			// redirect catre eror page
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flightNumber = request.getParameter("flightNumber");
		String airplaneType = request.getParameter("airplaneType");
		String departureCity = request.getParameter("departureCity");
		String departureDateTime = request.getParameter("departureDateTime");
		String arrivalCity = request.getParameter("arrivalCity");
		String arrivalDateTime = request.getParameter("arrivalDateTime");

		if (isEmty(flightNumber, airplaneType, departureCity, departureDateTime, arrivalCity, arrivalDateTime)) {
			System.out.println("Is empty");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

		Date departureDT = null;
		Date arrivalDT = null;
		try {
			departureDT = format.parse(departureDateTime);
			arrivalDT = format.parse(arrivalDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			response.sendRedirect("add-flight");
		}

	}

	private boolean isEmty(String... args) {
		for (String arg : args) {
			if (arg.length() == 0) {
				return true;
			}
		}
		return false;
	}
}

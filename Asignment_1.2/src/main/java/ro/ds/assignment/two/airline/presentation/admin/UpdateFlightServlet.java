package ro.ds.assignment.two.airline.presentation.admin;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ro.ds.assignment.two.airline.businesslogic.CityService;
import ro.ds.assignment.two.airline.businesslogic.FlightService;
import ro.ds.assignment.two.airline.domain.City;
import ro.ds.assignment.two.airline.domain.Flight;
import ro.ds.assignment.two.airline.exceptions.ServiceException;

public class UpdateFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityService cityService;
	private FlightService flightService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flightId = request.getParameter("flightId-update");
		Flight flight = new FlightService().findFlight(Integer.parseInt(flightId));
		
		request.setAttribute("flight", flight);
		request.setAttribute("cities", getCityService().getAllCities());
		request.setAttribute("error", request.getParameter("error"));
		request.setAttribute("success", request.getParameter("success"));

		request.getRequestDispatcher("update-flight.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String flightID = request.getParameter("flightId-update");
		String flightNumber = request.getParameter("flightNumber");
		String airplaneType = request.getParameter("airplaneType");
		String departureCity = request.getParameter("departureCity");
		String arrivalCity = request.getParameter("arrivalCity");

		if (departureCity.equals(arrivalCity)) {
			response.sendRedirect(
					"home?error=" + URLEncoder.encode("Invalid citiy. Please try again.", "UTF-8"));
			return;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date departureDateTime = null, arrivalDateTime = null;
		try {
			departureDateTime = format.parse(request.getParameter("departureDateTime"));
			arrivalDateTime = format.parse(request.getParameter("arrivalDateTime"));
		} catch (ParseException e) {
			response.sendRedirect(
					"home?error=" + URLEncoder.encode("Invalid date. Please try again.", "UTF-8"));
		}

		if (departureDateTime.equals(arrivalDateTime) || departureDateTime.after(arrivalDateTime)) {
			response.sendRedirect(
					"home?error=" + URLEncoder.encode("Invalid arrival date. Please try again.", "UTF-8"));
			return;
		}

		City departureCityy = null;
		City arrivalCityy = null;
		try {
			departureCityy = getCityService().findCityByName(departureCity);
			arrivalCityy = getCityService().findCityByName(arrivalCity);
		} catch (ServiceException exc) {
			response.sendRedirect(
					"home?error=" + URLEncoder.encode("City cannot be found. Please try again.", "UTF-8"));
			return;
		}

		Flight flight = new Flight(flightNumber, airplaneType, departureCityy, departureDateTime, arrivalCityy,
				arrivalDateTime);

		try {
			flight.setId(Integer.parseInt(flightID));
			getFlightService().updateFlight(flight);
		} catch (ServiceException exc) {
			response.sendRedirect(
					"home?error=" + URLEncoder.encode("Updating flight error... Please try again.", "UTF-8"));
			return;
		}
		response.sendRedirect("home?success=" + URLEncoder.encode("Successfully updated.", "UTF-8"));
	}

	private FlightService getFlightService() {
		if (null == flightService) {
			flightService = new FlightService();
		}
		return flightService;
	}

	private CityService getCityService() {
		if (null == cityService) {
			cityService = new CityService();
		}
		return cityService;
	}
}

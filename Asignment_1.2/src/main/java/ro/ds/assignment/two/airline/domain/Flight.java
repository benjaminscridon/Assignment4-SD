package ro.ds.assignment.two.airline.domain;

import java.util.Date;

/**
 * 
 * @author Beniamin Scridon
 * @since 10/18/2016
 */
public class Flight {

	private int id;
	private String flightNumber;
	private String airplaneType;
	private City departureCity;
	private Date departureDateTime;
	private City arrivalCity;
	private Date arrivalDateTime;

	public Flight() {
	}

	public Flight(String flightNumber, String airplaneType, City departureCity, Date departureDateTime,
			City arrivalCity, Date arrivalDateTime) {
		this.flightNumber = flightNumber;
		this.airplaneType = airplaneType;
		this.departureCity = departureCity;
		this.departureDateTime = departureDateTime;
		this.arrivalCity = arrivalCity;
		this.arrivalDateTime = arrivalDateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public Date getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(Date arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", airplaneType=" + airplaneType
				+ ", departureCity=" + departureCity + ", departureDateTime=" + departureDateTime + ", arrivalCity="
				+ arrivalCity + ", arrivalDateTime=" + arrivalDateTime + "]";
	}

}

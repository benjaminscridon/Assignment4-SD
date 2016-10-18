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
	private int departureCityId;
	private Date departureTime;
	private int arrivalCityId;
	private Date arrivalTime;

	public Flight() {
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

	public int getDepartureCityId() {
		return departureCityId;
	}

	public void setDepartureCityId(int departureCityId) {
		this.departureCityId = departureCityId;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalCityId() {
		return arrivalCityId;
	}

	public void setArrivalCityId(int arrivalCityId) {
		this.arrivalCityId = arrivalCityId;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}

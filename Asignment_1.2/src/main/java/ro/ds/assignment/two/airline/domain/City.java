package ro.ds.assignment.two.airline.domain;

/**
 * 
 * @author Beniamin Scridon
 * @since 10/18/2016
 */
public class City {

	private int id;
	private String name;
	private String latitude;
	private String longitude;
	
	public City() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}

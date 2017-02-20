package ro.utcluj.sd.assignment4.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "route_item")
public class RouteItem extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String city;
	private Date date;
	
	@Column(name = "city", nullable = false, length = 40)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}

package ro.utcluj.sd.assignment4.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "package")
public class Package extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private String senderCity;
	private String destinationCity;
	private boolean tacking;
	private User sender;
	private User receiver;
	private List<RouteItem> route;

	@Column(name = "name", nullable = false, length = 40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "description", nullable = true, length = 40)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "senderCity", nullable = false, length = 40)
	public String getSenderCity() {
		return senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	
	@Column(name = "destinationCity", nullable = false, length = 40)
	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	@Column(name = "tracking")
	public boolean isTacking() {
		return tacking;
	}

	public void setTacking(boolean tacking) {
		this.tacking = tacking;
	}
	
	@ManyToOne
	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}
	
	@ManyToOne
	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<RouteItem> getRoute() {
		return route;
	}

	public void setRoute(List<RouteItem> route) {
		this.route = route;
	}

}

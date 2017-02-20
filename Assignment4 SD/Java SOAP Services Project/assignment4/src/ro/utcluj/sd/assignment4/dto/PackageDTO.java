package ro.utcluj.sd.assignment4.dto;

import ro.utcluj.sd.assignment4.entities.RouteItem;

public class PackageDTO {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String description;
	private String senderCity;
	private String destinationCity;
	private boolean tacking;
	private UserDTO sender;
	private UserDTO receiver;
	private RouteItem[] route;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSenderCity() {
		return senderCity;
	}
	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public boolean isTacking() {
		return tacking;
	}
	public void setTacking(boolean tacking) {
		this.tacking = tacking;
	}
	public UserDTO getSender() {
		return sender;
	}
	public void setSender(UserDTO sender) {
		this.sender = sender;
	}
	public UserDTO getReceiver() {
		return receiver;
	}
	public void setReceiver(UserDTO receiver) {
		this.receiver = receiver;
	}
	public RouteItem[] getRoute() {
		return route;
	}
	public void setRoute(RouteItem[] route) {
		this.route = route;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

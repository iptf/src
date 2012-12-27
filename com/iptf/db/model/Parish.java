package com.iptf.db.model;

public class Parish {
	private int parishId;
	private String parishName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	
	public int getParishId() {
		return parishId;
	}
	public void setParishId(int parishId) {
		this.parishId = parishId;
	}
	public String getParishName() {
		return parishName;
	}
	public void setParishName(String parishName) {
		this.parishName = parishName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	

}

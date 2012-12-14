package com.anthonywoodard.postal.domain;

/**
 *  @author <a href="http://www.anthonywoodard.com">Anthony Woodard</a>
 */

public class Postal {
		
	private String zip = "";	
	private String city = "";	
	private String state = "";
				
	public String getZip() {
		return this.zip;
	}
	
	public void setZip(String zipCode) {
		this.zip = zipCode;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}

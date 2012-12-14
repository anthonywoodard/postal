package com.anthonywoodard.postal.dao;

import java.util.List;

/**
 * @author <a href="http://www.anthonywoodard.com">Anthony Woodard</a>
 */

public interface PostalDAO {
	
	List<String>zipLookUp(String zip);
	
	List<String>stateLookUp(String state);
	
	List<String>cityLookUp(String city);		
	
	List<String> getStates();
	
	List<String> getState(String city);
	
	List<String> getCities();
	
	List<String> getCity(String state);
	
	List<String>getZip(String zip);
}
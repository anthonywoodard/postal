package com.anthonywoodard.postal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anthonywoodard.postal.dao.mapper.PostalRowMapper;

/**
 *  @author <a href="http://www.anthonywoodard.com">Anthony Woodard</a>
 */

public class PostalDAOImpl implements PostalDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PostalDAOImpl.class);
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;		
		this.jdbcTemplate = new JdbcTemplate(dataSource);		
	}
	
	public List<String> zipLookUp(String zip) {						
		String stmt = "SELECT Zipcode from zipcodes where Zipcode LIKE '%' || ? || '%'";		
		return jdbcTemplate.query(stmt, 
				new Object[] {zip}, 
				new PostalRowMapper());			
	}
	
	public List<String> getZip(String zip) {
		String stmt = "SELECT City, state from vw_zipcodes where Zipcode = ?";
		return jdbcTemplate.query(stmt, 
				new Object[] {zip}, 
				new PostalRowMapper());
	}
	
	public List<String> stateLookUp(String state) {				
		String stmt = "SELECT state FROM states WHERE state LIKE '%' || ? || '%'";				
		return jdbcTemplate.query(stmt,
				new Object[] {state},
				new PostalRowMapper());		
	}
	
	public List<String> getState(String state) {
		String stmt = "SELECT DISTINCT City FROM vw_zipcodes WHERE state = ? ORDER BY City ASC";
		return jdbcTemplate.query(stmt,
				new Object[] {state},
				new PostalRowMapper());
	}
	
	public List<String> cityLookUp(String city) {					
		String stmt = "SELECT DISTINCT City FROM vw_zipcodes WHERE City LIKE '%' || ? || '%'";				
		return jdbcTemplate.query(stmt,
				new Object[] {city},
				new PostalRowMapper());					
	}
	
	public List<String> getCity(String city) {
		String stmt = "SELECT DISTINCT state FROM vw_zipcodes WHERE City = ? ORDER BY state ASC";
		return jdbcTemplate.query(stmt,
				new Object[] {city},
				new PostalRowMapper());
	}
	
	public List<String> getStates() {		
		return jdbcTemplate.query("SELECT state FROM states ORDER BY state ASC",
				new PostalRowMapper());		
	}
	
	public List<String> getCities() {		
		return jdbcTemplate.query("SELECT DISTINCT City FROM zipcodes ORDER BY City ASC",
				new PostalRowMapper());				
	}		
}
package com.anthonywoodard.postal.dao.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.anthonywoodard.postal.domain.Postal;

/**
 * @author <a href="http://www.anthonywoodard.com">Anthony Woodard</a>
 */

public class PostalResultSetExtractor implements ResultSetExtractor {
	
	public Object extractData(ResultSet rs) throws SQLException {
		Postal postal = new Postal();
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();				
		for(int i=1; i<=columns; ++i){
			if(md.getColumnName(i).equalsIgnoreCase("City")) {
				postal.setCity(rs.getString(i));
			}
			if(md.getColumnName(i).equalsIgnoreCase("state")) {
				postal.setState(rs.getString(i));
			}
			if(md.getColumnName(i).equalsIgnoreCase("Zipcode")) {
				postal.setZip(rs.getString(i));
			}
		}				
		return postal;
	}
}

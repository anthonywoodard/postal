package com.anthonywoodard.postal.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 *  @author <a href="http://www.anthonywoodard.com">Anthony Woodard</a>
 */

public class PostalRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int line) throws SQLException {
		PostalResultSetExtractor extractor = new PostalResultSetExtractor();
		return extractor.extractData(rs);
	}

}  
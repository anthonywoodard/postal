package org.stjude.postal.model.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.stjude.postal.model.domain.State;
import org.stjude.postal.model.domain.ZipCode;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/13/12
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ZipCodeMapper implements RowMapper<ZipCode> {
    public ZipCode mapRow(ResultSet rs, int rowNum) throws SQLException {
        State state = new State();
        state.setAbbr(rs.getString("abbr"));
        state.setState(rs.getString("state"));

        ZipCode zipCode = new ZipCode();
        zipCode.setZipCode(rs.getInt("zipcode"));
        zipCode.setCity(rs.getString("city"));
        zipCode.setState(state);
        return zipCode;
    }
}

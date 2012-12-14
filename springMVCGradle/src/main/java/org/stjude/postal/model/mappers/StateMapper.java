package org.stjude.postal.model.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.stjude.postal.model.domain.State;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/12/12
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class StateMapper implements RowMapper<State> {
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {
        State state = new State();
        state.setAbbr(rs.getString("abbr"));
        state.setState(rs.getString("state"));
        return state;
    }
}

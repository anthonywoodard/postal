package org.stjude.postal.model.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.stjude.postal.model.dao.StateDAO;
import org.stjude.postal.model.domain.State;
import org.stjude.postal.model.exceptions.StateDAOException;
import org.stjude.postal.model.mappers.StateMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/12/12
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository("stateDAO")
public class StateDAOImpl extends DAOImpl implements StateDAO {

    private static final String FIND_ALL = "SELECT * FROM states ORDER BY state";
    private static final String FIND_BY_ABBR = "SELECT * FROM states WHERE abbr=?";
    private static final String FIND_BY_NAME = "SELECT * FROM states WHERE state LIKE '?%'";

    @Override
    public State findByAbbr(String abbr) throws StateDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        return jdbcTemplate.queryForObject(FIND_BY_ABBR, new Object[] { abbr }, new StateMapper());
    }

    @Override
    public List<State> findAll() throws StateDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        return jdbcTemplate.query(FIND_ALL, new StateMapper());
    }

    @Override
    public List<State> findByName(String name) throws StateDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        return jdbcTemplate.query(FIND_BY_NAME, new Object[] { name }, new StateMapper());
    }

}

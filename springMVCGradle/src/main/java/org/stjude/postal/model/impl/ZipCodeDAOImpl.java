package org.stjude.postal.model.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.stjude.postal.model.dao.ZipCodeDAO;
import org.stjude.postal.model.domain.ZipCode;
import org.stjude.postal.model.exceptions.ZipCodeDAOException;
import org.stjude.postal.model.mappers.ZipCodeMapper;
import org.stjude.postal.utility.StringUtility;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/13/12
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("zipCodeDAO")
public class ZipCodeDAOImpl extends DAOImpl implements ZipCodeDAO {

    private static final String FIND_ZIPCODES = "SELECT DISTINCT Zipcode FROM vw_zipcodes WHERE Zipcode LIKE ? ORDER BY Zipcode";
    private static final String FIND_CITY = "SELECT * FROM vw_zipcodes WHERE Zipcode = ?";
    private static final String FIND_CITIES_BY_NAME = "SELECT DISTINCT City FROM vw_zipcodes WHERE City LIKE ? ORDER BY City";
    private static final String FIND_CITIES_BY_STATE = "SELECT DISTINCT City FROM vw_zipcodes WHERE Abbr = ? ORDER BY City";
    private static final String FIND_STATES_BY_CITY = "SELECT DISTINCT state FROM vw_zipcodes WHERE City = ? ORDER BY state";

    @Override
    public List<Integer> findZipCodes(int zip) throws ZipCodeDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        List zipCodes = jdbcTemplate.queryForList(FIND_ZIPCODES, new Object[]{String.valueOf(zip) + '%'});
        List<Integer> list = new ArrayList<Integer>();
        Iterator it = zipCodes.iterator();
        while (it.hasNext()) {
            HashMap<String, Integer> hashMap = (HashMap)it.next();
            list.add(hashMap.get("Zipcode"));
        }
        return list;
    }

    @Override
    public ZipCode findCity(int zip) throws ZipCodeDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        ZipCode zipCode = null;
        try{
            zipCode = jdbcTemplate.queryForObject(FIND_CITY, new Object[] { zip }, new ZipCodeMapper());
        } catch(EmptyResultDataAccessException erdae) {
        }
        return zipCode;
    }

    @Override
    public List<String> findCitiesByName(String city) throws ZipCodeDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        List list = jdbcTemplate.queryForList(FIND_CITIES_BY_NAME, new Object[]{city+'%'});
        List<String> cities = new ArrayList<String>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HashMap<String, String> hashMap = (HashMap)it.next();
            cities.add(StringUtility.toTitleCase(hashMap.get("City")));
        }
        return cities;
    }

    @Override
    public List<String> findCitiesByState(String abbr) throws ZipCodeDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        List list = jdbcTemplate.queryForList(FIND_CITIES_BY_STATE, new Object[]{abbr});
        List<String> cities = new ArrayList<String>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HashMap<String, String> hashMap = (HashMap)it.next();
            cities.add(StringUtility.toTitleCase(hashMap.get("City")));
        }
        return cities;
    }

    @Override
    public List<String> findStatesByCity(String city) throws ZipCodeDAOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
        List list = jdbcTemplate.queryForList(FIND_STATES_BY_CITY, new Object[]{city.toUpperCase()});
        List<String> states = new ArrayList<String>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HashMap<String, String> hashMap = (HashMap)it.next();
            states.add(StringUtility.toTitleCase(hashMap.get("state")));
        }
        return states;
    }
}

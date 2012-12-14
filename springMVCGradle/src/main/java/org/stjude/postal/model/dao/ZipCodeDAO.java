package org.stjude.postal.model.dao;

import org.stjude.postal.model.domain.ZipCode;
import org.stjude.postal.model.exceptions.ZipCodeDAOException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/13/12
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ZipCodeDAO {
    List<Integer> findZipCodes(int zipCode)
            throws ZipCodeDAOException;

    ZipCode findCity(int zipCode)
            throws ZipCodeDAOException;

    List<String> findCitiesByName(String city)
            throws ZipCodeDAOException;

    List<String> findCitiesByState(String state)
            throws ZipCodeDAOException;

    List<String> findStatesByCity(String city)
            throws ZipCodeDAOException;
}

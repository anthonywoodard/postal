package org.stjude.postal.tests.model.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;
import org.stjude.postal.model.domain.ZipCode;
import org.stjude.postal.model.exceptions.StateDAOException;
import org.stjude.postal.model.exceptions.ZipCodeDAOException;
import org.stjude.postal.model.impl.ZipCodeDAOImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: karmstrong
 * Date: 11/14/12
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"/test-config.xml"})
public class ZipCodeDAOTests extends AbstractJUnit4SpringContextTests {
    private ZipCodeDAOImpl zipCodeDAO;

    @Autowired
    public void setZipCodeDAO(ZipCodeDAOImpl zipCodeDAO) {
        this.zipCodeDAO = zipCodeDAO;
    }

    @Test
    public void getListOfZipCodes(){
        List<Integer> listZipCodes;
        try {
            listZipCodes = zipCodeDAO.findZipCodes(381);
            Assert.isTrue(listZipCodes.size() == 41, "The list should have 41 zipcodes isTrue begin with 381. but returned " + listZipCodes.size());
            Assert.isTrue(listZipCodes.get(0).equals(3810), "The first zipcode should be 3810 but returned "+listZipCodes.get(0));
            Assert.isTrue(listZipCodes.get(listZipCodes.size()-1).equals(38157), "The last zipcode should be 38157 but returned "+listZipCodes.get(listZipCodes.size()-1));
        } catch (ZipCodeDAOException zde) {
        }
    }

    @Test
    public void getCityByZipCode(){
        ZipCode zipCode;
        try {
            zipCode = zipCodeDAO.findCity(38103);
            Assert.isTrue(zipCode.getCity().equals("Memphis"), "City should be 'Memphis' but returned "+zipCode.getCity());
        } catch (ZipCodeDAOException zde) {
        }
    }

    @Test
    public void getCitiesByName(){
        List<String> listCities;
        try {
            listCities = zipCodeDAO.findCitiesByName("Chi");
            Assert.isTrue(listCities.size() == 42, "Query should return 42 cities but returned "+listCities.size());
            Assert.isTrue(listCities.get(0).equals("Chicago"), "First city should be 'Chicago' but returned "+listCities.get(0));
        } catch (ZipCodeDAOException zde) {
        }
    }

    @Test
    public void getCitiesByState(){
        List<String> listCities;
        try {
            listCities = zipCodeDAO.findCitiesByState("MA");
            Assert.isTrue(listCities.size() == 418, "Query should return 418 cities but returned "+listCities.size());
            Assert.isTrue(listCities.get(0).equals("Abington"), "First city should be 'Abington' but returned "+listCities.get(0));
            Assert.isTrue(listCities.get(listCities.size()-1).equals("Yarmouth Port"), "Last city should be 'Yarmouth Port' but returned "+listCities.get(listCities.size()-1));
        } catch (ZipCodeDAOException zde) {
        }
    }

    @Test
    public void getStatesByCity(){
        List<String> listStates;
        try {
            listStates = zipCodeDAO.findStatesByCity("Madison");
            Assert.isTrue(listStates.size() == 23, "Query should return 23 states but returned "+listStates.size());
            Assert.isTrue(listStates.get(0).equals("Alabama"), "First state should be 'Alabama' but returned "+listStates.get(0));
            Assert.isTrue(listStates.get(listStates.size()-1).equals("Wisconsin"), "Last state should be 'Wisconsin' but returned "+listStates.get(listStates.size()-1));
        } catch (ZipCodeDAOException zde) {
        }
    }

}

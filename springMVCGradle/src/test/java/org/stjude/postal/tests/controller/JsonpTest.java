package org.stjude.postal.tests.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;
import org.stjude.postal.model.domain.ZipCode;
import org.stjude.postal.model.exceptions.ZipCodeDAOException;
import org.stjude.postal.model.impl.ZipCodeDAOImpl;
import org.stjude.postal.utility.StringUtility;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: karmstrong
 * Date: 11/20/12
 * Time: 8:36 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"/test-config.xml"})
public class JsonpTest extends AbstractJUnit4SpringContextTests {
    private ZipCodeDAOImpl zipCodeDAO;

    @Autowired
    public void setZipCodeDAO(ZipCodeDAOImpl zipCodeDAO) {
        this.zipCodeDAO = zipCodeDAO;
    }

    @Test
    public void getListOfStates(){
        String callback = "process";
        ZipCode zipCode;
        try {
            zipCode = zipCodeDAO.findCity(38103);
            String json = StringUtility.toJsonP(zipCode, callback);
            Assert.isTrue(json.equals(";"+callback+"({\"zipCode\":38103,\"city\":\"Memphis\",\"state\":{\"abbr\":\"TN\",\"state\":\"Tennessee\"}});"), "JSONP not proper!");
        } catch (ZipCodeDAOException zde) {
        }
    }
}

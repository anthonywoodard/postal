package org.stjude.postal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.stjude.postal.model.domain.State;
import org.stjude.postal.model.domain.ZipCode;
import org.stjude.postal.model.exceptions.StateDAOException;
import org.stjude.postal.model.exceptions.ZipCodeDAOException;
import org.stjude.postal.model.impl.StateDAOImpl;
import org.stjude.postal.model.impl.ZipCodeDAOImpl;
import org.stjude.postal.utility.StringUtility;

import java.util.List;

@Controller
public class ApiController {

    private String callbackParameter = "callback";

    @Autowired
    private StateDAOImpl stateDAO;

    @Autowired
    private ZipCodeDAOImpl zipCodeDAO;

    public void setDaoImpl(StateDAOImpl stateDAO) {
        this.stateDAO = stateDAO;
    }

    public void setZipCodeDAO(ZipCodeDAOImpl zipCodeDAO) {
        this.zipCodeDAO = zipCodeDAO;
    }

    @RequestMapping(value="/zip/{zip}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public String getZip(@PathVariable Integer zip, WebRequest webRequest){
        try {
            ZipCode zipCode = zipCodeDAO.findCity(zip);
            return StringUtility.toJsonP(zipCode, webRequest.getParameter(callbackParameter));
        } catch (ZipCodeDAOException sde) {
            return null;
        }
    }

    @RequestMapping(value="/zips/{zip}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public String getZips(@PathVariable Integer zip, WebRequest webRequest){
        try {
            List<Integer> zips = zipCodeDAO.findZipCodes(zip);
            return StringUtility.toJsonP(zips, webRequest.getParameter(callbackParameter));
        } catch (ZipCodeDAOException sde) {
            return null;
        }
    }

    @RequestMapping(value="/cities/{city}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public String getCities(@PathVariable String city, WebRequest webRequest){
        try {
            List<String> cities = zipCodeDAO.findCitiesByName(city);
            return StringUtility.toJsonP(cities, webRequest.getParameter(callbackParameter));
        } catch (ZipCodeDAOException sde) {
            return null;
        }
    }

    @RequestMapping(value="/citystates/{city}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public String getStatesByCity(@PathVariable String city, WebRequest webRequest){
        try {
            List<String> states = zipCodeDAO.findStatesByCity(city);
            return StringUtility.toJsonP(states, webRequest.getParameter(callbackParameter));
        } catch (ZipCodeDAOException sde) {
            return null;
        }
    }

    @RequestMapping(value="/statecities/{state}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public String getCitiesByState(@PathVariable String state, WebRequest webRequest){
        try {
            List<String> cities = zipCodeDAO.findCitiesByState(state);
            return StringUtility.toJsonP(cities, webRequest.getParameter(callbackParameter));
        } catch (ZipCodeDAOException sde) {
            return null;
        }
    }

    @RequestMapping(value="/states", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public String getStates(WebRequest webRequest){
        List<State> list;
        try {
            list = stateDAO.findAll();
            return StringUtility.toJsonP(list, webRequest.getParameter(callbackParameter));
        } catch (StateDAOException sde) {
            return null;
        }
    }

}

package com.anthonywoodard.postal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

import com.anthonywoodard.postal.dao.PostalDAO;

/**
 * Handles requests for the application data.
 * @author <a href="http://www.anthonywoodard.com">Anthony Woodard</a>
 */

@RequestMapping("/data")
@Controller

public class PostalController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostalController.class);
	
	@Autowired
	PostalDAO postalDao;

	public PostalDAO getPostalDao() {
		return postalDao;
	}

	public void setPostalDao(PostalDAO postalDao) {
		this.postalDao = postalDao;
	}
	
	@RequestMapping(value="/{key}/{value}/{action}", method = RequestMethod.GET)
	public String getData(
			@PathVariable("key") String key,  			
			@PathVariable("value") String value,
			@PathVariable("action") String action,
			ModelMap map) {	
		
		if(key.equalsIgnoreCase("zip")) {
			if(action.equalsIgnoreCase("like")) {
				map.addAttribute("model", postalDao.zipLookUp(value));
			} else {
				map.addAttribute("model", postalDao.getZip(value));
			}
		} else if(key.equalsIgnoreCase("city")) {
			if(action.equalsIgnoreCase("like")) {
				map.addAttribute("model", postalDao.cityLookUp(value));
			} else {
				map.addAttribute("model", postalDao.getCity(value));
			}
		} else if(key.equalsIgnoreCase("state")) {	
			if(action.equalsIgnoreCase("like")) {
				map.addAttribute("model", postalDao.stateLookUp(value));
			} else {
				map.addAttribute("model", postalDao.getState(value));
			}
		}		
		return "data";				
	}
	
	@RequestMapping(value="/getStates", method = RequestMethod.GET)
	public String getStates(ModelMap map) {						
		map.addAttribute("model", postalDao.getStates());
		return "data";				
	}
}
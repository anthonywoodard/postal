package org.stjude.postal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@RequestMapping(value="/")
	public String getDefault(ModelMap map) {
        return "redirect:/index.html";
    }

    @RequestMapping(value="/index.html")
    public void getIndex(ModelMap map) {
        map.addAttribute("title", "Postal Project");
        map.addAttribute("menu", 1);
    }

    @RequestMapping(value="/about.html")
    public void getAbout(ModelMap map) {
        map.addAttribute("title", "About Postal Project");
        map.addAttribute("menu", 2);
    }
}

package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Filiale;

@Controller
public class guideController {
	

	
@RequestMapping(value="/guide", method = RequestMethod.GET)
	public ModelAndView guide(){
		Filiale filiale = new Filiale();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/guide");
		modelAndView.addObject("filiale",filiale);
		return modelAndView;
	}
	
}

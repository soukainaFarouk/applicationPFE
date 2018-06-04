package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {

	
	@RequestMapping(value="/role", method = RequestMethod.GET)
	public ModelAndView filiale(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/role");
		return modelAndView;
	}
	
	
	
}

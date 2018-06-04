package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.Filiale;
import com.example.repository.FilialeRepo;

@Controller
public class AfficherRefController {
	
	
	@Autowired
	private FilialeRepo filialeRepo;

	@RequestMapping(value="/afficherRef", method = RequestMethod.GET)
	public ModelAndView afficherRef(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/afficherRef");
		List<Filiale> allfiliales = filialeRepo.findAll();

		modelAndView.addObject("allfiliales", allfiliales);
		return modelAndView;
	}
	
	
}

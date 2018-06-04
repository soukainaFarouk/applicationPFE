package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Domaine;
import com.example.model.Filiale;
import com.example.repository.DomaineRepo;
import com.example.repository.FilialeRepo;


@Controller
public class DomaineController {

	@Autowired
	private DomaineRepo domaineRepo;
	
	@Autowired
	private FilialeRepo filialeRepo;

	@RequestMapping(value="/domaine", method = RequestMethod.GET)
	public ModelAndView domaine(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/domaine");
		Domaine domaine = new Domaine ();
		List<Filiale> allfiliales = filialeRepo.findAll();
		modelAndView.addObject("allfiliales", allfiliales);
		List<Domaine> domaines = domaineRepo.findAll();
		modelAndView.addObject("domaines", domaines);
		modelAndView.addObject("domaine", domaine);
		return modelAndView;
	}
	@RequestMapping(value = "/domaine", method = RequestMethod.POST)
	public ModelAndView ajoutDomaine(@ModelAttribute("domaine") Domaine domaine, BindingResult bindingResult,ModelAndView modelAndView) {

		if (bindingResult.hasErrors()) {
			
			modelAndView.addObject("message", "Domaine non enregistré");
			modelAndView = domaine();
		} else {
			domaineRepo.save(domaine);
			modelAndView.addObject("message", "Domaine bien enregistré");
			modelAndView = domaine();
		}
		return modelAndView;
	}
	
}




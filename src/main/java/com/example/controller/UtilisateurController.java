package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.Utilisateur;
import com.example.repository.UtilisateurRepo;

@Controller
public class UtilisateurController {

	public UtilisateurRepo utilisateurRepo;
	
	@RequestMapping(value="/utilisateur", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Utilisateur utilisateur = new Utilisateur();
		modelAndView.addObject("utilisateur", utilisateur);
		modelAndView.setViewName("admin/utilisateur");
		return modelAndView;
	}
}
package com.example.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.Filiale;
import com.example.model.User;
import com.example.repository.FilialeRepo;
import com.example.service.UserService;

@Controller
public class AlimenterRefController {
	
	@Autowired
	private FilialeRepo filialeRepo;

	@RequestMapping(value="/alimenterRef", method = RequestMethod.GET)
	public ModelAndView alimenterRef(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/alimenterRef");
		List<Filiale> allfiliales = filialeRepo.findAll();

		modelAndView.addObject("allfiliales", allfiliales);
		return modelAndView;
	}
	
}

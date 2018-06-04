package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.Filiale;
import com.example.repository.FilialeRepo;

@Controller
public class FilialeController {

	@Autowired
	private FilialeRepo filialeRepo;

	@RequestMapping(value="/filiale", method = RequestMethod.GET)
	public ModelAndView filiale(){
		Filiale filiale = new Filiale();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/filiale");
		List<Filiale> filiales = filialeRepo.findAll();
		modelAndView.addObject("filiales", filiales);
		modelAndView.addObject("filiale",filiale);
		return modelAndView;
	}
	
	@RequestMapping(value = "/filiale", method = RequestMethod.POST)
	public ModelAndView ajoutFiliale(@ModelAttribute("filiale") Filiale filiale, BindingResult bindingResult,ModelAndView modelAndView) {
		
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Filiale non enregistrée");
			modelAndView = filiale();
		} else {
			filialeRepo.save(filiale);
			modelAndView.addObject("successMessage", "Filiale bien enregistrée");
			modelAndView = filiale();
			}
		return modelAndView;
	}
	
	@RequestMapping(path = "/filiale/edit/{id}", method = RequestMethod.GET)
    public String editFiliale(Model model, @PathVariable(value = "id") Long id) {
		List<Filiale> filiales = filialeRepo.findAll();
		model.addAttribute("filiales", filiales);
		model.addAttribute("filiale",filialeRepo.findById(id));
		return "admin/filiale :: editmodal";
    }
	
	@RequestMapping(path = "/filiale/supression/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFiliale(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView=new ModelAndView();
		filialeRepo.deleteById(id);
		modelAndView = filiale();
		return modelAndView;
    }
}

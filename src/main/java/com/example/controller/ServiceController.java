package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Filiale;
import com.example.model.Service;
import com.example.model.User;
import com.example.repository.ServiceRepo;

@Controller
public class ServiceController {

	public ServiceRepo serviceRepo;
	
	@RequestMapping(value="/service", method = RequestMethod.GET)
	public ModelAndView service(){
		Service service = new Service();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/service");
		//List<Service> services = serviceRepo.findAll();
		//modelAndView.addObject("services", services);
		modelAndView.addObject("service",service);
		return modelAndView;
	}
	
	
	
	/*@RequestMapping(value = "/service", method = RequestMethod.POST)
	public ModelAndView ajoutService(@ModelAttribute("service") Service service, BindingResult bindingResult,ModelAndView modelAndView) {

		if (bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Service non enregistrée");
			modelAndView = service();
		} else {
			serviceRepo.save(service);
			modelAndView.addObject("successMessage", "Filiale bien enregistrée");
			modelAndView = service();
		}
		return modelAndView;
	}
	
	@RequestMapping(path = "/service/edit/{id}", method = RequestMethod.GET)
    public String editService(Model model, @PathVariable(value = "id") Long id) {
		List<Service> services = serviceRepo.findAll();
		model.addAttribute("services", services);
		model.addAttribute("service",serviceRepo.findById(id));
		return "admin/service :: editmodalservice";
    }
	
	@RequestMapping(path = "/service/supression/{id}", method = RequestMethod.GET)
    public ModelAndView deleteService(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView=new ModelAndView();
		serviceRepo.deleteById(id);
		modelAndView = service();
		return modelAndView;
    }*/
	
}



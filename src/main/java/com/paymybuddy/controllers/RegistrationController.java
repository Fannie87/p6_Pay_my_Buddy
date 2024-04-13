package com.paymybuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paymybuddy.model.Registration;
import com.paymybuddy.repository.DBUserRepository;


@Controller
public class RegistrationController {
	@Autowired
	private DBUserRepository dBUserRepository;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "registration", new Registration());
	}

	@RequestMapping(value = "/registration-success", method = RequestMethod.POST)
	public String submit(@ModelAttribute("registration") Registration registration, BindingResult result, ModelMap model) {
		
		if(registration.getFirstName().isBlank())
			result.rejectValue("firstName", null, "Merci de remplir le champ");
		
		if (result.hasErrors())
			return "registration";
		dBUserRepository.createUser(registration);
		return "registration";

//		return new ModelAndView("registration-success", "registration", registration);
	}
	
}

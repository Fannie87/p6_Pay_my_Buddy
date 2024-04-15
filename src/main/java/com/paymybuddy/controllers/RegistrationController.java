package com.paymybuddy.controllers;

import javax.servlet.http.HttpSession;

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
	public String submit(@ModelAttribute("registration") Registration registration, BindingResult result, ModelMap model, HttpSession session) {
		
		if(registration.getFirstName().isBlank())
			result.rejectValue("firstName", null, "Please enter your first name in this field");

		if(registration.getLastName().isBlank())
			result.rejectValue("lastName", null, "Please enter your last name in this field");
		
		if(registration.getMail().isBlank())
			result.rejectValue("mail", null, "Please enter your mail in this field");
		
		if(registration.getPassword().isBlank())
			result.rejectValue("password", null, "Please enter your password in this field");
		
		if (result.hasErrors())
			return "registration";
		dBUserRepository.createUser(registration);
		session.setAttribute("registration", registration);
		return "redirect:registration-success";
	}
	
	@RequestMapping(value = "/registration-success", method = RequestMethod.GET)
	public ModelAndView showRegistrationSucces(HttpSession session) {
		Registration registration = (Registration)  session.getAttribute("registration");
		return new ModelAndView("registration-success", "registration", registration);
	}

}

package com.paymybuddy.controllers;

import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paymybuddy.model.Registration;
import com.paymybuddy.repository.DBUserRepository;

@Controller
public class RegistrationController {  
	
	@Autowired 
	private DBUserRepository dBUserRepository;
 
	@GetMapping(value = "/registration")
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "registration", new Registration());
	}

	@PostMapping(value = "/registration-success")
	public String submit(@ModelAttribute("registration") Registration registration, BindingResult result, ModelMap model, HttpSession session) {
		
		if(registration.getFirstName().isBlank())
			result.rejectValue("firstName", null, "Please input your first name in this field");

		if(registration.getLastName().isBlank())
			result.rejectValue("lastName", null, "Please input your last name in this field");
		
		if(registration.getMail().isBlank())
			result.rejectValue("mail", null, "Please input your mail in this field");
		
		if(registration.getPassword().isBlank())
			result.rejectValue("password", null, "Please input your password in this field");
		else if(!EmailValidator.getInstance().isValid(registration.getMail()))
			result.rejectValue("mail", null, "The mail format is not good. ex : test@gmail.com");
		else if(dBUserRepository.countByMail(registration.getMail()).intValue() != 0)
			result.rejectValue("mail", null, "This mail is already used. Please input another one.");
		
		if (result.hasErrors()) 
			return "registration";
		
		
		dBUserRepository.createUser(registration);
		session.setAttribute("registration", registration);
		return "redirect:registration-success";
	}
	
	@GetMapping(value = "/registration-success")
	public ModelAndView showRegistrationSucces(HttpSession session) {
		Registration registration = (Registration)  session.getAttribute("registration");
		return new ModelAndView("registration-success", "registration", registration);
	}

}

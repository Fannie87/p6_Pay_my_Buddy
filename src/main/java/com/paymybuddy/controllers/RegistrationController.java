package com.paymybuddy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paymybuddy.model.Registration;


@Controller
public class RegistrationController {

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "registration", new Registration());
	}

	@RequestMapping(value = "/registration-success", method = RequestMethod.POST)
	public String submit(@ModelAttribute("registration") Registration registration, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "registration";
		}
//		model.addAttribute("name", employee.getName());
//		model.addAttribute("contactNumber", employee.getContactNumber());
//		model.addAttribute("id", employee.getId());
		return "registration-success";
	}
}

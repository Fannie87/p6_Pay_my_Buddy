package com.paymybuddy.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paymybuddy.dao.DBUser;
import com.paymybuddy.model.Connection;
import com.paymybuddy.repository.ConnectionRepository;
import com.paymybuddy.repository.DBUserRepository;

@Controller
public class ConnectionController {

	@Autowired
	private DBUserRepository dBUserRepository;

	@Autowired
	private ConnectionRepository connectionRepository;

	@GetMapping(value = "/connection")
	public ModelAndView showAddConnection() {
		return new ModelAndView("connection", "connection", new Connection());
	}

	@PostMapping(value = "/connection")
	public String submit(@ModelAttribute("connection") Connection connection, BindingResult result, ModelMap model,
			HttpSession session, HttpServletRequest request) {

		EmailValidator emailValidator = EmailValidator.getInstance();

		if (connection.getMail().isBlank()) {
			result.rejectValue("mail", null, "Please enter an email address");
			return "connection";
		}

		if (!emailValidator.isValid(connection.getMail())) {
			result.rejectValue("mail", null, "Not a good format");
			return "connection";
		}

		DBUser dBUserFriend = null;

		try {
			dBUserFriend = dBUserRepository.findByMail(connection.getMail());
		} catch (Exception e) {
			if (e instanceof EmptyResultDataAccessException) {
				result.rejectValue("mail", null, "Not such email found. Please try another one.");
				return "connection";
			}
		}

		// Récupère le mail de la personne connectée à ce moment là
		String mailPersonConnected = request.getUserPrincipal().getName();
		DBUser dBUser = dBUserRepository.findByMail(mailPersonConnected);

		int countConnection = connectionRepository.countConnection(dBUser.getId(), dBUserFriend.getId()).intValue();
		if (countConnection == 0) {
			connectionRepository.addConnection(dBUser.getId(), dBUserFriend.getId());
			// Permet d'enregistrer le mail en session en cas de refresh
			session.setAttribute("connection", connection);
			return "redirect:connection-success";
		} else {
			result.rejectValue("mail", null, "Mail already existing");
			return "connection";
		}

	}

//	Permet d'afficher le mail en session en cas de refresh
	@GetMapping(value = "/connection-success")
	public ModelAndView showConnectionSucces(HttpSession session) {
		Connection connection = (Connection) session.getAttribute("connection");
		return new ModelAndView("connection-success", "connection", connection);
	}

}

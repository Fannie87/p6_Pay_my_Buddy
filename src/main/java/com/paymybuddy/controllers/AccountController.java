package com.paymybuddy.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paymybuddy.dao.DBUser;
import com.paymybuddy.model.Account;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.DBUserRepository;

@Controller
public class AccountController {

	@Autowired
	private DBUserRepository dBUserRepository;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("account")
	public ModelAndView getAccountPage() {
		return new ModelAndView("account", "account", new Account());
	}

	@PostMapping("/addAccount")
	public String addAccount(@ModelAttribute("account") Account account, BindingResult result, ModelMap model,
			HttpServletRequest request) {

		if (account.getIban().isBlank())
			result.rejectValue("iban", null, "Please enter your IBAN number");

		if (account.getBic().isBlank())
			result.rejectValue("bic", null, "Please enter your BIC number");

		if (account.getNameAccount().isBlank())
			result.rejectValue("nameAccount", null, "Please enter your name account");

		if (result.hasErrors())
			return "account";

		String principal = request.getUserPrincipal().getName();

		DBUser dBUser = dBUserRepository.findByMail(principal);
		Integer id = dBUser.getId();
		account.setIdUser(id);

		accountRepository.createAccount(account);
		return "redirect:account-success";
	} 

	@GetMapping(value = "/account-success")
	public String showRegistrationSucces() {
		return "account-success";
	}

//	@GetMapping(value = "/transfer-balance")
//	public String showTransferBalance() {
//		return "transfer-balance";
//	}
}

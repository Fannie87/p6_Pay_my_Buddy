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
import com.paymybuddy.model.Pay;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.DBUserRepository;
import com.paymybuddy.repository.PayRepository;

@Controller
public class TransferController {
	
	@Autowired
	private DBUserRepository dBUserRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private PayRepository payRepository;

	
	@GetMapping("transfer")
	public ModelAndView getPayPage() {
		return new ModelAndView("transfer", "pay", new Pay());
	}
	
	@PostMapping("/transfer")
	public String payAmount(@ModelAttribute("pay") Pay pay, BindingResult result, ModelMap model,
			HttpServletRequest request) {

		if (pay.getAmount() == null)
			result.rejectValue("amount", null, "Please enter the amount you ant to transfer.");

		if (pay.getConnection().isBlank())  
			result.rejectValue("nameAccount", null, "Please enter your name account.");

		if (result.hasErrors())
			return "transfer";

		String principal = request.getUserPrincipal().getName();

		DBUser dBUser = dBUserRepository.findByMail(principal);
		Integer id = dBUser.getId(); 
		Account account= new Account();
		account.setIdUser(id);   

		accountRepository.createAccount(account);
		return "redirect:transfer-success";
	} 
}

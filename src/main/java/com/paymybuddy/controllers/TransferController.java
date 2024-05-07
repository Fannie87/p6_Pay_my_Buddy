package com.paymybuddy.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.paymybuddy.dao.DBUser;
import com.paymybuddy.model.Pay;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.ConnectionRepository;
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

	@Autowired
	private ConnectionRepository connectionRepository;

	@GetMapping("transfer")
	public String getPayPage(Model model, HttpServletRequest request) {
		model.addAttribute("pay", new Pay());
		String mail = request.getUserPrincipal().getName();

		DBUser dBUser = dBUserRepository.findByMail(mail);
		Map<Integer, String> mailFriend = connectionRepository.getFriendsList(dBUser.getId());

		model.addAttribute("listOfInstitutionsNames", mailFriend);

		return "transfer";
	}

//	@PostMapping("/transfer-success")
////	Pay = objet transmis dans formulaire, result = affiche les erreurs du formulaire,
////	request= récupérer le mail lors de la session
//	public String payAmount(@ModelAttribute("pay") Pay pay, BindingResult result, HttpServletRequest request) {
//
//		if (pay.getAmount() == null)
//			result.rejectValue("amount", null, "Please enter the amount you want to transfer.");
//
//		if (pay.getConnection().isBlank())
//			result.rejectValue("nameAccount", null, "Please enter your name account.");
//
//		if (result.hasErrors())
//			return "transfer";
//
//		String mail = request.getUserPrincipal().getName();
//
//		DBUser dBUser = dBUserRepository.findByMail(mail);
//		Integer id = dBUser.getId();
//		Account account = new Account();
//		account.setIdUser(id);
//
//		accountRepository.createAccount(account);
//		return "redirect:transfer-success";
//	}
}

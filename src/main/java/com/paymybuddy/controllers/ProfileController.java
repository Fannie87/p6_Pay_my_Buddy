package com.paymybuddy.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.paymybuddy.dao.DBUser;
import com.paymybuddy.dao.TransactionDAO;
import com.paymybuddy.model.Account;
import com.paymybuddy.model.ProfileAmount;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.DBUserRepository;
import com.paymybuddy.repository.TransactionRepository;

@Controller
public class ProfileController {

	@Autowired
	private DBUserRepository dBUserRepository;

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping(value = "/profile")
	public String showProfile(Model model, HttpServletRequest request) {
		model.addAttribute("profileAmountSupply", new ProfileAmount());
		model.addAttribute("profileAmountDebit", new ProfileAmount());

		String mail = request.getUserPrincipal().getName();

		DBUser dBUser = dBUserRepository.findByMail(mail);
		List<Account> accounts = accountRepository.getAccountsFromIdUser(dBUser.getId());

		Map<String, String> mapAccounts = new HashMap<String, String>();
		for (Account account : accounts) {
			mapAccounts.put(account.getIdAccount().toString(), account.getNameAccount());
		}

		request.getSession().setAttribute("mapAccounts", mapAccounts);
		request.getSession().setAttribute("balance", dBUser.getBalance());

		return "profile";
	}

	@PostMapping("/supply-success")
//	profileAmount = objet transmis dans formulaire, result = affiche les erreurs du formulaire,
//	request = récupérer le mail lors de la session
	public String supplyAmount(@ModelAttribute("profileAmountSupply") ProfileAmount profileAmountSupply,
			BindingResult result, HttpServletRequest request, Model model) {
		model.addAttribute("profileAmountDebit", new ProfileAmount());
		// Lien entre JSP et Java (attribute)

		if (profileAmountSupply.getBalance() == null)
			result.rejectValue("balance", null, "Please enter the amount you want to supply in Pay my Buddy.");
		else if(!NumberUtils.isCreatable(profileAmountSupply.getBalance()))
			result.rejectValue("balance", null, "Please enter a positive amount.");
		else {
			Float balance = Float.parseFloat(profileAmountSupply.getBalance());
			if (balance < 0)
				result.rejectValue("balance", null, "Please enter a positive amount.");
			else if (balance.isNaN())
				result.rejectValue("balance", null, "Please enter a positive amount.");
		}

		// Demande un string
		if ("NONE".equals(profileAmountSupply.getIdAccount()))
			result.rejectValue("idAccount", null, "Please enter your name account.");

		if (result.hasErrors())
			return "profile";

		String mail = request.getUserPrincipal().getName();
		DBUser dBUser = dBUserRepository.findByMail(mail);

		Float balanceAmount = dBUserRepository.getBalance(dBUser.getId());

		// Solde en cours + solde saisi = solde actualisé
		Float inputBalance = Float.parseFloat(profileAmountSupply.getBalance());
		dBUserRepository.loadBalance(dBUser.getId(), balanceAmount + inputBalance);
		String nameAccount = accountRepository.getAccountFromId(profileAmountSupply.getIdAccount()).getNameAccount();

		TransactionDAO transaction = new TransactionDAO();
		transaction.setAmount(inputBalance);
		transaction.setDescription("Load balance from your own account. account : " + nameAccount);
		transaction.setIdFriend(dBUser.getId());
		transaction.setIdUser(dBUser.getId());
		transactionRepository.createTransaction(transaction);

		return "redirect:profile-success";
	}

	@GetMapping(value = "/profile-success")
	public String showProfileSuccess(Model model, HttpServletRequest request) {
		String mail = request.getUserPrincipal().getName();
		DBUser dBUser = dBUserRepository.findByMail(mail);
		request.getSession().setAttribute("balance", dBUser.getBalance());

		return "profile-success";
	}
	
	@PostMapping("/debit-success")
	public String transferAmount(@ModelAttribute("profileAmountDebit") ProfileAmount profileAmountDebit,
			BindingResult result, HttpServletRequest request, Model model) {
		model.addAttribute("profileAmountSupply", new ProfileAmount());

		if (profileAmountDebit.getBalance() == null)
			result.rejectValue("balance", null, "Please enter the amount you want to transfer to your bank account.");
		else if(!NumberUtils.isCreatable(profileAmountDebit.getBalance()))
			result.rejectValue("balance", null, "Please enter a positive amount.");
		else {
			Float balance = Float.parseFloat(profileAmountDebit.getBalance());
			if (balance < 0)
				result.rejectValue("balance", null, "Please enter a positive amount.");
			else if (balance.isNaN())
				result.rejectValue("balance", null, "Please enter a positive amount.");
		}

		// Demande un string
		if ("NONE".equals(profileAmountDebit.getIdAccount()))
			result.rejectValue("idAccount", null, "Please enter your name account.");

		if (result.hasErrors())
			return "profile";

		String mail = request.getUserPrincipal().getName();
		DBUser dBUser = dBUserRepository.findByMail(mail);

		Float balanceAmount = dBUserRepository.getBalance(dBUser.getId());

		// Solde en cours + solde saisi = solde actualisé
		Float inputBalance = Float.parseFloat(profileAmountDebit.getBalance());
		dBUserRepository.loadBalance(dBUser.getId(), balanceAmount - inputBalance);
		String nameAccount = accountRepository.getAccountFromId(profileAmountDebit.getIdAccount()).getNameAccount();
		
		TransactionDAO transaction = new TransactionDAO();
		transaction.setAmount(inputBalance);
		transaction.setDescription("Debit balance from Pay my Buddy. account : " + nameAccount);
		transaction.setIdFriend(dBUser.getId());
		transaction.setIdUser(dBUser.getId());
		transactionRepository.createTransaction(transaction);

		return "redirect:profile-success";
	}

	
}


package com.paymybuddy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.paymybuddy.dao.DBUser;
import com.paymybuddy.dao.TransactionDAO;
import com.paymybuddy.model.Pay;
import com.paymybuddy.model.Transaction;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.ConnectionRepository;
import com.paymybuddy.repository.DBUserRepository;
import com.paymybuddy.repository.PayRepository;
import com.paymybuddy.repository.TransactionRepository;

@Controller
public class TransferController {

	@Autowired
	private DBUserRepository dBUserRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PayRepository payRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ConnectionRepository connectionRepository;

	@GetMapping("transfer")
	public String getPayPage(Model model, HttpServletRequest request) {
		model.addAttribute("pay", new Pay());
		String mail = request.getUserPrincipal().getName();

		DBUser dBUser = dBUserRepository.findByMail(mail);

		Map<Integer, String> friendList = connectionRepository.getFriendsList(dBUser.getId());

		request.getSession().setAttribute("friendList", friendList);

		List<TransactionDAO> transactionsDAO = transactionRepository.getTransactionsFromIdUser(dBUser.getId());
		List<Transaction> transactions = new ArrayList<Transaction>();

		for (TransactionDAO transactionDAO : transactionsDAO) {
			DBUser dBFriend = dBUserRepository.getUserById(transactionDAO.getIdFriend());
			Transaction transaction = new Transaction();
			transaction.setAmount(transactionDAO.getAmount());
			transaction.setDescription(transactionDAO.getDescription());
			transaction.setFriend(dBFriend.getFirstName() + " " + dBFriend.getLastName());
			transaction.setIdTrade(transactionDAO.getIdTrade());
			transactions.add(transaction);
		}

		request.getSession().setAttribute("transactions", transactions);

		return "transfer";
	}

	@PostMapping("transfer-success")
//	Pay = objet transmis dans formulaire, result = affiche les erreurs du formulaire,
//	request= récupérer le mail lors de la session
	public String payAmount(@ModelAttribute("pay") Pay pay, BindingResult result, HttpServletRequest request) {

		if (pay.getAmount() == null)
			result.rejectValue("amount", null, "Please enter the amount you want to transfer.");

		// Demande un string
		if ("NONE".equals(pay.getIdFriend()))
			result.rejectValue("idFriend", null, "Please select a friend.");

		if (result.hasErrors())
			return "transfer";

		String mail = request.getUserPrincipal().getName();

		DBUser dBUser = dBUserRepository.findByMail(mail);
		TransactionDAO transaction = new TransactionDAO();

		//résultat de la multiplication = double, obligé de le transformer en Float (commission de -0.5% dur chaque transaction)
		transaction.setAmount(Float.valueOf((float) (pay.getAmount() * 0.95)));

		transaction.setDescription("Money send to friend");
		transaction.setIdFriend(Integer.parseInt(pay.getIdFriend()));
		transaction.setIdUser(dBUser.getId());

		transactionRepository.createTransaction(transaction);

		return "transfer-success";
	}
}

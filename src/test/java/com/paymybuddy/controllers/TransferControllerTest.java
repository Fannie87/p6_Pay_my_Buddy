package com.paymybuddy.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.paymybuddy.dao.DBUser;
import com.paymybuddy.model.Pay;
import com.paymybuddy.repository.ConnectionRepository;
import com.paymybuddy.repository.DBUserRepository;
import com.paymybuddy.repository.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class TransferControllerTest {

	@InjectMocks
	private TransferController transferController;

	@Mock
	Model model;
	@Mock
	HttpServletRequest request;
	@Mock
	Principal principal;
	@Mock
	DBUserRepository dBUserRepository;
	@Mock
	TransactionRepository transactionRepository;
	@Mock
	ConnectionRepository connectionRepository;
	@Mock
	HttpSession session;
	@Mock
	BindingResult result;

	@Test
	void getPayPage() throws Exception {

		when(request.getUserPrincipal()).thenReturn(principal);
		when(principal.getName()).thenReturn("user@gmail.com");

		DBUser dBUser = new DBUser();
		when(dBUserRepository.findByMail("user@gmail.com")).thenReturn(dBUser);
		when(request.getSession()).thenReturn(session);

		String page = transferController.getPayPage(model, request);

		assertThat(page).isEqualTo("transfer");
	}

	@Test
	void payAmount() throws Exception {
		when(request.getUserPrincipal()).thenReturn(principal);
		when(principal.getName()).thenReturn("user@gmail.com");
		DBUser dBUser = new DBUser();
		when(dBUserRepository.findByMail("user@gmail.com")).thenReturn(dBUser);
		
		Pay pay = new Pay();
		pay.setAmount(10f);
		pay.setIdFriend("1");
		
		String page = transferController.payAmount(pay, result, request);
		
		assertThat(page).isEqualTo("transfer-success");
	}
	
	@Test
	void payAmountWithNotEnoughBalance() throws Exception {
		when(request.getUserPrincipal()).thenReturn(principal);
		when(principal.getName()).thenReturn("user@gmail.com");
		DBUser dBUser = new DBUser();
		when(dBUserRepository.findByMail("user@gmail.com")).thenReturn(dBUser);
		when(dBUserRepository.getBalance(any())).thenReturn(5f);

		Pay pay = new Pay();
		pay.setAmount(10f);
		pay.setIdFriend("1");
		
		transferController.payAmount(pay, result, request);
		
		verify(result).rejectValue("amount", null, "Your current balance is 5.0. You don't have enough money!");
		
		
	}

}

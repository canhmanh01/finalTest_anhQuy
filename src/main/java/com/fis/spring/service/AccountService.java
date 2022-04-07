package com.fis.spring.service;

import java.util.List;

import com.fis.spring.dto.ResponseDTO;
import com.fis.spring.entity.Account;

public interface AccountService {
	List<Account> getAllAccounts();
	
	List<Account> findAllByCustomer(Long customerId);
	
	List<Account> findAllAccountOderbyAccountNumber(Long customerId);

	List<Account> getAllAccountOderbyAccountNumber1(Long customerId);
	
	ResponseDTO addaccount(Account acount);

	ResponseDTO updateaccount(Account account);

	void deleteaccount(long id);

	Account findbyId(Long id);

}

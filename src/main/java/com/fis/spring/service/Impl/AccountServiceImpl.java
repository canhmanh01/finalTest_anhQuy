package com.fis.spring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.spring.dto.ResponseDTO;
import com.fis.spring.entity.Account;
import com.fis.spring.repo.AccountRepo;
import com.fis.spring.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepo accountrepo;

	@Override
	public ResponseDTO addaccount(Account acount) {
		
		ResponseDTO respo = new ResponseDTO();
		String massage = "accountNumber is exists! or accountNumber small 13";
		if (accountrepo.existsByAccountNumber(acount.getAccountNumber()) || acount.getAccountNumber().length() < 13) {
			respo.setCode("error");
			respo.setMassage(massage);
			return respo;
		} else {

			acount = accountrepo.save(acount);
			respo.setCode("success");
			respo.setMassage("create successfully!");
			respo.setData(acount);
			return respo;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public ResponseDTO updateaccount(Account account) {
		ResponseDTO respo = new ResponseDTO();
		if (accountrepo.findById(account.getId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage("Id is not exstis");
			return respo;
		}
		account.setAccountNumber(account.getAccountNumber());
		account.setBalance(account.getBalance());
		account.setStatus(account.getStatus());
		respo.setCode("succses");
		respo.setMassage("Update succsesfully!");
		respo.setData(respo);

		return respo;
	}

	@Override
	public void deleteaccount(long id) {
		// TODO Auto-generated method stub
		
		accountrepo.deleteById(id);

	}

	@Override
	public Account findbyId(Long id) {
		// TODO Auto-generated method stub
		return accountrepo.getById(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountrepo.findAll();
	}

	@Override
	public List<Account> findAllByCustomer(Long customerId) {
		// TODO Auto-generated method stub
		return accountrepo.findAllByCustomerId(customerId);
	}

	@Override
	public List<Account> findAllAccountOderbyAccountNumber(Long customerId) {
		// TODO Auto-generated method stub
		return accountrepo.findAllAccountOderbyAccountNumber(customerId);
	}

	@Override
	public List<Account> getAllAccountOderbyAccountNumber1(Long customerId) {
		// TODO Auto-generated method stub
		return accountrepo.getAllAccountOderbyAccountNumber1(customerId);
	}

}

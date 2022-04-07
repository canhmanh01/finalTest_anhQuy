package com.fis.spring.service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.spring.constant.CONSTANT;
import com.fis.spring.dto.ChuyentienDto;
import com.fis.spring.entity.Account;
import com.fis.spring.entity.Transaction;
import com.fis.spring.repo.AccountRepo;
import com.fis.spring.repo.TransactionRepo;
import com.fis.spring.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepo transactionRepo;
	
	@Autowired
	AccountRepo accountRepo;

	@Override
	public Transaction Chuyentien(ChuyentienDto chuyentienDto) {
		
		Account fromAccount= accountRepo.findById(chuyentienDto.getFromAccountId()).orElse(null);
		
		
		Account toAccount= accountRepo.findById(chuyentienDto.getToAccountId()).orElse(null);	
		
		Transaction transaction = new Transaction();
		
		transaction.setTransactionDate(chuyentienDto.getTransactionDate());
		
		transaction.setAmount(chuyentienDto.getAmount());
		
		transaction.setContent(chuyentienDto.getContent());
		
		transaction.setFromAccount(fromAccount);
		
		transaction.setToAccount(toAccount);
		
		if(fromAccount.getStatus() != CONSTANT.ACCOUNT_STATUS_HIEU_LUC || toAccount.getStatus() != CONSTANT.ACCOUNT_STATUS_HIEU_LUC) {
			
			transaction.setErrorReason("Tai khoan den hoac di khong con hieu luc");
			transaction.setStatus(CONSTANT.TRANSACTION_STATUS_FAIL);
		}
		else if(fromAccount.getBalance() < chuyentienDto.getAmount()) {
			
			transaction.setErrorReason("Tai khoan nguon khong du tien");
			transaction.setStatus(CONSTANT.TRANSACTION_STATUS_FAIL);
		} else {
			
			fromAccount.setBalance(fromAccount.getBalance() - chuyentienDto.getAmount());
			toAccount.setBalance(toAccount.getBalance() + chuyentienDto.getAmount());
			transaction.setStatus(CONSTANT.TRANSACTION_STATUS_SUCCESS);
			
		}
		return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> listTransaction(String from, String to) {
		 LocalDateTime localDatefrom = null;
	        LocalDateTime localDateto = null;
	        if (from != null && !from.isEmpty()) {
	            String[] listdate = from.split("-");
	            localDatefrom = LocalDateTime.of(Integer.parseInt(listdate[2]), Integer.parseInt(listdate[1]),
	                    Integer.parseInt(listdate[0]), 0, 0);
	        }
	        if (to != null && !to.isEmpty()) {
	            String[] listdate = to.split("-");
	            localDateto = LocalDateTime.of(Integer.parseInt(listdate[2]), Integer.parseInt(listdate[1]),
	                    Integer.parseInt(listdate[0]), 0, 0);
	        }
	        return transactionRepo.listTransaction(localDatefrom, localDateto);
	}


}

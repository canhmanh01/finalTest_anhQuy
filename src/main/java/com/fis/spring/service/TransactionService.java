package com.fis.spring.service;

import java.util.List;

import com.fis.spring.dto.ChuyentienDto;
import com.fis.spring.entity.Transaction;

public interface TransactionService {
	
	Transaction Chuyentien(ChuyentienDto chuyentienDto);
	
	
//    List<Transaction> findByFromAccount(Account account);  .
	
	List<Transaction> listTransaction(String from, String to);

}

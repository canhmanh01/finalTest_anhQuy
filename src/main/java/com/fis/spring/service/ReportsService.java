package com.fis.spring.service;

import java.util.List;

import com.fis.spring.entity.Transaction;

public interface ReportsService {
	
	List<Transaction> listTransactionReportByTime(String from, String to);

}

package com.fis.spring.service.Impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.spring.entity.Transaction;
import com.fis.spring.exception.AException;
import com.fis.spring.repo.ReportsRepo;
import com.fis.spring.service.ReportsService;

@Service
public class ReportsServiceIpml implements ReportsService {


	@Autowired
	ReportsRepo reportsRepo;




	@Override
	public List<Transaction> listTransactionReportByTime(String from, String to) {
		// TODO Auto-generated method stub
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
		long daysBetween = ChronoUnit.DAYS.between(localDatefrom, localDateto);
		if (daysBetween > 60)
			throw new AException("Error", "beyond time");
		return reportsRepo.listTransaction(localDatefrom, localDateto);
	}
}

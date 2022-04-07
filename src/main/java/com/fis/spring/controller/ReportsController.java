package com.fis.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.spring.entity.Transaction;
import com.fis.spring.service.ReportsService;

@RestController
@RequestMapping("/reports")
public class ReportsController {
	
	@Autowired
	ReportsService reportsService;
	
	@GetMapping(value = "/report")
	@ResponseBody
	public List<Transaction> getTransaction(@RequestParam(defaultValue = "empty") String from,
			@RequestParam(defaultValue = "empty") String to) {

		return reportsService.listTransactionReportByTime(from, to);

	}

}

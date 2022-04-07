package com.fis.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.spring.dto.ChuyentienDto;
import com.fis.spring.entity.Transaction;
import com.fis.spring.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping()
	@ResponseBody
    public ResponseEntity<?> createTransaction(@RequestBody ChuyentienDto chuyentienDto) {
        return ResponseEntity.ok(transactionService.Chuyentien(chuyentienDto));
    }
	
	@GetMapping(value = "/")
	@ResponseBody
    public List<Transaction> getTransaction(@RequestParam(defaultValue = "empty") String from,
            @RequestParam(defaultValue = "empty") String to) {
        return transactionService.listTransaction(from, to);
    }

}

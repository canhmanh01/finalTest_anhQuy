package com.fis.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.spring.entity.Account;
import com.fis.spring.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.addaccount(account));
	}
	
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.updateaccount(account));
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable (name ="id") Long accountId){
		accountService.deleteaccount(accountId);
		return new ResponseEntity<String>("delete success",HttpStatus.OK);
		
//		return ResponseEntity.ok(accountService.deleteaccount(accountId));
		
	}
	@GetMapping()
	@ResponseBody
	public ResponseEntity<?> getAllAccounts() {

		return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
	}
}

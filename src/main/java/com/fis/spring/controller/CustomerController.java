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

import com.fis.spring.entity.Customer;
import com.fis.spring.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.addcustomer(customer));
	}
	
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.updatecustomer(customer));
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable (name ="id") Long id){
		customerService.deletecustomer(id);
		return new ResponseEntity<String>("delete success",HttpStatus.OK);
		
//		return ResponseEntity.ok(accountService.deleteaccount(accountId));
		
	}
	@GetMapping()
	@ResponseBody
	public ResponseEntity<?> getAllAccounts() {

		return new ResponseEntity<>(customerService.customersAllList(), HttpStatus.OK);
	}

}

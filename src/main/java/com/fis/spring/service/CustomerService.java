package com.fis.spring.service;

import java.util.List;

import com.fis.spring.dto.ResponseDTO;
import com.fis.spring.entity.Customer;

public interface CustomerService {
	List<Customer> customersAllList();
	
	ResponseDTO addcustomer(Customer customer);

	ResponseDTO updatecustomer(Customer customer);

	void deletecustomer(Long id);

	Customer findById(Long id);

	

}

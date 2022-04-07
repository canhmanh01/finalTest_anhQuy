package com.fis.spring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.spring.dto.ResponseDTO;
import com.fis.spring.entity.Customer;
import com.fis.spring.repo.CustomerRepo;
import com.fis.spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public ResponseDTO addcustomer(Customer customer) {
		ResponseDTO respon = new ResponseDTO();
		String massage= "Customer name must not exceed 100 characters";
		String massage1= "The length of the proof number should not exceed 10 characters";
		if (customerRepo.existsByName(customer.getName())||customer.getName().length() < 100 ) {
			respon.setCode("error");
			respon.setMassage(massage);
			return respon;
					
		} 
			
	   if (customerRepo.existsByIdentityNo(customer.getIdentityNo())||customer.getIdentityNo().length() < 13) {
		   respon.setCode("error");
			respon.setMassage(massage1);
			return respon;
		
	}
		customer = customerRepo.save(customer);
		respon.setCode("success");
		respon.setMassage("create successfully!");
		respon.setData(customer);
		return respon;
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseDTO updatecustomer(Customer customer) {
		ResponseDTO respo = new ResponseDTO();
		if (customerRepo.findById(customer.getId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage("Id is not exists");
			return respo;
		}
		customer.setName(customer.getName());
		customer.setAddress(customer.getAddress());
		customer.setCustomerType(customer.getCustomerType());
		customer.setIdentityNo(customer.getIdentityNo());
		customer.setSatus(customer.getSatus());
		respo.setCode("success");
		respo.setMassage("create successfully!");
		respo.setData(customer);
		return respo;
	}

	@Override
	public void deletecustomer(Long id) {
		// TODO Auto-generated method stub
		
		customerRepo.deleteById(id);

	}

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return customerRepo.getById(id);
	}

	@Override
	public List<Customer> customersAllList() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}

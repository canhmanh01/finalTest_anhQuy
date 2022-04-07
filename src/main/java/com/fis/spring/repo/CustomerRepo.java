package com.fis.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.spring.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	Customer findByName (String name);
	
	Customer findByIdentityNo(String identityNo);

	boolean existsByName(String name);
	
	boolean existsByIdentityNo(String identityNo);
}

package com.fis.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fis.spring.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	Account findByAccountNumber(String accountNumber);

	boolean existsByAccountNumber(String accountNumber);

	List<Account> findAllByCustomerId(Long customerid);
	
	@Query(value = "SELECT account FROM Account account WHERE " + "account.status=1"
			+ "Oderby accountNumber", nativeQuery = true)
	List<Account> findAllAccountOderbyAccountNumber(Long customerId);

	// lấy ra danh sách account hết hiệu lực theo customerId truyền vào!
	@Query(value = "SELECT account FROM Account account WHERE " + "account.status !=1"
			+ "Oderby accountNumber", nativeQuery = true)
	List<Account> getAllAccountOderbyAccountNumber1(Long customerId);
}

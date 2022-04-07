package com.fis.spring.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fis.spring.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	
//	List<Transaction> findByTransactionDateBetween(LocalDateTime start, LocalDateTime end);
	
	@Query("SELECT u FROM Transaction u WHERE u.transactionDate between ?1 and  ?2 ORDER BY u.transactionDate DESC")
	List<Transaction> listTransaction(LocalDateTime from, LocalDateTime to);

	


	
//	Transaction findByToaccount (Long toAccount);
//	
//	Transaction findByfromAccount (Long fromAccount);

}

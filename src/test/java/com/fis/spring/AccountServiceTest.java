package com.fis.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.apache.catalina.authenticator.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.spring.dto.ResponseDTO;
import com.fis.spring.entity.Account;
import com.fis.spring.entity.Customer;
import com.fis.spring.exception.AException;
import com.fis.spring.repo.AccountRepo;
import com.fis.spring.repo.CustomerRepo;
import com.fis.spring.service.Impl.AccountServiceImpl;



@SpringBootTest
public class AccountServiceTest {
	@InjectMocks
	AccountServiceImpl accountService;
	
	@Mock
	AccountRepo accountRepo;
	
	@Mock
	CustomerRepo customerRepo;
	
	@Test	
	void add_success() {
		Account account=new Account();
		account.setAccountNumber("1234567890123");
		Optional<Customer> e =Optional.ofNullable(new Customer());
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		Mockito.when(accountRepo.findByAccountNumber("1234567890123")).thenReturn(null);
		Mockito.when(customerRepo.findById((long) 1)).thenReturn(e);
		ResponseDTO kq=accountService.addaccount(account);
		assertEquals(account, kq);
	}
	
	@Test	
	void add_with_value_null() {
		Account account=new Account();
		account.setAccountNumber("1234567890123");
		Optional<Customer> e =Optional.ofNullable(new Customer());
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		Mockito.when(accountRepo.findByAccountNumber("1234567890123")).thenReturn(null);
		Mockito.when(customerRepo.findById((long) 1)).thenReturn(e);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=accountService.addaccount(account);
	    });
	    String expectedMessage = "Các trường AccountNumber, CustomerId, Balance không được null";
	    String expectedCode = Constants.DEFAULT_JAAS_CONF;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	@Test	
	void add_with_accountNumber_value_false() {
		Account account=new Account();
		account.setAccountNumber("1234567890123");
		Optional<Customer> e =Optional.ofNullable(new Customer());
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		Mockito.when(accountRepo.findByAccountNumber("12345678901231")).thenReturn(null);
		Mockito.when(customerRepo.findById((long) 1)).thenReturn(e);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=accountService.addaccount(account);
	    });
	    String expectedMessage = "AccountNumber phải có độ dài bằng 13 và không có khoảng trắng";
	    String expectedCode = Constants.DEFAULT_JAAS_CONF;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	@Test	
	void add_with_balance_value_false() {
		Account account=new Account();
		account.setAccountNumber("1234567890123");
		Optional<Customer> e =Optional.ofNullable(new Customer());
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		Mockito.when(accountRepo.findByAccountNumber("1234567890123")).thenReturn(null);
		Mockito.when(customerRepo.findById((long) 1)).thenReturn(e);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=accountService.addaccount(account);
	    });
	    String expectedMessage = "Balance phải >= 0";
	    String expectedCode = Constants.DEFAULT_JAAS_CONF;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	@Test	
	void add_but_duplicate() {
		Account account=new Account();
		account.setAccountNumber("1234567890123");
		Optional<Customer> e =Optional.ofNullable(new Customer());
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		Mockito.when(accountRepo.findByAccountNumber("1234567890123")).thenReturn(new Account());
		Mockito.when(customerRepo.findById((long) 1)).thenReturn(e);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=accountService.addaccount(account);
	    });
	    String expectedMessage = "Account này đã tồn tại";
	    String expectedCode = Constants.DEFAULT_JAAS_CONF;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	@Test	
	void add_but_customer_not_found() {
		Account account=new Account();
		account.setAccountNumber("1234567890123");
		Optional<Customer> e =Optional.ofNullable(null);
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		Mockito.when(accountRepo.findByAccountNumber("1234567890123")).thenReturn(null);
		Mockito.when(customerRepo.findById((long) 1)).thenReturn(e);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=accountService.addaccount(account);
	    });
	    String expectedMessage = "Customer này không tồn tại";
	    String expectedCode = Constants.DEFAULT_JAAS_CONF;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	
}

package com.fis.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.tomcat.websocket.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.spring.dto.ResponseDTO;
import com.fis.spring.entity.Customer;
import com.fis.spring.exception.AException;
import com.fis.spring.repo.CustomerRepo;
import com.fis.spring.service.Impl.CustomerServiceImpl;



@SpringBootTest
public class CustomerServiceTest {
	@Mock
	CustomerRepo customerRepo;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Test	
	void add_success() {
		Customer customer=new Customer();
		customer.setCustomerType("1234567890");
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		Mockito.when(customerRepo.findByIdentityNo("1234567890")).thenReturn(null);
		ResponseDTO kq=customerService.addcustomer(customer);
		assertEquals(customer, kq);
	}
	
	@Test	
	void add_with_value_null() {
		Customer customer=new Customer();
		customer.setCustomerType("1234567890");
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		Mockito.when(customerRepo.findByIdentityNo("1234567890")).thenReturn(null);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=customerService.addcustomer(customer);
	    });
	    String expectedMessage = "Các trường Name, BirthDay, Address, IndentityNo, CustomerType, Status không được null";
	    String expectedCode = Constants.AUTHORIZATION_HEADER_NAME;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	@Test	
	void add_with_name_value_false() {
		Customer customer=new Customer();
		customer.setCustomerType("1234567890");
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		Mockito.when(customerRepo.findByIdentityNo("1234567890")).thenReturn(null);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=customerService.addcustomer(customer);
	    });
	    String expectedMessage = "Name phải có độ dài nhở hơn 100";
	    String expectedCode = Constants.AUTHORIZATION_HEADER_NAME;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	@Test	
	void add_with_indentityNo_value_false() {
		Customer customer=new Customer();
		customer.setCustomerType("1234567890");
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		Mockito.when(customerRepo.findByIdentityNo("12345678901")).thenReturn(null);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=customerService.addcustomer(customer);
	    });
	    String expectedMessage = "IndentityNo phải có độ dài bằng 10";
	    String expectedCode = Constants.AUTHORIZATION_HEADER_NAME;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	@Test	
	void add_with_mobile_value_false() {
		Customer customer=new Customer();
		customer.setCustomerType("1234567890");
		customer.setMobile("1");
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		Mockito.when(customerRepo.findByIdentityNo("1234567890")).thenReturn(null);
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=customerService.addcustomer(customer);
	    });
	    String expectedMessage = "Mobile phải có độ dài bằng 10 hoặc bằng 9";
	    String expectedCode = Constants.AUTHORIZATION_HEADER_NAME;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	@Test	
	void add_but_duplicate() {
		Customer customer=new Customer();
		customer.setCustomerType("1234567890");
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		Mockito.when(customerRepo.findByIdentityNo("1234567890")).thenReturn(new Customer());
		AException exception = assertThrows(AException.class, () -> {
			ResponseDTO kq=customerService.addcustomer(customer);
	    });
	    String expectedMessage = "Customer này đã tồn tại";
	    String expectedCode = Constants.AUTHORIZATION_HEADER_NAME;
	    assertEquals(expectedMessage, exception.getMessage());
	    assertEquals(expectedCode, exception.getCode());
	}
	
	
	
	
	
}

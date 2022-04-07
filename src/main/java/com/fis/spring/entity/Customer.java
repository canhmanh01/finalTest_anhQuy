package com.fis.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length = 100)
	private String name;

	private LocalDateTime birthday;
	
	
	private String address;

	private String identityNo;

	@Column(length = 10)
	private String mobile;

	private String customerType;

	private int satus;

	private LocalDateTime createDatetime;

	private LocalDateTime updateDatetime;



}

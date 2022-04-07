package com.fis.spring.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuyentienDto {

	private Long fromAccountId;
	private Long toAccountId;
	private LocalDateTime transactionDate;
	private Double amount;
	private String content;
}

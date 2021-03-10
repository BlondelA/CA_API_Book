package com.poc.controller.book.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookUpdate {
	private String title;
	private String autor_uuid;
	private BigDecimal price;
	private int stock;
}

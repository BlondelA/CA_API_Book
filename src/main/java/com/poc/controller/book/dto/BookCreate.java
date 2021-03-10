package com.poc.controller.book.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookCreate {
	@NotBlank
	private String title;
	@NotBlank
	private String autor_uuid;
	private BigDecimal price;
}

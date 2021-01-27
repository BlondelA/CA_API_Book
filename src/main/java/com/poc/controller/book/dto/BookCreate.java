package com.poc.controller.book.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BookCreate {
	@NotBlank
	private String title;
	@NotBlank
	private String autorUUID;

}

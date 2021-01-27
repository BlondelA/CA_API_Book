package com.poc.controller.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BookCreate {
	@NotBlank
	private String Title;
	private String Autor;

}

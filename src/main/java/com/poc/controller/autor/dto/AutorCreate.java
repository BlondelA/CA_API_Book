package com.poc.controller.autor.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AutorCreate {
	@NotBlank
	private String Name;
	private String FirstName;
}

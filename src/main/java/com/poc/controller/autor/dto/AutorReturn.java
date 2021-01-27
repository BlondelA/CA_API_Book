package com.poc.controller.autor.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AutorReturn {
	private UUID uuid;
	private String Name;
	private String FirstName;
}

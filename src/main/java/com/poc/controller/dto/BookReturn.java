package com.poc.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class BookReturn {
	private UUID uuid;
	private String autor;
	private String title;
}

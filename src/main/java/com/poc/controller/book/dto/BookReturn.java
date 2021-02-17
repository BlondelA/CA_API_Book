package com.poc.controller.book.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class BookReturn {
	private UUID uuid;
	private String title;
	private String autorUUID;
	private Double price;
}

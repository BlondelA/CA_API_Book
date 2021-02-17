package com.poc.controller.book.dto;

import lombok.Data;

@Data
public class BookUpdate {
	private String title;
	private String autorUUID;
	private Double price;
}

package com.poc.entity;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column(unique = true)
	private UUID uuid;

	@Lob
	private String title;

	@Lob
	private String autor_uuid;

	@Lob
	private Double price;

	@Lob
	private int stock;
}

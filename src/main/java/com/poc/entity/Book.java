package com.poc.entity;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "posts")
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
	private String autor;

//	@Lob
//	private Date date;
}

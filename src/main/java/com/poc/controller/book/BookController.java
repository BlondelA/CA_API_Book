package com.poc.controller.book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.controller.book.dto.BookCreate;
import com.poc.controller.book.dto.BookReturn;
import com.poc.controller.book.dto.BookUpdate;
import com.poc.entity.Book;
import com.poc.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	private final BookService bookService;
	private final ModelMapper modelMapper;

	public BookController(BookService bookService, ModelMapper modelMapper) {
		this.bookService = bookService;
		this.modelMapper = modelMapper;
	}

	@PostMapping("")
	public ResponseEntity<BookReturn> createBook(@RequestBody @Validated BookCreate book) {
		Optional<BookReturn> result = Optional.of(book)
				.map(entity -> modelMapper.map(entity, Book.class))
				.flatMap(bookService::createBook)
				.map(entity -> modelMapper.map(entity, BookReturn.class));
		return ResponseEntity.of(result);
	}

	@GetMapping("")
	public ResponseEntity<List<BookReturn>> getAllBooks() {
		List<BookReturn> bookReturns = bookService.getAllBooks().stream()
				.map(entity -> modelMapper.map(entity, BookReturn.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(bookReturns);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<BookReturn> getBook(@PathVariable UUID uuid) {
		Optional<BookReturn> result = bookService.getBook(uuid)
				.map(entity -> modelMapper.map(entity, BookReturn.class));
		return ResponseEntity.of(result);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<BookReturn> updateBook(@PathVariable UUID uuid, @RequestBody @Validated BookUpdate book) {
		Optional<BookReturn> result = Optional.of(book)
				.map(entity -> modelMapper.map(entity, Book.class))
				.flatMap(p -> bookService.updateBook(uuid, p))
				.map(entity -> modelMapper.map(entity, BookReturn.class));
		return ResponseEntity.of(result);
	}
}

package com.poc.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import com.poc.entity.Autor;
import org.springframework.stereotype.Service;

import com.poc.dao.BookDao;
import com.poc.entity.Book;

import static java.util.function.Predicate.not;

@Service
public class BookService {
	private final BookDao bookDao;

	public BookService(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	/**
	 * Récupère l'ensemble des livres
	 * @return un Stream de livres
	 */
	public Stream<Book> getAllBooks() {
		return StreamSupport.stream(bookDao.findAll()
				.spliterator(), false);
	}

	/**
	 * Récupère un livre
	 * @param uuid l'identification du livre
	 * @return le livre
	 */
	public Optional<Book> getBook(UUID uuid) {
		return bookDao.findByUuid(uuid);
	}

	/**
	 * Crée un livre
	 *
	 * @param book le livre à sauvegarder
	 * @return le livre
	 */
	public Optional<Book> createBook(Book book) {
		return Optional.of(book)
				.map(bookDao::save);
	}

	/**
	 * Modifie un livre
	 * @param uuid l'identifiant du message
	 * @param newBook le livre à modifier
	 * @return le livre
	 */
	public Optional<Book> updateBook(UUID uuid, Book newBook) {
		try {
			Book book = bookDao.findByUuid(uuid)
					.orElseThrow(EntityNotFoundException::new);
			Optional.of(newBook)
					.map(Book::getTitle)
					.filter(not(String::isBlank))
					.ifPresent(book::setTitle);
			Optional.of(newBook)
					.map(Book::getAutorUUID)
					.filter(not(String::isBlank))
					.ifPresent(book::setAutorUUID);
			Optional.of(newBook)
					.map(Book::getStock)
					.filter(stock -> stock!=null)
					.ifPresent(book::setStock);
			return Optional.of(book)
					.map(bookDao::save);
		} catch (EntityNotFoundException e) {
			return Optional.empty();
		}
	}
}

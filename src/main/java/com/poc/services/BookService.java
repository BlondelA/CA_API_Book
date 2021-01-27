package com.poc.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

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
	 * Récupère l'ensemble des publications
	 * @return un Stream de publications
	 */
	public Stream<Book> getAllBooks() {
		return StreamSupport.stream(bookDao.findAll()
				.spliterator(), false);
	}

	/**
	 * Récupère une publication
	 * @param uuid l'identification de la publication
	 * @return la publication
	 */
	public Optional<Book> getBook(UUID uuid) {
		return bookDao.findByUuid(uuid);
	}

	/**
	 * Crée une publication
	 *
	 * @param book la publication à sauvegarder
	 * @return la publication
	 */
	public Optional<Book> createBook(Book book) {
		return Optional.of(book)
				.map(bookDao::save);
	}

	/**
	 * Modifie une publication
	 * @param uuid l'identifiant du message
	 * @param newBook la publication à modifier
	 * @return la publication
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
					.map(Book::getAutor)
					.filter(not(String::isBlank))
					.ifPresent(book::setAutor);
//			Optional.of(newBook)
//					.map(Book::getDate)
//					.filter(not(Date::))
//					.ifPresent(book::setDate);
			return Optional.of(book)
					.map(bookDao::save);
		} catch (EntityNotFoundException e) {
			return Optional.empty();
		}
	}
}

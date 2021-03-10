package com.poc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	 * Récupère l'ensemble des livres
	 * @return un Stream de livres
	 */
	public List<Book> getAllBooks(){
//		return StreamSupport.stream(bookDao.findAll().spliterator(), false)
//				.collect(Collectors.toList());
		List<Book> books = new ArrayList<>();
     	bookDao.findAll().forEach(books::add);
     	System.out.println(books);
		return books;
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
					.map(Book::getAutor_uuid)
					.filter(not(String::isBlank))
					.ifPresent(book::setAutor_uuid);
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

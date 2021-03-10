package com.poc.steps.book;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import com.poc.dao.BookDao;
import com.poc.entity.Book;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Soit;

import static org.junit.Assert.assertTrue;

public class BookDaoStep {
	private final BookDao bookDao;

	public BookDaoStep(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	/**
	 * @param books la liste des livres sous forme d'un tableau avec les données suivantes :<br/>
	 *              ID : identifiant de la publication (Long)<br/>
	 *              TITLE : titre du livre (String)
	 *              AUTOR : auteur du livre (String)
	 */
	@Soit("les livres suivants :")
	public void initBooks(List<Map<String, String>> books) {
		books.forEach(map -> {
			var book = new Book();
			Optional.of("UUID").map(map::get).map(UUID::fromString).ifPresent(book::setUuid);
			Optional.of("TITLE").map(map::get).ifPresent(book::setTitle);
			Optional.of("AUTOR").map(map::get).ifPresent(book::setAutor_uuid);
			bookDao.save(book);
		});
	}

	@Alors("un livre existe avec le titre suivant : {string}")
	public void bookWithTitle(String text) {
		assertTrue(StreamSupport.stream(bookDao.findAll()
				.spliterator(), false)
				.anyMatch(book -> text.equals(book.getTitle())));
	}
}

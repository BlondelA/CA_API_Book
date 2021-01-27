package com.poc.steps.autor;

import com.poc.dao.AutorDao;
import com.poc.dao.BookDao;
import com.poc.entity.Autor;
import com.poc.entity.Book;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Soit;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertTrue;

public class AutorDaoStep {
	private final AutorDao autorDao;

	public AutorDaoStep(AutorDao autorDao) {
		this.autorDao = autorDao;
	}

	/**
	 * @param books la liste des livres sous forme d'un tableau avec les données suivantes :<br/>
	 *              ID : identifiant de la publication (Long)<br/>
	 *              TITLE : titre du livre (String)
	 *              AUTOR : auteur du livre (String)
	 */
	@Soit("les auteurs suivants :")
	public void initBooks(List<Map<String, String>> books) {
		books.forEach(map -> {
			var autor = new Autor();
			Optional.of("UUID").map(map::get).map(UUID::fromString).ifPresent(autor::setUuid);
			Optional.of("NAME").map(map::get).ifPresent(autor::setName);
			Optional.of("FIRSTNAME").map(map::get).ifPresent(autor::setFirstName);
			autorDao.save(autor);
		});
	}
}

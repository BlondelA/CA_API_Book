package com.poc.services;

import com.poc.dao.AutorDao;
import com.poc.entity.Autor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.function.Predicate.not;

@Service
public class AutorService {
	private final AutorDao autorDao;

	public AutorService(AutorDao autorDao) {
		this.autorDao = autorDao;
	}

	/**
	 * Récupère l'ensemble des auteurs
	 * @return un Stream de auteurs
	 */
	public Stream<Autor> getAllAutors() {
		return StreamSupport.stream(autorDao.findAll()
				.spliterator(), false);
	}

	/**
	 * Récupère un auteur
	 * @param uuid l'identification du auteur
	 * @return le auteur
	 */
	public Optional<Autor> getAutor(UUID uuid) {
		return autorDao.findByUuid(uuid);
	}

	/**
	 * Crée un auteur
	 *
	 * @param book le auteur à sauvegarder
	 * @return le auteur
	 */
	public Optional<Autor> createAutor(Autor book) {
		return Optional.of(book)
				.map(autorDao::save);
	}

	/**
	 * Modifie un auteur
	 * @param uuid l'identifiant du message
	 * @param newAutor le auteur à modifier
	 * @return le auteur
	 */
	public Optional<Autor> updateAutor(UUID uuid, Autor newAutor) {
		try {
			Autor book = autorDao.findByUuid(uuid)
					.orElseThrow(EntityNotFoundException::new);
			Optional.of(newAutor)
					.map(Autor::getName)
					.filter(not(String::isBlank))
					.ifPresent(book::setName);
			Optional.of(newAutor)
					.map(Autor::getFirstName)
					.filter(not(String::isBlank))
					.ifPresent(book::setFirstName);
			return Optional.of(book)
					.map(autorDao::save);
		} catch (EntityNotFoundException e) {
			return Optional.empty();
		}
	}
}

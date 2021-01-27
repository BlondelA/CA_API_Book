package com.poc.steps;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import com.poc.dao.PostDao;
import com.poc.entity.Book;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Soit;

import static org.junit.Assert.assertTrue;

public class PostDaoStep {
	private final PostDao postDao;

	public PostDaoStep(PostDao postDao) {
		this.postDao = postDao;
	}

	/**
	 * @param posts la liste des publications sous forme d'un tableau avec les données suivantes :<br/>
	 *              ID : identifiant de la publication (Long)<br/>
	 *              MESSAGE : message de la publication (String)
	 */
	@Soit("les publications suivantes :")
	public void initPosts(List<Map<String, String>> posts) {
		posts.forEach(map -> {
			var post = new Book();
			Optional.of("UUID").map(map::get).map(UUID::fromString).ifPresent(post::setUuid);
			Optional.of("MESSAGE").map(map::get).ifPresent(post::setMessage);
			postDao.save(post);
		});
	}

	@Alors("une publication existe avec le texte suivant : {string}")
	public void postWithText(String text) {
		assertTrue(StreamSupport.stream(postDao.findAll()
				.spliterator(), false)
				.anyMatch(book -> text.equals(book.getMessage())));
	}
}

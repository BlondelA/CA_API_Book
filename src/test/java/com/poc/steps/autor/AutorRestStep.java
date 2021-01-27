package com.poc.steps.autor;

import com.poc.common.TestContext;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AllArgsConstructor
public class AutorRestStep {
	private final TestContext context;
	private final MockMvc mvc;

	@Quand("on créé un livre contenant le titre suivant : {string}")
	public void createBook(String text) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/books").content("{ \"title\":\"" + text + "\" }")
			.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Quand("on consulte le livre {word}")
	public void getBook(String uuid) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/book/{id}", uuid)
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Quand("on modifie le livre {word} avec le titre {string}")
	public void onModifieLeLivreIdAvecLeMessage(String uuid, String text) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/books/{id}", uuid).content("{ \"title\":\"" + text + "\" }")
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Alors("le livre retourné contient le titre : {string}")
	public void bookHasTitle(String text) throws Exception {
		context.getResult()
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title", is(text)));
	}

	@Alors("les livres retournés contiennent l'auteur : {string}")
	public void bookHasAutor(String text) throws Exception {
		context.getResult()
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.autor", is(text)));
	}

	@Quand("on consulte la liste des livres")
	public void onConsulteLaListeDesLivres() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/books")
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Et("la liste retournée contient l'ensemble des livres suivants :")
	public void laListeRetourneeContientLEnsembleDesLivresSuivants(List<Map<String, String>> books)
			throws Exception {
		ResultActions result = context.getResult().andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

		String[] uuids = books.stream().map(map -> map.get("uuid")).toArray(String[]::new);
		String[] titles = books.stream().map(map -> map.get("title")).toArray(String[]::new);

		result.andExpect(jsonPath("$[*].uuid", contains(uuids)));
		result.andExpect(jsonPath("$[*].title", contains(titles)));
	}
}

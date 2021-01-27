package com.poc.steps;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.poc.common.TestContext;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import lombok.AllArgsConstructor;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AllArgsConstructor
public class PostRestStep {
	private final TestContext context;
	private final MockMvc mvc;

	@Quand("on créé une publication contenant le texte suivant : {string}")
	public void createPost(String text) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/posts").content("{ \"message\":\"" + text + "\" }")
			.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Quand("on consulte la publication {word}")
	public void getPost(String uuid) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/posts/{id}", uuid)
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Quand("on modifie la publication {word} avec le message {string}")
	public void onModifieLaPublicationIdAvecLeMessage(String uuid, String text) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/posts/{id}", uuid).content("{ \"message\":\"" + text + "\" }")
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Alors("la publication retournée contient le message : {string}")
	public void postHasText(String text) throws Exception {
		context.getResult()
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message", is(text)));
	}

	@Quand("on consulte la liste des publications")
	public void onConsulteLaListeDesPublications() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/posts")
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Et("la liste retournée contient l'ensemble des publications suivantes :")
	public void laPublicationRetourneeContientLEnsembleDesPublicationsSuivantes(List<Map<String, String>> posts)
			throws Exception {
		ResultActions result = context.getResult().andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

		String[] uuids = posts.stream().map(map -> map.get("uuid")).toArray(String[]::new);
		String[] texts = posts.stream().map(map -> map.get("text")).toArray(String[]::new);

		result.andExpect(jsonPath("$[*].uuid", contains(uuids)));
		result.andExpect(jsonPath("$[*].message", contains(texts)));
	}
}

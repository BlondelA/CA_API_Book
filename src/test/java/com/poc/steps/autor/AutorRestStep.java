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

	@Quand("on créé un auteur contenant le nom {string} et le prenom {string}")
	public void createAutor(String nom, String prenom) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/autors").content("{ \"name\":\"" + nom + "\" \"firstname\":\"" + prenom + "\" }")
			.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Quand("on créé un auteur contenant le nom suivant : {string}")
	public void createAutor(String nom) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/autors").content("{ \"name\":\"" + nom + "\" }")
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Quand("on consulte l'auteur {word}")
	public void getAutor(String uuid) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/autors/{id}", uuid)
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}


	@Quand("on modifie l'auteur {word} avec le nom {string}")
	public void onModifieLAuteurIdAvecLeNom(String uuid, String text) throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/autors/{id}", uuid).content("{ \"name\":\"" + text + "\" }")
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Alors("l'auteur retourné contient le nom : {string}")
	public void autorHasAutor(String text) throws Exception {
		context.getResult()
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", is(text)));
	}

	@Quand("on consulte la liste des auteurs")
	public void onConsulteLaListeDesAuteurs() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/autors")
				.headers(context.getHeaders());

		context.getRequestAttrs().forEach(request::requestAttr);

		context.setResult(mvc.perform(request.contentType(MediaType.APPLICATION_JSON)));
	}

	@Et("la liste retournée contient l'ensemble des auteurs suivants :")
	public void laListeRetourneeContientLEnsembleDesAuteursSuivants(List<Map<String, String>> autors)
			throws Exception {
		ResultActions result = context.getResult().andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

		String[] uuids = autors.stream().map(map -> map.get("uuid")).toArray(String[]::new);
		String[] names = autors.stream().map(map -> map.get("name")).toArray(String[]::new);
		String[] firstnames = autors.stream().map(map -> map.get("firstnames")).toArray(String[]::new);

		result.andExpect(jsonPath("$[*].uuid", contains(uuids)));
		result.andExpect(jsonPath("$[*].name", contains(names)));
		result.andExpect(jsonPath("$[*].firstname", contains(firstnames)));
	}
}

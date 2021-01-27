package com.poc.steps;

import com.poc.common.TestContext;

import io.cucumber.java.fr.Alors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CommunStep {
	private final TestContext context;

	public CommunStep(TestContext context) {
		this.context = context;
	}

	@Alors("la demande réussit")
	public void succeed() throws Exception {
		context.getResult().andExpect(status().isOk());
	}

	@Alors("la demande échoue avec un code {int}")
	public void failed(int code) throws Exception {
		context.getResult().andExpect(status().is(code));
	}
}

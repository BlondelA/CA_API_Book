package com.poc.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class TestContext {
	private Map<String, Object> objects;

	private HttpHeaders headers;
	private Map<String, Object> requestAttrs;

	@Setter
	private ResultActions result;

	public void init() {
		objects = new HashMap<>();
		headers = new HttpHeaders();
		requestAttrs = new HashMap<>();
	}
}
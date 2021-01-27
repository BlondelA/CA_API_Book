package com.poc.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber", glue = { "com.poc.common",
		"com.poc.steps" }, tags = "not @ignore")
public class CucumberTest {
}
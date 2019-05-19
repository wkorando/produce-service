package com.ibm.developer.producerservice;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ContractsBaseClass {

	@Autowired
	private ProduceController controller;

	@MockBean
	private ProduceRepo repo;

	@MockBean
	private ProduceService service;

	@Before
	public void before() throws Throwable {
		when(repo.findAll()).thenReturn(
				Arrays.asList(new Produce(1, "Apple", "Granny Smith", 100), 
						new Produce(2, "Apple", "Gala", 50),//
						new Produce(3, "Corn", "Sweet", 1000), //
						new Produce(4, "Pineapple", "", 300)));
		StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(controller);
		RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
	}

}

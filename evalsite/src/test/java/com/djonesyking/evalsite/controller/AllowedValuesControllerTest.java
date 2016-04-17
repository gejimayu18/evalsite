package com.djonesyking.evalsite.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class AllowedValuesControllerTest {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new AllowedValuesController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/rest/behaviors/pull").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"behaviorList\":[{\"name\":\"calm\",\"ticked\":false},{\"name\":\"friendly\",\"ticked\":false},{\"name\":\"hyper\",\"ticked\":false},{\"name\":\"excited\",\"ticked\":false},{\"name\":\"shy\",\"ticked\":false},{\"name\":\"fearful\",\"ticked\":false},{\"name\":\"unsure\",\"ticked\":false},{\"name\":\"easy to leash\",\"ticked\":false},{\"name\":\"difficult to leash\",\"ticked\":false},{\"name\":\"excited barking\",\"ticked\":false},{\"name\":\"unsure barking\",\"ticked\":false},{\"name\":\"aggressive barking\",\"ticked\":false},{\"name\":\"runs away\",\"ticked\":false},{\"name\":\"cowers in corner\",\"ticked\":false},{\"name\":\"won't move\",\"ticked\":false},{\"name\":\"had to be coaxed out\",\"ticked\":false},{\"name\":\"had to be carried out\",\"ticked\":false},{\"name\":\"other\",\"ticked\":false}]}")));
	}
}
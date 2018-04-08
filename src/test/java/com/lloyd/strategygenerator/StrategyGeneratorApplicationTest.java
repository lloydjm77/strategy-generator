package com.lloyd.strategygenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyGeneratorApplicationTest {

	@Autowired
	private RouterFunction<ServerResponse> routerFunction;

	private WebTestClient webTestClient;

	@Before
	public void setUp() {
		webTestClient = WebTestClient.bindToRouterFunction(routerFunction).build();
	}

	@Test
	public void should_generate_strategy() {
		webTestClient.get().uri("/strategy").exchange().expectStatus().is2xxSuccessful().expectBody(String.class);
	}
}

package com.lloyd.strategygenerator.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.lloyd.strategygenerator.configuration.properties.StrategyConfigurationProperties;
import com.lloyd.strategygenerator.configuration.properties.StrategyConfigurationProperties.Terms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * StrategyHandler
 */
@Component
public class StrategyHandler {

	@Autowired
	private StrategyConfigurationProperties strategyConfigurationProperties;

	public Mono<ServerResponse> generateStrategy(ServerRequest serverRequest) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(fromObject(produceStrategy(strategyConfigurationProperties)));
	}

	private String produceStrategy(StrategyConfigurationProperties strategyConfigurationProperties) {
		Terms terms = strategyConfigurationProperties.getTerms();

		Stack<String> nouns = createShuffledStackFromList(terms.getNouns());
		Stack<String> pluralNouns = createShuffledStackFromList(terms.getPluralNouns());
		Stack<String> adjectives = createShuffledStackFromList(terms.getAdjectives());

		return String.format(strategyConfigurationProperties.getText(), adjectives.pop(), indefinite(adjectives.pop()),
				nouns.pop(), pluralNouns.pop(), indefinite(nouns.pop()), adjectives.pop(), adjectives.pop(),
				adjectives.pop(), nouns.pop(), nouns.pop(), nouns.pop(), adjectives.pop(), indefinite(adjectives.pop()),
				nouns.pop(), pluralNouns.pop(), indefinite(nouns.pop()), nouns.pop(), pluralNouns.pop());
	}

	private <T> Stack<T> createShuffledStackFromList(List<T> input) {
		Stack<T> output = new Stack<>();
		output.addAll(input);
		Collections.shuffle(output);
		return output;
	}

	private String indefinite(String s) {
		return s.matches("^[aeiou].*") ? "an " + s : "a " + s;
	}
}
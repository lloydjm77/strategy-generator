package com.lloyd.strategygenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class StrategyGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrategyGeneratorApplication.class, args);
	}
}

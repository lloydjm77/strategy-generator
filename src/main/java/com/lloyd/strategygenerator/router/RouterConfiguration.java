package com.lloyd.strategygenerator.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.lloyd.strategygenerator.handler.StrategyHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(StrategyHandler strategyHandler) {
        return route(GET("/strategy"), strategyHandler::generateStrategy);
    }

}
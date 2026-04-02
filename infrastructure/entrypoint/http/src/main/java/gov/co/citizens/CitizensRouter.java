package gov.co.citizens;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import gov.co.citizens.CitizensHandler;

@Configuration
public class CitizensRouter {
    private static final String PATH = "/citizens";

    @Bean
    public RouterFunction<ServerResponse> routerCitizens(CitizensHandler handler){
        return route(GET(PATH+"/all"), handler::getAllCitizens);

    }



}
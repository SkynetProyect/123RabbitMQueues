package gov.co.emergencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import gov.co.emergencies.EmergenciesHandler;

@Configuration
public class EmergenciesRouter {
    private static final String PATH = "/emergencies";

    @Bean
    public RouterFunction<ServerResponse> routerEmergencies(EmergenciesHandler handler){
        return route(GET(PATH+"/all"), handler::getAllEmergencies)
                .andRoute(POST(PATH+"/create"), handler::createEmergency);

    }



}
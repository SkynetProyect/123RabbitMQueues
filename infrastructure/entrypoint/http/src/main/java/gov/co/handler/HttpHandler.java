package gov.co.handler;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import gov.co.citizen.Citizen;
import gov.co.emergency.Emergency;
import gov.co.citizen.usecase.CitizenUseCase;
import gov.co.emergency.usecase.EmergencyUsecase;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Component
public class HttpHandler {
    private final CitizenUseCase citizenUseCase;
    private final EmergencyUsecase emergencyUseCase;

    public HttpHandler(CitizenUseCase citizenUseCase, EmergencyUsecase emergencyUseCase){
        this.citizenUseCase = citizenUseCase;
        this.emergencyUseCase = emergencyUseCase;
    }

    public Mono<ServerResponse> createEmergency(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Emergency.class)
                .flatMap(emergency -> emergencyUseCase.save(emergency))
                .flatMap(savedEmergency -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(savedEmergency))
                .onErrorResume(Exception.class,
                        e -> ServerResponse.status(501).bodyValue(e.getMessage()));
    }
 
    public Mono<ServerResponse> getAllCitizens(ServerRequest serverRequest){

            return citizenUseCase.findAll().collectList()
                    .flatMap(citizen -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(citizen))
            .onErrorResume(Exception.class,
                    e -> ServerResponse.status(501).bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> getAllEmergencies(ServerRequest serverRequest){
            return emergencyUseCase.findAll().collectList()
                    .flatMap(emergency -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(emergency))
            .onErrorResume(Exception.class,
                    e -> ServerResponse.status(501).bodyValue(e.getMessage()));
    }

}
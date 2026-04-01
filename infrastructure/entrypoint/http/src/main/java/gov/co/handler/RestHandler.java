package gov.co.handler;


import gov.co.CitizenUsecase;
import gov.co.Emergency;
import gov.co.EmergencyUsecase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;


import reactor.core.publisher.Mono;

@Component
public class RestHandler {
    private final CitizenUsecase citizenUsecase;
    private final EmergencyUsecase emergencyUseCase;

    public RestHandler(CitizenUsecase citizenUsecase, EmergencyUsecase emergencyUseCase){
        this.citizenUsecase = citizenUsecase;
        this.emergencyUseCase = emergencyUseCase;
    }

    public Mono<ServerResponse> createEmergency(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Emergency.class)
                .flatMap(emergencyUseCase::save)
                .flatMap(savedEmergency -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(savedEmergency))
                .onErrorResume(Exception.class,
                        e -> ServerResponse.status(501).bodyValue(e.getMessage()));
    }
 
    public Mono<ServerResponse> getAllCitizens(ServerRequest serverRequest){

            return citizenUsecase.findAll().collectList()
                    .flatMap(citizen -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(citizen))
            .onErrorResume(Exception.class,
                    e -> ServerResponse.status(501).bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> getAllEmergencies(ServerRequest serverRequest){
            return emergencyUseCase.getAllEmergencies().collectList()
                    .flatMap(emergency -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(emergency))
            .onErrorResume(Exception.class,
                    e -> ServerResponse.status(501).bodyValue(e.getMessage()));
    }

}
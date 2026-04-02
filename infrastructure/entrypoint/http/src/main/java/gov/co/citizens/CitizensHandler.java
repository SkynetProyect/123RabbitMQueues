package gov.co.citizens;


import gov.co.CitizenUsecase;
import gov.co.Emergency;
import gov.co.EmergencyUsecase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;


import reactor.core.publisher.Mono;

@Component
public class CitizensHandler {
    private final CitizenUsecase citizenUsecase;
  

    public CitizensHandler(CitizenUsecase citizenUsecase){
        this.citizenUsecase = citizenUsecase;
    }


    public Mono<ServerResponse> getAllCitizens(ServerRequest serverRequest){

            return citizenUsecase.findAll().collectList()
                    .flatMap(citizen -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(citizen))
            .onErrorResume(Exception.class,
                    e -> ServerResponse.status(501).bodyValue(e.getMessage()));
    }

}
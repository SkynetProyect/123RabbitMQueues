package gov.co;

import gov.co.Citizen;
import gov.co.gateway.CitizenGateway;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public class CitizenUsecase{
    private final CitizenGateway gateway;

    public CitizenUsecase(CitizenGateway gateway){
        this.gateway = gateway;
    }

    public Mono<Citizen> getByIdentification(String identification, String kindof){
        return gateway.getByIdentification(identification, kindof);
    }
    public Flux<Citizen> findAll(){
        return gateway.findAll();
    }



}
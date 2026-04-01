package gov.co.gateway;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import gov.co.Citizen;

public interface CitizenGateway {

    public Mono<Citizen> getByIdentification(String identification, String kindof);
    public Flux<Citizen> findAll();

}
package gov.co.gateway;

import reactor.core.publisher.Mono;
import gov.co.Citizen;

public interface CitizenGateway {

    public Mono<Citizen> getByIdentification(String identification, String kindof);

}
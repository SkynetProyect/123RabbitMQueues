package gov.co.gateway;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import gov.co.Emergency;

public interface EmergencyGateway {

    public Mono<Emergency> getById(Long id);
    public Mono<Emergency> save(Emergency emergency);
    public Mono<Emergency> update(Emergency emergency);
    public Mono<Void> deleteById(Long id);
    public Flux<Emergency> getAllEmergencies();

}
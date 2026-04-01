package gov.co;

import gov.co.Emergency;
import gov.co.gateway.EmergencyGateway;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public class EmergencyUsecase{
    private final EmergencyGateway gateway;

    public EmergencyUsecase(EmergencyGateway gateway){
        this.gateway = gateway;
    }

    public Mono<Emergency> getById(Long id){
        return gateway.getById(id);
    }
    public Mono<Emergency> save(Emergency emergency){
        return gateway.save(emergency);
    }
    public Mono<Emergency> update(Emergency emergency){
        return gateway.update(emergency);}
    public Mono<Void> deleteById(Long id){
        return gateway.deleteById(id);}
    public Flux<Emergency> getAllEmergencies(){
        return gateway.getAllEmergencies();}



}
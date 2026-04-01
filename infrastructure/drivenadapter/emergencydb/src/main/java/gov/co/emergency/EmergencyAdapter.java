package gov.co.emergency;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import gov.co.Emergency;
import gov.co.gateway.EmergencyGateway;
import gov.co.emergency.repository.EmergencyRepository;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class EmergencyAdapter implements EmergencyGateway{

    private final EmergencyRepository citizenRepository;

    public EmergencyAdapter(EmergencyRepository citizenRepository){
        this.citizenRepository = citizenRepository;
    }
    
    @Override
    public Mono<Emergency> getById(Long id) {
        return citizenRepository.findById(id).map(entity -> new Emergency(entity.getId(), entity.getLat(), entity.getLon(), entity.getIdcitizen(), entity.fechaOcurrido(), entity.getUnitID()));
    }
    @Override
    public Mono<Emergency> save(Emergency emergency) {
        EmergencyEntity entity = new EmergencyEntity(emergency.getId(), emergency.getLat(), emergency.getLon(), emergency.getIdcitizen(), emergency.fechaOcurrido(), emergency.getUnitID());
        return citizenRepository.save(entity).map(savedEntity -> new Emergency(savedEntity.getId(), savedEntity.getLat(), savedEntity.getLon(), savedEntity.getIdcitizen(), savedEntity.fechaOcurrido(), savedEntity.getUnitID()));
    }
    @Override
    public Mono<Emergency> update(Emergency emergency) {
        EmergencyEntity entity = new EmergencyEntity(emergency.getId(), emergency.getLat(), emergency.getLon(), emergency.getIdcitizen(), emergency.fechaOcurrido(), emergency.getUnitID());
        return citizenRepository.save(entity).map(updatedEntity -> new Emergency(updatedEntity.getId(), updatedEntity.getLat(), updatedEntity.getLon(), updatedEntity.getIdcitizen(), updatedEntity.fechaOcurrido(), updatedEntity.getUnitID()));
    }
    @Override
    public Mono<Void> deleteById(Long id) {
        return citizenRepository.deleteById(id);
    }
    @Override
    public Flux<Emergency> getAllEmergencies() {
        return citizenRepository.findAll().map(entity -> new Emergency(entity.getId(), entity.getLat(), entity.getLon(), entity.getIdcitizen(), entity.fechaOcurrido(), entity.getUnitID()));
    }


}
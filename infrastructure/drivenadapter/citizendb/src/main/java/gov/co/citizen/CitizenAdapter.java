package gov.co.citizen;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import gov.co.Citizen;
import gov.co.gateway.CitizenGateway;
import gov.co.citizen.repository.CitizenRepository;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class CitizenAdapter implements CitizenGateway{

    private final CitizenRepository citizenRepository;

    public CitizenAdapter(CitizenRepository citizenRepository){
        this.citizenRepository = citizenRepository;
    }
    
    @Override
    public Mono<Citizen> getByIdentification(String identification, String kindof){
        return citizenRepository.getByIdentification(identification, kindof).map(entity ->
            new Citizen(entity.getId(), entity.getIdentification(), entity.getKindof(),
                        entity.getName(), entity.getAge(), entity.getGender(),
                        entity.getImageurl()));
    }
    @Override
    public Flux<Citizen> findAll(){
        return citizenRepository.findAll().map(entity ->
            new Citizen(entity.getId(), entity.getIdentification(), entity.getKindof(),
                        entity.getName(), entity.getAge(), entity.getGender(),
                        entity.getImageurl()));
    }

    

}
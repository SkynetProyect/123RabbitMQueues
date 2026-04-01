package gov.co.citizen.repository;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import gov.co.citizen.CitizenEntity;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends R2dbcRepository<CitizenEntity,Long> {

    @Query("SELECT * FROM citizens c WHERE c.identification =:identification and c.kindof =:kindof")
    Mono<CitizenEntity> getByIdentification(String identification, String kindof);

}
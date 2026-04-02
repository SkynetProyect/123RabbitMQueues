package gov.co.emergency.repository;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import gov.co.emergency.EmergencyEntity;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyRepository extends R2dbcRepository<EmergencyEntity,Long> {


}
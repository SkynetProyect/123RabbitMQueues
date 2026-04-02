package gov.co.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(
    basePackages = "gov.co.citizen.repository",
    entityOperationsRef = "CitizenTemplate"
)
public class CitizensDbConfig {}
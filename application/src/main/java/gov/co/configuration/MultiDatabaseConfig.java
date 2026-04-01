package gov.co.configuration;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import gov.co.configuration.DatabaseProperties;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

import java.util.Map;

@Configuration
@Component
public class MultiDatabaseConfig {

    @Autowired
    private DatabaseProperties dbProperties;


    private ConnectionFactory createConnectionFactory(String dbName) {
        Map<String, String> properties = dbProperties.getDatabases().get(dbName);
        String url = properties.get("url");
        String username = properties.get("username");
        String password = properties.get("password");

        return ConnectionFactoryBuilder.withUrl(url).username(username).password(password).build();
    }

    @Bean
    @Primary
    public ConnectionFactory db1ConnectionFactory() {
        return createConnectionFactory("citizensdb");
    }
    @Bean
    @Primary
    public R2dbcEntityTemplate r2dbcEntityTemplate() {
        return new R2dbcEntityTemplate(db1ConnectionFactory());
    }
    
    @Bean
    public ConnectionFactory db2ConnectionFactory() {
        return createConnectionFactory("emergenciesdb");
    }

    @Bean(name = "EmergenciesTemplate")
    public R2dbcEntityTemplate db2Template() {
        return new R2dbcEntityTemplate(db2ConnectionFactory());
    }
    
}
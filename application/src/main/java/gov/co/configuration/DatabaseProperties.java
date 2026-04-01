package gov.co.configuration;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.r2dbc")
public class DatabaseProperties {

    private Map<String, Map<String, String>> databases;

    // Getter
    public Map<String, Map<String, String>> getDatabases() {
        return databases;
    }

    // Setter
    public void setDatabases(Map<String, Map<String, String>> databases) {
        this.databases = databases;
    }

}
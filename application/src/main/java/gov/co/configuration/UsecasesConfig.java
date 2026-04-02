package  gov.co.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "gov.co",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Usecase$")
        },
        useDefaultFilters = false)
public class UsecasesConfig {
}
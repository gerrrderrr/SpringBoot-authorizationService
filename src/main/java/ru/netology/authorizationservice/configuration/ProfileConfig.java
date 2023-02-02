package ru.netology.authorizationservice.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.authorizationservice.profile.DevelopmentProfile;
import ru.netology.authorizationservice.profile.ProductionProfile;
import ru.netology.authorizationservice.profile.SystemProfile;

@Configuration
public class ProfileConfig {

    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true")
    @Bean
    public SystemProfile devProfile() {
        return new DevelopmentProfile();
    }

    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false")
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}

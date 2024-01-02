package jidol.lolApiProject.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiotApiConfiguration {

    @Bean
    public RiotApiInterceptor riotApiInterceptor() {
        return new RiotApiInterceptor();
    }
}
package jidol.lolApiProject.api;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class RiotApiInterceptor implements RequestInterceptor {

    @Value("${riot.api.api-key}")
    private String apiKey;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Riot-Token", apiKey);
    }
}
package jidol.lolApiProject.api.feignClient;

import jidol.lolApiProject.api.RiotApiConfiguration;
import jidol.lolApiProject.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="feign", url="${riot-api.by-name-url}", configuration = RiotApiConfiguration.class)
public interface SummonerApiClient {

    @GetMapping(value = "/{summonerName}")
    UserDto getUserDto(@PathVariable("summonerName") String summonerName);

}
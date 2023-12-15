package jidol.lolApiProject.api;

import jidol.lolApiProject.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="feign", url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name")
public interface RiotApiClient {

    @GetMapping(value = "/{summonerName}?api_key=RGAPI-705616bf-4a89-430a-965a-2ab5dbfdab3a")
    UserDto getUserDto(@PathVariable("summonerName") String summonerName);
}


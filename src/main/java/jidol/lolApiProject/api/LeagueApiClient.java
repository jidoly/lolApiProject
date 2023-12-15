package jidol.lolApiProject.api;

import jidol.lolApiProject.api.dto.LeagueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="league", url="https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner")
public interface LeagueApiClient {

    @GetMapping(value = "/{id}?api_key=RGAPI-705616bf-4a89-430a-965a-2ab5dbfdab3a")
    List<LeagueDto> getLeagueDto(@PathVariable("id") String id);
}
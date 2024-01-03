package jidol.lolApiProject.api.feignClient;

import jidol.lolApiProject.api.RiotApiConfiguration;
import jidol.lolApiProject.api.dto.LeagueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="league", url="${riot-api.by-summoner-url}", configuration = RiotApiConfiguration.class)
public interface LeagueApiClient {

    @GetMapping(value = "/{id}")
    List<LeagueDto> getLeagueDto(@PathVariable("id") String id);

}
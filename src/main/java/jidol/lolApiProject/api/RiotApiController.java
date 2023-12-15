package jidol.lolApiProject.api;

import jidol.lolApiProject.api.dto.InfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RiotApiController {

    private final RiotApiService riotApiService;

    /**
     * 나중에 String으로 값 넘겨주게
     */
    @GetMapping("/api/riot/{summonerName}")
    public List<InfoDto> get(@PathVariable String summonerName){
       return riotApiService.findBySummonerName(summonerName);
    }
}

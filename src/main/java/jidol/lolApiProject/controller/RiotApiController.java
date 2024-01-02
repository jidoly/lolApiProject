package jidol.lolApiProject.controller;

import jidol.lolApiProject.api.RiotApiService;
import jidol.lolApiProject.api.dto.InfoDto;
import jidol.lolApiProject.api.dto.LeagueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RiotApiController {

    private final RiotApiService riotApiService;

    @GetMapping("/api/gameInfo/{summonerName}")
    public List<InfoDto> getGame(@PathVariable String summonerName,
                                 @RequestParam(name = "start", required = false) Integer start,
                                 @RequestParam(name = "count", required = false) Integer count){

        int startValue = (start != null) ? start : 0;
        int countValue = (count != null) ? count : 1;

        //Get : 게임 정보 - gameId, gameEndTimestamp, <ParticipantDto> - 게임 정보(kill/assist/death..)  .. By:summonerName
       return riotApiService.findBySummonerName(summonerName, startValue, countValue);

    }
    @GetMapping("/api/summonerInfo/{summonerName}")
    public List<LeagueDto> getSummoner(@PathVariable String summonerName){
        //Get : 소환사 정보 - tier / win / lose .. By:summonerName
        return riotApiService.findLeagueInfo(summonerName);
    }




}

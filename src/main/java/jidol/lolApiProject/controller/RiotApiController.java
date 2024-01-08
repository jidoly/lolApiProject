package jidol.lolApiProject.controller;

import jidol.lolApiProject.api.RiotApiService;
import jidol.lolApiProject.api.dto.InfoDto;
import jidol.lolApiProject.api.dto.LeagueDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RiotApiController {

    private final RiotApiService riotApiService;

    /**
     *
     * @param summonerName - 유저 닉네임
     * @param start - 페이지수 시작
     * @param count - 가져올 게임 목록의 수
     *
     * @return : 게임목록의 InfoDto
     */
    @GetMapping("/api/gameInfo/{summonerName}")
    public List<InfoDto> getGame(@PathVariable String summonerName,
                                 @RequestParam(name = "start", required = false) Integer start,
                                 @RequestParam(name = "count", required = false) Integer count){

        //api 호출을 통해 가져오는 게임 List 갯수
        int startValue = (start != null) ? start : 0;
        int countValue = (count != null) ? count : 5;

        //Get : 게임 정보 - gameId, gameEndTimestamp, <ParticipantDto> - 게임 정보(kill/assist/death..)  .. By:summonerName
        List<InfoDto> bySummonerName = riotApiService.findBySummonerName(summonerName, startValue, countValue);

        log.info("result.size = {}", bySummonerName.size());
        return bySummonerName;

    }

    /**
     * @param summonerName - 소환사의 닉네임
     * @return : LeagueDto - 소환사 정보(티어, win, lose ...)
     */
    @GetMapping("/api/summonerInfo/{summonerName}")
    public List<LeagueDto> getSummoner(@PathVariable String summonerName){
        //Get : 소환사 정보 - 티어 / win / lose .. By:summonerName
        return riotApiService.findLeagueInfo(summonerName);
    }

}

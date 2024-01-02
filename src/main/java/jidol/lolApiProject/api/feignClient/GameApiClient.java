package jidol.lolApiProject.api.feignClient;

import jidol.lolApiProject.api.RiotApiConfiguration;
import jidol.lolApiProject.api.dto.GameDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "game", url = "https://asia.api.riotgames.com/lol/match/v5/matches", configuration = RiotApiConfiguration.class)
public interface GameApiClient {

    /**
     * count 20 기본값 제한 가능 // test시 1개만 가져오게
     * @param puuid
     */
//    @GetMapping(value = "/by-puuid/{puuid}/ids?start=0&count=1&api_key=RGAPI-705616bf-4a89-430a-965a-2ab5dbfdab3a")
//    List<String> getGameList(@PathVariable("puuid") String puuid);


    @GetMapping("/by-puuid/{puuid}/ids")
    List<String> getGameList(
            @PathVariable("puuid") String puuid,
            @RequestParam(name = "start", defaultValue = "0") int start,
            @RequestParam(name = "count", defaultValue = "20") int count);

    /**
     * 개별 매치 기록
     * @param matchId
     */
    @GetMapping(value = "/{matchId}")
    GameDto getgameDto(@PathVariable("matchId") String matchId);

}

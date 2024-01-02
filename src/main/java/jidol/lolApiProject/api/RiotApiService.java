package jidol.lolApiProject.api;

import jidol.lolApiProject.api.dto.GameDto;
import jidol.lolApiProject.api.dto.InfoDto;
import jidol.lolApiProject.api.dto.LeagueDto;
import jidol.lolApiProject.api.feignClient.GameApiClient;
import jidol.lolApiProject.api.feignClient.LeagueApiClient;
import jidol.lolApiProject.api.feignClient.SummonerApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RiotApiService {

    private final SummonerApiClient summonerApiClient;
    private final GameApiClient gameApiClient;
    private final LeagueApiClient leagueApiClient;

    /**
     * 소환사이름 -> puuid로 게임 List 가져오기
     *
     * @return
     */
    public List<InfoDto> findBySummonerName(String summonerName, int start, int count) {
        List<InfoDto> result = new ArrayList<>();
        //암호화된 puuid 가져오기
        String puuid = summonerApiClient.getUserDto(summonerName).getPuuid();

        List<String> gameList = gameApiClient.getGameList(puuid,start,count);

        for (String matchId : gameList) {
            GameDto gameDto = gameApiClient.getgameDto(matchId);
            InfoDto gameInfo = gameDto.getInfo();
            gameInfo.setMyPuuid(puuid);
            result.add(gameInfo);
        }

        return result;

    }

    public List<LeagueDto> findLeagueInfo(String summonerName) {

        String id = summonerApiClient.getUserDto(summonerName).getId();

        List<LeagueDto> result = leagueApiClient.getLeagueDto(id);

        return result;
    }
}
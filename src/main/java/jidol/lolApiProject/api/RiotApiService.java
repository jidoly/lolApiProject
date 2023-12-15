package jidol.lolApiProject.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jidol.lolApiProject.api.dto.GameDto;
import jidol.lolApiProject.api.dto.InfoDto;
import jidol.lolApiProject.api.dto.LeagueDto;
import jidol.lolApiProject.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RiotApiService {

    private final RiotApiClient riotApiClient;
    private final GameApiClient gameApiClient;
    private final LeagueApiClient leagueApiClient;
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 소환사이름 -> puuid로 게임 List -> 일단 List[0]의 게임 정보
     *
     * @return
     */
    public List<InfoDto> findBySummonerName(String summonerName) {
        List<InfoDto> result = new ArrayList<>();

        String puuid = riotApiClient.getUserDto(summonerName).getPuuid();

        List<String> gameList = gameApiClient.getGameList(puuid);

        for (String matchId : gameList) {
            GameDto gameDto = gameApiClient.getgameDto(matchId);
            InfoDto gameInfo = gameDto.getInfo();
            gameInfo.setMyPuuid(puuid);
            result.add(gameInfo);
        }

        return result;

    }

    public List<LeagueDto> findLeagueInfo(String summonerName) {

        String id = riotApiClient.getUserDto(summonerName).getId();

        log.info("====id={}=========", id);

        List<LeagueDto> result = leagueApiClient.getLeagueDto(id);
        log.info("====result={}=========", result);
        return result;
    }
}
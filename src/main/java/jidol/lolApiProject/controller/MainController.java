package jidol.lolApiProject.controller;

import jidol.lolApiProject.api.RiotApiService;
import jidol.lolApiProject.api.dto.InfoDto;
import jidol.lolApiProject.api.dto.LeagueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Value("${riot-img-url}")
    private String imageUrl;
    @Value("${riot-img-version}")
    private String imgVer;

    private final RiotApiService riotApiService;


    /**
     *
     * @param summonerName - 유저 닉네임
     * @param model - data : 게임 정보 :
                                    String myPuuid;
                                    Long gameId;
                                    Long gameEndTimestamp;
                                    List<ParticipantDto> Participants;
     * @return
     */
    @GetMapping("/main/{summonerName}")
    public String main(@PathVariable String summonerName,
                       @RequestParam(name = "start", required = false) Integer start,
                       @RequestParam(name = "count", required = false) Integer count,
                       Model model){

        int startValue = (start != null) ? start : 0;
        int countValue = (count != null) ? count : 1;

        //Get : 소환사 정보 - tier / win / lose .. By:summonerName
        List<LeagueDto> leagueInfo = riotApiService.findLeagueInfo(summonerName);

        //Get : 게임 정보 - gameId, gameEndTimestamp, <ParticipantDto> - 게임 정보(kill/assist/death..)  .. By:summonerName
        List<InfoDto> gameData = riotApiService.findBySummonerName(summonerName,startValue,countValue);


        model.addAttribute("leagueInfo", leagueInfo);
        model.addAttribute("gameData", gameData);

        return "main";

    }

    @GetMapping("/main2/{summonerName}")
    public String main2(@PathVariable String summonerName,
                       @RequestParam(name = "start", required = false) Integer start,
                       @RequestParam(name = "count", required = false) Integer count,
                       Model model){



        int startValue = (start != null) ? start : 0;
        int countValue = (count != null) ? count : 20;

//        Get : 소환사 정보 - tier / win / lose .. By:summonerName
        List<LeagueDto> leagueInfo = riotApiService.findLeagueInfo(summonerName);

//        Get : 게임 정보 - gameId, gameEndTimestamp, <ParticipantDto> - 게임 정보(kill/assist/death..)  .. By:summonerName
        List<InfoDto> gameData = riotApiService.findBySummonerName(summonerName,startValue,countValue);


        model.addAttribute("leagueInfo", leagueInfo);
        model.addAttribute("gameData", gameData);

        //이미지 url
        String img = imageUrl + imgVer;
        model.addAttribute("img", img);
//
        return "main2";

    }



    private static TestDto createTestDto() {
        return new TestDto(
                "Lx9bypbQiPIVq5Wqqn0c_9U-feB8u2MzrlUOJwL93oZE4ZttuZ3dEwg0H8-ckydex3UgW5wT5WJ0Pg",
                "바른말고운말이쁜말하는유저",
                "Kaisa",
                200,
                7,
                4,
                1203,
                70719,
                13277,
                0,
                61,
                true,
                12,
                30,
                5,
                "MIDDLE",
                "SUPPORT",
                0,
                true,
                false,
                1,
                0,
                3,
                6655,
                3042,
                3006,
                3115,
                1058,
                1058,
                2052
        );
    }


}

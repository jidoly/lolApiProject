package jidol.lolApiProject.controller;

import jidol.lolApiProject.api.RiotApiService;
import jidol.lolApiProject.api.dto.GameDto;
import jidol.lolApiProject.api.dto.InfoDto;
import jidol.lolApiProject.api.dto.LeagueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final RiotApiService riotApiService;

    @GetMapping("/main/{summonerName}")
    public String Main(@PathVariable String summonerName, Model model){

        //좀 발라서 넘길지 그냥 넘겨서 가공할지 고민해야됨
        List<InfoDto> data = riotApiService.findBySummonerName(summonerName);

        List<LeagueDto> leagueInfo = riotApiService.findLeagueInfo(summonerName);

        model.addAttribute("data", data);
        model.addAttribute("leagueInfo", leagueInfo);

        return "main";

    }
}

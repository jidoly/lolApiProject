package jidol.lolApiProject.controller;

import lombok.Data;

@Data
public class TestDto {

    private String puuid;
    private String summonerName;
    private String championName;
    private int teamId;
    private int summoner1Id;
    private int summoner2Id;
    private int timePlayed;
    private int totalDamageDealt;
    private int totalDamageTaken;
    private int visionScore;
    private int totalMinionsKilled;
    private boolean win;
    private int kills;
    private int assists;
    private int deaths;
    private String lane;
    private String role;
    private int sightWardsBoughtInGame;
    private boolean doubleKills;
    private boolean firstBloodKill;
    private int tripleKills;
    private int quadraKills;
    private int killingSprees;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;

    // 생성자
    public TestDto(String puuid, String summonerName, String championName, int teamId, int summoner1Id,
                          int summoner2Id, int timePlayed, int totalDamageDealt, int totalDamageTaken, int visionScore,
                          int totalMinionsKilled, boolean win, int kills, int assists, int deaths, String lane,
                          String role, int sightWardsBoughtInGame, boolean doubleKills, boolean firstBloodKill,
                          int tripleKills, int quadraKills, int killingSprees, int item0, int item1, int item2,
                          int item3, int item4, int item5, int item6) {
        this.puuid = puuid;
        this.summonerName = summonerName;
        this.championName = championName;
        this.teamId = teamId;
        this.summoner1Id = summoner1Id;
        this.summoner2Id = summoner2Id;
        this.timePlayed = timePlayed;
        this.totalDamageDealt = totalDamageDealt;
        this.totalDamageTaken = totalDamageTaken;
        this.visionScore = visionScore;
        this.totalMinionsKilled = totalMinionsKilled;
        this.win = win;
        this.kills = kills;
        this.assists = assists;
        this.deaths = deaths;
        this.lane = lane;
        this.role = role;
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
        this.doubleKills = doubleKills;
        this.firstBloodKill = firstBloodKill;
        this.tripleKills = tripleKills;
        this.quadraKills = quadraKills;
        this.killingSprees = killingSprees;
        this.item0 = item0;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
    }

}
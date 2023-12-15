package jidol.lolApiProject.api.dto;

import lombok.Data;

@Data
public class ParticipantDto { // 커밋테스트

    private String puuid; // 유저 암호화 아이디 pk임
    private String summonerName; // 소환사 닉네임
    private String championName; // 챔피언 이름
    private int teamId; // 팀 100[블루] / 200[레드]

    private int summoner1Id; // 소환사 스펠
    private int summoner2Id; // 4 점멸 11 강타 12 https://ddragon.leagueoflegends.com/cdn/13.24.1/img/spell/SummonerFlash.png

    /** 플레이 시간*/
    private int timePlayed;

    /** 총 피해량 / 피해받은량*/
    private int totalDamageDealt;
    private int totalDamageTaken;
    /** 시야 점수*/
    private int visionScore;
    /** 미니언 킬수*/
    private int totalMinionsKilled;

    /** 승리 여부*/
    private boolean win;


    /** K/D/A */
    private int kills;
    private int assists;
    private int deaths;

    /** 라인 */
    private String lane;
    private String role;

    /** 와드인듯 */
    private int sightWardsBoughtInGame;

    /** 멀티 킬*/
    private boolean doubleKills;
    private boolean firstBloodKill;
    private int tripleKills;
    private int quadraKills;
    /** 미쳐날뜀 */
    private int killingSprees;

    /**
     * 아이템 0~6
     */
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;





}

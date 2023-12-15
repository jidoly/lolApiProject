package jidol.lolApiProject.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class InfoDto {
    /** 추가 데이터*/
    private String myPuuid;

    private Long gameId;
    private Long gameEndTimestamp;
    private List<ParticipantDto> Participants;
}

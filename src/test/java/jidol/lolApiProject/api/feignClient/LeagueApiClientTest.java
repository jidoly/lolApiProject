package jidol.lolApiProject.api.feignClient;

import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import jidol.lolApiProject.api.dto.LeagueDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueApiClientTest {

    @Value("${riot-api.by-summoner-url}")
    private String url;
    @Value("${riot.api.api-key}")
    private String apiKey;

    @Test
    public void testGetLeagueDto() {
        // Feign 클라이언트 생성
        LeagueApiClient leagueApiClient = Feign.builder()
                .target(LeagueApiClient.class, url); // 실제 서버 주소 대신 MockServer 주소 사용

        // 테스트용 ID
        String testId = "testId";

        // Feign 클라이언트 메소드 호출
        List<LeagueDto> result = leagueApiClient.getLeagueDto(testId);

        // 결과 확인
        assertNotNull(result);
        // TODO: 실제로 반환된 데이터에 대한 추가적인 검증 수행
    }
}
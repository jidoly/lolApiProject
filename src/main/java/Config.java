import feign.Logger;
import jidol.lolApiProject.api.RiotApiInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    /** feign 로깅 처리 */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


}

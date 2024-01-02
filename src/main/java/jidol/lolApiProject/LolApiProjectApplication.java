package jidol.lolApiProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "jidol.lolApiProject.api")
@SpringBootApplication
public class LolApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LolApiProjectApplication.class, args);
	}

}

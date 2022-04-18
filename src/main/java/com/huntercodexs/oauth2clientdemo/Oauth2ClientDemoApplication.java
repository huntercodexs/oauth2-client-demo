package com.huntercodexs.oauth2clientdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Oauth2ClientDemoApplication {

	public static void main(String[] args) {
		log.info("\n\n\n");
		log.info("---------------------------------------------------------------------------------------------");
		log.debug("OAUTH2-CLIENT-DEMO STARTING");
		SpringApplication.run(Oauth2ClientDemoApplication.class, args);
		log.debug("OAUTH2-CLIENT-DEMO IS RUNNING");
	}

}

package com.matheus.OpenFeignExpertClub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignExpertClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignExpertClubApplication.class, args);
	}

}

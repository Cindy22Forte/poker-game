package com.cindytest.pokergame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationPropertiesScan
@EnableConfigurationProperties
@SpringBootApplication
public class PokerGameApplication {


	public static void main(String[] args) {
		SpringApplication.run(PokerGameApplication.class, args);
	}

	@Bean
	public CommandLineRunner game(PokerGame game) {

		return args -> {
			game.start();
		};
	}

}

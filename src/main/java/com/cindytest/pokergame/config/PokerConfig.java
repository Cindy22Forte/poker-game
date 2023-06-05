package com.cindytest.pokergame.config;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("poker")
@Value
@ConstructorBinding
@Builder
public class PokerConfig {

	@Default
	Integer handSize = 5;

	@Default
	String shuffleStrategy = "normal";
}

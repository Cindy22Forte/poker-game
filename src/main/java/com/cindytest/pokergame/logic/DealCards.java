package com.cindytest.pokergame.logic;

import java.util.ArrayList;
import java.util.List;

import com.cindytest.pokergame.config.PokerConfig;
import com.cindytest.pokergame.data.Card;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealCards {

	private final PokerConfig pokerConfig;

	public List<Card> dealHand(List<Card> shuffledDeck) {

		List<Card> playerHand = new ArrayList<>();

		for (int index = 0; index < pokerConfig.getHandSize(); index++) {
			playerHand.add(shuffledDeck.get(index));
		}

		return playerHand;
	}
}

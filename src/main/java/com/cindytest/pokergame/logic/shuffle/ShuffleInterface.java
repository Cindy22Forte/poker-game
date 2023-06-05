package com.cindytest.pokergame.logic.shuffle;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.cindytest.pokergame.data.Card;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

public interface ShuffleInterface {

	List<Card> shuffle(List<Card> deck);


	@Service
	@RequiredArgsConstructor
	@ConditionalOnProperty(name = "shuffle.strategy", havingValue = "collection")
	class Collection implements ShuffleInterface {

		@Override
		public List<Card> shuffle(List<Card> deck) {
			for (int shuffleCount = 0; shuffleCount < 3; shuffleCount++) {
				System.out.println("$huffling alternative...");
				Collections.shuffle(deck);
			}
			return deck;
		}
	}

	@Service
	@RequiredArgsConstructor
	@ConditionalOnProperty(name = "shuffle.strategy", havingValue = "normal")
	class Normal implements ShuffleInterface {

		@Override
		public List<Card> shuffle(List<Card> deck) {
			Random randomize = new Random();
			for (int shuffleCount = 0; shuffleCount < 3; shuffleCount++) {
				System.out.println("Shuffling ...");
				Card temp;
				for (Card ignored : deck) {
					int initial = randomize.nextInt(deck.size() - 1);
					int second = randomize.nextInt(deck.size() - 1);

					temp = deck.get(second);
					deck.set(second, deck.get(initial));
					deck.set(initial, temp);
				}
			}
			return deck;
		}
	}
}

package com.cindytest.pokergame.logic;

import java.util.List;
import java.util.stream.Stream;

import com.cindytest.pokergame.config.PokerConfig;
import com.cindytest.pokergame.data.Card;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.cindytest.pokergame.data.Suits.CLUBS;
import static com.cindytest.pokergame.data.Suits.DIAMONDS;
import static com.cindytest.pokergame.data.Suits.HEARTS;
import static com.cindytest.pokergame.data.Suits.SPADES;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class DealCardsTest {

	@ParameterizedTest
	@MethodSource("pokerParams")
	void dealCards(PokerConfig pokerConfig) {

//		List<Card> deck = List.of(new Card(2, HEARTS), new Card(3, HEARTS), new Card(4, HEARTS), new Card(5, HEARTS), new Card(6, HEARTS), new Card(7, HEARTS), new Card(8, HEARTS), new Card(9, HEARTS), new Card(10, HEARTS), new Card(11, HEARTS), new Card(12, HEARTS), new Card(13, HEARTS), new Card(14, HEARTS),
//				new Card(2, CLUBS), new Card(3, CLUBS), new Card(4, CLUBS), new Card(5, CLUBS), new Card(6, CLUBS), new Card(7, CLUBS), new Card(8, CLUBS), new Card(9, CLUBS), new Card(10, CLUBS), new Card(11, CLUBS), new Card(12, CLUBS), new Card(13, CLUBS), new Card(14, CLUBS),
//				new Card(2, DIAMONDS), new Card(3, DIAMONDS), new Card(4, DIAMONDS), new Card(5, DIAMONDS), new Card(6, DIAMONDS), new Card(7, DIAMONDS), new Card(8, DIAMONDS), new Card(9, DIAMONDS), new Card(10, DIAMONDS), new Card(11, DIAMONDS), new Card(12, DIAMONDS), new Card(13, DIAMONDS), new Card(14, DIAMONDS),
//				new Card(2, SPADES), new Card(3, SPADES), new Card(4, SPADES), new Card(5, SPADES), new Card(6, SPADES), new Card(7, SPADES), new Card(8, SPADES), new Card(9, SPADES), new Card(10, SPADES), new Card(11, SPADES), new Card(12, SPADES), new Card(13, SPADES), new Card(14, SPADES));
//
//		DealCards dealCards = new DealCards(pokerConfig);
//
//		List<Card> hand = dealCards.dealHand(deck);
//
//		log.info(hand.toString());
//		assertEquals("[Card(rank=2, suit=HEARTS), Card(rank=3, suit=HEARTS), Card(rank=4, suit=HEARTS), Card(rank=5, suit=HEARTS), Card(rank=6, suit=HEARTS)]", hand.toString());

	}

	private static Stream<Arguments> pokerParams() {
		return Stream.of(
				Arguments.of(PokerConfig.builder().handSize(5).build()));

	}

}
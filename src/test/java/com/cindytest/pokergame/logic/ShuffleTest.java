package com.cindytest.pokergame.logic;

import java.util.List;
import java.util.stream.Stream;

import com.cindytest.pokergame.config.PokerConfig;
import com.cindytest.pokergame.data.Card;
import com.cindytest.pokergame.logic.shuffle.ShuffleInterface;
import com.cindytest.pokergame.logic.shuffle.ShuffleInterface.Collection;
import com.cindytest.pokergame.logic.shuffle.ShuffleInterface.Normal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Slf4j
@RequiredArgsConstructor
class ShuffleTest {

	MakeDeck makeDeck = new MakeDeck();

	PokerConfig pokerConfig;

	@ParameterizedTest
	@MethodSource("pokerNormalParams")
	void testNormalShuffle() {

		ShuffleInterface shuffleInterface = new Normal();
		List<Card> combo = makeDeck.cardCombos();

		log.info(combo.toString());

		List<Card> unShuffled = List.copyOf(combo);
		List<Card> shuffled = shuffleInterface.shuffle(combo);

		assertNotEquals(unShuffled, shuffled);
	}

	@ParameterizedTest
	@MethodSource("pokerCollectionParams")
	void testCollectionsShuffle() {

		ShuffleInterface shuffleInterface = new Collection();

		List<Card> combo = makeDeck.cardCombos();

		log.info(combo.toString());

		List<Card> unShuffled = List.copyOf(combo);

		List<Card> shuffled = shuffleInterface.shuffle(combo);

		assertNotEquals(unShuffled, shuffled);
	}

	private static Stream<Arguments> pokerNormalParams() {
		return Stream.of(
				Arguments.of(PokerConfig.builder().shuffleStrategy("normal").handSize(5).build()));

	}

	private static Stream<Arguments> pokerCollectionParams() {
		return Stream.of(
				Arguments.of(PokerConfig.builder().shuffleStrategy("collection").build()));

	}

}
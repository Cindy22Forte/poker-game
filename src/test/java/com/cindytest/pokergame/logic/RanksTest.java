package com.cindytest.pokergame.logic;

import java.util.List;

import com.cindytest.pokergame.data.Card;
import com.cindytest.pokergame.data.HandRank;
import com.cindytest.pokergame.data.HandSuit;
import com.cindytest.pokergame.data.PokerHands;
import com.cindytest.pokergame.data.Suits;
import com.cindytest.pokergame.logic.evaluate.Ranks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RanksTest {

	Ranks ranks = new Ranks();

	@Test
	void returnStraightFlush() {

//		List<Card> listDeck = List.of(new Card(2, Suits.HEARTS), new Card(3, Suits.HEARTS), new Card(4, Suits.HEARTS), new Card(5, Suits.HEARTS), new Card(6, Suits.HEARTS));
//		List<HandSuit> listSuit = List.of(new HandSuit(2, 5));
//		List<HandRank> listRank = List.of(new HandRank(2, 1), new HandRank(3, 1), new HandRank(4, 1), new HandRank(5, 1), new HandRank(6, 1));
//
//		String result = ranks.determineRank(listDeck, listRank, listSuit);
//		assertEquals(PokerHands.STRAIGHT_FLUSH.getName(), result);
	}

	@Test
	void returnFourOfKind() {

		List<HandRank> listRank = List.of(new HandRank(13, 4), new HandRank(2, 1));

		assertTrue(ranks.getBasicRankHand(listRank, 4));
	}

	@Test
	void returnFullHouse() {

		List<HandRank> listRank = List.of(new HandRank(13, 3), new HandRank(2, 2));

		assertTrue(ranks.fullHouse(listRank));
	}

	@Test
	void returnFlush() {

		List<HandSuit> listSuit = List.of(new HandSuit(1, 5));

		assertTrue(ranks.flush(listSuit));
	}

	@Test
	void returnStraight() {

//		List<Card> listDeck = List.of(new Card(12, Suits.HEARTS), new Card(11, Suits.HEARTS), new Card(10, Suits.HEARTS), new Card(9, Suits.HEARTS), new Card(8, Suits.HEARTS));

//		assertTrue(ranks.straight(listDeck));
	}

	@Test
	void returnThreeOfKind() {

		List<HandRank> listRank = List.of(new HandRank(13, 3), new HandRank(2, 2));

		assertTrue(ranks.getBasicRankHand(listRank, 3));
	}

	@Test
	void returnTwoPair() {

		List<HandRank> listRank = List.of(new HandRank(13, 2), new HandRank(2, 2));

		assertTrue(ranks.twoPair(listRank));
	}

	@Test
	void returnOnePair() {

		List<HandRank> listRank = List.of(new HandRank(13, 1), new HandRank(2, 2), new HandRank(3, 1));

		assertTrue(ranks.getBasicRankHand(listRank, 1));
	}

	@Test
	void returnHighCards() {

//		List<HandRank> listRank = List.of(new HandRank(13, 1), new HandRank(2, 1));
//		List<HandSuit> listSuit = List.of(new HandSuit(1, 1));
//		List<Card> listDeck = List.of(new Card(12, Suits.HEARTS), new Card(11, Suits.SPADES), new Card(3, Suits.HEARTS), new Card(1, Suits.HEARTS), new Card(8, Suits.HEARTS));
//
//		String result = ranks.determineRank(listDeck, listRank, listSuit);
//		assertEquals(PokerHands.HIGH_CARDS.getName(), result);
	}

}
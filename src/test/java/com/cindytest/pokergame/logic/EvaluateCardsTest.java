package com.cindytest.pokergame.logic;

import java.util.List;

import com.cindytest.pokergame.data.Card;
import com.cindytest.pokergame.data.HandRank;
import com.cindytest.pokergame.data.HandSuit;
import com.cindytest.pokergame.data.Suits;
import com.cindytest.pokergame.logic.evaluate.EvaluateCards;
import com.cindytest.pokergame.logic.evaluate.Ranks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateCardsTest {

	public Ranks ranks;

	@Test
	void getHandRanks(){
		EvaluateCards evaluateCards = new EvaluateCards(ranks);

//		List<Card> hand = List.of(new Card(2, Suits.HEARTS), new Card(3, Suits.HEARTS), new Card(4, Suits.HEARTS), new Card(5, Suits.HEARTS), new Card(6, Suits.HEARTS));
//
//		List<HandRank> ranks = evaluateCards.getHandRanks(hand);
//
//		assertEquals("[HandRank(rank=2, count=1), HandRank(rank=3, count=1), HandRank(rank=4, count=1), HandRank(rank=5, count=1), HandRank(rank=6, count=1)]", ranks.toString());
	}

	@Test
	void getHandSuits(){
//		EvaluateCards evaluateCards = new EvaluateCards(ranks);
//
//		List<Card> hand = List.of(new Card(2, Suits.HEARTS), new Card(3, Suits.HEARTS), new Card(4, Suits.HEARTS), new Card(5, Suits.HEARTS), new Card(6, Suits.HEARTS));
//
//		List<HandSuit> suits = evaluateCards.getHandSuits(hand);
//
//		assertEquals("[HandSuit(suit=1, count=5)]", suits.toString());
	}

}
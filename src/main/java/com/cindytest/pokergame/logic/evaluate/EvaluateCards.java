package com.cindytest.pokergame.logic.evaluate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.cindytest.pokergame.data.Card;
import com.cindytest.pokergame.data.HandRank;
import com.cindytest.pokergame.data.HandSuit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EvaluateCards {

	private final Ranks ranks;

	private static final Integer RANKS = 13;

	private static final Integer SUITS = 4;

	public void evaluateHand(List<Card> hand) {

		List<HandRank> handRanks = getHandRanks(hand);
		List<HandSuit> handSuits = getHandSuits(hand);

		String highestRank = ranks.determineRank(hand, handRanks, handSuits);
		System.out.println("\nYou have: " + highestRank);
	}

	public List<HandRank> getHandRanks(List<Card> hand) {
		List<Integer> rank = new ArrayList<>();
		List<HandRank> storedRank = new ArrayList<>();

		for (Card card : hand) {
			rank.add(card.getRank().getCardRank());
		}

		for (int value = 0; value < RANKS; value++) {
			Integer countRank = Collections.frequency(rank, value);
			Integer groupRank = value;
			HandRank total = new HandRank(groupRank, countRank);
			storedRank.add(value, total);
		}
		return storedRank.stream().filter(i -> i.getCount() > 0).collect(Collectors.toList());
	}

	public List<HandSuit> getHandSuits(List<Card> hand) {
		List<HandSuit> storedSuit = new ArrayList<>() {};
		List<Integer> suit = new ArrayList<>();

		for (Card card : hand) {
			suit.add(card.getSuit().getSuiteValue());
		}

		for (int type = 0; type < SUITS; type++) {
			Integer countSuit = Collections.frequency(suit, type);
			Integer groupSuit = type;
			HandSuit total = new HandSuit(groupSuit, countSuit);
			storedSuit.add(type, total);
		}
		return storedSuit.stream().filter(i -> i.getCount() > 0).collect(Collectors.toList());
	}

}

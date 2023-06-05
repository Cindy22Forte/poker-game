package com.cindytest.pokergame.logic.evaluate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cindytest.pokergame.data.Card;
import com.cindytest.pokergame.data.HandRank;
import com.cindytest.pokergame.data.HandSuit;
import com.cindytest.pokergame.data.PokerHands;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Ranks {

	public String determineRank(List<Card> hand, List<HandRank> handRanks, List<HandSuit> storedSuit) {
		String evaluation;

		if (straightFlush(storedSuit, hand))
			evaluation = PokerHands.STRAIGHT_FLUSH.getName();
		else if (getBasicRankHand(handRanks, PokerHands.FOUR_OF_A_KIND.getSignificant()))
			evaluation = PokerHands.FOUR_OF_A_KIND.getName();
		else if (fullHouse(handRanks))
			evaluation = PokerHands.FULL_HOUSE.getName();
		else if (flush(storedSuit))
			evaluation = PokerHands.FLUSH.getName();
		else if (straight(hand))
			evaluation = PokerHands.STRAIGHT.getName();
		else if (getBasicRankHand(handRanks, PokerHands.THREE_OF_A_KIND.getSignificant()))
			evaluation = PokerHands.THREE_OF_A_KIND.getName();
		else if (twoPair(handRanks))
			evaluation = PokerHands.TWO_PAIR.getName();
		else if (getBasicRankHand(handRanks, PokerHands.ONE_PAIR.getSignificant()))
			evaluation = PokerHands.ONE_PAIR.getName();
		else
			evaluation = PokerHands.HIGH_CARDS.getName();

		return evaluation;
	}

	public Boolean straightFlush(List<HandSuit> storedSuit, List<Card> hand) {
		return flush(storedSuit) && straight(hand);
	}

	public Boolean fullHouse(List<HandRank> storedRank) {
		int countPairs = 0;
		int countCrowd = 0;

		for (HandRank handRank : storedRank) {
			if (handRank.getCount() == PokerHands.THREE_OF_A_KIND.getSignificant())
				countPairs++;
			if (handRank.getCount() == PokerHands.ONE_PAIR.getSignificant())
				countCrowd++;
		}

		return countPairs == 1 && countCrowd == 1;
	}

	public Boolean flush(List<HandSuit> storedSuit) {
		for (HandSuit handSuit : storedSuit) {
			if (handSuit.getCount() == PokerHands.FLUSH.getSignificant())
				return true;
		}
		return false;
	}

	public Boolean straight(List<Card> hand) {

		List<Integer> justRank = new ArrayList<>();

		for (Card card : hand) {
			justRank.add(card.getRank().getCardRank());
		}

		Collections.sort(justRank);
		for (int i = 1; i < 5; i++) {
			Integer a = justRank.get(i - 1);
			Integer b = justRank.get(i) - 1;
			if (!a.equals(b)) {
				return false;
			}
		}
		return true;
	}

	public Boolean getBasicRankHand(List<HandRank> storedRank, Integer numberSignificant) {

		for (HandRank handRank : storedRank) {
			if (handRank.getCount().equals(numberSignificant))
				return true;
		}
		return false;
	}

	public Boolean twoPair(List<HandRank> storedRank) {
		int countTwoPairs = 0;
		for (HandRank handRank : storedRank) {
			if (handRank.getCount() == 2)
				countTwoPairs++;
		}
		if (countTwoPairs == 2)
			return true;
		else
			return false;
	}
}

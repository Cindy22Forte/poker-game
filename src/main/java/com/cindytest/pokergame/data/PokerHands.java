package com.cindytest.pokergame.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PokerHands {
	STRAIGHT_FLUSH(1, "Straight Flush"),
	FOUR_OF_A_KIND(4, "Four of a Kind"),
	FULL_HOUSE(5, "Full House"),
	FLUSH(5, "Flush"),
	STRAIGHT(5, "Straight"),
	THREE_OF_A_KIND(3, "Three of a Kind"),
	TWO_PAIR(4, "Two Pairs"),
	ONE_PAIR(2, "One Pair"),
	HIGH_CARDS(0, "High Cards");

	private int significant;

	private String name;
}

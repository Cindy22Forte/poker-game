package com.cindytest.pokergame.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Suits {
	HEARTS(1, "\u2764"),
	CLUBS(2, "\u2667"),
	DIAMONDS(3, "\u2666"),
	SPADES(4, "\u2664");

	private int suiteValue;

	private String suitSymbol;
}

package com.cindytest.pokergame.data;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class Card {

	Values rank;

	Suits suit;
}

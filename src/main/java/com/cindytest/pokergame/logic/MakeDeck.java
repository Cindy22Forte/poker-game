package com.cindytest.pokergame.logic;

import java.util.ArrayList;
import java.util.List;

import com.cindytest.pokergame.data.Card;
import com.cindytest.pokergame.data.Suits;
import com.cindytest.pokergame.data.Values;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakeDeck {

	public List<Card> cardCombos() {

		List<Card> combo = new ArrayList<>();

		for (Suits suits : Suits.values()) {
			for (Values values : Values.values()) {
				Integer rank = values.getCardRank();
				Card card = new Card(values, suits);
				combo.add(card);
			}
		}
		return combo;
	}
}

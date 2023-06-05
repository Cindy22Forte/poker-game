package com.cindytest.pokergame;

import java.util.List;
import java.util.Scanner;

import com.cindytest.pokergame.data.Card;
import com.cindytest.pokergame.logic.DealCards;
import com.cindytest.pokergame.logic.MakeDeck;
import com.cindytest.pokergame.logic.evaluate.EvaluateCards;
import com.cindytest.pokergame.logic.shuffle.ShuffleInterface;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokerGame {

	public final EvaluateCards evaluateCards;

	public final DealCards dealCards;

	public final MakeDeck makeDeck;

	public final ShuffleInterface shuffleInterface;

	public void start() {
		Scanner input = new Scanner(System.in);
		String answer;

		do {
			//Make deck
			List<Card> combo = makeDeck.cardCombos();

			//Shuffle
			List<Card> shuffled = shuffleInterface.shuffle(combo);

			//Deal
			List<Card> hand = dealCards.dealHand(shuffled);

			System.out.print("Your hand: ");
			hand.forEach(card -> System.out.print(card.getRank().getCardName() + card.getSuit().getSuitSymbol() + " "));

			//Evaluate
			evaluateCards.evaluateHand(hand);

			System.out.println("Would you like to play again? (y/n)");
			answer = input.nextLine();
		} while (answer.equals("y"));
	}
}

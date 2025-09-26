package com.cardgame;

import java.util.Stack;

public interface Game {

	//Initialize player cards
	public void initializePlayerCards(CardDeck deck, int cards, Stack<String> player1, Stack<String> player2);
}

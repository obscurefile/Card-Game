package com.cardgame;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CardDeck {
	
	//Number of suits, ranks, and cards
	public static final int CARD_SUITS = 4;
	public static final int CARD_RANKS = 13;
	public static final int CARD_NUM = CARD_SUITS * CARD_RANKS;
	
	//Card suits
	private enum Suits {
		Heart, Diamond,
		Spade, Club
	}
	
	//Card ranks	
	private enum Ranks {
		Two(2), Three(3), Four(4),
		Five(5), Six(6), Seven(7),
		Eight(8), Nine(9), Ten(10), 
		Jack(11), Queen(12), King(13),
		Ace(14);
		
		private final int cardPower;
		
		//Gets the number value from ranks
		private Ranks(int value) {
			this.cardPower = value;
		}
		
		//Returns card power
		private int getCardPower() {
			return cardPower;
		}
	}
	
	//Deck of cards
	private String[] storedCards = new String[CARD_NUM];
	
	//Returns stored cards 
	public String[] getStoredCards() {
		
		return storedCards;
	}
	
	//Gets random card suit or rank
	private int randomCardNum(int category) {
		
		int num = new Random().nextInt(0, category);
		return num;
	}
		
	//Makes random card
	private String randomCard() {
		
		String chosenCardSuit = Suits.values()[randomCardNum(CARD_SUITS)].toString();
		String chosenCardRank = Ranks.values()[randomCardNum(CARD_RANKS)].toString();
	
		String chosenCard = chosenCardRank + " of " + chosenCardSuit + "s";
		
		return chosenCard;
	}
	
	//Creates a deck of cards
	public void createDeck() {
		
		for (int i = 0; i < CARD_NUM; i++) {
			
			String playerCard = randomCard();
		
			//Checks if the card is not already made
			if (!(Arrays.asList(storedCards).contains(playerCard)) && i < CARD_NUM) {
				
				storedCards[i] = playerCard;
			} else {
				i--;
			}
		}
	}
	
	//Shuffles deck of cards
	public void shuffleDeck() {
		
		Collections.shuffle(Arrays.asList(storedCards));
	}
	
	//Compares two player cards
	public int compareCards(String player1Card, String player2Card) {

		//Player card values
		int p1CardValue = 0;
		int p2CardValue = 0;
		
		//Card ranks
		String[] ranks = new String[CARD_RANKS];
		
		//Adds all of card ranks to an array
		for (int i = 0; i < CARD_RANKS; i++) {
			ranks[i] = Ranks.values()[i].toString();
		}
		
		//Checks through rank array
		for (int j = 0; j < ranks.length; j++) {
			
			//If player 1's card contains the rank from the array the card's value becomes the same value as the rank
			if (player1Card.contains(ranks[j])) {
				
				p1CardValue = Ranks.valueOf(ranks[j]).getCardPower();
			}
			
			//If player 2's card contains the rank from the array the card's value becomes the same value as the rank
			if (player2Card.contains(ranks[j])) {

				p2CardValue = Ranks.valueOf(ranks[j]).getCardPower();
			}
		}
		
		//Compares both cards
		return Integer.compare(p1CardValue, p2CardValue);
	}
}

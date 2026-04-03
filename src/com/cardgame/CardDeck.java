package com.cardgame;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CardDeck {
	
	//Number of suits, ranks, and cards
	public static final int CARD_SUITS = 4;
	public static final int CARD_RANKS = 13;
	public static final int MAX_CARDS = CARD_SUITS * CARD_RANKS;
	
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
	private String[] storedCards = new String[MAX_CARDS];
	
	//Returns stored cards 
	public String[] getStoredCards() {
		
		return storedCards;
	}
		
	//Makes random card
	private String randomCard() {
		
		//Creates card using rank and suit names
		String card = Ranks.values()[new Random().nextInt(0, CARD_RANKS)].toString() + " of " + Suits.values()[new Random().nextInt(0, CARD_SUITS)].toString() + "s";
		
		return card;
	}
	
	//Creates a deck of cards
	public void createDeck() {
		
		for (int i = 0; i < MAX_CARDS; i++) {
			
			String playerCard = randomCard();
		
			//Checks if the card is not already made
			if (!(Arrays.asList(storedCards).contains(playerCard)) && i < MAX_CARDS) {
				
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
		
		//Checks through ranks
		for (Ranks r : Ranks.values()) {
			
			//Gets the card power of each card
			if (player1Card.contains(r.toString())) {
				
				p1CardValue = Ranks.valueOf(r.toString()).getCardPower();
			} else if(player2Card.contains(r.toString())) {
				
				p2CardValue = Ranks.valueOf(r.toString()).getCardPower();
			}
		}
		
		//Compares both cards
		return Integer.compare(p1CardValue, p2CardValue);
	}
}

package com.cardgame;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CardDeck {
	
	public static final int CARD_SUITS = 4;
	public static final int CARD_RANKS = 13;
	public static final int MAX_CARDS = CARD_SUITS * CARD_RANKS;
	
	private String[] storedCards = new String[MAX_CARDS];
	
	private enum Suits {
		Heart, Diamond,
		Spade, Club
	}
		
	private enum Ranks {
		Two(2), Three(3), Four(4),
		Five(5), Six(6), Seven(7),
		Eight(8), Nine(9), Ten(10), 
		Jack(11), Queen(12), King(13),
		Ace(14);
		
		private final int cardPower;
		
		private Ranks(int value) {
			this.cardPower = value;
		}
		
		private int getCardPower() {
			return cardPower;
		}
	}
	
	public String[] getStoredCards() {
		
		return storedCards;
	}
		
	private String randomCard() {
		
		String card = Ranks.values()[new Random().nextInt(0, CARD_RANKS)].toString() + " of " + Suits.values()[new Random().nextInt(0, CARD_SUITS)].toString() + "s";
		return card;
	}
	
	public void createDeck() {
		
		for (int i = 0; i < MAX_CARDS; i++) {
			
			String playerCard = randomCard();
		
			//In case the card already exists
			if (!(Arrays.asList(storedCards).contains(playerCard)) && i < MAX_CARDS) {
				
				storedCards[i] = playerCard;
			} else {
				i--;
			}
		}
	}
	
	public void shuffleDeck() {
		
		Collections.shuffle(Arrays.asList(storedCards));
	}
	
	public int compareCards(String player1Card, String player2Card) {

		int p1CardValue = 0;
		int p2CardValue = 0;
		
		for (Ranks r : Ranks.values()) {
			
			//Gets the card power of each card
			if (player1Card.contains(r.toString())) {
				
				p1CardValue = Ranks.valueOf(r.toString()).getCardPower();
			} else if(player2Card.contains(r.toString())) {
				
				p2CardValue = Ranks.valueOf(r.toString()).getCardPower();
			}
		}
		
		return Integer.compare(p1CardValue, p2CardValue);
	}
}

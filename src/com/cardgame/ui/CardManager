package com.cardgame.ui;

import com.cardgame.War;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;
import java.util.Map;

public class CardManager {
	
	//Parts of the card
	private BufferedImage cardBack, blankCard, cardSuit, rankCardSuit, cardRank, courtCard;
	
	//Name of the card
	private String cardName;
	
	//Card suit number
	private int suitNum;

	//Image loaded
	boolean imagedLoaded;
	
	//Constructor
	public CardManager(boolean player) {
		
		if (player == true) {
			
			setBlankCard();
			setCardBack();
		}
	}
	
	//Sets the card before it gets drawn
	void setCardName(String card) {
		
		cardName = card;
	}
	
	//Sets card back
	private void setCardBack() {
		
		try {
		
			cardBack = ImageIO.read(getClass().getResourceAsStream("/cards/cardback.png"));
		} catch (IOException e) {
			
			System.err.println("Card back image not located");
		}
	}
	
	//Sets card suit images
	private void setCardSuit(String suit, String smallSuit) {
		
		try {
			
			cardSuit = ImageIO.read(getClass().getResourceAsStream("/suits/" + suit + ".png"));
			rankCardSuit = ImageIO.read(getClass().getResourceAsStream("/suits/" + smallSuit + ".png"));
		} catch (IOException e) {

			System.err.println("Card suit images not located");
		}
	}
	
	//Sets card rank images
	private void setCardRank(String rank) {
		
		try {
			
			cardRank = ImageIO.read(getClass().getResourceAsStream("/ranks/" + rank + ".png"));
		} catch (IOException e) {

			System.err.println("Card rank images not located");
		}
	}
	
	//Sets court card image
	private void setCardCourt(String court) {
		
		try {
			
			courtCard = ImageIO.read(getClass().getResourceAsStream("/courts/" + court + ".png"));
		} catch (IOException e) {
			
			System.err.println("Court card images not located");
		}
	}
	
	//Gets card suit based on card name
	private void getCardSuit() {
	
		int cardSuitNum = 0;		
		
		//Card suits
		Map<Integer, String> suits =
				
			Map.ofEntries(
					
				Map.entry(1, "Heart"), Map.entry(2, "Diamond"),
				Map.entry(3, "Spade"), Map.entry(4, "Club")
			);

		//Sets suit depending on card name
		for (int value : suits.keySet()) {
			
			if (cardName.contains(suits.get(value).toString())) {
				
				cardSuitNum = value;
				break;
			}
		}
		
		switch (cardSuitNum) {
		
		case 1:
			setCardSuit("heart", "rankHeart");
			break;
			
		case 2:
			setCardSuit("diamond", "rankDiamond");
			break;
			
		case 3:
			setCardSuit("spade", "rankSpade");
			break;
			
		case 4:
			setCardSuit("club", "rankClub");
			break;
		}
	}
	
	//Gets card rank based on card name
	private void getCardRank() {

		int cardRankNum = 0;
		
		//Card ranks
		Map<Integer, String> ranks = 
				
			Map.ofEntries(
					
				Map.entry(1, "Two"), Map.entry(2, "Three"),
				Map.entry(3, "Four"), Map.entry(4, "Five"),
				Map.entry(5, "Six"), Map.entry(6, "Seven"),
				Map.entry(7, "Eight"), Map.entry(8, "Nine"),
				Map.entry(9, "Ten"), Map.entry(10, "Jack"),
				Map.entry(11, "Queen"), Map.entry(12, "King"),
				Map.entry(13, "Ace")
			);
				
		//Sets rank depending on card name	
		for(int value : ranks.keySet()) {
			
			if(cardName.contains(ranks.get(value))) {
				
				cardRankNum = value;
				break;
			}
		}
		
		//Ensures the right amount of suits are drawn on each card
		suitNum = cardRankNum;
		
		switch (cardRankNum) {
		
		case 1:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rTwo");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
		
				setCardRank("bTwo");
			}
			
			break;
		
		case 2:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rThree");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bThree");
			}
			
			break;
			
		case 3:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rFour");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bFour");
			}
			
			break;
			
		case 4:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rFive");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bFive");
			}
			
			break;
			
		case 5:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rSix");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bSix");
			}
			
			break;
			
		case 6:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rSeven");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bSeven");
			}
			
			break;
			
		case 7:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rEight");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bEight");
			}
			
			break;
			
		case 8:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rNine");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bNine");
			}
			
			break;
			
		case 9:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rTen");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bTen");
			}
			
			break;
			
		case 10:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardCourt("rCourtJack");
				setCardRank("rJack");

			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardCourt("bCourtJack");
				setCardRank("bJack");

			}
			
			break;
			
		case 11:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardCourt("rCourtQueen");
				setCardRank("rQueen");
				
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardCourt("bCourtQueen");
				setCardRank("bQueen");
				
			}
			
			break;
			
		case 12:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardCourt("rCourtKing");
				setCardRank("rKing");
				
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardCourt("bCourtKing");
				setCardRank("bKing");

			}
			
			break;
			
		case 13:
			
			if (cardName.contains("Heart") || cardName.contains("Diamond")) {
				
				setCardRank("rAce");
			} else if (cardName.contains("Spade") || cardName.contains("Club")) {
				
				setCardRank("bAce");
			}
			
			break;
		}
		
	}
	
	//Sets blank card
	private void setBlankCard() {
			
		try {
			
			blankCard = ImageIO.read(getClass().getResourceAsStream("/cards/blankCard.png"));
		} catch (IOException e) {
			
			System.err.println("Blank card image not located");
		}	
	}

	//Sets components from resources based on card name
	public void setPlayerCard(String card) {
		
		setCardName(card);
		getCardSuit();
		getCardRank();
	}
	
	//Add card suits to blank card
	private void addCardSuit(Graphics2D g2, int x, int y) {
		
		//Card suit under rank
		g2.drawImage(rankCardSuit, x+17, y+57, rankCardSuit.getTileWidth(), rankCardSuit.getTileHeight(), null);
		
		//Upside down card suit under rank
		g2.drawImage(rankCardSuit, x+143, (y+168) + rankCardSuit.getTileHeight(), rankCardSuit.getTileWidth(), -rankCardSuit.getTileHeight(), null);
		
		//Each case draws a different card depending on the number
		switch (suitNum) {
		
		case 1:
			//Top row
			g2.drawImage(cardSuit, x+75, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+75, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
		
		case 2:
			//Top row
			g2.drawImage(cardSuit, x+75, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Middle row
			g2.drawImage(cardSuit, x+75, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+75, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 3:
			//Top row
			g2.drawImage(cardSuit, x+47, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+47, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 4:
			//Top row
			g2.drawImage(cardSuit, x+47, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Middle row
			g2.drawImage(cardSuit, x+75, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+47, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 5:
			//Top row
			g2.drawImage(cardSuit, x+47, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Middle row
			g2.drawImage(cardSuit, x+47, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+47, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 6:
			//Top row
			g2.drawImage(cardSuit, x+47, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Middle row
			g2.drawImage(cardSuit, x+47, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+75, y+82, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+47, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
		
		case 7:
			//Top row
			g2.drawImage(cardSuit, x+47, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+57, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Middle row
			g2.drawImage(cardSuit, x+47, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+75, y+82, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+47, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+74, (y+136) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+163) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 8:
			//Top row
			g2.drawImage(cardSuit, x+47, y+27, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+27, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+47, y+77, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+77, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Middle row
			g2.drawImage(cardSuit, x+75, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+47, (y+143) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+143) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+47, (y+193) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+193) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 9:
			//Top row
			g2.drawImage(cardSuit, x+47, y+27, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+27, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+47, y+77, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, y+77, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+74, y+51, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			
			//Bottom row
			g2.drawImage(cardSuit, x+47, (y+143) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+143) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+47, (y+193) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+103, (y+193) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+74, (y+168) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 10:
			//Court card frame
			g2.drawImage(courtCard, x+47, y+57, courtCard.getTileWidth(), courtCard.getTileHeight(), null);
			
			//Card suits
			g2.drawImage(cardSuit, x+50, y+62, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+99, (y+158) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
		
		case 11:
			//Court card frame
			g2.drawImage(courtCard, x+47, y+57, courtCard.getTileWidth(), courtCard.getTileHeight(), null);
			
			//Card suits
			g2.drawImage(cardSuit, x+50, y+62, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+99, (y+158) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 12:
			//Court card frame
			g2.drawImage(courtCard, x+47, y+57, courtCard.getTileWidth(), courtCard.getTileHeight(), null);
			
			//Card suits
			g2.drawImage(cardSuit, x+50, y+62, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			g2.drawImage(cardSuit, x+99, (y+158) + cardSuit.getTileHeight(), cardSuit.getTileWidth(), -cardSuit.getTileHeight(), null);
			break;
			
		case 13:
			//Card suit in center of card
			g2.drawImage(cardSuit, x+75, y+110, cardSuit.getTileWidth(), cardSuit.getTileHeight(), null);
			break;
		}
	}
	
	//Add card rank to blank card
	private void addCardRank(Graphics2D g2, int x, int y) {
		
		//Card rank over suit
		g2.drawImage(cardRank, x+17, y+22, cardRank.getTileWidth(), cardRank.getTileHeight(), null);
		
		//Upside down card rank over suit
		g2.drawImage(cardRank, (x+143) + cardRank.getTileWidth(), (y+198) + cardRank.getTileHeight(), -cardRank.getTileWidth(), -cardRank.getTileHeight(), null);
	}

	//Status of card suit images
	private boolean suitImagesLoaded() {
		
		//If the card has a court image
		if (cardName.contains("Jack") || cardName.contains("Queen") || cardName.contains("King")) {
			
			imagedLoaded = rankCardSuit != null && cardSuit != null && courtCard != null;

		//If the card doesn't have a court image
		} else {
			
			imagedLoaded = rankCardSuit != null && cardSuit != null;	
		}
		
		return imagedLoaded;
	}
	
	//Status of card rank images
	private boolean rankImagesLoaded() {
		
		return cardRank != null;
	}
	
	//Creates card with components
	private void createCard(Graphics2D g2, int x, int y) {

		g2.drawImage(blankCard, x, y, blankCard.getTileWidth(), blankCard.getTileHeight(), null);
		
		if (cardName != null) {
		
			//Add card suit images
			if (suitImagesLoaded()) {
				
				addCardSuit(g2, x, y);
			}

			//Add card rank images
			if (rankImagesLoaded()) {
				
				addCardRank(g2, x, y);	
			}
		}
	}
	
	//Draws deck of player 1's cards
	public void drawPlayer1Deck(Stack<String> playerDeck, Graphics2D g2, int x, int y) {
		
		for (int i = 0; i < playerDeck.size()-1; i++) {
			g2.drawImage(cardBack, x+(i), y, cardBack.getTileWidth(), cardBack.getTileHeight(), null);;
		}
	}
	
	//Draws deck of player 2's cards
	public void drawPlayer2Deck(Stack<String> playerDeck, Graphics2D g2, int x, int y) {

		for (int i = 0; i < playerDeck.size()-1; i++) {
			g2.drawImage(cardBack, x-(i), y+cardBack.getTileHeight(), cardBack.getTileWidth(), -cardBack.getTileHeight(), null);;
		}
	}
	
	//Draws drawn player card
	public void drawPlayerCard(Graphics2D g2, int x, int y) {
		
		createCard(g2, x, y);
	}

	//Draws war on screen
	public void drawWar(Graphics2D g2, int x, int y) {
		
		for (int i = 0; i < 3; i++) {
			g2.drawImage(cardBack, x, y+200+(i*20), cardBack.getTileWidth(), cardBack.getTileHeight(), null);
		}
		
		drawPlayerCard(g2, x, y+260);
	}
	
	//Update cards
	public void cardUpdate(CardManager player1, CardManager player2, War game) {
		
		if (game.inGame(game.getPlayer1Cards())) {
					
			player1.setPlayerCard(game.getPlayer1Cards().peek());
		}
		
		if (game.inGame(game.getPlayer2Cards())) {
			
			player2.setPlayerCard(game.getPlayer2Cards().peek());
		}
	}
}

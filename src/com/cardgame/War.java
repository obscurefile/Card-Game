package com.cardgame;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class War implements Game {

	//Player cards
	private Stack<String> player1Cards = new Stack<>();
	private Stack<String> player2Cards = new Stack<>();
	
	//Drawn cards used for war
	private Stack<String> player1DrawnCards = new Stack<>();
	private Stack<String> player2DrawnCards = new Stack<>();
	
	//Timer
	public static Timer timer = new Timer();
	private int delay = 2000;
	
	//War Visible
	private boolean warCardsVisible;
	
	//Get player 1 cards
	public Stack<String> getPlayer1Cards(){
			
			return player1Cards;
	}
	
	//Get player 2 cards
	public Stack<String> getPlayer2Cards(){
			
			return player2Cards;
	}
	
	//Get player 1 drawn cards
	public Stack<String> getPlayer1DrawnCards(){
		
		return this.player1DrawnCards;
	}
	
	//Get player 2 drawn cards
	public Stack<String> getPlayer2DrawnCards(){
			
			return this.player2DrawnCards;
	}
	
	public boolean getWarVisibility() {
		
		return warCardsVisible;
	}
	
	public void setWarVisibility(boolean value) {
		
		warCardsVisible = value;
	}

	//Player has won
	public boolean gameFinished() {
		
		return player1Cards.size() == 0 || player2Cards.size() == 0;
	}
	
	//Player is in the match
	public boolean inGame(Stack<String> player) {
		
		return player.size() < 52 && player.size() > 0;
	}
	
	//Checks if both players are eligible for war
	private boolean eligibleForWar() {
		
		return player1Cards.size() >= 4 && player2Cards.size() >= 4;
	}
	
	//Delay
	private void delay() {
		
		try {
			
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
	//Show player cards during war
	private void showCards() {
		
		warCardsVisible = true;
		
		if (warCardsVisible) {
			
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					
					warCardsVisible = false;
				}
			};
			
			timer.schedule(task, delay);
			
			delay();
		}
	}
	
	//Gives each player their cards
	@Override
	public void initializePlayerCards(CardDeck deck, int cards, Stack<String> player1, Stack<String> player2) {
		
		for (int i = 0; i < cards; i++) {
			
			player1.push(deck.getStoredCards()[i]);
		}
		
		for (int n = 0; n < cards; n++) {
			
			player2.push(deck.getStoredCards()[cards + n]);
		}
	}
	
	//Compares player cards
	private int compareCards(CardDeck deck) {
		
		return deck.compareCards(player1Cards.peek(), player2Cards.peek());
	}
	
	//Compares player drawn cards
	private int compareDrawnCards(CardDeck deck) {
		
		return deck.compareCards(player1DrawnCards.peek(), player2DrawnCards.peek());
	}
	
	//Player wins play
	private void playerWinsPlay(Stack<String> winner, Stack<String> loser) {
		
		//Temporary stack
		Stack<String> temp = new Stack<>();
		
		//Holds both the winner's card and loser's card
		temp.push(winner.pop());
		temp.push(loser.pop());
		
		//The cards get sent to the bottom of the stack
		temp.addAll(winner);
		
		//Temporary stack becomes the winner's stack
		winner.clear();
		winner.addAll(temp);
		
		temp = null;
	}
	
	//Player wins war  
	private void playerWinsWar(Stack<String> winner, Stack<String> winnerDrawn, Stack<String> loserDrawn, Stack<String> drawn) {
		
		//Temporary stack
		Stack<String> temp = new Stack<>();

		//Cards added to drawn pile
		drawn.addAll(winnerDrawn);
		drawn.addAll(loserDrawn);
		
		//Temporary stack holds drawn cards and adds the winner cards on top
		temp.addAll(drawn);
		temp.addAll(winner);
		
		//Winner cards gets all the cards in the drawn stack
		winner.clear();
		winner.addAll(temp);
		
		//Drawn cards get cleared for next play
		winnerDrawn.clear();
		loserDrawn.clear();

		temp = null;
		drawn.clear();
	}
	
	//Player wins the match
	private void playerWins(Stack<String> winner, Stack<String> loser) {
		
		//Temporary stack
		Stack<String> temp = new Stack<>();
		
		//Adds all of the cards to temporary stack
		temp.addAll(loser);
		temp.addAll(winner);
		
		//Clears winner and loser stacks
		loser.clear();
		winner.clear();
		
		//Winner gets all the cards
		winner.addAll(temp);
		
		temp = null;
	}
	
	//Player wins match during war
	private void playerWins(Stack<String> winner, Stack<String> loser, Stack<String> drawn) {
			
		//Temporary stack
		Stack<String> temp = new Stack<>();
		
		//Adds the drawn cards to the winner
		temp.addAll(drawn);
		
		//Adds all of the cards to temporary stack
		temp.addAll(loser);
		temp.addAll(winner);
		
		//Clears winner and loser stacks
		loser.clear();
		winner.clear();
		
		//Winner gets all the cards
		winner.addAll(temp);
		
		temp = null;
		
		drawn.clear();
	}

	//Ends match
	private void endWar() {
		
		if (player1Cards.size() > player2Cards.size()) {
			
			playerWins(player1Cards, player2Cards);
		} else {
			
			playerWins(player2Cards, player1Cards);
		}
	}
	
	//End war and match
	private void endWar(Stack<String> drawn) {
		
		if (player1Cards.size() > player2Cards.size()) {
			
			playerWins(player1Cards, player2Cards, drawn);
		} else {
			
			playerWins(player2Cards, player1Cards, drawn);
		}
	}

	//War
	private void playerWar(CardDeck deck) {

		//Drawn cards
		Stack<String> drawnCards = new Stack<>();
		
		//Both players placed down cards as well as 4 addition cards gets added to their drawn cards
		for (int i = 0; i < 5; i++) {
			
			player1DrawnCards.push(player1Cards.pop());
			player2DrawnCards.push(player2Cards.pop());

		}

		showCards();
		
		switch (compareDrawnCards(deck)) {
		
		//Player 1 Takes Cards
		case 1:
			
			playerWinsWar(player1Cards, player1DrawnCards, player2DrawnCards, drawnCards);
			break;
			
		//Player 2 Takes Cards
		case -1:
			
			playerWinsWar(player2Cards, player2DrawnCards, player1DrawnCards, drawnCards);
			break;
		
		//Both players draw more cards
		case 0:

			while (compareDrawnCards(deck) == 0 && eligibleForWar()) {
				
				for(int i = 0; i < 4; i++) {
					
					player1DrawnCards.push(player1Cards.pop());
					player2DrawnCards.push(player2Cards.pop());
				}
				
				showCards();
			}
			
			if (compareDrawnCards(deck) == 1) {
				
				if (player1Cards.size() > 4 && player2Cards.size() < 4) {
						
					playerWins(player1Cards, player2Cards, drawnCards);
					
				} else {
					
					playerWinsWar(player1Cards, player1DrawnCards, player2DrawnCards, drawnCards);
				}
				
			} else if (compareDrawnCards(deck) == -1) {
				
				if (player2Cards.size() > 4 && player1Cards.size() < 4) {
					
					playerWins(player2Cards, player1Cards, drawnCards);
				} else {
					
					playerWinsWar(player2Cards, player2DrawnCards, player1DrawnCards, drawnCards);
				}
			} else if (compareDrawnCards(deck) == 0){
				
				endWar(drawnCards);
			}
			break;
		}
		
		//Drawn cards get cleared for next match
		player1DrawnCards.clear();
		player2DrawnCards.clear();
	}	
	
	//Plays each player cards
	public void playCard(CardDeck deck) {
		
		int cardResult;
		
		//Comparing each players first card
		cardResult = compareCards(deck);
		
		switch (cardResult) {
		
		//Player 1 Takes Cards
		case 1:
			
			playerWinsPlay(player1Cards, player2Cards);
			
			break;
			
		//Cards have the same power
		case 0:
			
			//If both players have enough cards war starts
			if (player1Cards.size() >= 5 && player2Cards.size() >= 5) {
				
				playerWar(deck);	
			} else {
				
				//Ends war if either player doesn't have enough cards
				endWar();
			}
			
			break;
			
		//Player 2 Takes Cards
		case -1:
			
			playerWinsPlay(player2Cards, player1Cards);
			
			break;
		}
	}
}

package com.cardgame.ui;

import com.cardgame.CardDeck;
import com.cardgame.War;
import java.util.Timer;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
	
	//JPanel width and height
	final static int WIDTH = 1200;
	final static int HEIGHT = 800;
	
	//Player card positions
	int player1X = 300;
	int player1Y = 250;
	
	int player2X = 700;
	int player2Y = 250;
	
	//Player Deck positions
	int player1DeckX = 50;
	int player1DeckY = 500;
	
	int player2DeckX = 970;
	int player2DeckY = 50;
	
	//Player Mouse
	MouseHandler playerMouse = new MouseHandler();
	
	//Card Managers
	CardManager gameCardManager = new CardManager(false);
	CardManager player1CardManager = new CardManager(true);
	CardManager player2CardManager = new CardManager(true);
	CardManager player1WarCardManager = new CardManager(true);
	CardManager player2WarCardManager = new CardManager(true);
	
	//Game
	CardDeck deck = new CardDeck();
	War warGame = new War();
	
	//Creates game panel, what will display and run the game
	public GamePanel(Timer timer) {
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));;
		this.setBackground(new Color(0, 128, 0));
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addMouseListener(playerMouse);
		timer = new Timer();
	}
	
	//Game thread
	Thread gameThread;
	
	//Starts the game thread, the program will run once this thread commences and end once it stops
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {

		//Creates a new deck of cards and distributes to each player
		deck.createDeck();
		deck.shuffleDeck();
		
		//Gives each player 26 cards
		warGame.initializePlayerCards(deck, 26, warGame.getPlayer1Cards(), warGame.getPlayer2Cards());
		
		while(gameThread != null){
			
			update();
			repaint();
				
			//If either player wins the game ends
			if (warGame.gameFinished() == true) {
				
				if (warGame.getPlayer1Cards().size() > warGame.getPlayer2Cards().size()) {
					
					System.out.println("Player 1 Wins!");
				} else {
					
					System.out.println("Player 2 Wins!");
				}
			}
			
			//If there are additional cards the game stops
			if (((warGame.getPlayer1Cards().size() + warGame.getPlayer2Cards().size()) != 52)) {
				
				System.err.println(Math.abs((warGame.getPlayer1Cards().size() + warGame.getPlayer2Cards().size())-52) + " Cards Misplaced");
				
				System.err.println("Player 1: " + warGame.getPlayer1Cards().size() + "\n" + "Player 2: " + warGame.getPlayer2Cards().size());
				
				gameThread = null;
			}
		}
	}
	
	//Updates on-screen information
	public void update() {

		//Plays card after every click
		if (playerMouse.mouseClick == true && warGame.gameFinished() == false) {
			
			warGame.playCard(deck);
			
			playerMouse.mouseClick = false;	
		}
		
		//Sets the next cards after a play as long as neither of the players have won
		if (warGame.gameFinished() != true) {
			
			gameCardManager.cardUpdate(player1CardManager, player2CardManager, warGame);
		} 
	}
	
	//Paints on-screen information
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		//Draws player 1's deck
		player1CardManager.drawPlayer1Deck(warGame.getPlayer1Cards(), g2, player1DeckX, player1DeckY);
		
		//Draws player 2's deck
		player2CardManager.drawPlayer2Deck(warGame.getPlayer2Cards(), g2, player2DeckX, player2DeckY);
		
		//Draws player 1's cards if they are in game
		if (warGame.inGame(warGame.getPlayer1Cards())) {
			
			player1CardManager.drawPlayerCard(g2, player1X, player1Y);
		}
		
		//Draws player 2's cards if they are in game
		if (warGame.inGame(warGame.getPlayer2Cards())) {
			
			player2CardManager.drawPlayerCard(g2, player2X, player2Y);
		}
		
		//Draw player 1's cards during war
		if (!warGame.getPlayer1DrawnCards().isEmpty()) {
			
			//Updates player 1's cards during war
			player1WarCardManager.setPlayerCard(warGame.getPlayer1DrawnCards().peek());
			
			player1WarCardManager.drawWar(g2, player1X, player1Y);
		}
		
		//Draw player 2's cards during war
		if (!warGame.getPlayer2DrawnCards().isEmpty()) {
			
			//Updates player 2's cards during war
			player2WarCardManager.setPlayerCard(warGame.getPlayer2DrawnCards().peek());
			
			player2WarCardManager.drawWar(g2, player2X, player2Y);
		}

		g2.dispose();
	}
}

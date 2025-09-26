package com.cardgame.ui;

import com.cardgame.War;

public class Main {
	
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		GamePanel game = new GamePanel(War.timer);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null); //Makes default frame position the middle of the screen
		
		game.startGameThread();
	}
}
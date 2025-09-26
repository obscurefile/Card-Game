package com.cardgame.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

	boolean mouseClick, held;
	
	//Checks if mouse is within Player 1's deck
	public boolean inDeck(MouseEvent mouse) {
		
		boolean test = (mouse.getX() > 50 && mouse.getX() < 230 && mouse.getY() > 500 && mouse.getY() < 750);
		return test;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (inDeck(e)) {
			mouseClick = true;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
package com.cardgame.ui;

import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GameFrame extends JFrame {
	
	public GameFrame() {
		this.setTitle("War Game"); //Titles frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Makes exit close frame 
		this.getContentPane().setBackground(Color.black); //Sets background color to black
		this.setVisible(true); //Makes frame visible
		this.setResizable(false); //Stops user from changing frame size
		
		File img = new File("res/icons/cardgameicon.png"); //Gets image file from resource folder
		String cardicon = img.getAbsolutePath(); //Gets the path of the image file
		ImageIcon gameicon = new ImageIcon(cardicon); //Creates image icon
		
		this.setIconImage(gameicon.getImage()); //Sets image icon
	}
}
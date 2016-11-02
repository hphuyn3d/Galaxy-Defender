package com.game.src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Handles Keyboard input
 * Whenever user presses the key, it will call on this class
 * @author hunghuynh
 *
 */
public class KeyInput extends KeyAdapter {
	Game game;
	
	/**
	 * Calls keyboard input within the game class
	 * @param game
	 */
	public KeyInput(Game game){
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}

}

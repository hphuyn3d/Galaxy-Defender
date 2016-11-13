/**
 * Handles Keyboard input
 * Whenever user presses the key, it will call on this class
 * @author Hung Huynh
 *
 */
package com.game.src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	Game game;

	// Calls keyboard input within the game class
	public KeyInput(Game game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
	}

}

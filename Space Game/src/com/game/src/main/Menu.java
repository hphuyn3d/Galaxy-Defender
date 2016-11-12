package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	// Creating buttons
	public Rectangle playButton = new Rectangle(Game.WIDTH / 2 + 120, 150, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 + 120, 250, 100, 50);

	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		// Making a new font (title of game menu)
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("SPACE RANGER", Game.WIDTH / 2, 100);

		// Drawing the buttons
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 19, playButton.y + 30);
		g2d.draw(playButton);
		g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
		g2d.draw(quitButton);
	}

}

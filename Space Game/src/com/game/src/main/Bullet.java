package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

	private Textures tex;
	private Game game;

	public Bullet(double x, double y, Textures tex, Game game) {
		super(x, y);
		this.tex = tex;
		this.game = game;

	}

	public void tick() {
		y -= 10;
		if (Collision.Crash(this, game.e)) {
			System.out.println("COLLISION DETECTED");
		}
	}

	public void render(Graphics g) {
		g.drawImage(tex.missle, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	/**
	 * Makes the bullet destroy itself when it goes pass the screen
	 * 
	 * @return
	 */
	public double getY() {
		return y;
	}

}

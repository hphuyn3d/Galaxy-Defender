package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	private LinkedList<Enemy> e = new LinkedList<Enemy>();

	Random r = new Random();
	Bullet TempBullet;
	Enemy TempEnemy;
	Game game;
	Textures tex;

	public void createEnemy(int enemy_count) {
		for (int i = 0; i < enemy_count; i++) {
			// Randomizes enemy spawn location
			addEnemy(new Enemy(r.nextInt(Game.WIDTH * Game.SCALE), 0, tex, this, game));
		}
	}

	public Controller(Game game, Textures tex) {
		this.game = game;
		this.tex = tex;

	}

	public void tick() {
		for (int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);
			if (TempBullet.getY() < 0)
				removeBullet(TempBullet);

			TempBullet.tick();
		}
		for (int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);
			// Spawns enemy at the top of the screen if enemy has made it all
			// the way to the bottom
			TempEnemy.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);

			TempBullet.render(g);
		}
		for (int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);

			TempEnemy.render(g);
		}
	}

	public void addBullet(Bullet block) {
		b.add(block);
	}

	public void removeBullet(Bullet block) {
		b.remove(block);
	}

	public void addEnemy(Enemy block) {
		e.add(block);
	}

	public void removeEnemy(Enemy block) {
		e.remove(block);
	}

	public LinkedList<Bullet> getBullet() {
		return b;
	}

	public LinkedList<Enemy> getEnemy() {
		return e;
	}

}

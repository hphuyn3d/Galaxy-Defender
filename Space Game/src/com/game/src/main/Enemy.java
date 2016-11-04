package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject{
	private Textures tex;
	Random r = new Random();
	private int speed = (r.nextInt(3)+1);
	
	public Enemy(double x, double y, Textures tex){
		super(x, y);
		this.tex = tex;
	}
	
	/**
	 * updating method
	 */
	public void tick(){
		// Enemy travels at different speeds 
		y += speed;
		//// Spawns enemy randomly at the top of the screen if enemy has made it all the way to the bottom
		if(y > (Game.HEIGHT * Game.SCALE)){
			// Once they go down the screen, they will travel at different speeds at the top
			speed = (r.nextInt(3)+1);
			y = 0;
			x = r.nextInt(Game.WIDTH * Game.SCALE);
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void render(Graphics g){
		g.drawImage(tex.enemy, (int) x,(int) y, null) ;
	}
	
	

}

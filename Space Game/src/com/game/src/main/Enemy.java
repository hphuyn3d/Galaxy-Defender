package com.game.src.main;

import java.awt.Graphics;
import java.util.Random;

public class Enemy {
	private double x, y;
	private Textures tex;
	Random r = new Random();
	
	public Enemy(double x, double y, Textures tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
	}
	
	/**
	 * updating method
	 */
	public void tick(){
		y += 1;
		//// Spawns enemy randomly at the top of the screen if enemy has made it all the way to the bottom
		if(y > (Game.HEIGHT * Game.SCALE)){
			y = 0;
			x = r.nextInt(Game.WIDTH * Game.SCALE);
		}
	}
	
	public void render(Graphics g){
		g.drawImage(tex.enemy, (int) x,(int) y, null) ;
	}
	
	

}

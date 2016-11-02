package com.game.src.main;

import java.awt.Graphics;

public class Bullet {
	private double x;
	private double y;
	private Textures tex;
	 
	public Bullet(double x, double y, Textures tex){
		this.x = x;
		this.y = y;
		this.tex = tex;
		
		
	}
	
	public void tick(){
		y -= 10;
	}
	
	public void render(Graphics g){
		g.drawImage(tex.missle, (int) x, (int) y, null);
	}
	
	
	
	/**
	 * Makes the bullet destroy itself when it goes pass the screen
	 * @return
	 */
	public double getY(){
		return y;
	}
	

}

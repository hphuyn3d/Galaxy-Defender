package com.game.src.main;


import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	private double velX = 0;
	private double velY = 0;
	
	private Textures tex;
	
	
	public Player(double x, double y, Textures tex){
		super(x,y);
		this.tex = tex;
				
	}
	/**
	 * Smoother Movements 
	 */
	public void tick(){
		x += velX;
		y += velY;
		
		// So player cannot move pass the screen
		if(x <= 0)
			x = 0;
		if(x >= 640 - 22)
			x = 640 - 22;
		if(y < 0)
			y = 0;
		if(y >= 480 - 32)
			y = 480 - 32;

		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	/**
	 * Draws out our image
	 * @param g
	 */
	public void render(Graphics g){
		g.drawImage(tex.player, (int) x, (int) y, null);
		
	}
	
	/**
	 * Gets the X value of the player
	 * @return
	 */
	public double getX(){
		return x;
	}
	/**
	 * Gets the Y value of the player
	 * @return
	 */
	public double  getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setVelX(double velX){
		this.velX  = velX;
	}
	
	public void setVelY(double velY){
		this.velY  = velY;
	}

}

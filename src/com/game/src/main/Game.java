package com.game.src.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "2D Space Game";

	private boolean running = false;
	// Initializing thread
	private Thread thread;

	// Buffers window 
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	
	private boolean is_shooting = false;
	
	// Initializing Player
	private Player p;
	// Initializing Controller
	private Controller c;
	// Initializing Texture
	private Textures tex;
	
	 
	public void init(){
		// Brings the focus to the screen so you don't have to press the screen to start moving.
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			spriteSheet = loader.loadImage("/sprite_sheet.png");
			background = loader.loadImage("/background.png");
		}catch(IOException e){
			e.printStackTrace();
		}
		
		addKeyListener(new KeyInput(this));
		tex = new Textures(this);
		p = new Player(200, 200, tex);
		c = new Controller(this, tex);
	}

	private synchronized void start(){
		if(running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();  


	}

	// Saying synchronized means to deal with threads.
	private synchronized void stop(){
		if(!running)
			return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace(); //tells us our error
		}
		System.exit(1);

	} 

	// Game Loop
	public void run(){
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;  
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks, Fps " + frames);
				// Reset updates and frames
				updates = 0;
				frames = 0;
			}

		}
		stop();
	}
	/**
	 * Everything in the game that updates
	 */
	private void tick(){
		p.tick();
		c.tick();

	}

	/**
	 * Everything in the game that renders
	 */
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return; 
		}
		// creates graphic context for drawing buffers
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(background, 0, 0, null);
		
		p.render(g);
		c.render(g);
		//////////////////////////////////
		g.dispose();
		bs.show();

	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			p.setVelX(5);
		} else if (key == KeyEvent.VK_LEFT){
			p.setVelX(-5);
		} else if (key == KeyEvent.VK_DOWN){
			p.setVelY(5);
		} else if (key == KeyEvent.VK_UP) {
			p.setVelY(-5);
		} else if (key == KeyEvent.VK_SPACE && !is_shooting){
			is_shooting = true;
			c.addBullet(new Bullet(p.getX(), p.getY(), tex));
		}
		
	}
	
	
	/**
	 * Method that resets the input back to 0. 
	 * @param e
	 */
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			p.setVelX(0);
		} else if (key == KeyEvent.VK_LEFT){
			p.setVelX(0);
		} else if (key == KeyEvent.VK_DOWN){
			p.setVelY(0);
		} else if (key == KeyEvent.VK_UP) {
			p.setVelY(0);
		} else if (key == KeyEvent.VK_SPACE){
			is_shooting = false; // Forces player to hit the space bar key again inorder to shoot another bullet
		}
	} 



	public static void main(String args[]){
		Game game = new Game();

		// Setting Dimensions
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE ));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE ));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE ));

		JFrame frame = new JFrame(game.TITLE);
		// adding game class into the game 
		frame.add(game);
		// Packs object frame
		frame.pack();
		// The x (exit) button in the top right corner
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Don't want to resize window
		frame.setResizable(false);
		// Window starts in the middle of the screen instead of top left
		frame.setLocationRelativeTo(null);
		// Can actually see the game
		frame.setVisible(true);
		// Starts the game
		game.start();
	}
	
	 

	public BufferedImage getSpriteSheet() {
		// TODO Auto-generated method stub
		return spriteSheet;
	}
	
	





}

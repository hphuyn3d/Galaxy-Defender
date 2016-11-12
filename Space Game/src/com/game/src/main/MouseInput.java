package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		// Play button
		if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
			if (my >= 150 && my <= 200) {
				// Pressed Play Button
				Game.state = Game.STATE.GAME;
			}
		}
		// Quit Button
		if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
			if (my >= 250 && my <= 300) {
				// Pressed Quit Button
				System.exit(1); 
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

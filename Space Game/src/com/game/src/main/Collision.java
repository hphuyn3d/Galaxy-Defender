package com.game.src.main;

import java.util.LinkedList;

public class Collision {
	public static boolean Crash(Bullet b, LinkedList<Enemy> e) {
		for (int i = 0; i < e.size(); i++) {
			if (b.getBounds().intersects(e.get(i).getBounds())) {
				return true;
			}
		}
		return false;
	}

	public static boolean Crash(Enemy e, LinkedList<Bullet> b) {
		for (int i = 0; i < b.size(); i++) {
			if (e.getBounds().intersects(b.get(i).getBounds())) {
				return true;
			}
		}
		return false;
	}

}

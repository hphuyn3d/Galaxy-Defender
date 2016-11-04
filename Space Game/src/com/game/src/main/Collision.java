package com.game.src.main;

import java.util.LinkedList;

public class Collision {
	public static boolean Crash(Bullet b, LinkedList<Enemy> e){
		for(int i = 0; i < e.size(); i++){
			if(b.getBounds().intersects(e.get(i).getBounds())){
				return true;
			}
		}
		return false;
	}

}

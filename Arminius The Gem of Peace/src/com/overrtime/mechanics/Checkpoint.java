package com.overrtime.mechanics;

import com.overrtime.game.Display;
import com.overrtime.managers.LevelManager;
import com.overrtime.world.Level;
import com.overrtime.world.entities.Player;

public class Checkpoint {

	public static boolean kingdomCheckpoint, townCheckpoint, forestCheckpoint,cavern = false;
	public static String currentCheckpoint = "";
	public static int cx,cy;
	public static int lastHealth;
	
	public static boolean hasCheckpoint() {
		if(townCheckpoint) {
			return true;
		}
		if(forestCheckpoint) {
			return true;
		}
		return false;
	}
	
	public static void setCheckpoint(String name, boolean tof, int health) {
		if(name.equals("Kingdom")) {
			kingdomCheckpoint = true;
			townCheckpoint = false;
			forestCheckpoint = false;
			cx = 100;
			cy = 100;
			lastHealth = health;
			System.out.println("Checkpoint set!");
		}
		if(name.equals("Town")) {
			townCheckpoint = true;
			forestCheckpoint = false;
			kingdomCheckpoint = false;
			lastHealth = health;
			cx = 100;
			cy = 100;
			System.out.println("Checkpoint set!");
		}
		if(name.equals("Forest")) {
			forestCheckpoint = true;
			townCheckpoint = false;
			kingdomCheckpoint = false;
			lastHealth = health;
			cx = 100;
			cy = 100;
			System.out.println("Checkpoint set!");
		}
		if(name.equals("Cavern")) {
			cavern= true;
			forestCheckpoint = false;
			townCheckpoint = false;
			kingdomCheckpoint = false;
			lastHealth = health;
			cx = 100;
			cy = 100;
			System.out.println("Checkpoint set to: Cavern!");
		}
		
	}
	
	@SuppressWarnings("static-access")
	public static void setPlace() {
		if(townCheckpoint) {
			Player.xo = cx;
			Player.yo = cy;
			Player.health = lastHealth;
			LevelManager.setCurrentLevel(new Level(Display.getTextures().level), "Town", 300, 200);
		}
		if(forestCheckpoint) {
			Player.xo = cx;
			Player.yo = cy;
			Player.health = lastHealth;
			LevelManager.setCurrentLevel(new Level(Display.getTextures().forestLevel), "Forest", 100, 100);
		}
		if(cavern) {
			Player.xo = cx;
			Player.yo = cy;
			Player.health = lastHealth;
			LevelManager.setCurrentLevel(new Level(Display.getTextures().cavern), "Cavern", 100, 100);
		}
	}
	
	
	
}

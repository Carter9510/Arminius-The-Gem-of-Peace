package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;
import com.overrtime.managers.LevelManager;
import com.overrtime.mechanics.Checkpoint;
import com.overrtime.world.entities.Player;

public class Warp extends Tile {
	public BufferedImage texture;
	public static Rectangle warpRect;

	Rooms r = new Rooms();

	@SuppressWarnings("static-access")
	public Warp() {

		// Display.getTextures();
		texture = Display.getTextures().warp;

		setTexture(texture);

		setName("Warp");
	}

	public void tick() {
		//System.out.println(warpRect.x + ", " + warpRect.y);
	}

	@SuppressWarnings("static-access")
	public void render(Graphics g, int x, int y) {
		g.drawImage(this.texture, x, y, 32, 32, null);
		warpRect = new Rectangle(x, y, 32, 32);
		if (collides(warpRect)) {
			String name = LevelManager.getCurrentLevel().getName();
			if (name.equals("Room")) {
				LevelManager.setCurrentLevel(Display.room.current, Display.room.cName, Display.room.lx, Display.room.ly);
			}
			if (name.equals("Kingdom")) {
				LevelManager.setCurrentLevel(new Level(Display.getTextures().level), "Town", 300, 200);
				Checkpoint.setCheckpoint("Town", true, Player.aH);
			}
			if (name.equals("Town")) {
				LevelManager.setCurrentLevel(new Level(Display.getTextures().cavern), "Cavern", 100, 100);
				Checkpoint.setCheckpoint("Cavern", true, Player.aH);
			}
			if(name.equals("Cavern")) {
				LevelManager.setCurrentLevel(new Level(Display.getTextures().forestLevel), "Forest", 100, 100);
				Checkpoint.setCheckpoint("Forest",true, Player.aH);
			}
			if(name.equals("Forest")) {
				LevelManager.setCurrentLevel(new Level(Display.getTextures().level), "Town", 300, 200);
				Checkpoint.setCheckpoint("Town", true, Player.aH);
			}
		}
	}


}
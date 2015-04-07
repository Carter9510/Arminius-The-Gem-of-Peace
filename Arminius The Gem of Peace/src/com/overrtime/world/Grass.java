package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

import com.overrtime.game.Display;

public class Grass extends Tile{

	public BufferedImage texture;
	public BufferedImage lit;
	
	public static Rectangle gRect;
    Clip clip;
	
	@SuppressWarnings("static-access")
	public Grass() {
		texture = Display.getTextures().grass;

		setName("Grass");
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x,int y) {
		g.drawImage(texture, (int)x, (int)y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		gRect = new Rectangle((int)x,(int)y,8,8);
		
	}

	
}

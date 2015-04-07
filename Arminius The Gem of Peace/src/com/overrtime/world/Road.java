package com.overrtime.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Road extends Tile{

	private BufferedImage texture;
	
	@SuppressWarnings("static-access")
	public Road() {
		texture = Display.getTextures().road;
		setName("Road");
	}

	public void tick() {
		
	}


	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
	}
	

}

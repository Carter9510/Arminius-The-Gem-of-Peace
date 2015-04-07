package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class WoodT extends Tile{

	private BufferedImage texture;
	
	@SuppressWarnings("static-access")
	public WoodT() {
		
		texture = Display.getTextures().woodT;
		setName("WoodT");
	}

	public void tick() {
		
	}


	public void render(Graphics g, int x, int y) {
		new Grass().render(g, x, y);
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		Rectangle r = new Rectangle(x,y,32,32);
		
		if(collides(r)) {
			collide();
		}
		
	}
	
}

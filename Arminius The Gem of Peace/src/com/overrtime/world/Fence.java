package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Fence extends Tile{

	public 	BufferedImage texture;
	public Rectangle fenceRect = new Rectangle(0,0,32,32);
	
	

	@SuppressWarnings("static-access")
	public Fence() {
		texture = Display.getTextures().fence;
		setName("Fence");
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		new Grass().render(g, x, y);
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
	
		fenceRect = new Rectangle(x,y,32,32);
		
		if(collides(fenceRect)) {
			collide();
		}
		
		
		
		
	}

	
}

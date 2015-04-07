package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Marble extends Tile{

	public BufferedImage texture;
	
	public Rectangle marbleRect;
	
	@SuppressWarnings("static-access")
	public Marble() {
		solid(true);
		
		texture = Display.getTextures().marble;
		setName("Marble");
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		
		marbleRect = new Rectangle(x,y,32,32);
		
		if(collides(marbleRect))
			collide();
		
	}

	
}

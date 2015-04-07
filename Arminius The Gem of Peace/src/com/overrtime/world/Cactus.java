package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Cactus extends Tile{

	public BufferedImage texture;
	public Rectangle cactusRect = new Rectangle(0,0,0,0);
		
	@SuppressWarnings("static-access")
	public Cactus() {
		setTexture(Display.getTextures().cactus);
		setName("Cactus");
		setLightValue(0);
	}
	
	public void tick() {
		
	}

	@SuppressWarnings("static-access")
	public void render(Graphics g, int x, int y) {
		g.drawImage(Display.getTextures().sand, x,y,32,32, null);
		g.drawImage(getTexture(), x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		
		cactusRect = new Rectangle(x,y,32,32);
		
		if(collides(cactusRect)) {
			collide();
		}
		
		
		
		harm(cactusRect, 0.1);
	}
	
}

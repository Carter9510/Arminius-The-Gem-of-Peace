package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class TombStone extends Tile{

	public BufferedImage texture;
	public Rectangle tRect;
	
	@SuppressWarnings("static-access")
	public TombStone() {
		texture = Display.getTextures().tombstone;
		setName("Tombstone");
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x,int y) {
		new Grass().render(g, x, y);
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		
		
		if(collides(new Rectangle(x,y,32,32))) 
			collide();
	}
	
	
}

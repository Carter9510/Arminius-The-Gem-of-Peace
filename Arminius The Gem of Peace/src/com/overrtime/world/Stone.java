package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;
import com.overrtime.mechanics.Recipe;

public class Stone extends Tile{

	public BufferedImage texture;
	public static Rectangle stoneRect = new Rectangle(0,0,32,32);
	
	int z = 16;
	
	Recipe r = new Recipe();
	
	int ix,iy;
	
	@SuppressWarnings("static-access")
	public Stone() {
		ix = x;
		iy = y;
		texture = Display.getTextures().stone;
		setName("Stone");
	}
	
	public void tick() {
	
	}

	@SuppressWarnings("static-access")
	public void render(Graphics g, int x, int y) {
		this.x = x;
		this.y =y;
		g.drawImage(texture, x,y, Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		stoneRect = new Rectangle(x,y,32,32);
		
		if(collides(stoneRect)) {
			collide();
		}
		
	}
	
	
}
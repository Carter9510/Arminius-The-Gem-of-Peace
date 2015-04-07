package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Brick extends Tile{

	public BufferedImage texture;
	public static Rectangle brickRect = new Rectangle(0,0,0,0);
	
	
	@SuppressWarnings("static-access")
	public Brick() {
		texture = Display.getTextures().brick;
		setName("Brick");
		setLightValue(0);
	}

	public void tick () {
		
	}
	
	public void render(Graphics g, int x,int y) {
		brickRect = new Rectangle(x,y,32,32);
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);	
		
		if(collides(brickRect))
			collide();
		
	}
	
}

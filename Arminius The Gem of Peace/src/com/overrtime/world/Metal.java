package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Metal extends Tile{

	private BufferedImage texture;
	
	@SuppressWarnings("static-access")
	public Metal() {
		texture = Display.getTextures().metal;
		setName("Metal");
	}

	public void tick() {
		
	}


	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		
		Rectangle metalRect = new Rectangle(x,y,32,32);
		
		if(collides(metalRect)) {
			collide();
		}
		
	}
	

}

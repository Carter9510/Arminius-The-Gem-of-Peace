package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Wood extends Tile{

	private BufferedImage texture;
	public static Rectangle woodRect = new Rectangle(0,0,32,32);
	
	@SuppressWarnings("static-access")
	public Wood() {
		texture = Display.getTextures().wood;
		setName("Wood");
		setLightValue(1);
	}

	public void tick() {
		
	}


	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		woodRect = new Rectangle(x,y,32,32);

		
		
		if(collides(woodRect)) 
			collide();

	}
	
	
}
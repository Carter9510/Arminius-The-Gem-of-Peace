package com.overrtime.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Ice extends Tile {
	
	private BufferedImage texture;
	
	@SuppressWarnings("static-access")
	public Ice() {
		setName("Ice");
		texture = Display.getTextures().ice;
	}
	
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture,x,y,32,32, null);
	}
	
	public void render(Graphics g) {
		g.drawImage(texture,x, yo,32,32,null);
	}
	
}

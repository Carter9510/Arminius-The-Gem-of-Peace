package com.overrtime.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Granite extends Tile{

	
	@SuppressWarnings("static-access")
	public Granite() {
		
		BufferedImage texture = Display.getTextures().granite;
		
		setTexture(texture);
		setName("Granite");
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		g.drawImage(getTexture(),x,y,32,32,null);
	}
	
	public void render(Graphics g) {
		
	}

	
	
}

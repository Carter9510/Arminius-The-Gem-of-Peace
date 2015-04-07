package com.overrtime.world;

import java.awt.Graphics;

import com.overrtime.game.Display;

public class Fire extends Tile{

	@SuppressWarnings("static-access")
	public Fire() {
		
		setName("Fire");
		setTexture(Display.getTextures().fire);
	}

	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		g.drawImage(getTexture(),x,y,32,32,null);
		
		
		
		
	}
	
	public void render(Graphics g) {
		
	}
	
	
}

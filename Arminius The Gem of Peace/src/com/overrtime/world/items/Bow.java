package com.overrtime.world.items;

import java.awt.Graphics;

import com.overrtime.game.Display;

public class Bow extends Tool{

	@SuppressWarnings("static-access")
	public Bow() {
		
		setTexture(Display.getTextures().bow);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(getTexture(),x,y,32,32,null);
		g.drawString("" + getStack(),x,y + 42);
		drop();
	}
	
}

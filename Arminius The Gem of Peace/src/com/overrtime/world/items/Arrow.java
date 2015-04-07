 package com.overrtime.world.items;

import java.awt.Graphics;

import com.overrtime.game.Display;

public class Arrow extends Tool{

	int quantity = 0;
	
	@SuppressWarnings("static-access")
	public Arrow() {
		setTexture(Display.getTextures().arrow);
		quantity = 12;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(getTexture(),x,y,32,32,null);
		
		g.drawString(String.valueOf(quantity),x + 25,y + 40);
	}
	
}

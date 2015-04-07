package com.overrtime.world.items;

import java.awt.Graphics;

import com.overrtime.game.Display;

public class GreenGem extends Tool{

	@SuppressWarnings("static-access")
	public GreenGem() {
		
		setTexture(Display.getTextures().gem);
		setName("Gem");
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(getTexture(),x,y,32,32,null);
	}

	
	
}

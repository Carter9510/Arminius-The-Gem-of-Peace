package com.overrtime.world.items;

import java.awt.Graphics;

import com.overrtime.game.Display;

public class Stone_Item extends Item{

	@SuppressWarnings("static-access")
	public Stone_Item() {
		
		setTexture(Display.getTextures().stone);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(getTexture(),x,y,32,32,null);
		
		drawStack(g);
	}
	
}

package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class StoneR extends Tile{

	@SuppressWarnings("static-access")
	public StoneR() {
		setName("StoneR");
		setTexture(Display.getTextures().stoneR);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		new Grass().render(g, x, y);
		drawTexture(g,x,y);
		
		if(collides(new Rectangle(x,y,32,32))) {
			collide();
		}
	}
	
	
}

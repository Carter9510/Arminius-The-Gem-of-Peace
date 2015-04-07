package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class Furnace extends Tile{

	public Rectangle rect;
	
	
	@SuppressWarnings("static-access")
	public Furnace() {
		
		setName("Furnace");
	
		setTexture(Display.getTextures().furnace);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		rect = new Rectangle(x,y,32,32);
		setRectangle(rect);
		//new CobbleStone();
		g.drawImage(getTexture(),x,y,32,32,null);
		
		if(collides(rect))
			collide();
	
	}
	
	public void render(Graphics g) {
		
	}

}

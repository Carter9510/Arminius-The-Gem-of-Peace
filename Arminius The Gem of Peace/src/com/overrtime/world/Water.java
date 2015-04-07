package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class Water extends Tile{
	
	
	int frame = 0;
	
	private Rectangle waterRect;
	
	
	@SuppressWarnings("static-access")
	public Water() {
		setName("Water");
		setTexture(Display.getTextures().water);
	}
	
	@SuppressWarnings("static-access")
	public void tick() {
		frame++;
		if(frame <= 800) {
			setTexture(Display.getTextures().water);
		}
		if(frame > 800 & frame <= 1600) {
			setTexture(Display.getTextures().water1);
		}
		if(frame > 1600) {
			frame = 0;
		}
	}
	
	public void render(Graphics g,int x,int y) {
		drawTexture(g,x,y);
		
		tick();
	
		waterRect = new Rectangle(x,y,32,32);
		

		if(collides(waterRect)) {
			collide();
		}
		
	}

}
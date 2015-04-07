package com.overrtime.world.items;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class Tea extends Consumable{

	@SuppressWarnings("static-access")
	public Tea() {
		
		setName("Tea");
		setTexture(Display.getTextures().tea);
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x,int y) {
	}
	
	public void render(Graphics g) {
		rect = new Rectangle(x,y,32,32);
		setRectangle(rect);
		g.drawImage(getTexture(),x,y,32,32,null);
		g.drawString("" + beginStack,x,y + 42);
		drop();
		
	}
	
}

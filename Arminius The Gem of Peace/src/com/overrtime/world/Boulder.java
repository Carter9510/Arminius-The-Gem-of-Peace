package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class Boulder extends Tile{

	@SuppressWarnings("static-access")
	public Boulder() {
		setName("Boulder");
		setTexture(Display.getTextures().boulder);
		setLightValue(0);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		new Grass().render(g, x, y);
		g.drawImage(getTexture(), x, y, 32, 32, null);
		
		Rectangle rect = new Rectangle(x,y,32,32);
		if(collides(rect)) {
			collide();
		}
	}
	
}

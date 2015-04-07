package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class StoneL extends Tile{

	@SuppressWarnings("static-access")
	public StoneL() {
		setName("StoneL");
		setTexture(Display.getTextures().stoneL);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x, int y) {
		new Grass().render(g, x, y);
		g.drawImage(getTexture(),x,y,32,32,null);
		
		if(collides(new Rectangle(x,y,32,32))) {
			collide();
		}
	}
	
	
}
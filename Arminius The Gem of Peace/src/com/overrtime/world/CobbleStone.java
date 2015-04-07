package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class CobbleStone extends Tile{

	public static Rectangle rect = new Rectangle(0,0,0,0);
	
	@SuppressWarnings("static-access")
	public CobbleStone() {
		setTexture(Display.getTextures().cobblestone);
		setName("Cobblestone");
		
		rect = new Rectangle(x,y,32,32);
		
	}

	public void tick() {
		
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(getTexture(),x,y,32,32,null);
	}

	public void render(Graphics g) {

	}

}

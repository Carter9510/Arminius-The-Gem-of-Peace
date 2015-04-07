package com.overrtime.world;

import java.awt.Graphics;

import com.overrtime.game.Display;

public class FalseTree extends Tile{

	@SuppressWarnings("static-access")
	public FalseTree() {
		
		setName("FalseTree");
		setTexture(Display.getTextures().tree);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x,int y) {
		new Grass().render(g, x, y);
		g.drawImage(getTexture(),x,y,32,32, null);
	}
	
	public void render(Graphics g) {
		
	}
	
}

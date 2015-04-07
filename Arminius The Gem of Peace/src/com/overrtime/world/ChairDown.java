package com.overrtime.world;

import java.awt.Graphics;

import com.overrtime.game.Display;

public class ChairDown extends Tile{

	@SuppressWarnings("static-access")
	public ChairDown() {
		
		setName("ChairDown");
		
		setTexture(Display.getTextures().chairDn);
		setLightValue(0);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		new CobbleStone().render(g,x,y);
		g.drawImage(getTexture(),x,y,32,32,null);
	}
	
	public void render(Graphics g) {
		
	}

	
	
}

package com.overrtime.mechanics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;
import com.overrtime.world.entities.Player;

public class Health {

	private BufferedImage bars;
	
	public Health() {
		
	}
	
	@SuppressWarnings("static-access")
	public void tick() {
		int aH = (int)Player.health;
		if(aH >= 70 & aH <= 100) {
			bars = Display.getTextures().bar;
		}
		if(aH <= 70 & aH >= 45) {
			bars = Display.getTextures().bar1;
		}
		if(aH <= 45 & aH >= 10) {
			bars = Display.getTextures().bar2;
		}
		if(aH <= 10) {
			bars = Display.getTextures().bar3;
		}
		if(aH <= 0) {
			Player.dead = true;
		}
	}
	
	public void render(Graphics g, int x,int y) {
		g.drawImage(bars, x, y, 96, 32, null);
		
		int aH = (int)Player.health;
		g.drawString("" + aH,x + 35,y + 20);
	}
	
}

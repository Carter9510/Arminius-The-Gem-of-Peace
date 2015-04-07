package com.overrtime.mechanics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;
import com.overrtime.world.entities.Player;

public class Stamina {

	private BufferedImage bars;
	
	@SuppressWarnings("static-access")
	public void tick() {
		if(Player.stamina <= 25) {
			bars = Display.getTextures().s;
		}
		if(Player.stamina > 25 & Player.stamina <= 50) {
			bars = Display.getTextures().s1;
		}
		if(Player.stamina > 50 & Player.stamina < 75) {
			bars = Display.getTextures().s2;
		}
		if(Player.stamina > 75 & Player.stamina <= 100) {
			bars = Display.getTextures().s3;
		}
	}
	
	public void render(Graphics g, int x,int y, int fontsize) {
		g.drawImage(bars,x,y,96,32,null);
		
		g.setFont(new Font("Bold",Font.BOLD, fontsize));
		g.drawString("Stamina:" + (int)Player.stamina, x + 10,y + 20);
	}
	
}

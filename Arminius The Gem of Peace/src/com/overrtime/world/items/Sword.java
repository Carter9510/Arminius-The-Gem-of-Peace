package com.overrtime.world.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Sword extends Tool{

	public BufferedImage texture;
	
	public static Rectangle sRect;
	
	public static boolean slice = false;
	
	BufferedImage f1, f2, f3, f4;
	
	public static boolean selected = false;
	
	int time = 0;
	
	@SuppressWarnings("static-access")
	public Sword() {
		setName("Sword");
		setStrength(2);
		texture = Display.getTextures().sword;
		sRect = new Rectangle(x,y,32,32);
		setTexture(texture);
	}
	
	@SuppressWarnings("static-access")
	public void tick() {
		sRect = new Rectangle(x,y,8,8);
		
		setTexture(Display.getTextures().sword);
		
		if(slice) {
			setTexture(Display.getTextures().sword);
			time++;
			if(time > 10) {
				setTexture(Display.getTextures().sword2);
			}
			if(time > 30) {
				setTexture(Display.getTextures().sword1);
			}
			if(time > 50) {
				time = 0;
				slice = false;
			}
		}
 		
	}
	
	public void render(Graphics g,int x,int y) {
			tick();
			if(slice) {
				g.drawImage(getTexture(), x,y,24,24,null);
			}
	}
	
	
	public void render(Graphics g) {
		g.drawImage(texture, x,y,Display.tilesize * Display.scale, Display.tilesize * Display.scale, null);
		g.drawString("" + getStack(),x,y + 42);
		drop();
		
	}

}

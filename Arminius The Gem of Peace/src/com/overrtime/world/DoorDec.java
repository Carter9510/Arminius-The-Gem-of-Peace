package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.overrtime.game.Display;

public class DoorDec extends Tile{

	private BufferedImage texture;
	//private Rectangle door;
	
	public Rectangle doorRect;
	
	//room selection
	int id = 0;
	Random rand = new Random();
	int count = 0;
	//end
	
	@SuppressWarnings("static-access")
	public DoorDec() {
		texture = Display.getTextures().door;
		setName("DoorDec");
	}
		

	public void tick() {
		
	}
	
	@SuppressWarnings("static-access")
	public void render(Graphics g, int x, int y) {
		g.drawImage(Display.getTextures().wood, x,y,32,32,null);
		doorRect = new Rectangle(x,y,32,32);
		g.drawImage(texture, x,y,32,32, null);	
	}
	
}

package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;

public class Tree extends Tile{

	public BufferedImage texture;

	public Rectangle treeRect;
	
	@SuppressWarnings("static-access")
	public Tree() {
		texture = Display.getTextures().tree;
		
		setName("Tree");
	}

	
	public void tick() {
		
	}

	
	public void render(Graphics g, int x, int y) {
		new Grass().render(g, x, y);
		g.drawImage(texture,x,y,32,32,null);
		
		treeRect = new Rectangle(x,y,32,32);
	
		//Graphics2D g2d = (Graphics2D) g;
		
		//g2d.draw(treeRect);
		
		if(collides(treeRect))
			collide();
		
	}

	
	public void render(Graphics g) {
		
	}

	
	
}

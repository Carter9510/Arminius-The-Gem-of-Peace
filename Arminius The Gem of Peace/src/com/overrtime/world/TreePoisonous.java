package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.overrtime.game.Display;

public class TreePoisonous extends Tile{


	public Rectangle treeRect;
	
	@SuppressWarnings("static-access")
	public TreePoisonous() {
		
		setName("PoisonousTree");
		setTexture(Display.getTextures().treePoisonous);
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g,int x, int y) {
		new Grass().render(g,x,y);
		g.drawImage(getTexture(),x,y,32,32,null);
		treeRect = new Rectangle(x,y,32,32);
		Rectangle box = new Rectangle(x - 4,y - 10,42,52);
		
		
		if(collides(treeRect)){
			collide();
		}
		
		harm(box, 0.2);
		
	}
	
	public void render(Graphics g) {
		
	}
	
}

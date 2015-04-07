package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;
import com.overrtime.world.items.Tool;

public class Item_Stick extends Tool{

	public BufferedImage texture;
	public int beginStack;
	
	@SuppressWarnings("static-access")
	public Item_Stick() {
		setName("Stick");
		setBeginStack(2);
		
		texture = Display.getTextures().stick;
		setTexture(texture);
		
		
		addStack();
		
	}

	String name;

	public void tick() {
		
	}
	
	@SuppressWarnings("static-access")
	public void render(Graphics g) {
		//this.beginStack = beginStack;
		rect = new Rectangle(x,y,32,32);
		g.drawImage(Display.getTextures().stick, x,y,32,32,null);
		
		g.drawString("" + getStack(), x,y + 32);
		
		
	
		
		
	}
	
	
	
}

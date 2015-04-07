package com.overrtime.world.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Tool extends Item{

	public static String toolName;
	protected int strength;
	protected BufferedImage texture;
	protected int x,y;
	protected boolean stackable;
	public int beginStack;
	public Rectangle rect;
	
	public Tool() {
		rect = new Rectangle(x,y,32,32);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@SuppressWarnings("static-access")
	public void setName(String toolName) {
		this.toolName = toolName;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}

	public int addStack() {
		return beginStack++;
	}
	

	
	public void setStack(int stack) {
		beginStack = stack;
	}
	
	public int getStack() {
		return beginStack;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}

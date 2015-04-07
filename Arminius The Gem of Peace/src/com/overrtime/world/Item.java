package com.overrtime.world;

import java.awt.Graphics;

public abstract class Item {

	protected String itemName;
	protected int x,y;
	
	public abstract void tick();
	public abstract void render(Graphics g, int x,int y);
	
	public void setName(String name) {
		itemName = name;
	}
	
	public String getName() {
		return itemName;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}

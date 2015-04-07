package com.overrtime.world.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected BufferedImage texture;	
	protected String name;
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	public void  setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
}
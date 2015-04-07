package com.overrtime.particles;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Particle {

	protected int size;//Example 2 = 2x2 in width and length
	protected Color color;
	protected int start = 0;
	protected int durationTime;
	
	public Particle(int durationTime, Color color, int size) {
		this.durationTime = durationTime;
		this.color = color;
		this.size = size;
	}
	
	public abstract void render(Graphics g,int x,int y);
	
	public void setColor(Color particleColor) {
		color = particleColor;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void removeParticle() {
		start += 1;
		if(start > 0) {
//			/System.out.println("BYE");
			setColor(new Color(0f, 0f, 0f, 0f));
		}
	}
	
	public void printValue() {
		System.out.println("" + getColor().getBlue() + "," +  getColor().getRed());
	}
	
}
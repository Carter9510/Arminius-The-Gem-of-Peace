package com.overrtime.particles;

import java.awt.Color;
import java.awt.Graphics;

public class Torch_Particle extends Particle{

	public Torch_Particle(int durationTime, Color color, int size) {
		super(durationTime, color, size);
		
		setColor(Color.GRAY);
	}
	
	public void render(Graphics g,int x,int y) {
		g.setColor(getColor());
		g.fillRect(x,y,size,size);
		
		removeParticle();
	}
	
}

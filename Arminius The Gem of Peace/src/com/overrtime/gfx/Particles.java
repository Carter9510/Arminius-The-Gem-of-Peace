package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class Particles {

	public BufferedImage particleDark, particleLow, particleMedium, particleBright, particleTwinkle;
	
	public Particles(SpriteSheet ss) {
		particleDark = ss.crop(0, 0, 16, 16);
		particleLow = ss.crop(1, 0, 16, 16);
		particleMedium = ss.crop(2, 0, 16, 16);
		particleBright = ss.crop(3, 0, 16, 16);
		particleTwinkle = ss.crop(4, 0, 16, 16);
	}
	
}

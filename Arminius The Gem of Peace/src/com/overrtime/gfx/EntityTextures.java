package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class EntityTextures {

	public BufferedImage dragon;
	
	public EntityTextures(SpriteSheet ss) {
		dragon = ss.crop(0, 0, 16, 16);
	}
	
}

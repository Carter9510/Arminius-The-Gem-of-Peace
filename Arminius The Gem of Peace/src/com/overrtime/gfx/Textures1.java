package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class Textures1 {

	public BufferedImage b1;
	
	public Textures1(Sprite32 ss) {
		b1 = ss.crop(0, 0, 32, 32);
	}
	
}

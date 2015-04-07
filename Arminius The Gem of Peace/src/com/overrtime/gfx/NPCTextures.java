package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class NPCTextures {

	public BufferedImage reg, regd, regd1, regup, regup1, reglt, reglt1, regrt, regrt1;
	
	public NPCTextures(SpriteSheet ss) {
		reg = ss.crop(0,0,16,16);
		regd = ss.crop(1,0,16, 16);
		regd1 = ss.crop(2, 0, 16, 16);
		regup = ss.crop(3, 0, 16, 16);
		regup1 = ss.crop(4, 0, 16, 16);
		reglt = ss.crop(5, 0, 16, 16);
		reglt1 = ss.crop(6, 0, 16, 16);
		regrt = ss.crop(7, 0, 16, 16);
		regrt1 = ss.crop(0, 1, 16, 16);
	}
	
}

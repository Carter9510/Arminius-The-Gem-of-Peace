package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class PlayerTextures {

	public BufferedImage player, pd1, pd2, up, up1, up2, lt, lt1, lt2, rt, rt1, rt2;
	
	public PlayerTextures(SpriteSheet ss) {
		player = ss.crop(0, 0, 16, 16);
		pd1 = ss.crop(1, 0, 16, 16);
		pd2 = ss.crop(2, 0, 16, 16);
		up = ss.crop(3, 0, 16, 16);
		up1 = ss.crop(4, 0, 16, 16);
		up2 = ss.crop(5, 0, 16, 16);
		lt = ss.crop(6, 0, 16, 16);
		lt1 = ss.crop(7, 0, 16, 16);
		lt2 = ss.crop(0, 1, 16, 16);
		rt = ss.crop(1, 1, 16, 16);
		rt1 = ss.crop(2, 1, 16, 16);
		rt2 = ss.crop(3, 1, 16, 16);
	}
	
}

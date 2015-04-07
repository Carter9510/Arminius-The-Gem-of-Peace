package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class Sprite32 {

	private BufferedImage u;
	
	public Sprite32(BufferedImage u) {
		this.u = u;
	}
	
	public BufferedImage crop(int col, int row,int w,int h) {
		return u.getSubimage(col * 32, row * 32, w, h);
	}
	
}

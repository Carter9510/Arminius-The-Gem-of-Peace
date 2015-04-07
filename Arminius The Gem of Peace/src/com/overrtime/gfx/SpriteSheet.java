package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage spriteSheet;
	
	public SpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	
	public BufferedImage crop(int col, int row,int w, int h) {
		return spriteSheet.getSubimage(col * 16, row * 16, w, h);
	}
	
}

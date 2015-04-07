package com.overrtime.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.overrtime.game.Display;

public class Importer {
	
	@SuppressWarnings("static-access")
	public BufferedImage load(String path) {
		try {
			Display.debug.writeToDebug("Image Loaded From: " + path);
			return ImageIO.read(getClass().getResource(path));
		}catch(IOException ioe) {
			Display.debug.writeToDebug("" + ioe.getCause());
		}
		return null;
	}
	
	public BufferedImage loadOut(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

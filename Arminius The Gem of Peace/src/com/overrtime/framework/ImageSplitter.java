package com.overrtime.framework;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSplitter {

	public static void split(BufferedImage image) throws IOException {
		int rows = 2;
		int cols = 3;
		
		int chunks = rows * cols;
		
		int chunkWidth = image.getWidth() / cols;
		int chunkHeight = image.getHeight()  / rows;
		int count = 0;
		
		BufferedImage[] arrayToStore = new BufferedImage[chunks];
		for(int x = 0;x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				arrayToStore[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
			}
		}
		
		for(int i = 0; i < arrayToStore.length; i++) {
			ImageIO.write(arrayToStore[i], "png", new File("C:/Arminius/" + i + ".png"));
		}
	}
	
	@SuppressWarnings("unused")
	public ImageSplitter() {
		 try {
			 String path = "/level.png";
			 BufferedImage i = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
			 
			 split(i);
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public static void main(String[] args) {
		new ImageSplitter();
	}
	
}

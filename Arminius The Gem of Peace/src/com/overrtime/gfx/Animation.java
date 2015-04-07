package com.overrtime.gfx;

import java.awt.image.BufferedImage;

public class Animation {

	int frame = 0;
	public Animation() {
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					frame++;
					if(frame > 500) {
						frame = 0;
					}
				}
			}		
		}).start();
	}
	
	public void cycle(BufferedImage texture, BufferedImage first, BufferedImage second) {
		if(frame < 400) {
			texture = first;
		}
		if(frame > 400) {
			texture = second;
		}
	}
	
}

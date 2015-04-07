package com.overrtime.cutscenes;

import java.awt.Font;
import java.awt.Graphics;


public class Beginning {

	int transitionPos = 0;
	
	public boolean stop = false;
	
	public void render(Graphics g) {
		g.setFont(new Font("Bold",Font.PLAIN, 25));
		if(!stop) {
			transitionPos++;
			if(transitionPos >= 0 && transitionPos <= 200) {
				
			}
		}
	}
}
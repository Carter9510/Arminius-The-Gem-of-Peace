package com.overrtime.applet;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

import com.overrtime.game.Display;

public class Applet extends JApplet{

	public static final long serialVersionUID= 1L;
	
	@SuppressWarnings("static-access")
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					Display game = new Display();
					setSize(game.width * game.scale, game.height * game.scale);
					
					add(game, BorderLayout.CENTER);
					
					game.start();
					
					
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

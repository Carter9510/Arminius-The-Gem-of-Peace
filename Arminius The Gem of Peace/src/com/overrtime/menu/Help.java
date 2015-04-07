package com.overrtime.menu;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.overrtime.gfx.Textures;

public class Help implements Runnable{

	Canvas c;
	JFrame frame;
	
	BufferedImage pTree;
	Textures t;
	private Thread thread;
	boolean running = false;
	
	public Help() {
		c = new Canvas();
		c.setMinimumSize(new Dimension(800,600));
		c.setPreferredSize(new Dimension(800,600));
		c.setPreferredSize(new Dimension(800,600));
		frame = new JFrame("Help");
		frame.setLayout(new BorderLayout());
		frame.add(c);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		
		Image cursor = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cursor.png"));
		
		frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursor, new Point(0,0), "Cursor"));
		
		t = new Textures("/textures.png");
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		while(running) {
			render();
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		try {
			thread.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public void render() {
		
		BufferStrategy  bs = c.getBufferStrategy();
		if(bs == null) {
			c.createBufferStrategy(2);
			return;
		}
		Graphics  g= bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,frame.getWidth(),frame.getHeight());
		g.drawImage(t.treePoisonous, 20, 50, 32,32, null);
		g.setColor(Color.red);
		g.drawString("This Is A Poisonous Tree! It Does Damage!", 60, 70);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cursor.png")), 20, 120, 32,32,null);
		g.drawString("This Is Your Cursor!", 60, 140);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cold3.png")), 20, 190, 64, 32, null);
		g.drawString("This Is Your Stamina Bar! You Need Stamina To Run! Hold Shift While Moving To Run!", 100, 200);
		
		g.drawString("To Report A Bug Press 'B' while in game", 20, 260);
		
		g.dispose();
		bs.show();
	}
	
	
}

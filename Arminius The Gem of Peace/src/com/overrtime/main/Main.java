package com.overrtime.main;


import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.overrtime.game.Display;
import com.overrtime.gfx.Export;
import com.overrtime.gfx.Importer;

public class Main {


	public static Display game;
	public static JFrame window;
	public static Export ex = new Export();
	public static Importer load = new Importer();

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		game = new Display();
		window = new JFrame("Arminius The Gem of Peace");
		window.setResizable(false);
		window.setSize(game.width, game.height);
		window.setLayout(new BorderLayout());
		window.add(game, BorderLayout.CENTER);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setIconImage(load.load("/icon.png"));
		window.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent e) {

			}

			public void windowClosed(WindowEvent e) {
				
			}

			public void windowClosing(WindowEvent e) {
				
			}

			public void windowDeactivated(WindowEvent e) {

			}

			public void windowDeiconified(WindowEvent e) {

			}

			public void windowIconified(WindowEvent e) {

			}

			public void windowOpened(WindowEvent e) {

			}

		});
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		game.start();

	}
	
}
package com.overrtime.menu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Controls extends JFrame{

	public static final long serialVersionUID = 1L;
	public JTextArea area;
	
	public String text = "Player Controls:\n\nW Moves Player Forwrard\nS Moves Player Down\nA Moves Player Left\nD Moves Player Right\nLeft Arrow and Right Arrow Moves The Hotbar Selecter";
	
	public Controls() {
		setTitle("Arminius: The Gem of Peace - Controls");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		area = new JTextArea();
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setText(text);
		
		JScrollPane jsp = new JScrollPane(area);	
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
}

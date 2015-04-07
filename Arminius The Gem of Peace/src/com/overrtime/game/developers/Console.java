package com.overrtime.game.developers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.overrtime.game.Display;
import com.overrtime.managers.LevelManager;
import com.overrtime.mechanics.Checkpoint;
import com.overrtime.world.Level;
import com.overrtime.world.entities.Player;

public class Console extends JFrame{

	public static final long serialVersionUID = 1L;
	
	private JTextField command;
	private JTextArea cArea;
	
	public static boolean output = false;
	
	@SuppressWarnings("static-access")
	public Console() {
		setTitle("Console");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		command = new JTextField();
		command.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					String c = command.getText();
					
					if(c.equalsIgnoreCase("cavern")) {
						LevelManager.setCurrentLevel(new Level(Display.getTextures().cavern), "Cavern", 100, 100);
						Checkpoint.setCheckpoint("Cavern", true, Player.aH);
						
						cArea.append("Level Changed To Cavern\n");
						command.setText("");
					}
					
					if(c.equalsIgnoreCase("town")) {
						LevelManager.setCurrentLevel(new Level(Display.getTextures().level), "Town", 100, 100);
						Checkpoint.setCheckpoint("Town", true, Player.aH);
						
						cArea.append("Level Changed To Town\n");
						command.setText("");
					}
					
					if(c.equalsIgnoreCase("forest")) {
						LevelManager.setCurrentLevel(new Level(Display.getTextures().forestLevel), "Forest", 100, 100);
						Checkpoint.setCheckpoint("Forest", true, Player.aH);
						
						cArea.append("Level Changed To Forest\n");
						command.setText("");
					}
					if(c.equalsIgnoreCase("stamina false")) {
						Player.change = false;
						
						cArea.append("Stamina Decrease False!\n");
						command.setText("");
					} 
					
					if(c.equalsIgnoreCase("quit")) {
						System.exit(0);
					}
					
					if(c.equalsIgnoreCase("godmode true")) {
						Player.godMode = true;
						command.setText("");
						cArea.append("Godmode set to true!\n");
					}
					
					if(c.equalsIgnoreCase("godmode false")) {
						Player.godMode = false;
						command.setText("");
						cArea.append("Godmode set to false!");
					}
					
					if(c.equalsIgnoreCase("die")) {
						Player.health  =0;
						command.setText("");
						cArea.append("WHY DID YOU COMIT SUICIDE ;(\n");
					}	
					
					if(c.equalsIgnoreCase("output false")) {
						output = false;
						command.setText("");
						cArea.append("Output Set To False!\n");
					}
					
					if(c.equalsIgnoreCase(("output true"))) {
						output = true;
						command.setText("");
						cArea.append("Output Set To True!\n");
					}
					
			}
		});
		
		add(command, BorderLayout.SOUTH);
		
		cArea = new JTextArea();
		cArea.setEditable(false);
		cArea.setLineWrap(true);
		cArea.setWrapStyleWord(true);
		
		JScrollPane jsp = new JScrollPane(cArea);
		
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
}
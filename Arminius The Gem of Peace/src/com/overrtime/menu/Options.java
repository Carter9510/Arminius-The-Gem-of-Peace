package com.overrtime.menu;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.nio.channels.FileChannel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Options extends JFrame{

	private static final long serialVersionUID = 1L;

	public void init() {
		File f = new File("C:/Arminius");
		if(!f.exists()) {
			f.mkdirs();
		}
		
		File f1 = new File("C:/Arminius/Data");
		
		if(!f1.exists()) {
			f1.mkdir();
		}
		
		File f2 = new File("C:/Arminius/World");
		
		if(!f2.exists()) {
			f2.mkdir();
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Options() {
		init();
		setTitle("Arminius Menu: Options");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		final JComboBox jcb = new JComboBox();
		jcb.setBounds(225, 150, 150, 20);
		jcb.addItem("System Type");
		jcb.addItem("Normal");
		jcb.addItem("Stronger PC");
		jcb.addItem("Gaming PC");
		//add(jcb);
		
		JButton texture = new JButton("Texture Pack");
		texture.setBounds(50,100,150,20);
		texture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser();
					
					int result = jfc.showDialog(null, "Choose");
					
					if(result == JFileChooser.APPROVE_OPTION) {
						String path = jfc.getSelectedFile().getAbsolutePath();
						
						File f = new File("C:/Arminius/Packs");
						if(!f.exists())
							f.mkdirs();
						
						@SuppressWarnings("resource")
						FileChannel source = new FileInputStream(new File(path)).getChannel();
						@SuppressWarnings("resource")
						FileChannel destination = new FileOutputStream("C:/Arminius/Packs/pack.png").getChannel();
						destination.transferFrom(source, 0, source.size());
						
						source.close();
						destination.close();
						
			
						
					}
					
				}catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
	//	add(texture);
		
		JButton getTextures = new JButton("Get More Textures");
		getTextures.setBounds(200,100,150,20);
		getTextures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://www.overrtimestudios.weebly.com/texture-packs.html"));
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		});
		
	//	add(getTextures);
		
		JButton resetTexture = new JButton("Reset Texture Pack");
		resetTexture.setBounds(50,150,150,20);
		resetTexture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File f = new File("C:/Arminius/Packs/pack.png");
					if(f.exists()) {
						f.delete();
					}
				}catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		//add(resetTexture);
		
		JButton apply = new JButton("Apply");
		apply.setBounds(125, 200, 150, 20);
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File f = new File("C:/Arminius/Data/limit.agop");
					
					if(!f.exists()) {
						if(f.createNewFile())
							System.out.println("Created!");
					}
					
					PrintStream ps = new PrintStream(f);
					
					if(jcb.getSelectedItem().equals("System Type")) {
						ps.println("Normal");
					}else {
						ps.println(jcb.getSelectedItem());
					}
					
					ps.close();
				}catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		
		//add(apply);
		
		setVisible(true);
	}
	
}
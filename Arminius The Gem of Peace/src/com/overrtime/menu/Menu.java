package com.overrtime.menu;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;
import javax.swing.JFrame;

import com.overrtime.main.Main;
import com.overrtime.managers.Data;
import com.overrtime.sfx.AudioPlayer;

import javazoom.jl.player.Player;

public class Menu extends Canvas implements Runnable, MouseListener, MouseMotionListener{
	
	public static final long serialVersionUID = 1L;
	public static final int width = 250,height = 180,scale = 2;
	public Dimension screensize = new Dimension(width * scale, height * scale);
	public boolean running = false;
	public Thread thread;
	
	BufferedImage t,t1,t2;
	
	public Rectangle rect = new Rectangle(205,50,140,30);
	public Rectangle r1 = new Rectangle(205, 90, 140, 30);
	public Rectangle r2 = new Rectangle(205, 275, 140, 40);
	
	Font f = new Font("Bold", Font.BOLD, 24);
	
	private static JFrame frame;
	
	Rectangle r = new Rectangle(0,0,0,0);
	
	Point p = new Point(0,0);
	
	static Player player;
	
	boolean make = true;
	static boolean hidden = false;
	boolean loop = true;
	
	BufferedImage single;
	
	public static AudioPlayer ap;
	
	public static String system_user = Data.system_user;

	int second = 0;
	
	String gameVersion = "0.0.0(PROTO-TYPE)";
	
	
	@SuppressWarnings("unused")
	public void init(){
		try {
			checkFiles();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cursor.png"));
		Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(image, p, "Test");
		
			URL url = getClass().getResource("/textures.png");
		
		setCursor(c);
	}
	
	public Menu() {
		setMinimumSize(screensize);
		setPreferredSize(screensize);
		setMaximumSize(screensize);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
	

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	@SuppressWarnings("static-access")
	public void tick() {
		
		
		second++;
		
		if(second <= 150) {
			t2 = background();
		}
		if(second > 150 && second <= 300) {
			t2 = background1();
		}
		if(second > 300) {
			second = 0;
		}
		if(make){
			new Thread(new Runnable() {
				public void run() {
					t2 = background();
				
					ap = new AudioPlayer("/MenuScreen.mp3");
					setVolume(.33F);
					ap.playAudio();
				}
			}).start();
			make = false;
		}
		
		if(!frame.isVisible()) {
			ap.stopAudio();
		}
		
	}
	
	@SuppressWarnings("unused")
	public void render() {
				BufferStrategy bs = getBufferStrategy(); 
				if(bs == null) {
					createBufferStrategy(2);
					return;
				}
				final Graphics g = bs.getDrawGraphics();
				
				g.fillRect(0, 0, getWidth(), getHeight());

				g.setFont(f);

				
				
				g.drawImage(t2, 0,0,getWidth(),getHeight(),null);
				g.setColor(Color.red);
				
				g.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
				g.drawString(gameVersion, 20, 360);
				
				
				Graphics2D g2d = (Graphics2D) g;	
				g.dispose();
				bs.show();
	}
	
	
	@SuppressWarnings("deprecation")
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		thread.stop();
	}
	
	public static void main(String[] args) {
		Menu m = new Menu();
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(m);
		frame.pack();
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				AudioPlayer.stopAudio();
			}

			@SuppressWarnings("static-access")
			@Override
			public void windowDeactivated(WindowEvent e) {
				ap.stopAudio();
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
		});
		
		frame.setVisible(true);
		
		m.start();
	}


	@SuppressWarnings({"deprecation", "static-access"})
	public void mouseClicked(MouseEvent e) {
		int mousecode = e.getButton();
		
		if(r.intersects(rect)) {
			if(mousecode == MouseEvent.BUTTON1) {
				frame.hide();
				stop();
				Main m= new Main();
				m.main(null);
			}
		}

		
		if(r.intersects(r1)) {
			if(mousecode == MouseEvent.BUTTON1) {
				new Help().start();
			}
		}
		
		if(r.intersects(r2)) {
			if(mousecode == MouseEvent.BUTTON1) {
				new Options();
			}
		}

		
	}

	
	public void mouseEntered(MouseEvent e) {
		
	}

	
	public void mouseExited(MouseEvent e) {
				
	}

	public void mousePressed(MouseEvent e) {
		
	}

	
	public void mouseReleased(MouseEvent e) {		
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		r = new Rectangle(e.getX(),e.getY(),16,16);
	}

	public BufferedImage background() {
		try {
			return ImageIO.read(getClass().getResource("/Menu.png"));//was "/menu_bg.png"
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BufferedImage background1() {
		try {
			return ImageIO.read(getClass().getResource("/Menu1.png"));//was "/menu_bg.png"
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void checkFiles()throws Exception{
		System.out.println(system_user);
		File f = new File("C:/Arminius");
		File f1 = new File("C:/Arminius/World");
		File f2 = new File("C:/Arminius/Data");
		File f3 = new File("C:/Arminius/Plugins");
		File f4 = new File("C:/Arminius/Jars");
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		if(!f1.exists()) {
			f1.mkdirs();
		}
		
		if(!f2.exists()) {
			f2.mkdirs();
		}
		
		if(!f3.exists()) {
			f3.mkdirs();
		}
		
		if(!f4.exists()) {
			f4.mkdirs();
		} 
		
	}
	
	public void createSize() {
		try {
			URL gameSize = new URL("https://www.dropbox.com/s/yd8gx8a2w8kgqxl/arminius%2C%20the%20gem%20of%20peace.jar?dl=1");
			ReadableByteChannel rbc = Channels.newChannel(gameSize.openStream());
			FileOutputStream fos = new FileOutputStream("C:/Arminius/Jars/game.jar");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE); 
			
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void setVolume(float volume) {
		 Port.Info source = Port.Info.SPEAKER;

		        if (AudioSystem.isLineSupported(source)) 
		        {
		            try 
		            {
		                Port outline = (Port) AudioSystem.getLine(source);
		                outline.open();                
		                FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);                
		                volumeControl.setValue(volume); 
		                System.out.println("newest volume: " + volumeControl.getValue() );
		            } 
		            catch (LineUnavailableException ex) 
		            {
		                System.err.println("source not supported");
		                ex.printStackTrace();
		            }            
		        }
	}
	
}
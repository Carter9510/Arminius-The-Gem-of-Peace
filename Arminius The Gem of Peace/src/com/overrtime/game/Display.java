package com.overrtime.game;

//import game.overrtime.game.info.MonitorInfo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.overrtime.debugger.Debugger;
import com.overrtime.game.developers.Console;
import com.overrtime.gfx.EntityTextures;
import com.overrtime.gfx.Importer;
import com.overrtime.gfx.NPCTextures;
import com.overrtime.gfx.Particles;
import com.overrtime.gfx.PlayerTextures;
import com.overrtime.gfx.SpriteSheet;
import com.overrtime.gfx.Textures;
import com.overrtime.gfx.Textures1;
import com.overrtime.managers.KeyManager;
import com.overrtime.managers.LevelManager;
import com.overrtime.managers.MouseManager;
import com.overrtime.mechanics.Checkpoint;
import com.overrtime.world.Level;
import com.overrtime.world.Rooms;
import com.overrtime.world.entities.Player;

public class Display extends Canvas implements Runnable {

	public static int width = 380;
	public static int height = 300;
	public static int scale = 2;
	public static int tilesize = 16;
	public static Dimension screensize = new Dimension(width * scale, height * scale);
	public static boolean running = false;
	private static Importer load = new Importer();
	public static int level = 0;
	public static boolean fullscreen = false;
	public static boolean write = true;
	public static Debugger debug = new Debugger();
	public static LevelManager lm = new LevelManager();
	public static boolean pause = false;
	public static final long serialVersionUID = 1L;
	public static Thread thread;
	public static Textures textures;
	private static PlayerTextures pt;
	private static Textures1 t1;
	private static Player p;
	public static Level test;
	public static Level forest;
	public static NPCTextures npct;
	private static Particles particles;
	public static EntityTextures et;
	public static Graphics g = null;
	public static Rooms room = new Rooms();
	public static boolean initialized = false;

	// startup
	int startup = 0;
	boolean count = true;
	// end

	// screen
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice[] gs = ge.getScreenDevices();
	// end

	// LEVEL
	public static Level l;
	// END

	public static boolean screenshot = false;

	int ticks;
	int frames;

	static double limit;

	Thread init;

	// update stuff
	public static double FRAMES_PER_SECOND = 0;

	// private MonitorInfo mi = new MonitorInfo();
	// end

	@SuppressWarnings("static-access")
	public void init() {
		textures = new Textures("/textures.png");

		BufferedImage si = load.load("/playerTextures.png");
		SpriteSheet s1 = new SpriteSheet(si);
		pt = new PlayerTextures(s1);

		BufferedImage si2 = load.load("/npcTextures.png");
		SpriteSheet npcS = new SpriteSheet(si2);
		npct = new NPCTextures(npcS);

		BufferedImage si3 = load.load("/particles.png");
		SpriteSheet p1 = new SpriteSheet(si3);
		particles = new Particles(p1);

		BufferedImage si4 = load.load("/entityTextures.png");
		SpriteSheet p2 = new SpriteSheet(si4);
		et = new EntityTextures(p2);

		test = new Level(load.load("/kingdom.png"));
		LevelManager.setCurrentLevel(test, "Kingdom", 300, 200);// was x = 300,
																// y = 200
		Checkpoint.setCheckpoint("Kingdom", true, 100);

		p = new Player(150, 150, 50);

		debug.writeToDebug("All Components Intialized Successfully!");

		System.out.println("DONE");

		initialized = true;

		room.select();

	}

	public Display() {
		BufferedImage cursor = load.load("/cursor.png");

		Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(cursor,
				new Point(0, 0), "C");

		setCursor(c);

		setMinimumSize(screensize);
		setPreferredSize(screensize);
		setMaximumSize(screensize);
		addKeyListener(new KeyManager());
		addMouseMotionListener(new MouseManager());
		addMouseListener(new MouseManager());
		setFocusable(true);
		setBounds(9000, 9000, 9000, 9000);

	}

	public synchronized void start() {
		if (running) {
			return;
		}
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

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				if (Console.output) {
					System.out.println("Ticks and Frames: " + ticks);
				}
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public void tick() {

		p.tick();
		LevelManager.getCurrentLevel().tick();

	}

	@SuppressWarnings("static-access")
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		final Graphics g = bs.getDrawGraphics();

		this.g = g;

		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		count = false;
		if (LevelManager.getCurrentLevel().intialized) {
			LevelManager.getCurrentLevel().render(g);
			p.render(g);
		}

		if (write) {
			debug.writeToDebug("Graphics In Display Class Intialized");
			write = false;
		}

		if (screenshot) {
			BufferedImage shot = new BufferedImage(width * 2, height * 2,
					BufferedImage.TYPE_INT_RGB);

			createImage(shot);

			screenshot = false;
		}

		this.g = g;

		g.dispose();
		bs.show();

	}

	public static Textures getTextures() {
		return textures;
	}

	public static PlayerTextures getPTextures() {
		return pt;
	}

	public static Textures1 getTextures1() {
		return t1;
	}

	public static NPCTextures getNPCT() {
		return npct;
	}

	public static Particles getParticles() {
		return particles;
	}

	public static EntityTextures getEntityTextures() {
		return et;
	}

	public static Level getLevel() {
		return LevelManager.getCurrentLevel();
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		debug.close();
		thread.stop();
	}

	public void createImage(BufferedImage image) {
		Graphics2D s = image.createGraphics();

		LevelManager.getCurrentLevel().render(s);
		p.render(s);

		s.dispose();

		File file = new File("C:/Arminius/screenshot.png");
		try {
			ImageIO.write(image, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resize(int w, int h) {
		width = w;
		height = h;
		screensize = new Dimension(w * scale, h * scale);
	}

}
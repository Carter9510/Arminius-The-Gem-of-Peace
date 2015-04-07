package com.overrtime.world.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import com.overrtime.game.Display;
import com.overrtime.managers.LevelManager;
import com.overrtime.mechanics.Health;
import com.overrtime.mechanics.Stamina;
import com.overrtime.mechanics.Time;
								
public class Player {

	public static int x, y, z;
	public static int xo = 0, yo = 0, xs, ys;
	public static double ox,oy,sx,sy;
	public static boolean up, dn, lt, rt;
	public static float speed = .0f;
	public static boolean mouseDown = false;

	float leftF = 0;
	float rightF = 0;
	float upF = 0;
	float dnF = 0;

	public BufferedImage texture;

	public static boolean moving = false;

	public static int pX, pY;
	public static int tX, tY;

	public static Rectangle placeRect = new Rectangle(pX, pY, 32, 32);

	public static boolean place = false;

	public static String listX[] = new String[5];
	public static String listY[] = new String[5];

	public static boolean csu = false, csd = false, csl = false, csr = false;

	public static float health = 100;

	public static int aH = (int)Player.health;
	
	
	public static Rectangle playerRect = new Rectangle(0, 0, 40, 40);

	public static int cx = 300, cy = 300;
	public static int mx, my;

	public static boolean aup = true, adn = true, alt = true, art = true;
	public static boolean dead = false;
	public static boolean isShifting = false;

	//health
	public static boolean godMode = false;
	//end

	private Health health1;

	public static boolean inDoor = false;

	public static Rectangle mouseRect;

	public static boolean readyToShooot = true;
	public static boolean shoot = false;

	public static float numArrows = 0;



	public static boolean cu, cd, cl, cr;

	public static boolean damage = false;


	public static Rectangle options = new Rectangle(0,0,0,0);
	public static Rectangle texture1 = new Rectangle(0,0,0,0);
	
	
	Time time = new Time();
	
	LevelManager lm = new LevelManager();

	public static float stamina = 100;
	public static float Stamina = stamina;
	
	
	public static boolean c = false;
	
	public static float money = 0;
	
	Stamina cs = new Stamina();
	
	public static boolean change = true;
	
	//death code
	int tickCount;
	BufferedImage img = new BufferedImage(Display.width, Display.height, BufferedImage.TYPE_INT_RGB);
	int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	//end

	@SuppressWarnings("static-access")
	public Player(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;

		
		x = xo;
		y = yo;
		
		health1 = new Health();

		mouseRect = new Rectangle(cx, cy, 16, 16);

		texture = Display.getPTextures().player;
		xs = 0;
		ys = 0;
		
		stamina -= 0.01;
	}


	boolean set = true;
	
	public void tick() {
		tickCount++;
		if(set) {
			stamina--;
			set = false;
		}
		if(!isShifting) {
			if(stamina <= 100) {
				if(moving) {
					stamina += 0.01;
				}else {
					stamina += 0.05;
				}
			}
			speed = 1;
		}else {
			if(change) {
				stamina -= 0.05;
				if(stamina <= 0) {
					stamina = 0;
					speed = 1;
					isShifting = false;
				}else {
					speed = 2;
				}
			}else {
				speed = 2;
			}
		}
		
		xs = 0;
		ys = 0;
		aH = (int)Player.health;
		
		placeRect = new Rectangle(pX, pY, 16, 16);
		
		if (up & !cu) {
			moving = true;
			ys -= speed;
			y++;
			
			if(!isShifting) {
				upF += 1;
			}else {
				upF+= 5;
			}
			
			
			if (upF >= 1 && upF <= 75) {
				texture = Display.getPTextures().up1;
			}
			if (upF >= 75 && upF <= 150) {
				texture = Display.getPTextures().up2;
			}
			if (upF > 150) {
				upF = 0;
			}

		} else if (dn & !cd) {
			moving = true;
			xs = 0;
			ys = 0;

			y--;
			
			ys += speed;

			if(!isShifting)  {
				dnF += 1;
			}else {
				dnF += 5;
			}
			
			if (dnF >= 1 && dnF <= 75) {
				texture = Display.getPTextures().pd1;
			}
			if (dnF >= 75 && dnF <= 150) {
				texture = Display.getPTextures().pd2;
			}
			if (dnF > 150) {
				dnF = 0;
			}
		}
		if (lt & !cl) {
			moving = true;
			xs = 0;
			ys = 0;
			x--;

			xs -= speed;

			if(!isShifting) {
				leftF += 1;
			}else {
				leftF += 5;
			}
			
			if (leftF >= 1 && leftF <= 75) {
				texture = Display.getPTextures().lt1;
			}
			if (leftF >= 75 && leftF <= 150) {
				texture = Display.getPTextures().lt2;
			}
			if (leftF > 150) {
				leftF = 0;
			}

		} else if (rt & !cr) {
			moving = true;
			xs += speed;
			
			x++;

			if(!isShifting) {
				rightF += 1;
			}else {
				rightF += 5;
			}
			
			if (rightF >= 1 && rightF <= 75) {
				texture = Display.getPTextures().rt1;
			}
			if (rightF >= 75 && rightF <= 150) {
				texture = Display.getPTextures().rt2;
			}
			if (rightF > 150) {
				rightF = 0;
			}

		}

		if(dn & lt & !cd & !cl) {
			ys += speed;
		}
		
		if(up & lt & !cu & !cl) {
			ys -= speed;
		}
	

	
		mouseRect = new Rectangle(mx, my, 16, 16);


		playerRect = new Rectangle(cx + 15, cy, 10, 30);

		// testing purpose
		if (damage && !godMode) {
			health -= 0.01;
		}
		//end

		health1.tick();
		cs.tick();
		
		if (health <= 0) {
			health = 0;
			Time.hour = 0;
			Time.minute = 0;
			Time.second = 0;
			stamina = 100;
			dead = true;
			
			//die screen code
			for(int i = 0; i < pixels.length; i++) {
				pixels[i] = (int) (i * Math.random() * tickCount * Math.PI);
			}
			 
		}
		
		move(xs, ys);

		try {
			time.tick();			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(xo >= LevelManager.getCurrentLevel().w * 32 - 316) {
			Player.cr = true;
		}
		if(xo <= (LevelManager.getCurrentLevel().w * 32 - LevelManager.getCurrentLevel().w * 32) - 300) {
			Player.cl = true;
		}
		if(yo >= LevelManager.getCurrentLevel().h * 32 - 316) {
			Player.cd = true;
		}
		if(yo <= (LevelManager.getCurrentLevel().h*32- LevelManager.getCurrentLevel().h * 32) - 300) {
			Player.cu = true;
		}
		
		if (Player.dead) {
			Player.cu = true;
			Player.cd = true;
			Player.cl = true;
			Player.cr = true;
		}
		
	}


	public void move(int xs, int ys) {
		xo += xs;
		yo += ys;
		
		if(!moving) {
			cu = false;
			cd = false;
			cl = false;
			cr = false;
		}
	}

	@SuppressWarnings("static-access")
	public void render(Graphics g) {
		
		g.drawImage(texture, cx, cy, 32, 32, null);

		g.setColor(Color.yellow);

		g.setFont(new Font("Bold", Font.BOLD, 12));

		health1.render(g, 625, 50);
		cs.render(g, 125, 50, 12);
		
		g.drawString("X: " + xo + ", Y:" + yo, 50, 50);

		
		options = new Rectangle(200, 200, 100, 40);

		
		if(Display.pause) {
			aup = false;
			adn = false;
			alt = false;
			art = false;
			g.drawString("Options", 200, 220);
		}
		
		
		
		g.setColor(Color.red);
		g.drawString(time.timeString,625, 40);
		
		g.setColor(Color.green);
		g.drawString("$" + money, 170,40);
		
		g.setColor(Color.black);
		g.setFont(new Font("Bold",Font.BOLD, 13));
		
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.red);
		g2.draw(placeRect);
		
		
		while(dead) {
			g.drawImage(img, 0,0,Display.width * 2, Display.height * 2,null);
			g.setColor(Color.black);
			g.setFont(new Font("Bold",Font.BOLD, 20));
			g.drawString("You Died! Press (R) To Respawn", 235, 300);
			return;
		}
		
	}



	public static int getXo() {
		return xo;
	}

	public static int getYo() {
		return yo;
	}


}
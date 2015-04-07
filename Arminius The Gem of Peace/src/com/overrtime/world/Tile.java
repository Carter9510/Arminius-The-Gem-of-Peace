package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.world.entities.Player;

public abstract class Tile {

	protected int lightValue = 0;
	
	int xo = Player.getXo();
	int yo = Player.getYo();
	protected String name;
	protected BufferedImage texture;

	public static Tile grass = new Grass();
	public static Tile cactus = new Cactus();
	public static Tile stone = new Stone();
	public static Tile road = new Road();
	public static Tile dirt = new Dirt();
	public static Tile metal = new Metal();
	public static Tile wood = new Wood();
	public static Tile sand = new Sand();
	public static Tile door  = new Door();
	public static Tile doordec = new DoorDec();
	public static Tile soil = new Soil();
	public static Tile wheat = new Wheat();
	public static Tile woodL = new WoodL();
	public static Tile woodR = new WoodR();
	public static Tile woodT = new WoodT();
	public static Tile tombstone = new TombStone();
	public static Tile brick = new Brick();
	public static Tile fence = new Fence();
	public static Tile marble = new Marble();
	public static Tile warp = new Warp();
	public static Tile tree = new Tree();
	public static Tile falsetree = new FalseTree();
	public static Tile stoneFloor = new StoneFloor();
	public static Tile cobblestone = new CobbleStone();
	public static Tile treePoisonous = new TreePoisonous();
	public static Tile chairUp = new ChairUp();
	public static Tile chairDown = new ChairDown();
	public static Tile chairLeft = new ChairLeft();
	public static Tile chairRight = new ChairRight();
	public static Tile furnace = new Furnace();
	public static Tile fire = new Fire();
	public static Tile ice = new Ice();
	public static Tile granite = new Granite();
	public static Tile boulder = new Boulder();
	public static Tile water = new Water();
	public static Tile stoneL = new StoneL();
	public static Tile stoneR = new StoneR();
	public static Tile stoneT = new StoneT();

	protected static int tileID;
	
	public Rectangle rect;
	
	public static int x = 0,y = 0;
	
	static boolean solid = false;
	
	protected String behindBlock;
	
	public abstract void tick();
	public abstract void render(Graphics g, int x,int y);
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public void setRectangle(Rectangle rect) {
		this.rect = rect;
	}
	
	public Rectangle getRect() {
		return rect;
	}

	
	public static int X() {
		return x;
	}
	
	public static int Y() {
		return y;
	}
	
	
	public void solid(boolean tof) {
		solid = tof;
	}
	
	public static boolean isSolid() {
		return solid;
	}
	
	public void collide() {
		if(Player.up) {
			Player.cu = true;
			Player.yo += 1;
		}
		
		if(Player.dn) {
			Player.yo -= 1;
			Player.cd = true;
		}
		
		if(Player.lt) {
			Player.xo += 1.5;
			Player.cl = true;
		}
		
		
		if(Player.rt) {
			Player.xo -= 1;
			Player.cr = true;
		}
				
	}
	
	public boolean collides(Rectangle r) {
		if(r.intersects(Player.playerRect)) {
			return true;
		}
		return false;
	}
	
	public void harm(Rectangle rect, double damage) {
		if(collides(rect)) {
			Player.health -= damage;
		}
	}
	
	public void setLightValue(int lightValue) {
		this.lightValue = lightValue;
	}
	
	public int getLightValue() {
		if(lightValue > 0) {
			return lightValue;
		}else {
			return 0;
		}
	}
	
	public void drawTexture(Graphics g,int x,int y) {
		g.drawImage(getTexture(),x,y,32,32,null);
	}

}
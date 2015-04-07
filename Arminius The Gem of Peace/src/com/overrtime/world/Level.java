package com.overrtime.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.overrtime.game.Display;
import com.overrtime.managers.LevelManager;
import com.overrtime.mechanics.Stamina;
import com.overrtime.world.entities.Player;

public class Level {

	public Tile[][] tiles;
	

	
	public int w, h;

	public int xPos, yPos;

	LevelManager lm;

	static String name = "";

	int ID = 0;

	Stamina cs = new Stamina();

	public int[] xs;
	public int[] ys;

	public BufferedImage image;
	


	public boolean intialized = false;

	public Level(BufferedImage levelImage) {
		image = levelImage;
		w = levelImage.getWidth();
		h = levelImage.getHeight();
		
		Player.cu = false;
		Player.cd = false;
		Player.cl = false;
		Player.cr = false;	
		
		loadLevel(levelImage);
	}
	
	public void setName(String lName) {
		name = lName;
	}

	
	public void loadLevel(BufferedImage levelImage) {
		int width = levelImage.getWidth();
		int height = levelImage.getHeight();
		tiles = new Tile[width][height];
		for (int y = 0; y < levelImage.getHeight(); y++) {
			for (int x = 0; x < levelImage.getWidth(); x++) {
				Color c = new Color(levelImage.getRGB(x,  y));
				
				String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());

				
				
				switch(h){
				case "64d00f":
					tiles[x][ y] = new Grass();
					break;
				case "736950":
					tiles[x][ y] = new Stone();
					break;
				case "887058":
					tiles[x][ y] = new Road();
					break;
				case "332a27":
					tiles[x][ y] = new Dirt();
					break;
				case "dedede":
					tiles[x][ y] = new Metal();
					break;
				case "6d5d30":
					tiles[x][ y] = new Wood();
					break;
				case "f6e29a":
					tiles[x][ y] = new Sand();
					break;
				case "a58261":
					tiles[x][ y] = new Door();
					break;
				case "a27630":
					tiles[x][y] = new DoorDec();
					break;
				case "623c36":
					tiles[x][ y] = new Soil();
					break;
				case "ffd800":
					tiles[x][ y] = new Wheat();
					break;
				case "796735":
					tiles[x][ y] = new WoodL();
					break;
				case "514130":
					tiles[x][ y] = new WoodR();
					break;
				case "776443":
					tiles[x][ y] = new WoodT();
					break;
				case "bdcbc5":
					tiles[x][ y] = new TombStone();
					break;
				case "ff2727":
					tiles[x][ y] = new Brick();
					break;
				case "826725":
					tiles[x][ y] = new Fence();
					break;
				case "007f0e":
					tiles[x][ y] = new Cactus();
					break;
				case "ffffff":
					tiles[x][ y] = new Marble();
					break;	
				case "0026ff":
					tiles[x][ y] = new Warp();
					break;
				case "673c22":
					tiles[x][ y] = new Tree();
					break;
				case "b55b27":
					tiles[x][ y] = new FalseTree();
					break;
				case "73693e":
					tiles[x][ y] = new StoneFloor();
					break;
				case "aba18a":
					tiles[x][ y] = new CobbleStone();
					break;
				case "3a2319":
					tiles[x][ y] = new TreePoisonous();
					break;
				case "8a4025":
					tiles[x][ y] = new ChairLeft();
					break;
				case "c7b26f":
					tiles[x][ y] = new ChairRight();
					break;
				case "ba9951":
					tiles[x][ y] = new ChairDown();
					break;
				case "a88e52":
					tiles[x][ y] = new ChairUp();
					break;
				case "473d4e":
					tiles[x][ y] = new Furnace();
					break;
				case "ff693a":
					tiles[x][ y] = new Fire();
					break;
				case "acc7d9":
					tiles[x][ y] = new Ice();
					break;
				case "493d36":
					tiles[x][ y] = new Granite();
					break;
				case "4f4b41":
					tiles[x][ y] = new Boulder();
					break;
				case "2d8efe":
					tiles[x][y] = new Water();
					break;
				case "a69b7b":
					tiles[x][y] = new StoneL();
					break;
				case "685f49":
					tiles[x][y] = new StoneR();
					break;
				case "645a45":
					tiles[x][y] = new StoneT();
					break;
				default:
					tiles[x][ y] = new Grass();
					break;
				}
				
				intialized = true;
			}
		}
	}

	public void render(Graphics g) {
		
		int xo = Player.getXo();
		int yo = Player.getYo();

		int x0 = Math.max(xo / (Display.tilesize * Display.scale), 0);
		int  y0 = Math.max(yo / (Display.tilesize * Display.scale), 0);
		int x1 = Math.min((xo + Display.width * Display.scale) / (Display.tilesize * Display.scale) + 1, w);
		int  y1 = Math.min((yo + Display.height * Display.scale) / (Display.tilesize * Display.scale ) + 1, h);
	

		
		for (int  y = y0;  y < y1;  y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(g, x * 32 - xo,y * 32 - yo);
			}
		}
		
	}
	
	public void tick() {}


	public Tile getTile(int x, int y) {
		switch (tiles[x][y].getName()) {
		case "Grass":
			return Tile.grass;
		case "Stone":
			return Tile.stone;
		case "Road":
			return Tile.road;
		case "Dirt":
			return Tile.dirt;
		case "Wheat":
			return Tile.wheat;
		case "Sand":
			return Tile.sand;
		case "Door":
			return Tile.door;
		case "DoorDec":
			return Tile.doordec;
		case "Tombstone":
			return Tile.tombstone;
		case "Wood":
			return Tile.wood;
		case "WoodR":
			return Tile.woodR;
		case "WoodL":
			return Tile.woodL;
		case "WoodT":
			return Tile.woodT;
		case "Fence":
			return Tile.fence;
		case "Cactus":
			return Tile.cactus;
		case "Marble":
			return Tile.marble;
		case "Warp":
			return Tile.warp;
		case "Tree":
			return Tile.tree;
		case "FalseTree":
			return Tile.falsetree;
		case "Soil":
			return Tile.soil;
		case "Metal":
			return Tile.metal;
		case "StoneFloor":
			return Tile.stoneFloor;
		case "Cobblestone":
			return Tile.cobblestone;
		case "PoisonousTree":
			return Tile.treePoisonous;
		case "ChairUp":
			return Tile.chairUp;
		case "ChairDown":
			return Tile.chairDown;
		case "ChairLeft":
			return Tile.chairLeft;
		case "ChairRight":
			return Tile.chairRight;
		case "Furnace":
			return Tile.furnace;
		case "Brick":
			return Tile.brick;
		case "Fire":
			return Tile.fire;
		case "Ice":
			return Tile.ice;
		case "Granite":
			return Tile.granite;
		case "Boulder":
			return Tile.boulder;
		case "Water":
			return Tile.water;
		case "StoneL":
			return Tile.stoneL;
		case "StoneR":
			return Tile.stoneR;
		case "StoneT":
			return Tile.stoneT;
		default:
			return Tile.grass;
		}
	}
	
	public String getName() {
		return name;
	}

	public String get(int x,int y) {
		return tiles[x][y].name;
	}

	public static final int anchorX(int x) {
		return (x-((x  >>> 31) * 99)) / 100 * 100;
	}
	
	public static final int anchorY(int y) {
		return (y-((y >>> 31)*99)) / 1* 1;
	}
	
	
}
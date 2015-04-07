package com.overrtime.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.overrtime.game.Display;
import com.overrtime.mechanics.TexturePack;

public class Textures {

	public static BufferedImage cavern;
	public static BufferedImage player, grass, stone, road, dirt, metal, wood, sand, door, stick, bar, bar1, bar2, bar3, chest, chest1, dirt1, wheat, seed, woodL, woodR, woodT, tombstone, sword, sword1, sword2, log, bow, arrow, arrow1, brick, warp, torch, fence, fence1, cactus, marble, lamp, water, water1, level, forestLevel, tree, forestLevel1, kingdom, cobblestone, gem, treePoisonous, r, r1, r2, chairL, chairR, chairUp, chairDn, stool, furnace, fire, s, s1, s2, s3, tea, ice, granite, boulder, red, b, b1, b2, b3, b4, b5, b6,b7, b8, b9, b10, b11, b12, spawn;
	public static BufferedImage stoneL, stoneR, stoneT;
	public TexturePack tp = new TexturePack();
	public TexturePack tp1 = new TexturePack();
	
	

	@SuppressWarnings("static-access")
	public Textures(final String path) {
				SpriteSheet ns;
				SpriteSheet ns1;
				try {
					BufferedImage image = ImageIO.read(getClass().getResource(path));
					ns = new SpriteSheet(image);
					tp.setSpriteSheet(ns);
					
					BufferedImage img = ImageIO.read(getClass().getResource("/textures1.png"));
					ns1 = new SpriteSheet(img);
					tp1.setSpriteSheet(ns1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				SpriteSheet ss = tp.getSpriteSheet();
				player = ss.crop(0, 0, 16, 16);
				grass = ss.crop(1, 0, 16, 16);
				stone = ss.crop(2, 0, 16, 16);
				road = ss.crop(3, 0, 16, 16);
				dirt = ss.crop(4, 0, 16, 16);
				metal = ss.crop(5, 0, 16, 16);
				wood = ss.crop(6, 0, 16, 16);
				sand = ss.crop(7, 0, 16, 16);
				door = ss.crop(0, 1, 16, 16);
				stick = ss.crop(1, 1, 16, 16);
				chest = ss.crop(2, 1, 16, 16);
				chest1 = ss.crop(3, 1, 16, 16);
				dirt1 = ss.crop(4, 1, 16, 16);
				wheat = ss.crop(5, 1, 16, 16);
				seed = ss.crop(6, 1, 16, 16);
				woodL = ss.crop(7, 1, 16, 16);
				woodR = ss.crop(0, 2, 16, 16);
				woodT = ss.crop(1, 2, 16, 16);
				tombstone = ss.crop(2, 2, 16, 16);
				sword = ss.crop(3, 2, 16, 16);
				sword1 = ss.crop(4, 2, 16, 16);
				log = ss.crop(5, 2, 16, 16);
				bow = ss.crop(6, 2, 16, 16);
				arrow = ss.crop(7, 2, 16, 16);
				arrow1 = ss.crop(0, 3, 16, 16);
				brick = ss.crop(1, 3, 16, 16);
				warp = ss.crop(2, 3, 16, 16);
				torch = ss.crop(3, 3, 16, 16);
				fence = ss.crop(4, 3, 16, 16);
				fence1 = ss.crop(5, 3, 16, 16);
				cactus = ss.crop(6, 3, 16, 16);
				marble = ss.crop(7, 3, 16, 16);
				water = ss.crop(0, 4, 16, 16);
				water1 = ss.crop(1, 4, 16, 16);
				tree = ss.crop(2, 4, 16, 16);
				cobblestone = ss.crop(3, 4, 16, 16);
				gem = ss.crop(4, 4, 16, 16);
				treePoisonous = ss.crop(5, 4, 16, 16);
				chairR = ss.crop(6, 4, 16, 16);
				chairL = ss.crop(7, 4, 16, 16);
				chairDn = ss.crop(0, 5, 16, 16);
				chairUp = ss.crop(1, 5, 16, 16);
				stool = ss.crop(2, 5, 16, 16);
				furnace = ss.crop(3, 5, 16, 16);
				fire = ss.crop(4, 5, 16, 16);
				tea = ss.crop(5, 5, 16, 16);
				ice = ss.crop(6, 5, 16, 16);
				granite = ss.crop(7, 5, 16, 16);
				sword2 = ss.crop(0, 6, 16, 16);
				boulder = ss.crop(1, 6, 16, 16);
				spawn = ss.crop(2, 6, 16, 16);
				b = ss.crop(3, 6, 16, 16);
				b1 = ss.crop(4, 6, 16, 16);
				b2 = ss.crop(5, 6, 16, 16);
				b3 = ss.crop(6, 6,16,16);
				b4 = ss.crop(7, 6, 16, 16);
				b5 = ss.crop(0, 7, 16, 16);
				b6 = ss.crop(1, 7, 16, 16);
				b7 = ss.crop(2, 7, 16, 16);
				b8 = ss.crop(3, 7, 16, 16);
				b9 = ss.crop(4, 7, 16, 16);
				b10 = ss.crop(5, 7, 16, 16);
				b11 = ss.crop(6, 7, 16, 16);
				b12 = ss.crop(7, 7, 16, 16);
				
				SpriteSheet ss1 = tp1.getSpriteSheet();
				stoneL = ss1.crop(0, 0, 16, 16);
				stoneR = ss1.crop(1,0,16,16);
				stoneT = ss1.crop(2,0,16,16);
				
				
				try {
					bar = ImageIO.read(getClass().getResource("/health.png"));
					bar1 = ImageIO.read(getClass().getResource("/h1.png"));
					bar2 = ImageIO.read(getClass().getResource("/h2.png"));
					bar3 = ImageIO.read(getClass().getResource("/h3.png"));
					level = ImageIO.read(getClass().getResource("/town.png"));
					forestLevel = ImageIO.read(getClass().getResource("/forest.png"));
					forestLevel1 = ImageIO.read(getClass().getResource("/forest1.png"));
					kingdom = ImageIO.read(getClass().getResource("/kingdom.png"));
					r = ImageIO.read(getClass().getResource("/room.png"));
					r1 = ImageIO.read(getClass().getResource("/r1.png"));
					r2 = ImageIO.read(getClass().getResource("/r2.png"));
					cavern = ImageIO.read(getClass().getResource("/cavern.png"));
					s = ImageIO.read(getClass().getResource("/cold.png"));
					s1 = ImageIO.read(getClass().getResource("/cold1.png"));
					s2 = ImageIO.read(getClass().getResource("/cold2.png"));
					s3 = ImageIO.read(getClass().getResource("/cold3.png"));
				} catch (IOException e) {
					Display.debug.writeToDebug("Texture Error: " + e.getCause());
				}
				Display.debug.writeToDebug("Textures Intialized");
	}

}

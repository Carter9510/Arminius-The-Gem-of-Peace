package com.overrtime.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.overrtime.game.Display;
import com.overrtime.managers.LevelManager;
import com.overrtime.world.entities.Player;

public class Door extends Tile{

	private BufferedImage texture;
	//private Rectangle door;
	
	public Rectangle doorRect;
	
	public static Rooms r = new Rooms();

	//room selection
	int id = 0;
	Random rand = new Random();
	int count = 0;
	//end
	
	@SuppressWarnings("static-access")
	public Door() {
		texture = Display.getTextures().door;
		setName("Door");
		id = rand.nextInt(20);
			
			
			if(id < 5) {
				id = 0;
			}
		
			if(id > 5 && id <= 10) {
				id = 1;
			}
		
			if(id > 10 && id <= 19) {
				id = 2;
			}
			
			if(id == 0) {
				id = 2;
			}
			if(id == 1) {
				id = 0;
			}
			if(id == 2) {
				id = 1;
			}
			
			System.out.println("NEW ID: " + id);
	
	}

	public void tick() {
		
	}
	
	boolean check = true;

	public void render(Graphics g, int x, int y) {
		doorRect = new Rectangle(x,y,32,32);
		
		g.drawImage(texture, x,y,32,32, null);
		
		if(collides(doorRect)) {
			System.out.println("Test");
			Display.room.lx = Player.getXo();
			Display.room.ly = Player.getYo();
			Display.room.current = LevelManager.getCurrentLevel();
			LevelManager.setCurrentLevel(Rooms.rooms[id], Rooms.name, -145,-73);
		}
			//String name = LevelManager.getLevelName();
		
	}

	public void setTile(int x, int y, Tile t) {
		if(x % 16 == 0 & y % 16 == 0) {
		}else {
			roundUp(x);
			roundUp(y);
		}
	}
	
	public int roundX(int x) {
		if(x % 16 == 0) {
			return x;
		}else {
			roundUp(x);
			return x;
		}
	}
	
	public int roundY(int y) {
		if(y% 16 == 0) {
			return y;
		}else {
			roundUp(y);
			return y;
		}
	}
	
	public void roundXandY(int x,int y) {
		roundX(x);
		roundY(y);
	}
	
	public static int roundUp(int num) {
		return (int) (Math.ceil(num / 16d) * 16);
	}
	
}
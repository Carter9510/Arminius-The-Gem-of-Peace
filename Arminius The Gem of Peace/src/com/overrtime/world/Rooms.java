package com.overrtime.world;

import com.overrtime.game.Display;
import com.overrtime.managers.LevelManager;
import com.overrtime.world.entities.Player;

public class Rooms {

	public Level current;
	public String cName;
	public Level room, r1,r2;
	public Level selected;
	public static String name = "Room";
	boolean select = true;
	
	int lx = 0,ly = 0;
	
	public static Level[] rooms = new Level[3];
	
	public static int roomID;
	
	@SuppressWarnings("static-access")
	public void select() {//did use the variable input String currentName
		if(Display.initialized){
		current = LevelManager.getCurrentLevel();
		cName = current.getName();
		Player.cu = false;
		Player.cd = false;
		Player.cl = false;
		Player.cr = false;
		room = new Level(Display.getTextures().r);
		r1 = new Level(Display.getTextures().r1);
		r2 = new Level(Display.getTextures().r2);

		for(int i = 0; i <= 3; i++) {
			System.out.println(i);
			if(i == 1) {
				selected = room;
				lx = Player.getXo();
				ly = Player.getYo();
				//LevelManager.setCurrentLevel(selected, name,-145,-73);
				rooms[0] = room;
			}
			if(i == 2) {
				selected = r1;
				lx = Player.getXo();
				ly = Player.getYo() + 10;
				//LevelManager.setCurrentLevel(selected,  name,-145,-73);
				rooms[1] = r1;
			}
			if(i == 2) {
				selected = r2;
				lx = Player.getXo();
				ly = Player.getYo() + 10;
				//LevelManager.setCurrentLevel(selected, name,-145,-73);
				rooms[2] = r2;
			}
						
		}
			//Random r = new Random();
			//int ri = r.nextInt(3);
		}
			

	}
	
	
	//public void setName(String name) {
		//current = name;
	//}
	
	public int getX() {
		return lx;
	}
	
	public int getY() {
		return ly;
	}
	
}

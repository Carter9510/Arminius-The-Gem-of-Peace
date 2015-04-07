package com.overrtime.managers;

import com.overrtime.world.Level;
import com.overrtime.world.Tile;
import com.overrtime.world.entities.Player;


public class LevelManager
{
  private static Level currentLevel;
  static String name;
  public static int ID = 0;
  public static boolean set = false;
  
  public static void setCurrentLevel(Level newLevel, String name, int x,int y)//if broke and forgot this method had int x, int y aswell!
  {
	  set = true;
	  Player.xo = x;
	  Player.yo = y;
	 if(name.contains("Room")) {
		 Player.xo = x;
		 Player.yo = y;
	 }
    currentLevel = newLevel;
    currentLevel.setName(name);
    System.out.println("Level Name: " + currentLevel.getName());
    //currentLevel.setName(name);
  }
  
  public static void setName(String level)
  {
    name = level;
    System.out.println("Switched: " + name);
  }
  
  public static Level getCurrentLevel()
  {
    return currentLevel;
  }
  
  public static String getLevelName()
  {
    return currentLevel.getName();
  }
  
  
  public static String getName()
  {
    return name;
  }
  
  public static Tile[][] getTile() {
	  return currentLevel.tiles;
  }
  
  public static void set(Level level) {
	  currentLevel = level;
  }
  
}

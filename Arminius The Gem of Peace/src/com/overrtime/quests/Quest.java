package com.overrtime.quests;

import com.overrtime.managers.LevelManager;

public class Quest {

	public static String quest;
	public static int reward;
	public static boolean done;
	public static boolean levelType;
	
	@SuppressWarnings("static-access")
	public Quest(String quest, int reward, boolean levelType) {
		this.quest = quest;
		this.reward = reward;
		this.levelType = levelType;
		System.err.println("Added Quest: " + quest);
    }
	
	public boolean isCompleted() {
		if(levelType && quest.equals("Find The Cavern") && LevelManager.getCurrentLevel().getName().equals("Cavern")) {
			return true;
		}else {
			return false;
		}
	}
	
	public void delete() {
		reward = 0;
	}
	
}

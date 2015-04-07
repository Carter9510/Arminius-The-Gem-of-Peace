package com.overrtime.gfx;


import java.io.File;
import java.io.PrintStream;

import com.overrtime.managers.Data;
import com.overrtime.managers.LevelManager;


public class Export {

	public void writeToFile(File f, String text) {
		try {
			if(!f.exists()) {
				if(f.createNewFile())
					System.out.println("Created!");
				PrintStream ps = new PrintStream(f);
				
				ps.println(text);
				
				ps.close();
			}
			if(f.exists()) {
				PrintStream ps = new PrintStream(f);
				
				ps.println(text);
				
				ps.close();
			}
		}catch(Exception e) {
			
		}
	}

	public void export()throws Exception {
		File levelFile = new File("C:/Users/" + Data.system_user + "/Arminius/World/level.agopW");
		PrintStream ps = new PrintStream(levelFile);
		for(int y = 0; y < LevelManager.getCurrentLevel().h; y++) {
			for(int x = 0; x < LevelManager.getCurrentLevel().w; x++) {
				ps.println(LevelManager.getCurrentLevel().tiles[x][y].getName());
			}
		}
		ps.close();
	}
	
}

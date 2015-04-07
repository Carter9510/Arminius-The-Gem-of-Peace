package com.overrtime.debugger;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Debugger {

	static File f;;
	static PrintStream ps;
	static boolean correct = false;
	
	public Debugger() {
		String user = System.getProperty("user.name");
		
		System.out.println(user);
	}

	
	public void createDebugFile(){
		if(!f.exists()) {
			try {
				if(f.createNewFile())
					System.out.println("Debug File Created!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeToDebug(String text) {
		try {
			if(correct) {
				ps.println(text);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		ps.close();
	}
	
}

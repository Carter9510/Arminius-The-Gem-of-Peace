package com.overrtime.managers;

import java.util.ArrayList;


public class IntManager {

	public  static ArrayList<Integer> x = new ArrayList<Integer>();
	public static ArrayList<Integer> y = new ArrayList<Integer>();
	
	
	
	public static void addX(int x1) {
		x.add(x1);
	}
	
	public static void addY(int y1) {
		y.add(y1);
	}

	public int getX(int index) {
		return x.get(index);
	}
	
	public int getY(int index) {
		return y.get(index);
	}
	
}

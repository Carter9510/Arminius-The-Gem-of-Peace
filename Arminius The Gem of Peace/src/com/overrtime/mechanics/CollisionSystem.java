package com.overrtime.mechanics;



import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionSystem {

	public static ArrayList<Rectangle> collidingShapes = new ArrayList<Rectangle>();
	
	public CollisionSystem() {
		System.out.println(collidingShapes.get(0));
	}
	
	public boolean checkPlayerCollision(Rectangle playerShape) {
		for(Rectangle s: collidingShapes) {
			if(s.intersects(playerShape)) {
				return true;
			}else {
				return false;
			}
		}
		return true;
	}	
	
	public Rectangle getRectangle(int index) {
		return collidingShapes.get(index);
	}
	
	public void addRect(Rectangle r) {
		collidingShapes.add(r);
	}
	
}

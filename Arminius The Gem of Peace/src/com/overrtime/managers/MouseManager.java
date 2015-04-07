package com.overrtime.managers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.overrtime.world.entities.Player;

public class MouseManager implements MouseListener, MouseMotionListener {

	public static boolean intersects = false;

	LevelManager lm = new LevelManager();

	int x, y;

	@SuppressWarnings("unused")
	public void mouseClicked(MouseEvent e) {
		int mousecode = e.getButton();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	//@SuppressWarnings("unused")
	public void mousePressed(MouseEvent e) {
		int mousecode = e.getButton();

		x = e.getX() + Player.xo;
		y = e.getY() + Player.yo;
		

		Player.mouseDown = true;

	//	if (mousecode == MouseEvent.BUTTON1) {
		//	lm.getCurrentLevel().setTile(x / 32 * 1, y / 32 * 1,
	//				new CobbleStone("Cobblestone", 0, 0, false, 0));
	//	}
		
		if(mousecode == MouseEvent.BUTTON2) {
			
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Player.mouseDown = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	public void mouseMoved(MouseEvent e) {
		Player.mx = e.getX();
		Player.my = e.getY();
		
		Player.pX = e.getX();
		Player.pY = e.getY();
		

		x = e.getX() + Player.xo;
		y = e.getY() + Player.yo;

		if (x < 0) {
			x = 0;
		}

		if (y < 0) {
			y = 0;
		}

	}

	public static void tick() {

	}

}

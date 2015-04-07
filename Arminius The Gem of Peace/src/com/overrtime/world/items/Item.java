package com.overrtime.world.items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.overrtime.world.entities.Player;

public abstract class Item {

	protected String itemName;
	protected int x,y;
	protected BufferedImage texture;
	protected boolean stackable;
	protected int beginStack;
	public static Rectangle rect;
	protected boolean dropped = false;
	protected int dx,dy;

	public Item() {
		rect = new Rectangle(x,y,32,32);
	}
	
	public void setStackable(boolean tof) {
		stackable = tof;
	}
	
 	public void setBeginStack(int bs) {
 		this.beginStack = bs;
 	}
	
	public String getName() {
		return itemName;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public boolean stackable() {
		return stackable;
	}
	
	public void setDropped(boolean tof) {
		dropped = tof;
	}
	
	public boolean getDropped() {
		return dropped;
	}
	
	public void setName(String itemName) {
		this.itemName = itemName;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}

	public void setXandY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int addToStack() {
		return beginStack++;
	}
	
	public int getStack() {
		return beginStack;
	}
	
	@SuppressWarnings("static-access")
	public void setRectangle(Rectangle rect) {
		this.rect = rect;
	}
	
	public int removeStack() {
		if(beginStack > 0) {
			return beginStack--;
		}else {
			System.out.println("Nothing To Drop");
			return 0;
		}
	}
	
	public  Rectangle getRectangle() {
		return rect;
	}
	
	public void addStack(int amount) {
		beginStack += amount;
	}

	
	public int get() {
		return beginStack;
	}
	
	public void setDxAndDy(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void drop() {
		
	}
	
	public void renderDropped(Graphics g) {
		if(getDropped()) {
			g.drawImage(getTexture(),300 - Player.getXo(),dy - Player.getYo(),21,21,null);
		}
	}
	
	public void combine(Item i) {
		if(i.getName() == itemName) {
			addStack(i.getStack());
		}
	}
	
	public void drawStack(Graphics g) {
		g.setColor(Color.yellow);
		g.clearRect(x, y + 43, 4, 4);
		g.drawString("" + get(), x,y + 43);
	}
	
}
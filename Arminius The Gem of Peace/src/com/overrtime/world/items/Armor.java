package com.overrtime.world.items;

public abstract class Armor{

	protected int strength;
	protected String name;
	
	
	public Armor(int strength) {
		this.strength = strength;
	}
	
	public abstract void tick();
	public abstract void render();
	
}

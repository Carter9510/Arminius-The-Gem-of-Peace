package com.overrtime.world.items;


public abstract class Consumable extends Item{

	protected double heatValue;
	
	public Consumable() {
	
	}
	
	public void consume() {
		if(stackable()) {
			if(getStack() > 0) {
				removeStack();
			}
		}
	}
	
	public void setHeatValue(double heatValue) {
		this.heatValue = heatValue;
	}	


	
}

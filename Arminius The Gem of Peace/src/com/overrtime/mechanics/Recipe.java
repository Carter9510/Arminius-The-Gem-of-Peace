package com.overrtime.mechanics;

import com.overrtime.world.items.Tool;

public class Recipe {

	public String output;
	public String materials = "Stick";

	public String craftingRecipes = "Stick";
	
	public void addMaterial(String material) {
		StringBuilder sb = new StringBuilder(materials);
		sb.append(" " + material);
		materials = sb.toString();
	}
	
	public void addRecipe(String i, String i1, String i2) {
		StringBuilder sb = new StringBuilder(craftingRecipes);
		sb.append(" " + i + " " + i1  + " " + i2);
		craftingRecipes = sb.toString();
		System.out.println(craftingRecipes);
	}
	
	public void addRecipe(String i, String i1) {
		StringBuilder sb = new StringBuilder(craftingRecipes);
		sb.append(" " + i + " " + i1);
		craftingRecipes = sb.toString();
	}
	
	public void addRecipe(String i) {
		StringBuilder sb = new StringBuilder(craftingRecipes);
		sb.append(" " + i);
		craftingRecipes = sb.toString();
	}
	
	public boolean craftable(Tool i) {
		if(craftingRecipes.contains(i.getName()) & i.getStack() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean craftable(Tool i, Tool i1, Tool i2) {
		if(craftingRecipes.contains(i.getName())& craftingRecipes.contains(i1.getName()) & craftingRecipes.contains(i2.getName()) & i.getStack() > 0 & i1.getStack() > 0 & i2.getStack() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean craftable(Tool i, Tool i1) {
		if(craftingRecipes.contains(i.getName()) & craftingRecipes.contains(i1.getName()) & i.getStack() > 0 & i1.getStack() > 0) {
			return true;
		}
		return false;
	}

	
	public String getOutput() {
		return output;
	}
	
}

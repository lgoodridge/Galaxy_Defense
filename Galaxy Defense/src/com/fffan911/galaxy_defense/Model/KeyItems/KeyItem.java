package com.fffan911.galaxy_defense.Model.KeyItems;

public abstract class KeyItem {
	//Constants
	private static final String TAG = "KeyItem";
	
	//Boolean Methods
	public boolean namesMatch(String otherKeyItemName) {
		return getName().equals(otherKeyItemName);
	}
	
	//Get Methods
	public String getDetails() {
		return getName() + "\n\n" + getDescription();
	}
	
	//Abstract Methods
	public abstract String getName();
	public abstract String getDescription();
}

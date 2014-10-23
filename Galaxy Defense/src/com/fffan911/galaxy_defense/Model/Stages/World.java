package com.fffan911.galaxy_defense.Model.Stages;

import com.fffan911.galaxy_defense.R;

public enum World {
	//Enum Values
	ZERO("Debug World", 0, R.drawable.space_background),
	ONE("Mercury", 1, R.drawable.blank);
	
	//Attributes
	private String worldName;
	private int worldNumber;
	private int defaultBackgroundId;
	
	//Constructor
	private World(String worldName, int worldNumber, int defaultBackgroundId){
		this.worldName = worldName;
		this.worldNumber = worldNumber;
		this.defaultBackgroundId = defaultBackgroundId;
	}
	
	//Get Methods
	public String getWorldName() {
		return worldName;
	}
	public int getWorldNumber() {
		return worldNumber;
	}
	public int getDefaultBackgroundId() {
		return defaultBackgroundId;
	}
}

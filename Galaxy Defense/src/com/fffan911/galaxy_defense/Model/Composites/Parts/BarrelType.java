package com.fffan911.galaxy_defense.Model.Composites.Parts;

public enum BarrelType {
	//Enum Values
	SINGLE ("Single"), 
	DOUBLE ("Double"),
	LAUNCHER ("Launcher"),
	VOID ("Void");
	
	//Attributes
	private final String screenName;
	
	//Enum Constructor
	private BarrelType(String screenName) {
		this.screenName = screenName;
	}
	
	//Get Methods
	public String getScreenName() {
		return screenName;
	}
}

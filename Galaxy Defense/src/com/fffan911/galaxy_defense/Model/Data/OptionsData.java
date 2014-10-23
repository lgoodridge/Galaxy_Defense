package com.fffan911.galaxy_defense.Model.Data;

public class OptionsData {
	//Instance
	private static OptionsData instance;
	
	//Singleton Constructor
	private OptionsData(){
		
	}
	
	//Singleton Method
	public OptionsData getInstance(){
		if (instance == null) {
			instance = new OptionsData();
		}
		return instance;
	}
}

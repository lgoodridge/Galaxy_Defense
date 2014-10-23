package com.fffan911.galaxy_defense.Controller.Proxies;

import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Data.GameState;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class GenericProxy {
	//References
	protected Activity activity;
	//Constants
	private static final String TAG = "GenericProxy";
	
	//Constructor
	public GenericProxy(Activity activity){
		this.activity = activity;
	}
	
	//Intent Methods
	public void switchToMainMenu(){
		GameData.getInstance().setGameState(GameState.MAIN_MENU);
		GameData.getInstance().setGameMode(GameMode.MENU);
		Intent mainMenuIntent = new Intent("com.fffan911.galaxy_defense.MAIN_MENU_ACTIVITY");
		activity.startActivity(mainMenuIntent);
		activity.finish();
	}
	public void switchToBattle(){
		GameData.getInstance().setGameState(GameState.BATTLE);
		Intent battleIntent = new Intent("com.fffan911.galaxy_defense.BATTLE_ACTIVITY");
		activity.startActivity(battleIntent);
		activity.finish();
	}
	public void switchToAsteroids(){
		GameData.getInstance().setGameState(GameState.ASTEROIDS);
		Intent asteroidsIntent = new Intent("com.fffan911.galaxy_defense.ASTEROIDS_ACTIVITY");
		activity.startActivity(asteroidsIntent);
		activity.finish();
	}
	public void switchToShop() {
		GameData.getInstance().setGameState(GameState.SHOP);
		Intent shopIntent = new Intent("com.fffan911.galaxy_defense.SHOP_ACTIVITY");
		activity.startActivity(shopIntent);
		activity.finish();
	}
	public void switchToBlueprint() {
		GameData.getInstance().setGameState(GameState.BLUEPRINT);
		Intent blueprintIntent = new Intent("com.fffan911.galaxy_defense.BLUEPRINT_ACTIVITY");
		activity.startActivity(blueprintIntent);
		activity.finish();
	}
	public void exitApp(){
		activity.finish();
	}
	
	//Open Methods
	public void openOptionsMenu() {
		activity.openOptionsMenu();
	}
}

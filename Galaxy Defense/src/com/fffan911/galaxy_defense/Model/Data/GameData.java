package com.fffan911.galaxy_defense.Model.Data;

import java.util.ArrayList;

import com.fffan911.galaxy_defense.Model.KeyItems.KeyItem;
import com.fffan911.galaxy_defense.Model.Miscellany.OnPauseListener;

public class GameData {
	//Instance
	private static GameData instance;
	//Enumerations
	private GameMode gameMode;
	private GameState gameState;
	//References
	private ArrayList<KeyItem> keyItems;
	private ArrayList<OnPauseListener> onPauseListeners;
	//Story Data
	private int currStoryScore;
	private int bestStoryScore;
	//Arcade Data
	private int currArcadeScore;
	private int bestArcadeScore;
	//State Variables
	private boolean isPaused;
	
	//Singleton Constructor
	private GameData(){
		gameMode = GameMode.MENU;
		gameState = GameState.MAIN_MENU;
		keyItems = new ArrayList<KeyItem>();
		onPauseListeners = new ArrayList<OnPauseListener>();
		currStoryScore = 0;
		bestStoryScore = 0;
		currArcadeScore = 0;
		bestArcadeScore = 0;
		isPaused = false;
	}
	
	//Singleton Method
	public static GameData getInstance(){
		if (instance == null) {
			instance = new GameData();
		}
		return instance;
	}
	
	//Pause + Unpause
	public void pause(){
		isPaused = true;
		for (OnPauseListener listener : onPauseListeners) listener.onPause();
	}
	public void unpause(){
		isPaused = false;
		for (OnPauseListener listener : onPauseListeners) listener.onUnpause();
	}
	
	//Add + Remove Methods
	public void addKeyItem(KeyItem keyItem) {
		keyItems.add(keyItem);
	}
	public void addOnPauseListener(OnPauseListener listener){
		onPauseListeners.add(listener);
	}
	public void addScore(int amount) {
		if (isAtMode(GameMode.STORY)) addStoryScore(amount);
		if (isAtMode(GameMode.ARCADE)) addArcadeScore(amount);
	}
	public void addStoryScore(int amount) {
		currStoryScore += amount;
		if (currStoryScore > bestStoryScore) bestStoryScore = currStoryScore;
	}
	public void addArcadeScore(int amount) {
		currArcadeScore += amount;
		if (currArcadeScore > bestArcadeScore) bestArcadeScore = currArcadeScore;
	}
	public void removeKeyItem(String keyItemName) {
		keyItems.remove(getKeyItem(keyItemName));
	}
	public void removeOnPauseListener(OnPauseListener listener){
		onPauseListeners.remove(listener);
	}
	public void remScore(int amount) {
		if (isAtMode(GameMode.STORY)) remStoryScore(amount);
		if (isAtMode(GameMode.ARCADE)) remArcadeScore(amount);
	}
	public void remStoryScore(int amount) {
		currStoryScore -= amount;
		if (currStoryScore > bestStoryScore) bestStoryScore = currStoryScore;
	}
	public void remArcadeScore(int amount) {
		currArcadeScore -= amount;
		if (currArcadeScore > bestArcadeScore) bestArcadeScore = currArcadeScore;
	}
	
	//Boolean Methods
	public boolean isAtMode(GameMode gameModeToCheck){
		return gameMode == gameModeToCheck;
	}
	public boolean isAtState(GameState gameStateToCheck){
		return gameState == gameStateToCheck;
	}
	public boolean isPaused(){
		return isPaused;
	}
	public boolean hasKeyItem(String keyItemName) {
		return getKeyItem(keyItemName) != null;
	}
	
	//Set Methods
	public void setGameMode(GameMode newGameMode){
		gameMode = newGameMode;
	}
	public void setGameState(GameState newGameState){
		gameState = newGameState;
	}
	public void setCurrStoryScore(int newCurrScore){
		currStoryScore = newCurrScore;
	}
	public void setBestStoryScore(int newBestScore){
		bestStoryScore = newBestScore;
	}
	public void setCurrArcadeScore(int newCurrScore){
		currArcadeScore = newCurrScore;
	}
	public void setBestArcadeScore(int newBestScore){
		bestArcadeScore = newBestScore;
	}
	
	//Get Methods
	public GameMode getGameMode(){
		return gameMode;
	}
	public GameState getGameState(){
		return gameState;
	}
	public ArrayList<KeyItem> getKeyItems() {
		return keyItems;
	}
	public KeyItem getKeyItem(String keyItemName) {
		for (KeyItem keyItem : keyItems) {
			if (keyItem.namesMatch(keyItemName)) return keyItem;
		}
		return null;
	}
	public int getScore() {
		if (isAtMode(GameMode.STORY)) return currStoryScore;
		if (isAtMode(GameMode.ARCADE)) return currArcadeScore;
		return -1;
	}
	public int getBestScore() {
		if (isAtMode(GameMode.STORY)) return bestStoryScore;
		if (isAtMode(GameMode.ARCADE)) return bestArcadeScore;
		return -1;
	}
	public int getCurrStoryScore(){
		return currStoryScore;
	}
	public int getBestStoryScore(){
		return bestStoryScore;
	}
	public int getCurrArcadeScore(){
		return currArcadeScore;
	}
	public int getBestArcadeScore(){
		return bestArcadeScore;
	}
}

package com.fffan911.galaxy_defense.Model.Stages;

import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GameUIProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Model.Miscellany.ActivityLoadThread;
import com.fffan911.galaxy_defense.Model.Stages.ArcadeStages.ArcadeStage_0_1;
import com.fffan911.galaxy_defense.Model.Stages.StoryStages.StoryStage_0_1;
import com.fffan911.galaxy_defense.Model.Stages.StoryStages.StoryStage_0_2;

import android.app.Activity;
import android.util.Log;

public class StageManager {
	//Instance
	private static StageManager instance;
	//References
	private Stage[] loadedStages;
	private Stage currentStage;
	private Activity currentActivity;
	private boolean activityLoaded;
	//Constants
	private static final String TAG = "StageManager";
	
	//Singleton Constructor
	private StageManager() {
		this.loadedStages = null;
		this.currentStage = null;
		this.currentActivity = null;
		this.activityLoaded = false;
	}
	
	//Singleton Method
	public static StageManager getInstance() {
		if (instance == null) {
			instance = new StageManager();
		}
		return instance;
	}
	
	//Play and Stop Methods
	public void playStage(int worldNum, int stageNum){
		//Get Stage and Activity Switcher
		currentStage = findStage(worldNum, stageNum);
		GenericProxyUser gpu = (GenericProxyUser)currentActivity;
		GenericProxy genericProxy = gpu.getProxy();
		//Switch Activities based on Stage Type
		if (currentStage.getStageType().equals("Asteroids")) {
			genericProxy.switchToAsteroids();
		} else if (currentStage.getStageType().equals("Battle")) {
			genericProxy.switchToBattle();
		}
		//Wait for Activity to Load
		activityLoaded = false;
		new ActivityLoadThread().start();
	}
	public void stopCurrentStage(){
		currentStage.stopStage();
	}
	
	//Reaction Methods
	public void gameActivityLoaded(){
		//Get the Panel and load Stage with the Panel
		GameProxyUser gameProxyUser = (GameProxyUser)currentActivity;
		GameUIProxy gameUIProxy = gameProxyUser.getUIProxy();
		currentStage.loadStage(gameUIProxy.getGamePanel());
		//Start the stage
		currentStage.startStage();
	}
	
	//Stage Matrix Loading Methods
	public void loadStoryStages() {
		Stage[] storyStages = new Stage[2];
		storyStages[0] = new StoryStage_0_1();
		storyStages[1] = new StoryStage_0_2();
		loadedStages = storyStages;
	}
	public void loadArcadeBattleStages() {}
	public void loadArcadeAsteroidsStages() {
		Stage[] arcadeStages = new Stage[1];
		arcadeStages[0] = new ArcadeStage_0_1();
		loadedStages = arcadeStages;
	}
	public void loadArcadeAllStages() {
		Stage[] arcadeStages = new Stage[1];
		arcadeStages[0] = new ArcadeStage_0_1();
		loadedStages = arcadeStages;
	}
	public void loadVersusStages() {}
	
	//Stage Completion Methods
	public void stageVictory() {}
	public void stageDefeat() {}
	
	//Find Methods
	public Stage findStage(int worldNum, int stageNum){
		for (Stage stage : loadedStages){
			if (stage.getWorldNumber() == worldNum && stage.getStageNumber() == stageNum) {
				return stage;
			}
		}
		Log.e(TAG, "Stage " + worldNum + "-" + stageNum + " not found.");
		return null;
	}
	
	//Boolean Methods
	public boolean isActivityLoaded(){
		return activityLoaded;
	}
	
	//Set Methods
	public void setCurrentActivity(Activity activity){
		this.currentActivity = activity;
	}
	public void setActivityLoaded(boolean activityLoaded){
		this.activityLoaded = activityLoaded;
	}
	
	//Get Methods
	public Stage[] getLoadedStages(){
		return loadedStages;
	}
	public Stage getCurrentStage(){
		return currentStage;
	}
	public Activity getCurrentActivity(){
		return currentActivity;
	}
}

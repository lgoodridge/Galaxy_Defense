package com.fffan911.galaxy_defense.Model.Stages;

import java.util.List;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Miscellany.GameThread;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public abstract class Stage {
	//References
	private World world;
	private GamePanel panel;
	private GameThread thread;
	private Script script;
	private Handler handler;
	//Attributes
	private String stageType;
	private long stageRunTime;
	private int stageNumber;
	private int updateLoopNumber;
	//Constants
	private static final String TAG = "Stage";
	
	//Constructor
	public Stage(World world, int stageNumber, String stageType) {
		this.stageNumber = stageNumber;
		this.stageType = stageType;
		this.world = world;
		this.updateLoopNumber = 0;
		this.stageRunTime = 0l;
		this.handler = new Handler(Looper.getMainLooper());
	}
	
	//Start and Stop Methods
	public final void startStage(){
		Log.d(TAG, "Starting Stage " + getWorldNumber() + "-" + getStageNumber());
		thread.setRunning(true);
		thread.start();
	}
	public final void stopStage(){
		Log.d(TAG, "Stopping Stage " + getWorldNumber() + "-" + getStageNumber());
		boolean retry = true;
		while (retry) {
			thread.setRunning(false);
			retry = false;
		}
		Log.d(TAG, "Thread was shut down cleanly.");
		panel.deref();
		PlayerData.getInstance().clearPlayerHealthData();
	}
	
	//Preparation Methods
	public void loadStage(GamePanel panel){
		this.panel = panel;
		this.thread = new GameThread(panel.getHolder(), this);
		this.script = new Script(constructCueList(panel));
		preparePanel();
	}
	private void preparePanel() {
		panel.createPlayerShip();
		panel.createPlayerTarget();
	}
	
	//Stage Methods
	public void update(long updateTimeDiff){
		panel.update(updateTimeDiff);
		script.update(updateTimeDiff);
		stageRunTime += updateTimeDiff;
		checkStageState();
		updateLoopNumber++;
	}
	public void render(Canvas canvas){
		panel.render(canvas);
		panel.checkForCollisions();
		panel.checkForBoundsCollisions();
		if (updateLoopNumber % 1 == 0) {
			redrawHealthBar();
			redrawScore();
		}
	}
	
	//Redraw Methods
	private void redrawHealthBar() {
		handler.post(new Runnable() {
			public void run() {
				GameProxyUser gpu = (GameProxyUser)(getPanel().getContext());
				gpu.getUIProxy().getHealthBar().invalidate();
			}
		});
	}
	private void redrawScore() {
		handler.post(new Runnable() {
			public void run() {
				GameProxyUser gpu = (GameProxyUser)(getPanel().getContext());
				gpu.getUIProxy().getScoreView().setText("Score: " + GameData.getInstance().getScore());
				gpu.getUIProxy().getScoreView().invalidate();
			}
		});
	}
	
	//Check Methods
	public void checkStageState(){
		if (victoryConditionReached()){
			stopStage();
			StageManager.getInstance().stageVictory();
			onVictory();
		}
		if (defeatConditionReached()){
			stopStage();
			StageManager.getInstance().stageDefeat();
			onDefeat();
		}
	}
	
	//Get Methods
	public Script getScript(){
		return script;
	}
	public GamePanel getPanel(){
		return panel;
	}
	public GameThread getThread(){
		return thread;
	}
	public World getWorld(){
		return world;
	}
	public String getWorldName(){
		return world.getWorldName();
	}
	public int getWorldNumber(){
		return world.getWorldNumber();
	}
	public int getStageNumber(){
		return stageNumber;
	}
	public String getStageType(){
		return stageType;
	}
	public int getDefaultBackgroundId(){
		return world.getDefaultBackgroundId();
	}
	public long getStageRunTime(){
		return stageRunTime;
	}
	
	//Abstract Methods
	public abstract List<Cue> constructCueList(GamePanel panel);
	public abstract void onVictory();
	public abstract void onDefeat();
	public abstract boolean victoryConditionReached();
	public abstract boolean defeatConditionReached();
	public abstract GameMode getGameMode();
}

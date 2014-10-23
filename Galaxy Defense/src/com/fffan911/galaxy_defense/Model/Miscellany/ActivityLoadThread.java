package com.fffan911.galaxy_defense.Model.Miscellany;

import android.util.Log;

import com.fffan911.galaxy_defense.Model.Stages.StageManager;

public class ActivityLoadThread extends Thread {
	//Attributes
	private boolean isRunning;
	//Constants
	private static final String TAG = "ActivityLoadThread";
	
	//Constructor
	public ActivityLoadThread() {
		this.isRunning = true;
	}
	
	//Run Method
	@Override
	public void run(){
		while (isRunning){
			if (StageManager.getInstance().isActivityLoaded()) {
				Log.d(TAG, "Activity Loaded.");
				StageManager.getInstance().gameActivityLoaded();
				isRunning = false;
				boolean retry = true;
				while (retry){
					try {
						join();
						retry = false;
					} catch (InterruptedException ie) {}
				}
			}
		}
	}
}

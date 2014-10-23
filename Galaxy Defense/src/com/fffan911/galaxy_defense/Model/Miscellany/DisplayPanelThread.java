package com.fffan911.galaxy_defense.Model.Miscellany;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

import com.fffan911.galaxy_defense.View.Customs.DisplayPanel;

public class DisplayPanelThread extends Thread {
	//References
	private DisplayPanel displayPanel;
	private SurfaceHolder holder;
	//Attributes
	private long lastUpdateTime;
	private long updateTimeDiff;
	private boolean isRunning;
	//Constants
	private static final int MAX_FPS = 40;
	private static final int MAX_FRAME_SKIPS = 5;
	private static final int FRAME_PERIOD = 1000 / MAX_FPS;
	private static final String TAG = "DisplayPanelThread";
	
	//Constructor
	public DisplayPanelThread (DisplayPanel displayPanel) {
		this.displayPanel = displayPanel;
		this.holder = displayPanel.getHolder();
		this.lastUpdateTime = System.currentTimeMillis();
		this.updateTimeDiff = 0l;
		this.isRunning = false;
	}
	
	@Override
	public void run() {
		//Init the Game loop
		Canvas canvas;
		Log.d(TAG, "Starting Game Loop...");
		
		//Init FPS variables
		long beginTime;
		long timeDiff;
		int sleepTime;
		int framesSkipped;
		sleepTime = 0;
		
		//While the thread is running
		while (isRunning){
			//Set update times
			updateTimeDiff = System.currentTimeMillis() - lastUpdateTime;
			lastUpdateTime = System.currentTimeMillis();
			
			//Necessary to lock the canvas
			canvas = null;
			
			try {
				//Lock the canvas
				canvas = holder.lockCanvas();
				
				synchronized(holder){
					//Init time + frame variables
					beginTime = System.currentTimeMillis();
					framesSkipped = 0;
					
					//Update and render the panel
					displayPanel.update(updateTimeDiff);
					displayPanel.render(canvas);
					displayPanel.checkForBoundsCollisions();
					
					//Update the times
					timeDiff = System.currentTimeMillis() - beginTime;
					sleepTime = (int)(FRAME_PERIOD - timeDiff);
					
					//If we have extra time
					if (sleepTime > 0) {
						try {
							Thread.sleep(sleepTime); //FIX: replace with something else
						} catch (InterruptedException ie) {}
					}
					
					//If we're behind - update w/o rendering
					while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS){
						displayPanel.update(updateTimeDiff);
						sleepTime += FRAME_PERIOD;
						framesSkipped++;
					}
				}
			//Get rid of any exceptions
			} catch (Exception e) {
			} finally {
				//If canvas exists, unlock it
				if (canvas != null) {
					holder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
	
	//Set Methods
	public void setRunning(boolean bool){
		isRunning = bool;
	}
}

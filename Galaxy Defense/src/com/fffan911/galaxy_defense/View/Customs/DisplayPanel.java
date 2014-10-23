package com.fffan911.galaxy_defense.View.Customs;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.DisplayPanelController;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Miscellany.DisplayPanelThread;
import com.fffan911.galaxy_defense.Model.Physics.Position;

public class DisplayPanel extends GamePanel {
	//References
	private DisplayPanelThread displayThread;
	private boolean playerShipPositionSet;
	//Constants
	private static final String TAG = "DisplayPanel";
	
	//Constructor
	public DisplayPanel(Context context, AttributeSet attrs){
		super(context, attrs);
		this.playerShipPositionSet = false;
		setController(new DisplayPanelController(this));
		setThread(new DisplayPanelThread(this));
		startThread();
	}
	
	//Action Methods
	private void startThread() {
		displayThread.setRunning(true);
		displayThread.start();
	}
	
	//GamePanel Methods
	@Override
	public void render(Canvas canvas) {
		super.render(canvas);
		if (!playerShipPositionSet) {
			if (getWidth() == 0) return;
			getPlayerShip().setX(getPlayerShipStartingPosition().getX());
			getPlayerShip().setY(getPlayerShipStartingPosition().getY());
			playerShipPositionSet = true;
		}
	}
	@Override
	public Position getPlayerShipStartingPosition(){
		return new Position(getXCenter(), getHeight() - (PlayerShip.SIZE / 2));
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		super.surfaceDestroyed(holder);
		displayThread.setRunning(false);
	}
	
	//Set Methods
	private void setThread(DisplayPanelThread thread){
		this.displayThread = thread;
	}
}

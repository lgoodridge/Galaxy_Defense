package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import android.util.Log;
import android.view.MotionEvent;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.View.Customs.DisplayPanel;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class DisplayPanelController extends Controller {
	//Constants
	private static final String TAG = "DisplayPanelController";
	
	//Constructor
	public DisplayPanelController(GamePanel panel) {
		super(panel);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		//Process Touch Event
		if (me.getAction() == MotionEvent.ACTION_DOWN || 
		me.getAction() == MotionEvent.ACTION_MOVE) {
			//Move the player ship to that position
			DisplayPanel displayPanel = (DisplayPanel)(getView());
			displayPanel.getPlayerShip().getPosition().moveTo((int)me.getX(),
			displayPanel.getPlayerShip().getY(), displayPanel.getPlayerShip().getMaxSpeed());
			Log.d(TAG, "Moving To: " + (int)me.getX() + " , " + displayPanel.getPlayerShip().getY());
		}
		return true;
	}
}

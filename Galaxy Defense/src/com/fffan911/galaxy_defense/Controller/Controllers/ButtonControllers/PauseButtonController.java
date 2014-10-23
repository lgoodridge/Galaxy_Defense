package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Model.Data.GameData;

public class PauseButtonController extends Controller {
	//Constants
	private final static String TAG = "PauseButtonController";
	
	//Constructor
	public PauseButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			//Pause the Game
			GameData gameData = GameData.getInstance();
			if (gameData.isPaused()) gameData.unpause();
			else gameData.pause();
			//If it's now paused, display the Options Menu
			if (!gameData.isPaused()) return true;
			GenericProxyUser gpu = (GenericProxyUser)(getView().getContext());
			gpu.getProxy().openOptionsMenu();
		}
		return true;
	}
}

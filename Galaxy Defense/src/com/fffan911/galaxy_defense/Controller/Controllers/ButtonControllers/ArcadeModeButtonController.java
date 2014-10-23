package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuUIProxy;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ArcadeModeButtonController extends Controller{
	//Constants
	private final static String TAG = "ArcadeModeButtonController";
	
	//Constructor
	public ArcadeModeButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED!");
			StageManager.getInstance().loadArcadeAllStages();
			GenericProxyUser gpu = (GenericProxyUser)(getView().getContext());
			gpu.getUIProxy().displayStageSelectorPopup();
		}
		return true;
	}
}

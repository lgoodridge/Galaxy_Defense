package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;
import com.fffan911.galaxy_defense.View.Buttons.StageButton;

public class StageButtonController extends Controller {
	//Constants
	private static final String TAG = "StageButtonController";
	
	//Constructor
	public StageButtonController(StageButton stageButton) {
		super(stageButton);
	}
	
	//Touch Event Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			StageButton stageButton = (StageButton)(getView());
			StageManager.getInstance().playStage(stageButton.getWorldNum(), 
			stageButton.getStageNum());
			GameData.getInstance().setGameMode(StageManager.getInstance().
			getCurrentStage().getGameMode());
		}
		return true;
	}
}

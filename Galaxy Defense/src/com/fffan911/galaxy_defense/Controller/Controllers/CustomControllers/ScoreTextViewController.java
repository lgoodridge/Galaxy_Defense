package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class ScoreTextViewController extends Controller {
	//Constants
	private static final String TAG = "ScoreTextViewController";
	
	//Constructor
	public ScoreTextViewController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me){
		return true;
	}
}

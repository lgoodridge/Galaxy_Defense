package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class BattleFragmentLayoutController extends Controller {
	//Constants
	private static final String TAG = "BattleFragmentLayoutController";
	
	//Constructor
	public BattleFragmentLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	public boolean onTouchEvent(MotionEvent me){
		return true;
	}
}

package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class AsteroidsSideFragmentLayoutController extends Controller {
	//Constants
	private final static String TAG = "AsteroidsSideFragmentLayoutController";
	
	//Constructor
	public AsteroidsSideFragmentLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return true;
	}
}

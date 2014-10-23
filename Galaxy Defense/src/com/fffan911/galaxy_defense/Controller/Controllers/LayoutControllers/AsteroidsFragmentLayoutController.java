package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class AsteroidsFragmentLayoutController extends Controller {
	//Constants
	private static final String TAG = "AsteroidsFragmentLayoutController";
	
	//Constructor
	public AsteroidsFragmentLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	public boolean onTouchEvent(MotionEvent me){
		return true;
	}
}

package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class DisplayFragmentLayoutController extends Controller {
	//Constants
	private static final String TAG = "DisplayFragmentLayoutController";
	
	//Constructor
	public DisplayFragmentLayoutController(View view) {
		super(view);
	}
	
	//Controller Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return true;
	}
}

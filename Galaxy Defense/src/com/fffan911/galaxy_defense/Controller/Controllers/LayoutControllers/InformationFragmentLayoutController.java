package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class InformationFragmentLayoutController extends Controller {
	//Constants
	private static final String TAG = "InformationFragmentLayoutController";
	
	//Constructor
	public InformationFragmentLayoutController(View view) {
		super(view);
	}
	
	//Controller Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return true;
	}
}

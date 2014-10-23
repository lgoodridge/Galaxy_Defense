package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class BlueprintLayoutController extends Controller {
	//Constants
	private static final String TAG = "BlueprintLayoutController";
	
	//Constructor
	public BlueprintLayoutController(View view) {
		super(view);
	}
	
	//Controller Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return true;
	}
}

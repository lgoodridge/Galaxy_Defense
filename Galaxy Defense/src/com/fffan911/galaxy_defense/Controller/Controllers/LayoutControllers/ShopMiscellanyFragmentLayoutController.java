package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class ShopMiscellanyFragmentLayoutController extends Controller {
	//Constants
	private static final String TAG = "ShopMiscellanyFragmentLayoutController";
	
	//Constructor
	public ShopMiscellanyFragmentLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	public boolean onTouchEvent(MotionEvent me){
		return true;
	}
}

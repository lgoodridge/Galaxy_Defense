package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class ShopShipFragmentLayoutController extends Controller {
	//Constants
	private static final String TAG = "ShopShipFragmentLayoutController";
	
	//Constructor
	public ShopShipFragmentLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	public boolean onTouchEvent(MotionEvent me){
		return true;
	}
}

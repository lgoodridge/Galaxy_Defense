package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class ShopWeaponsFragmentLayoutController extends Controller {
	//Constants
	private static final String TAG = "ShopWeaponsFragmentLayoutController";
	
	//Constructor
	public ShopWeaponsFragmentLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	public boolean onTouchEvent(MotionEvent me){
		return true;
	}
}

package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

public class BuyWeaponPopupLayoutController extends Controller {
	//Constants
	private static final String TAG = "BuyWeaponPopupLayoutController";
	
	//Constructor
	public BuyWeaponPopupLayoutController(View view) {
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return true;
	}
}

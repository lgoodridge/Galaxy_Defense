package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

import android.view.MotionEvent;
import android.view.View;

public class ShieldBarController extends Controller{
	//Constants
	private static final String TAG = "ShieldBarController";
	
	//Constructor
	public ShieldBarController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me){
		return true;
	}
}

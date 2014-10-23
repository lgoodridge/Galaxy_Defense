package com.fffan911.galaxy_defense.Controller.Controllers;

import android.view.MotionEvent;
import android.view.View;

public abstract class Controller {
	//References
	private View view;
	
	//Constructor
	public Controller(View view){
		this.view = view;
	}
	
	//Get Methods
	public View getView(){
		return view;
	}
	
	//Abstract Methods
	public abstract boolean onTouchEvent(MotionEvent me);
}

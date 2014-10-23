package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.CloseBuyWeaponButtonController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class CloseBuyWeaponButton extends Button {
	//References
	private Controller controller;
	//Constants
	private final static String TAG = "CloseBuyWeaponButton";
	
	//Constructor
	public CloseBuyWeaponButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new CloseBuyWeaponButtonController(this));
		setText("Close");
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me){
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private final void setController(Controller controller){
		this.controller = controller;
	}
}

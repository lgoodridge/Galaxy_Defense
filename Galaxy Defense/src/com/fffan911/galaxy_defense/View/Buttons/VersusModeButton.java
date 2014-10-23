package com.fffan911.galaxy_defense.View.Buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.VersusModeButtonController;

public class VersusModeButton extends Button {
	//References
	private Controller controller;
	//Constants
	private final static String TAG = "VersusModeButton";
	
	//Constructor
	public VersusModeButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new VersusModeButtonController(this));
		setText("Versus Mode");
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

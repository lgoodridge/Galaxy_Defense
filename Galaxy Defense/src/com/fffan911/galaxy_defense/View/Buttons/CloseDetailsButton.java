package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.CloseDetailsButtonController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class CloseDetailsButton extends Button {
	//Reference
	private Controller controller;
	//Constants
	private static final String TAG = "CloseDetailsButton";
	
	//Constructor
	public CloseDetailsButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new CloseDetailsButtonController(this));
		setText("Close");
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private final void setController(Controller controller) {
		this.controller = controller;
	}
}

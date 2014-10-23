package com.fffan911.galaxy_defense.View.Buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.PauseButtonController;

public class PauseButton extends Button{
	//References
	private Controller controller;
	//Constants
	private final static String TAG = "PauseButton";
	
	//Constructor
	public PauseButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new PauseButtonController(this));
		setText("PAUSE");
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

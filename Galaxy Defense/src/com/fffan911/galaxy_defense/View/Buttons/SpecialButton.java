package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.SpecialButtonController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class SpecialButton extends Button {
	//References
	private Controller controller;
	//Constants
	private static final String TAG = "SpecialButton";
	
	//Constructor
	public SpecialButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new SpecialButtonController(this));
		setText("SPECIAL");
		setBackgroundDrawable(getResources().getDrawable(R.drawable.blue_button_background));
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

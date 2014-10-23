package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.BlueprintButtonController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class BlueprintButton extends Button {
	//References
	private Controller controller;
	//Constants
	private final static String TAG = "BlueprintButton";
	
	//Constructor
	public BlueprintButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new BlueprintButtonController(this));
		setBackgroundResource(R.drawable.blue_button_background);
		setText("BLUEPRINT");
	}
	public BlueprintButton(Context context) {
		super(context);
		setController(new BlueprintButtonController(this));
		setBackgroundResource(R.drawable.blue_button_background);
		setText("BLUEPRINT");
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

package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.CloseStageSelectorButtonController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class CloseStageSelectorButton extends Button {
	//References
	private Controller controller;
	//Constants
	private final static String TAG = "CloseStageSelectorButton";
	
	//Constructor
	public CloseStageSelectorButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new CloseStageSelectorButtonController(this));
		setBackgroundResource(R.drawable.black_button_background);
		setText("Close");
	}
	public CloseStageSelectorButton(Context context) {
		super(context);
		setController(new CloseStageSelectorButtonController(this));
		setBackgroundResource(R.drawable.black_button_background);
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

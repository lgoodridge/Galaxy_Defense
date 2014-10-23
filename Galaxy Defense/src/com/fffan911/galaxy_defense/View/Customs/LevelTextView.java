package com.fffan911.galaxy_defense.View.Customs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.LevelTextViewController;

public class LevelTextView extends TextView {
	//Reference
	private Controller controller;
	//Constants
	private static final String TAG = "LevelTextView";
	
	//Construcutor
	public LevelTextView(Context context, AttributeSet attrs){
		super(context, attrs);
		setController(new LevelTextViewController(this));
		setText("Level 1-1: Mars");
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

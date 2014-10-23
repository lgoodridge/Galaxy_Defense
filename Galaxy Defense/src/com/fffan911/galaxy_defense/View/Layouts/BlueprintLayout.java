package com.fffan911.galaxy_defense.View.Layouts;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.BlueprintLayoutController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class BlueprintLayout extends LinearLayout {
	//References
	private Controller controller;
	//Constants
	private static final String TAG = "BlueprintLayout";
	
	//Constructor
	public BlueprintLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new BlueprintLayoutController(this));
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

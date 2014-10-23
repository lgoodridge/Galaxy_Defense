package com.fffan911.galaxy_defense.View.Layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.AsteroidsFragmentLayoutController;

public class AsteroidsFragmentLayout extends LinearLayout{
	//References
	private Controller controller;
	//Constants
	private final static String TAG = "AsteroidsFragmentLayout";
	
	//Constructor
	public AsteroidsFragmentLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new AsteroidsFragmentLayoutController(this));
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

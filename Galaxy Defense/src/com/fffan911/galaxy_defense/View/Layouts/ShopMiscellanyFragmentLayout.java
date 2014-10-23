package com.fffan911.galaxy_defense.View.Layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.ShopMiscellanyFragmentLayoutController;

public class ShopMiscellanyFragmentLayout extends LinearLayout {
	//Controller
	private Controller controller;
	//Constants
	private final static String TAG = "ShopMiscellanyFragmentLayout";
	
	//Constructor
	public ShopMiscellanyFragmentLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new ShopMiscellanyFragmentLayoutController(this));
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

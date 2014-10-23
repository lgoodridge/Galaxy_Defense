package com.fffan911.galaxy_defense.View.Layouts;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.BuyPopupLayoutController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class BuyPopupLayout extends LinearLayout {
	//References
	private Controller controller;
	//Constants
	private static final String TAG = "BuyPopupLayout";
	
	//Constructor
	public BuyPopupLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new BuyPopupLayoutController(this));
	}
	
	//Touch Methods
	public boolean onTouchEvent(MotionEvent me) {
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private void setController(Controller controller) {
		this.controller = controller;
	}
}

package com.fffan911.galaxy_defense.View.Layouts;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.NotEnoughMoneyPopupLayoutController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class NotEnoughMoneyPopupLayout extends LinearLayout {
	//References
	private Controller controller;
	//Constants
	private static final String TAG = "NotEnoughMoneyPopupLayout";
	
	//Constructor
	public NotEnoughMoneyPopupLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new NotEnoughMoneyPopupLayoutController(this));
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private void setController(Controller controller) {
		this.controller = controller;
	}
}

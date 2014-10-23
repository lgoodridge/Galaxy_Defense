package com.fffan911.galaxy_defense.View.Layouts;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.BuyWeaponPopupLayoutController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class BuyWeaponPopupLayout extends LinearLayout {
	//References
	private Controller controller;
	//Constants
	private static final String TAG = "BuyWeaponPopupLayout";
	
	//Constructor
	public BuyWeaponPopupLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new BuyWeaponPopupLayoutController(this));
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

package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.ShopButtonController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class ShopButton extends Button {
	//References
	private Controller controller;
	//Constants
	private final static String TAG = "ShopButton";
	
	//Constructor
	public ShopButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new ShopButtonController(this));
		setBackgroundResource(R.drawable.yellow_button_background);
		setText("SHOP");
	}
	public ShopButton(Context context) {
		super(context);
		setController(new ShopButtonController(this));
		setBackgroundResource(R.drawable.yellow_button_background);
		setText("SHOP");
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

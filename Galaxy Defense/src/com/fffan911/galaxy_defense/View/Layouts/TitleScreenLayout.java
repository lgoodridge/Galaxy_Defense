package com.fffan911.galaxy_defense.View.Layouts;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.TitleScreenLayoutController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class TitleScreenLayout extends RelativeLayout {
	//Attributes and References
	private Controller controller;
	//Constants
	private final static String TAG = "TitleScreenLayout";
	
	//Constructor
	public TitleScreenLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new TitleScreenLayoutController(this));
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

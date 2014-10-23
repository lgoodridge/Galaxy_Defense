package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TitleScreenLayoutController extends Controller {
	//Constants
	private final static String TAG = "TitleScreenLayoutController";
	
	//Constructor
	public TitleScreenLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED!");
			Activity titleScreenActivity = (Activity)(getView().getContext());
			Intent mainMenuIntent = new Intent("com.fffan911.galaxy_defense.MAIN_MENU_ACTIVITY");
			titleScreenActivity.startActivity(mainMenuIntent);
			titleScreenActivity.finish();
		}
		return true;
	}
}

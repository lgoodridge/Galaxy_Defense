package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;

public class BlueprintButtonController extends Controller {
	//Constants
	private final static String TAG = "BlueprintButtonController";
	
	//Constructor
	public BlueprintButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			GenericProxyUser gpu = (GenericProxyUser)(getView().getContext());
			gpu.getProxy().switchToBlueprint();
		}
		return true;
	}
}

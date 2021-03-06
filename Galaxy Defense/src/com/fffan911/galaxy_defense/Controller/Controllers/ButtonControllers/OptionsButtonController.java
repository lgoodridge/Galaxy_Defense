package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericUIProxy;

public class OptionsButtonController extends Controller{
	//Constants
	private final static String TAG = "OptionsButtonController";
	
	//Constructor
	public OptionsButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			GenericProxyUser genericProxyUser = (GenericProxyUser)(getView().getContext());
			GenericUIProxy genericUIProxy = genericProxyUser.getUIProxy();
			genericUIProxy.displayOptionsPopup();
		}
		return true;
	}
}

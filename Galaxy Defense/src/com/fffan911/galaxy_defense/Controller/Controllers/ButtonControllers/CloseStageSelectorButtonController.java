package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericUIProxy;

public class CloseStageSelectorButtonController extends Controller {
	//Constants
	private static final String TAG = "CloseStageSelectorButtonController";
	
	//Constructor
	public CloseStageSelectorButtonController(View view) {
		super(view);
	}
	
	//Controller Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			GenericProxyUser genericProxyUser = (GenericProxyUser)(getView().getContext());
			GenericUIProxy genericUIProxy = genericProxyUser.getUIProxy();
			genericUIProxy.closeStageSelectorPopup();
		}
		return true;
	}
}

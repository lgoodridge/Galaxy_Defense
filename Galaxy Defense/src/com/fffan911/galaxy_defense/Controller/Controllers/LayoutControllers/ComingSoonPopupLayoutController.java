package com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuUIProxy;

public class ComingSoonPopupLayoutController extends Controller{
	//Constants
	private final static String TAG = "ComingSoonPopupLayoutController";
	
	//Constructor
	public ComingSoonPopupLayoutController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			MainMenuProxyUser mainMenuProxyUser = (MainMenuProxyUser)(getView().getContext());
			MainMenuUIProxy mainMenuUIProxy = mainMenuProxyUser.getUIProxy();
			mainMenuUIProxy.closeComingSoonPopup();
		}
		return true;
	}
}

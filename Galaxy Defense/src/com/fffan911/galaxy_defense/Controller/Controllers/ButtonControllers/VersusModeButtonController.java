package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuUIProxy;

public class VersusModeButtonController extends Controller {
	//Constants
	private final static String TAG = "VersusModeButtonController";
	
	//Constructor
	public VersusModeButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			int rightEdge = (int) (me.getRawX() - me.getX() + getView().getWidth());
			int topEdge = (int) (me.getRawY() - me.getY());
			MainMenuProxyUser mainMenuProxyUser = (MainMenuProxyUser)(getView().getContext());
			MainMenuUIProxy mainMenuUIProxy = mainMenuProxyUser.getUIProxy();
			mainMenuUIProxy.displayComingSoonPopup(rightEdge + 50, topEdge);
		}
		return true;
	}
}

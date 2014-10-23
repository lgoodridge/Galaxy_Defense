package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuUIProxy;

public class ShopButtonController extends Controller {
	//Constants
	private final static String TAG = "ShopButtonController";
	
	//Constructor
	public ShopButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			GenericProxyUser gpu = (GenericProxyUser)(getView().getContext());
			gpu.getProxy().switchToShop();
		}
		return true;
	}
}

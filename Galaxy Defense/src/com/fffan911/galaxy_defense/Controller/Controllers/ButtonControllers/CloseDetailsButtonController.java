package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopUIProxy;

public class CloseDetailsButtonController extends Controller {
	//Constants
	private static final String TAG = "CloseDetailsButtonController";
	
	//Constructor
	public CloseDetailsButtonController(View view) {
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d(TAG, "TOUCHED");
			ShopProxyUser shopProxyUser = (ShopProxyUser)(getView().getContext());
			ShopUIProxy shopUIProxy = shopProxyUser.getUIProxy();
			shopUIProxy.closeDetailsPopup();
		}
		return true;
	}
}

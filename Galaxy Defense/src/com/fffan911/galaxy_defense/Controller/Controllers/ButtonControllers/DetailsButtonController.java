package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopUIProxy;
import com.fffan911.galaxy_defense.View.Buttons.DetailsButton;

public class DetailsButtonController extends Controller {
	//Constants
	private static final String TAG = "DetailsButtonController";
	
	//Constructor
	public DetailsButtonController(View view) {
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d(TAG, "TOUCHED");
			DetailsButton detailsButton = (DetailsButton)(getView());
			ShopProxyUser shopProxyUser = (ShopProxyUser)(getView().getContext());
			ShopUIProxy shopUIProxy = shopProxyUser.getUIProxy();
			shopUIProxy.displayDetailsPopup(detailsButton.getDetailsText());
		}
		return true;
	}
}

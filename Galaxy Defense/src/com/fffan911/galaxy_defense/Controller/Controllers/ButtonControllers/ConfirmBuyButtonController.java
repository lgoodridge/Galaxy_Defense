package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopUIProxy;
import com.fffan911.galaxy_defense.Model.Miscellany.Vendor;
import com.fffan911.galaxy_defense.View.Buttons.ConfirmBuyButton;

public class ConfirmBuyButtonController extends Controller {
	//Constants
	private final static String TAG = "ConfirmBuyButtonController";
	
	//Constructor
	public ConfirmBuyButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			ShopProxyUser shopProxyUser = (ShopProxyUser)(getView().getContext());
			ShopUIProxy shopUIProxy = shopProxyUser.getUIProxy();
			ConfirmBuyButton confirmBuyButton = (ConfirmBuyButton)(getView());
			confirmBuyButton.getStoredPurchasable().purchase(shopUIProxy);
			Vendor.getInstance().refreshPurchasables();
			shopProxyUser.refreshCurrentTab();
		}
		return true;
	}
}

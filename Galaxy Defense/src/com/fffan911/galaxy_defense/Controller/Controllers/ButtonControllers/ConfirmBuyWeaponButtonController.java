package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopUIProxy;
import com.fffan911.galaxy_defense.Model.Miscellany.Vendor;
import com.fffan911.galaxy_defense.View.Buttons.ConfirmBuyButton;
import com.fffan911.galaxy_defense.View.Buttons.ConfirmBuyWeaponButton;

public class ConfirmBuyWeaponButtonController extends Controller {
	//Constants
	private final static String TAG = "ConfirmBuyWeaponButtonController";
	
	//Constructor
	public ConfirmBuyWeaponButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN){
			Log.d(TAG, "TOUCHED");
			ShopProxyUser shopProxyUser = (ShopProxyUser)(getView().getContext());
			ShopUIProxy shopUIProxy = shopProxyUser.getUIProxy();
			ConfirmBuyWeaponButton confirmBuyWeaponButton = (ConfirmBuyWeaponButton)(getView());
			confirmBuyWeaponButton.getStoredPurchasable().setWeaponSlot(getWeaponSlot());
			confirmBuyWeaponButton.getStoredPurchasable().purchase(shopUIProxy);
			shopUIProxy.closeBuyWeaponPopup();
			Vendor.getInstance().refreshPurchasables();
			shopProxyUser.refreshCurrentTab();
		}
		return true;
	}
	
	//Support Methods
	private int getWeaponSlot() {
		View rootView = getView().getRootView();
		RadioButton slotOneRB = (RadioButton)(rootView.findViewById(R.id.weapon_slot_one_radio_button));
		if (slotOneRB.isChecked()) return 1;
		RadioButton slotTwoRB = (RadioButton)(rootView.findViewById(R.id.weapon_slot_two_radio_button));
		if (slotTwoRB.isChecked()) return 2;
		RadioButton slotThreeRB = (RadioButton)(rootView.findViewById(R.id.weapon_slot_three_radio_button));
		if (slotThreeRB.isChecked()) return 3;
		RadioButton slotFourRB = (RadioButton)(rootView.findViewById(R.id.weapon_slot_four_radio_button));
		if (slotFourRB.isChecked()) return 4;
		RadioButton slotFiveRB = (RadioButton)(rootView.findViewById(R.id.weapon_slot_five_radio_button));
		if (slotFiveRB.isChecked()) return 5;
		RadioButton slotSixRB = (RadioButton)(rootView.findViewById(R.id.weapon_slot_six_radio_button));
		if (slotSixRB.isChecked()) return 6;
		Log.e(TAG, "ERROR: NO RADIO BUTTON SELECTED");
		return -1;
	}
}

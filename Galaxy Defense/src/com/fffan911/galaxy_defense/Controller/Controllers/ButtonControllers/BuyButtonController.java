package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopUIProxy;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.View.Buttons.BuyButton;

public class BuyButtonController extends Controller {
	//Constants
	private static final String TAG = "BuyButtonController";
	
	//Constructor
	public BuyButtonController(View view) {
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d(TAG, "TOUCHED");
			BuyButton buyButton = (BuyButton)(getView());
			ShopProxyUser shopProxyUser = (ShopProxyUser)(getView().getContext());
			ShopUIProxy shopUIProxy = shopProxyUser.getUIProxy();
			if (buyButton.hasWeaponPurchasableStored()) shopUIProxy.displayBuyWeaponPopup(buyButton.getStoredPurchasable(), getBuyText());
			else shopUIProxy.displayBuyPopup(buyButton.getStoredPurchasable(), getBuyText());
		}
		return true;
	}
	
	//String Methods
	public String getBuyText() {
		String buyText = "";
		BuyButton buyButton = (BuyButton)(getView());
		Purchasable purchasable = buyButton.getStoredPurchasable();
		int cost = buyButton.getStoredPurchasable().getCost();
		int etheriumCost = buyButton.getStoredPurchasable().getEtheriumCost();
		
		buyText = buyText + purchasable.getName() + "\n\nCurrent Funds: $" + PlayerData.getInstance().getMoney() + 
		"\nCurrent Etherium: " + PlayerData.getInstance().getEtherium() + " E\n\n";
		
		if (cost == 0 && etheriumCost == 0) {
			buyText += "FREE!";
		} else if (etheriumCost == 0) {
			buyText = buyText + "Cost: $" + purchasable.getCost() + "\n\nFunds after Purchase: " + 
			fundsString((PlayerData.getInstance().getMoney() - purchasable.getCost()));
		} else if (cost == 0) {
			buyText = buyText + "Etherium Cost: " + purchasable.getEtheriumCost() + " E\n\nEtherium after Purchase: " +
			etheriumString((PlayerData.getInstance().getEtherium() - purchasable.getEtheriumCost()));
		} else {
			buyText = buyText + "Cost: $" + purchasable.getCost() + "\nEtherium Cost: " + purchasable.getEtheriumCost() +
			" E\n\nFunds after Purchase: " + fundsString((PlayerData.getInstance().getMoney() - purchasable.getCost())) +  
			"\nEtherium after Purchase: " + etheriumString((PlayerData.getInstance().getEtherium() - purchasable.getEtheriumCost()));
		}
		return buyText;
	}
	public String fundsString(int amount) {
		if (amount < 0) return "Not Enough Funds";
		else return "$" + amount;
	}
	public String etheriumString(int amount) {
		if (amount < 0) return "Not Enough Etherium";
		else return amount + " E";
	}
}

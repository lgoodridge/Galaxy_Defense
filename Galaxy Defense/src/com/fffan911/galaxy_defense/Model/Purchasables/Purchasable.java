package com.fffan911.galaxy_defense.Model.Purchasables;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopUIProxy;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;

public abstract class Purchasable {
	//Attributes
	private boolean alreadyPurchased;
	protected int weaponSlot;
	
	//Constructor
	public Purchasable() {
		alreadyPurchased = false;
	}
	
	//Purchasble Methods
	public void purchase(ShopUIProxy shopUIProxy) {
		if (alreadyPurchased()) {
			shopUIProxy.displayAlreadyPurchasedPopup();
		} else if (PlayerData.getInstance().getMoney() < getCost() || 
		PlayerData.getInstance().getEtherium() < getEtheriumCost()) {
			shopUIProxy.displayNotEnoughMoneyPopup();
		} else {
			PlayerData.getInstance().remMoney(getCost());
			PlayerData.getInstance().remEtherium(getEtheriumCost());
			activatePurchase();
			if (!isRebuyable()) alreadyPurchased = true;
			shopUIProxy.closeBuyPopup();
		}
	}
	
	//Boolean Methods
	public boolean isUnlocked() {
		return PlayerData.getInstance().getTier() >= getTier();
	}
	public boolean isRebuyable() {
		return (getType() == PurchasableType.COMPOSITE_REPLACEMENT) ||
		(getType() == PurchasableType.WEAPON_REPLACEMENT);
	}
	public boolean alreadyPurchased() {
		return alreadyPurchased;
	}
	
	//Set Methods
	public void setWeaponSlot(int newWeaponSlot) {
		weaponSlot = newWeaponSlot;
	}
	
	//Get Methods
	public int getButtonBackgroundID() {
		switch (getType()) {
			case COMPOSITE_REPLACEMENT: 
				return R.drawable.yellow_button_background;
			case COMPOSITE_UPGRADE:
				return R.drawable.blue_button_background;
			case WEAPON_REPLACEMENT:
				return R.drawable.yellow_button_background;
			case WEAPON_UPGRADE:
				return R.drawable.blue_button_background;
			case WEAPON_EVOLUTION:
				return R.drawable.red_button_background;
			case ACCESSORY:
				return R.drawable.purple_button_background;
			case KEY_ITEM:
				return R.drawable.green_button_background;
			default:
				return -1;
		}
	}
	public String getCostString() {
		if (getCost() == 0 && getEtheriumCost() == 0) {
			return "FREE!";
		} else if (getEtheriumCost() == 0) {
			return "$" + getCost();
		} else if (getCost() == 0) {
			return "" + getEtheriumCost() + " E";
		} else {
			return "$" + getCost() + " + " + getEtheriumCost() + " E";
		}
	}
	
	//Abstract Methods
	public abstract void activatePurchase();
	public abstract PurchasableType getType();
	public abstract int getTier();
	public abstract int getCost();
	public abstract int getEtheriumCost();
	public abstract String getName();
	public abstract String getDetails();
}

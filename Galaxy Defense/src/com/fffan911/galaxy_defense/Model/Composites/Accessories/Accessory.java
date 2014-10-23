package com.fffan911.galaxy_defense.Model.Composites.Accessories;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

public abstract class Accessory extends Composite {
	//Constants
	private static final String TAG = "Accessory";
	
	//Composite Defaults
	@Override
	public int getMaxHealthAddition() {
		return 0;
	}
	@Override
	public int getMaxArmorAddition() {
		return 0;
	}
	@Override
	public int getMaxShieldsAddition() {
		return 0;
	}
	@Override
	public int getShieldDelayAddition() {
		return 0;
	}
	@Override
	public int getShieldRechargeRateAddition() {
		return 0;
	}
	@Override
	public float getMaxHealthMultiplier() {
		return 1.0f;
	}
	@Override
	public float getMaxArmorMultiplier() {
		return 1.0f;
	}
	@Override
	public float getMaxShieldsMultiplier() {
		return 1.0f;
	}
	@Override
	public float getShieldDelayMultiplier() {
		return 1.0f;
	}
	@Override
	public float getShieldRechargeRateMultiplier() {
		return 1.0f;
	}
	@Override
	public float getMaxSpeedAddition() {
		return 0;
	}
	@Override
	public float getMaxSpeedMultiplier() {
		return 1.0f;
	}
	@Override
	public int getWeaponDamageAddition() {
		return 0;
	}
	@Override
	public int getWeaponReloadTimeReduction() {
		return 0;
	}
	@Override
	public float getWeaponSpeedAddition() {
		return 0.0f;
	}
	@Override
	public float getWeaponAccelerationAddition() {
		return 0.0f;
	}
	@Override
	public float getWeaponDamageMultiplier() {
		return 1.0f;
	}
	@Override
	public float getWeaponReloadTimeMultiplier() {
		return 1.0f;
	}
	@Override
	public float getWeaponSpeedMultiplier() {
		return 1.0f;
	}
	@Override
	public float getWeaponAccelerationMultiplier() {
		return 1.0f;
	}
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		ArrayList<Purchasable> purchasableUpgrades = new ArrayList<Purchasable>();
		return purchasableUpgrades;
	}
	@Override
	public String getUpgradeFlowChart() {
		return "[NO UPGRADES AVAILABLE]";
	}
	@Override
	public String getDetails() {
		return getName() + "\n\n" + getSummary() + "\n\nSpecial Effects:\n"
		+ getSpecialEffectsDescription();
	}
	
	//Boolean Methods
	public boolean namesMatch(String otherAccessoryName) {
		return getName().equals(otherAccessoryName);
	}
	
	//Abstract Methods
	public abstract String getAccessoryListName();
	public abstract String getAccessoryListDescription();
}

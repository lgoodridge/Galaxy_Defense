package com.fffan911.galaxy_defense.Model.Composites.Parts;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

public class VoidCore extends Core {
	//Constants
	private static final String TAG = "VoidCore";
	
	//Get Methods
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
		return 0;
	}
	@Override
	public float getWeaponAccelerationAddition() {
		return 0;
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
	public int getTier() {
		return 0;
	}
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		ArrayList<Purchasable> purchasableUpgrades = new ArrayList<Purchasable>();
		return purchasableUpgrades;
	}
	@Override
	public Composite getBaseComposite() {
		return this;
	}
	@Override
	public String getName() {
		return "Void Core";
	}
	@Override
	public String getSummary() {
		return "A ship core that does nothing.";
	}
	@Override
	public String getSpecialEffectsDescription() {
		return "No Special Effects";
	}
	@Override
	public String getUpgradeFlowChart() {
		return "Void";
	}
}

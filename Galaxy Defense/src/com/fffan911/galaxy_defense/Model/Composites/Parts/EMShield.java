package com.fffan911.galaxy_defense.Model.Composites.Parts;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

public class EMShield extends Shield {
	//Constants
	private static final String TAG = "EMShield";
	
	//Get Methods
	@Override
	public int getMaxShieldsAddition() {
		return 100;
	}
	@Override
	public int getShieldDelayAddition() {
		return 5000;
	}
	@Override
	public int getShieldRechargeRateAddition() {
		return 50;
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
	public int getTier() {
		return 1;
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
		return "EM Shield";
	}
	@Override
	public String getSummary() {
		return "An electro-magnetic shield mainly used to deflect small space debris. " +
		"Fairly common."; 
	}
	@Override
	public String getSpecialEffectsDescription() {
		return "No Special Effects";
	}
	@Override
	public String getUpgradeFlowChart() {
		return "Base";
	}
}

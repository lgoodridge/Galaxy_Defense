package com.fffan911.galaxy_defense.Model.Composites.Parts;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

public class CarbonBody extends Body {
	
	//Get Methods
	@Override
	public int getMaxHealthAddition() {
		return 150;
	}
	@Override
	public float getMaxHealthMultiplier() {
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
		return "Carbon Body";
	}
	@Override
	public String getSummary() {
		return "An inner shell made from carbon fibers. Standard issue for " +
		"contemporary ships. ";
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

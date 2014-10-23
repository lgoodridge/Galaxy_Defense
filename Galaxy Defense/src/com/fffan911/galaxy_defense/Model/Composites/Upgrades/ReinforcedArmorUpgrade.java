package com.fffan911.galaxy_defense.Model.Composites.Upgrades;

import com.fffan911.galaxy_defense.Model.Composites.Composite;

public class ReinforcedArmorUpgrade extends CompositeUpgrade {
	//Constants
	private static final String TAG = "ReinforcedArmorUpgrade";
	
	//Constructor
	public ReinforcedArmorUpgrade(Composite innerComposite) {
		super(innerComposite);
	}
	public ReinforcedArmorUpgrade() {
		super();
	}
	
	//Upgrade Methods
	@Override
	public float getMaxArmorMultiplier() {
		return super.getMaxArmorMultiplier() * 1.2f;
	}
	@Override
	public float getMaxSpeedAddition() {
		return super.getMaxSpeedAddition() - 20;
	}
	@Override
	public String getUpgradeName() {
		return "Reinforced Armor";
	}
	@Override
	public String getUpgradeFlowChartName() {
		return "Reinforced";
	}
	@Override
	public String getUpgradeSummary() {
		return "Reinforce the armor with additional layers. Increases " +
		"defense provided by the armor, at the cost of a small speed reduction.";
	}
	@Override
	public String getUpgradeEffectsDescription() {
		return "Armor Multiplier: x1.2\nShip Speed: -20";
	}
}

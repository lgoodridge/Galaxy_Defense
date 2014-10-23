package com.fffan911.galaxy_defense.Model.Composites.Accessories;

import com.fffan911.galaxy_defense.Model.Composites.Composite;

public class FlashCCUAccessory extends Accessory {
	//Constants
	private static final String TAG = "FlashCCUAccessory";
	
	//Stat Modifiers
	@Override
	public float getMaxSpeedMultiplier() {
		return 1.15f;
	}
	@Override
	public float getMaxShieldsMultiplier() {
		return 1.1f;
	}
	
	//Other Information
	@Override
	public int getTier() {
		return 1;
	}
	@Override
	public Composite getBaseComposite() {
		return this;
	}
	@Override
	public String getName() {
		return "Flash CCU";
	}
	@Override
	public String getSummary() {
		return "Flash the Core Control Unit, enabling the core to divert more power " +
		"to the ships engines and shields.";
	}
	@Override
	public String getSpecialEffectsDescription() {
		return "Ship Speed: x1.15\nShields: x1.1";
	}
	@Override
	public String getAccessoryListName() {
		return "Flash the CCU";
	}
	@Override
	public String getAccessoryListDescription() {
		return "Small increase to speed and shield strength";
	}
}

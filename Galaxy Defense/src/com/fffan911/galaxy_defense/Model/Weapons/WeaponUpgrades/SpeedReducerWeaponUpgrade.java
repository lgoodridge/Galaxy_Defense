package com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades;

import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;

public class SpeedReducerWeaponUpgrade extends WeaponUpgrade {
	//Constants
	private static final String TAG = "SpeedReducerWeaponUpgrade";
	
	//Constructor
	public SpeedReducerWeaponUpgrade(Weapon innerWeapon, Ship ownerShip) {
		super(innerWeapon, ownerShip);
	}
	public SpeedReducerWeaponUpgrade(Weapon innerWeapon) {
		super(innerWeapon);
	}
	public SpeedReducerWeaponUpgrade() {
		super();
	}
	
	//Upgrade Methods
	@Override
	public float getBaseSpeedMultiplier() {
		return super.getBaseSpeedMultiplier() * 0.5f;
	}
	
	//Information Methods
	@Override
	public String getUpgradeName() {
		return "Speed Reducer";
	}
	@Override
	public String getUpgradeFlowChartName() {
		return "Speed Reduced";
	}
	@Override
	public String getUpgradeSummary() {
		return "Reduces the weapon's speed";
	}
	@Override
	public String getUpgradeEffectsDescription() {
		return "Speed: x0.5";
	}
}

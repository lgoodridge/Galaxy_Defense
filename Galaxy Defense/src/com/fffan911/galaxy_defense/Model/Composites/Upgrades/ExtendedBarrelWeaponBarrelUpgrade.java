package com.fffan911.galaxy_defense.Model.Composites.Upgrades;

import android.util.Log;

import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;

public class ExtendedBarrelWeaponBarrelUpgrade extends WeaponBarrelUpgrade {
	//Constants
	private static final String TAG = "ExtendedBarrelWeaponBarrelUpgrade";
	
	//Constructor
	public ExtendedBarrelWeaponBarrelUpgrade(WeaponBarrel innerWeaponBarrel) {
		super(innerWeaponBarrel);
	}
	
	//Upgrade Methods
	@Override
	public int getWeaponDamageAddition() {
		return super.getWeaponDamageAddition() + 100;
	}
	@Override
	public float getWeaponSpeedMultiplier() {
		return super.getWeaponSpeedMultiplier() * 1.2f;
	}
	@Override
	public String getUpgradeName() {
		return "Extended Barrel";
	}
	@Override
	public String getUpgradeFlowChartName() {
		return "Extended Barrel";
	}
	@Override
	public String getUpgradeSummary() {
		return "Extends the weapon barrel, giving the weapon a higher launch velocity " +
		"and a small increase to impact damage";
	}
	@Override
	public String getUpgradeEffectsDescription() {
		return "Weapon Damage +100\nWeapon Speed x1.2";
	}
}

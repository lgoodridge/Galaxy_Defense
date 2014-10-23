package com.fffan911.galaxy_defense.Model.Composites.Parts;

import com.fffan911.galaxy_defense.Model.Composites.Composite;

public abstract class Shield extends Composite {
	//Constants
	private static final String TAG = "Shield";
	
	//Non-Standard Composite Defaults
	@Override
	public int getMaxHealthAddition() {
		return 0;
	}
	@Override
	public int getMaxArmorAddition() {
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
}

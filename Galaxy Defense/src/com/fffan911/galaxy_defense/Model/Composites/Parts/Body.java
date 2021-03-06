package com.fffan911.galaxy_defense.Model.Composites.Parts;

import com.fffan911.galaxy_defense.Model.Composites.Composite;

public abstract class Body extends Composite {
	//Constants
	private static final String TAG = "Body";
	
	//Non-Standard Composite Defaults
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

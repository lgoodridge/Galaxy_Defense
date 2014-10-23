package com.fffan911.galaxy_defense.Model.Composites.Parts;

import com.fffan911.galaxy_defense.Model.Composites.Composite;

public abstract class WeaponBarrel extends Composite {
	//References
	private BarrelType barrelType;
	//Attributes
	private int reloadTime;
	//Constants
	private static final String TAG = "WeaponBarrel";
	
	//Constructor
	public WeaponBarrel(BarrelType barrelType) {
		this.barrelType = barrelType;
		this.reloadTime = 0;
	}
	
	//Reload Time Handling Methods
	public void addReloadTime(int addTime) {
		reloadTime += addTime;
	}
	public void remReloadTime(int remTime) {
		reloadTime -= remTime;
		if (reloadTime < 0) reloadTime = 0;
	}
	public void clearReloadTime() {
		reloadTime = 0;
	}
	
	//Boolean Methods
	public boolean barrelTypeMatches(BarrelType barrelType) {
		return this.barrelType == barrelType;
	}
	public boolean isReadyToFire() {
		return reloadTime == 0;
	}
	
	//Set Methods
	public void setReloadTime(int newReloadTime) {
		reloadTime = newReloadTime;
	}
	
	//Get Methods
	public BarrelType getBarrelType() {
		return barrelType;
	}
	public int getReloadTime() {
		return reloadTime;
	}
	
	//Non-Standard Composite Defaults
	public int getMaxHealthAddition() {
		return 0;
	}
	public int getMaxArmorAddition() {
		return 0;
	}
	public int getMaxShieldsAddition() {
		return 0;
	}
	public int getShieldDelayAddition() {
		return 0;
	}
	public int getShieldRechargeRateAddition() {
		return 0;
	}
	public float getMaxHealthMultiplier() {
		return 1.0f;
	}
	public float getMaxArmorMultiplier() {
		return 1.0f;
	}
	public float getMaxShieldsMultiplier() {
		return 1.0f;
	}
	public float getShieldDelayMultiplier() {
		return 1.0f;
	}
	public float getShieldRechargeRateMultiplier() {
		return 1.0f;
	}
}

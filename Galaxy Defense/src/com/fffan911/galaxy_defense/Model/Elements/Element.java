package com.fffan911.galaxy_defense.Model.Elements;

import com.fffan911.galaxy_defense.Model.Actors.Ship;

public abstract class Element {
	//Attributes
	private int level;
	private long timeRemaining;
	private boolean isTimeless;
	
	//Constructor
	public Element(int level) {
		this.level = level;
		this.timeRemaining = detActiveTime();
		this.isTimeless = detIsTimeless();
	}
	public Element() {
		this(1);
	}
	
	//Action Methods
	public void update(long updateTimeDiff, Ship ship) {
		activateEffect(updateTimeDiff, ship);
		remTimeRemaining(updateTimeDiff);
		if (hasTimeRunOut()) ship.remElement(this);
	}
	
	//Boolean Methods
	public boolean hasTimeRunOut() {
		if (isTimeless) return false;
		return timeRemaining == 0l;
	}
	public boolean isTimeless() {
		return isTimeless;
	}
	
	//Add + Remove Methods
	public void addTimeRemaining(long amount) {
		if (isTimeless) return;
		timeRemaining += amount;
	}
	public void remTimeRemaining(long amount) {
		if (isTimeless) return;
		timeRemaining -= amount;
		if (timeRemaining < 0l) timeRemaining = 0l;
	}
	
	//Set Methods
	public void setLevel(int newLevel) {
		level = newLevel;
	}
	public void setTimeRemaining(long newTimeRemaining) {
		timeRemaining = newTimeRemaining;
	}
	public void setIsTimeless(boolean newBool) {
		isTimeless = newBool;
	}
	
	//Get Methods
	public int getLevel() {
		return level;
	}
	public long getTimeRemaining() {
		return timeRemaining;
	}
	public long getTimeActive() {
		return detActiveTime() - timeRemaining;
	}
	public String getDetails() {
		return getName() + "\n\nEffect: " + getSummary() + "\n\n" + getLevelEffectChart();
	}
	
	//Stat Modifier Methods
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
	public float getMaxSpeedAddition() {
		return 0.0f;
	}
	public float getMaxSpeedMultiplier() {
		return 1.0f;
	}
	public int getWeaponDamageAddition() {
		return 0;
	}
	public int getWeaponReloadTimeReduction() {
		return 0;
	}
	public float getWeaponSpeedAddition() {
		return 0.0f;
	}
	public float getWeaponAccelerationAddition() {
		return 0.0f;
	}
	public float getWeaponDamageMultiplier() {
		return 1.0f;
	}
	public float getWeaponReloadTimeMultiplier() {
		return 1.0f;
	}
	public float getWeaponSpeedMultiplier() {
		return 1.0f;
	}
	public float getWeaponAccelerationMultiplier() {
		return 1.0f;
	}
	
	//Abstract Methods
	protected abstract void activateEffect(long updateTimeDiff, Ship ship);
	public abstract void elementAlreadyActiveEffect(Ship ship, Element activeElement);
	protected abstract long detActiveTime();
	protected abstract boolean detIsTimeless();
	public abstract String getName();
	public abstract String getSummary();
	public abstract String getLevelEffectChart();
}

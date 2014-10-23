package com.fffan911.galaxy_defense.Model.Weapons;

import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;

public abstract class SpecialWeapon extends Weapon {
	
	//Constructor
	public SpecialWeapon(Ship ship) {
		super(ship);
	}
	public SpecialWeapon() {
		super();
	}
	
	//Standardized Weapon Methods
	@Override
	public BarrelType getRequiredBarrelType() {
		return BarrelType.VOID;
	}
	@Override
	public int getBaseReloadTime() {
		return 0;
	}
	@Override
	public float getBaseReloadTimeMultiplier() {
		return 1.0f;
	}
	@Override
	public int getButtonIconID() {
		return -1;
	}
	
	//Abstract Methods
	public abstract void launchSpecialAttack(Ship ship);
}

package com.fffan911.galaxy_defense.Model.Weapons.WeaponEvolutions;

import java.util.List;

import android.graphics.Bitmap;

import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades.WeaponUpgrade;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public abstract class WeaponEvolution extends WeaponUpgrade {
	
	//Constructor
	public WeaponEvolution(Weapon innerWeapon, Ship innerShip) {
		super(innerWeapon, innerShip);
		purchasableUpgrades = null;
	}
	public WeaponEvolution(Weapon innerWeapon) {
		super(innerWeapon);
		purchasableUpgrades = null;
	}
	public WeaponEvolution() {
		super();
		purchasableUpgrades = null;
	}
	
	//Upgrade Methods
	public String getUpgradeName() {
		return getName();
	}
	
	//Redefined Methods
	public List<Purchasable> getPurchasableUpgrades() {
		if (purchasableUpgrades == null) {
			purchasableUpgrades = constructPurchasableUpgrades();
		} 
		return purchasableUpgrades;
	}
	
	//Abstract Methods
	public abstract List<Purchasable> constructPurchasableUpgrades();
	public abstract List<Purchasable> getPurchasableEvolutions();
	public abstract Bitmap[] getAnimationBitmaps(GamePanel panel);
	public abstract int getAnimationFramePeriod();
	public abstract int getButtonIconID();
	public abstract Weapon getBaseWeapon();
	public abstract String getName();
	public abstract String getSummary();
}

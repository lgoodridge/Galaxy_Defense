package com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades;

import java.util.List;

import android.graphics.Bitmap;

import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.Upgrade;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public abstract class WeaponUpgrade extends Weapon implements Upgrade {
	//References
	private Weapon innerWeapon;
	//Constants
	private static final String TAG = "WeaponUpgrade";
	
	//Constructor
	public WeaponUpgrade(Weapon innerWeapon, Ship ownerShip) {
		super(ownerShip);
		this.innerWeapon = innerWeapon;
	}
	public WeaponUpgrade(Weapon innerWeapon) {
		this(innerWeapon, null);
	}
	public WeaponUpgrade() {
		this(null, null);
	}
	
	//Construct Methods
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		return innerWeapon.constructPurchasableUpgrades();
	}
	
	//Set Methods
	public final void setInnerWeapon(Weapon weapon) {
		this.innerWeapon = weapon;
	}
	
	//Get Methods
	@Override
	public BarrelType getRequiredBarrelType() {
		return innerWeapon.getRequiredBarrelType();
	}
	@Override
	public int getBaseDamage() {
		return innerWeapon.getBaseDamage();
	}
	@Override
	public int getBaseReloadTime() {
		return innerWeapon.getBaseReloadTime();
	}
	@Override
	public float getBaseSpeed() {
		return innerWeapon.getBaseSpeed();
	}
	@Override
	public float getBaseAcceleration() {
		return innerWeapon.getBaseAcceleration();
	}
	@Override
	public float getBaseDamageMultiplier() {
		return innerWeapon.getBaseDamageMultiplier();
	}
	@Override
	public float getBaseReloadTimeMultiplier() {
		return innerWeapon.getBaseReloadTimeMultiplier();
	}
	@Override
	public float getBaseSpeedMultiplier() {
		return innerWeapon.getBaseSpeedMultiplier();
	}
	@Override
	public float getBaseAccelerationMultiplier() {
		return innerWeapon.getBaseAccelerationMultiplier();
	}
	@Override
	public int getWidth() {
		return innerWeapon.getWidth();
	}
	@Override
	public int getHeight() {
		return innerWeapon.getHeight();
	}
	@Override
	public int getTier() {
		return innerWeapon.getTier();
	}
	@Override
	public int getLevel() {
		return innerWeapon.getLevel() + 1;
	}
	@Override
	public List<Purchasable> getPurchasableUpgrades() {
		return innerWeapon.getPurchasableUpgrades();
	}
	@Override
	public List<Purchasable> getPurchasableEvolutions() {
		return innerWeapon.getPurchasableEvolutions();
	}
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		return innerWeapon.getAnimationBitmaps(panel);
	}
	@Override
	public int getAnimationFramePeriod() {
		return innerWeapon.getAnimationFramePeriod();
	}
	@Override
	public int getButtonIconID() {
		return innerWeapon.getButtonIconID();
	}
	@Override
	public Weapon getBaseWeapon() {
		return innerWeapon.getBaseWeapon();
	}
	@Override
	public String getName() {
		return innerWeapon.getName();
	}
	@Override
	public String getSummary() {
		return innerWeapon.getSummary();
	}
	@Override
	public String getSpecialEffectsDescription() {
		return innerWeapon.getSpecialEffectsDescription();
	}
	@Override
	public String getUpgradeDetails() {
		return getUpgradeName() + "\n\n" + getUpgradeSummary() + "\n\nEffects:\n" +
		getUpgradeEffectsDescription();
	}
	@Override
	public String getUpgradeFlowChart() {
		if (getUpgradeFlowChartName().equals("")) return innerWeapon.getUpgradeFlowChart();
		else return innerWeapon.getUpgradeFlowChart() + " => " + getUpgradeFlowChartName();
	}
}

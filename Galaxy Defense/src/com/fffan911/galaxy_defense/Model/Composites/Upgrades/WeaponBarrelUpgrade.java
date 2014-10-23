package com.fffan911.galaxy_defense.Model.Composites.Upgrades;

import java.util.List;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

public abstract class WeaponBarrelUpgrade extends WeaponBarrel implements Upgrade {
	//References
	private WeaponBarrel innerWeaponBarrel;
	//Constants
	private static final String TAG = "WeaponBarrelUpgrade";
	
	//Constructor
	public WeaponBarrelUpgrade(WeaponBarrel innerWeaponBarrel) {
		super(innerWeaponBarrel.getBarrelType());
		this.innerWeaponBarrel = innerWeaponBarrel;
	}
	public WeaponBarrelUpgrade() {
		this(null);
	}
	
	//Set Methods
	public final void setInnerWeaponBarrel(WeaponBarrel weaponBarrel) {
		innerWeaponBarrel = weaponBarrel;
	}
	
	//Init Methods
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		return innerWeaponBarrel.constructPurchasableUpgrades();
	}
	
	//Get Methods
	@Override
	public int getMaxHealthAddition() {
		return innerWeaponBarrel.getMaxHealthAddition();
	}
	@Override
	public int getMaxArmorAddition() {
		return innerWeaponBarrel.getMaxArmorAddition();
	}
	@Override
	public int getMaxShieldsAddition() {
		return innerWeaponBarrel.getMaxShieldsAddition();
	}
	@Override
	public int getShieldDelayAddition() {
		return innerWeaponBarrel.getShieldDelayAddition();
	}
	@Override
	public int getShieldRechargeRateAddition() {
		return innerWeaponBarrel.getShieldRechargeRateAddition();
	}
	@Override
	public float getMaxHealthMultiplier() {
		return innerWeaponBarrel.getMaxHealthMultiplier();
	}
	@Override
	public float getMaxArmorMultiplier() {
		return innerWeaponBarrel.getMaxArmorMultiplier();
	}
	@Override
	public float getMaxShieldsMultiplier() {
		return innerWeaponBarrel.getMaxShieldsMultiplier();
	}
	@Override
	public float getShieldDelayMultiplier() {
		return innerWeaponBarrel.getShieldDelayMultiplier();
	}
	@Override
	public float getShieldRechargeRateMultiplier() {
		return innerWeaponBarrel.getShieldRechargeRateMultiplier();
	}
	@Override
	public float getMaxSpeedAddition() {
		return innerWeaponBarrel.getMaxSpeedAddition();
	}
	@Override
	public float getMaxSpeedMultiplier() {
		return innerWeaponBarrel.getMaxSpeedMultiplier();
	}
	@Override
	public int getWeaponDamageAddition() {
		return innerWeaponBarrel.getWeaponDamageAddition();
	}
	@Override
	public int getWeaponReloadTimeReduction() {
		return innerWeaponBarrel.getWeaponReloadTimeReduction();
	}
	@Override
	public float getWeaponSpeedAddition() {
		return innerWeaponBarrel.getWeaponSpeedAddition();
	}
	@Override
	public float getWeaponAccelerationAddition() {
		return innerWeaponBarrel.getWeaponAccelerationAddition();
	}
	@Override
	public float getWeaponDamageMultiplier() {
		return innerWeaponBarrel.getWeaponDamageMultiplier();
	}
	@Override
	public float getWeaponReloadTimeMultiplier() {
		return innerWeaponBarrel.getWeaponReloadTimeMultiplier();
	}
	@Override
	public float getWeaponSpeedMultiplier() {
		return innerWeaponBarrel.getWeaponSpeedMultiplier();
	}
	@Override
	public float getWeaponAccelerationMultiplier() {
		return innerWeaponBarrel.getWeaponAccelerationMultiplier();
	}
	@Override
	public Composite getBaseComposite() {
		return innerWeaponBarrel.getBaseComposite();
	}
	@Override
	public int getTier() {
		return innerWeaponBarrel.getTier();
	}
	@Override
	public List<Purchasable> getPurchasableUpgrades() {
		return innerWeaponBarrel.getPurchasableUpgrades();
	}
	@Override
	public String getName() {
		return innerWeaponBarrel.getName();
	}
	@Override
	public String getSummary() {
		return innerWeaponBarrel.getSummary();
	}
	@Override
	public String getSpecialEffectsDescription() {
		return innerWeaponBarrel.getSpecialEffectsDescription();
	}
	@Override
	public String getDetails() {
		return innerWeaponBarrel.getDetails();
	}
	@Override
	public String getUpgradeDetails() {
		return getUpgradeName() + "\n\n" + getUpgradeSummary() + "\n\nEffects:\n" +
		getUpgradeEffectsDescription();
	}
	@Override
	public String getUpgradeFlowChart() {
		if (getUpgradeFlowChartName().equals("")) return innerWeaponBarrel.getUpgradeFlowChart();
		else return innerWeaponBarrel.getUpgradeFlowChart() + " => " + getUpgradeFlowChartName();
	}
}

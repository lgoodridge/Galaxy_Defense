package com.fffan911.galaxy_defense.Model.Composites.Upgrades;

import java.util.List;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

public abstract class CompositeUpgrade extends Composite implements Upgrade {
	//References
	private Composite innerComposite;
	//Constants
	private static final String TAG = "CompositeUpgrade";
	
	//Constructor
	public CompositeUpgrade(Composite innerComposite) {
		this.innerComposite = innerComposite;
	}
	public CompositeUpgrade() {
		this(null);
	}
	
	//Set Methods
	public final void setInnerComposite(Composite composite) {
		innerComposite = composite;
	}
	
	//Init Methods
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		return innerComposite.constructPurchasableUpgrades();
	}
	
	//Get Methods
	@Override
	public int getMaxHealthAddition() {
		return innerComposite.getMaxHealthAddition();
	}
	@Override
	public int getMaxArmorAddition() {
		return innerComposite.getMaxArmorAddition();
	}
	@Override
	public int getMaxShieldsAddition() {
		return innerComposite.getMaxShieldsAddition();
	}
	@Override
	public int getShieldDelayAddition() {
		return innerComposite.getShieldDelayAddition();
	}
	@Override
	public int getShieldRechargeRateAddition() {
		return innerComposite.getShieldRechargeRateAddition();
	}
	@Override
	public float getMaxHealthMultiplier() {
		return innerComposite.getMaxHealthMultiplier();
	}
	@Override
	public float getMaxArmorMultiplier() {
		return innerComposite.getMaxArmorMultiplier();
	}
	@Override
	public float getMaxShieldsMultiplier() {
		return innerComposite.getMaxShieldsMultiplier();
	}
	@Override
	public float getShieldDelayMultiplier() {
		return innerComposite.getShieldDelayMultiplier();
	}
	@Override
	public float getShieldRechargeRateMultiplier() {
		return innerComposite.getShieldRechargeRateMultiplier();
	}
	@Override
	public float getMaxSpeedAddition() {
		return innerComposite.getMaxSpeedAddition();
	}
	@Override
	public float getMaxSpeedMultiplier() {
		return innerComposite.getMaxSpeedMultiplier();
	}
	@Override
	public int getWeaponDamageAddition() {
		return innerComposite.getWeaponDamageAddition();
	}
	@Override
	public int getWeaponReloadTimeReduction() {
		return innerComposite.getWeaponReloadTimeReduction();
	}
	@Override
	public float getWeaponSpeedAddition() {
		return innerComposite.getWeaponSpeedAddition();
	}
	@Override
	public float getWeaponAccelerationAddition() {
		return innerComposite.getWeaponAccelerationAddition();
	}
	@Override
	public float getWeaponDamageMultiplier() {
		return innerComposite.getWeaponDamageMultiplier();
	}
	@Override
	public float getWeaponReloadTimeMultiplier() {
		return innerComposite.getWeaponReloadTimeMultiplier();
	}
	@Override
	public float getWeaponSpeedMultiplier() {
		return innerComposite.getWeaponSpeedMultiplier();
	}
	@Override
	public float getWeaponAccelerationMultiplier() {
		return innerComposite.getWeaponAccelerationMultiplier();
	}
	@Override
	public int getTier() {
		return innerComposite.getTier();
	}
	@Override
	public List<Purchasable> getPurchasableUpgrades() {
		return innerComposite.getPurchasableUpgrades();
	}
	@Override
	public Composite getBaseComposite() {
		return innerComposite.getBaseComposite();
	}
	@Override
	public String getName() {
		return innerComposite.getName();
	}
	@Override
	public String getSummary() {
		return innerComposite.getSummary();
	}
	@Override
	public String getSpecialEffectsDescription() {
		return innerComposite.getSpecialEffectsDescription();
	}
	@Override
	public String getDetails() {
		return getName() + "\n\n" + getSummary() + "\n\n" + Composite.getNotableStats(this) +
		"\n\nSpecial Effects: " + getSpecialEffectsDescription();
	}
	@Override
	public String getUpgradeDetails() {
		return getUpgradeName() + "\n\n" + getUpgradeSummary() + "\n\nEffects:\n" +
		getUpgradeEffectsDescription();
	}
	@Override
	public String getUpgradeFlowChart() {
		if (getUpgradeFlowChartName().equals("")) return innerComposite.getUpgradeFlowChart();
		else return innerComposite.getUpgradeFlowChart() + " => " + getUpgradeFlowChartName();
	}
}

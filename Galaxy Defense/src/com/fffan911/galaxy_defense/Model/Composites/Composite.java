package com.fffan911.galaxy_defense.Model.Composites;

import java.util.List;

import android.util.Log;

import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

public abstract class Composite {
	//References
	private List<Purchasable> purchasableUpgrades;
	//Constants
	private static String TAG = "Composite";
	
	//Static Methods
	public static String getDetailsAndUpgrades(Composite composite) {
		return composite.getDetails() + "\n\nUpgrade Chart:\n" + composite.getUpgradeFlowChart();
	}
	public static String getNotableStats(Composite composite) {
		String notableStats = "Stats:";
		String bases = "";
		if (composite.getMaxHealthAddition() != 0) bases = bases + "\nHealth: " + signedStat(composite.getMaxHealthAddition());
		if (composite.getMaxArmorAddition() != 0) bases = bases + "\nArmor: " + signedStat(composite.getMaxArmorAddition());
		if (composite.getMaxShieldsAddition() != 0) bases = bases + "\nShields: " + signedStat(composite.getMaxShieldsAddition());
		if (composite.getShieldDelayAddition() != 0) bases = bases + "\nShield Delay: " + signedStat(composite.getShieldDelayAddition()/1000.0f) + " seconds";
		if (composite.getShieldRechargeRateAddition() != 0) bases = bases + "\nShield Recharge Rate: " + signedStat(composite.getShieldRechargeRateAddition());
		if (composite.getMaxSpeedAddition() != 0) bases = bases + "\nShip Speed: " + signedStat(composite.getMaxSpeedAddition());
		if (composite.getWeaponDamageAddition() != 0) bases = bases + "\nWeapon Damage: " + signedStat(composite.getWeaponDamageAddition());
		if (composite.getWeaponReloadTimeReduction() != 0) bases = bases + "\nWeapon Reload Time Reduction: " + 
		signedStat(composite.getWeaponReloadTimeReduction()/(-1000.0f)) + " seconds";
		if (composite.getWeaponSpeedAddition() != 0) bases = bases + "\nWeapon Speed: " + signedStat(composite.getWeaponSpeedAddition());
		if (composite.getWeaponAccelerationAddition() != 0) bases = bases + "\nWeapon Acceleration: " + signedStat(composite.getWeaponAccelerationAddition());
		String mults = "";
		if (composite.getMaxHealthMultiplier() != 1.0) mults = mults + "\nHealth Multiplier: x" + composite.getMaxHealthMultiplier();
		if (composite.getMaxArmorMultiplier() != 1.0) mults = mults + "\nArmor Multiplier: x" + composite.getMaxArmorMultiplier();
		if (composite.getMaxShieldsMultiplier() != 1.0) mults = mults + "\nShields Multiplier: x" + composite.getMaxShieldsMultiplier();
		if (composite.getShieldDelayMultiplier() != 1.0) mults = mults + "\nShield Delay Multiplier: x" + composite.getShieldDelayMultiplier();
		if (composite.getShieldRechargeRateMultiplier() != 1.0) mults = mults + "\nShield Recharge Rate Multiplier: x" + 
		composite.getShieldRechargeRateMultiplier();
		if (composite.getMaxSpeedMultiplier() != 1.0) mults = mults + "\nShip Speed Multiplier: x" + composite.getMaxSpeedMultiplier();
		if (composite.getWeaponDamageMultiplier() != 1.0) mults = mults + "\nWeapon Damage Multiplier: x" + composite.getWeaponDamageMultiplier();
		if (composite.getWeaponReloadTimeMultiplier() != 1.0) mults = mults + "\nWeapon Reload Time Multiplier: x" + composite.getWeaponReloadTimeMultiplier();
		if (composite.getWeaponSpeedMultiplier() != 1.0) mults = mults + "\nWeapon Speed Multiplier: x" + composite.getWeaponSpeedMultiplier();
		if (composite.getWeaponAccelerationMultiplier() != 1.0) mults = mults + "\nWeapon Acceleration Multiplier: x" + 
		composite.getWeaponAccelerationMultiplier();
		if (!bases.equals("") && !mults.equals("")) notableStats = notableStats + bases + "\n" + mults;
		else notableStats = notableStats + bases + mults;
		return notableStats;
	}
	public static String signedStat(float stat) {
		if (stat > 0) return "+" + stat;
		else return "" + stat;
	}
	
	//Get Methods
	public List<Purchasable> getPurchasableUpgrades() {
		if (purchasableUpgrades == null) {
			purchasableUpgrades = constructPurchasableUpgrades();
		}
		return purchasableUpgrades;
	}
	public String getDetails() {
		return getName() + "\n\n" + getSummary() + "\n\n" + Composite.getNotableStats(this) +
		"\n\nSpecial Effects: " + getSpecialEffectsDescription();
	}
	
	//Construct Methods
	public abstract List<Purchasable> constructPurchasableUpgrades();
	//Get Health Stat Bases Methods
	public abstract int getMaxHealthAddition();
	public abstract int getMaxArmorAddition();
	public abstract int getMaxShieldsAddition();
	public abstract int getShieldDelayAddition();
	public abstract int getShieldRechargeRateAddition();
	public abstract float getMaxHealthMultiplier();
	public abstract float getMaxArmorMultiplier();
	public abstract float getMaxShieldsMultiplier();
	public abstract float getShieldDelayMultiplier();
	public abstract float getShieldRechargeRateMultiplier();
	//Get Other Stat Bases Methods
	public abstract float getMaxSpeedAddition();
	public abstract float getMaxSpeedMultiplier();
	//Get Weapon Stats Methods
	public abstract int getWeaponDamageAddition();
	public abstract int getWeaponReloadTimeReduction();
	public abstract float getWeaponSpeedAddition(); 
	public abstract float getWeaponAccelerationAddition();
	public abstract float getWeaponDamageMultiplier();
	public abstract float getWeaponReloadTimeMultiplier();
	public abstract float getWeaponSpeedMultiplier();
	public abstract float getWeaponAccelerationMultiplier();
	//Get Other Items Methods
	public abstract int getTier();
	public abstract Composite getBaseComposite();
	public abstract String getName();
	public abstract String getSummary();
	public abstract String getSpecialEffectsDescription();
	public abstract String getUpgradeFlowChart();
}

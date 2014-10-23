package com.fffan911.galaxy_defense.Model.Weapons;

import java.util.List;

import android.graphics.Bitmap;
import android.util.Log;

import com.fffan911.galaxy_defense.Model.Actors.Actor;
import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Actors.TargetDummy;
import com.fffan911.galaxy_defense.Model.Actors.WeaponActor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Elements.Element;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public abstract class Weapon implements Cloneable {
	//Attributes & References
	private Ship ownerShip;
	protected List<Element> baseElements;
	protected List<Purchasable> purchasableUpgrades;
	//Constants
	private static final String TAG = "Weapon";
	
	//Constructor
	public Weapon(Ship ship) {
		this.ownerShip = ship;
	}
	public Weapon() {
		this(null);
	}
	
	//Actor Methods
	public void update(long updateTimeDiff, WeaponActor weaponActor) {
		return;
	}
	public void handleCollision(WeaponActor weaponActor, Actor actor){
		if (actor.equals(ownerShip)) return;
		if (actor.equals(weaponActor.getLastHitActor())) return;
		if (actor instanceof Ship) {
			Ship ship = (Ship)actor;
			ship.damage(getDamage());
			weaponActor.deref();
		}
		if (actor instanceof TargetDummy) {
			TargetDummy targetDummy = (TargetDummy)actor;
			targetDummy.deref();
			weaponActor.deref();
		}
	}
	
	//Clone Method
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}
	
	//Set Methods
	public void setOwnerShip(Ship ship) {
		this.ownerShip = ship;
	}
	
	//Static Get Methods
	public static String getDetailsAndUpgrade(Weapon weapon) {
		return weapon.getDetails() + "\n\nUpgrade Chart:\n" + weapon.getUpgradeFlowChart();
	}
	
	//Complex Get Methods
	public int getDamage(){
		if (ownerShip == null) return (int)(getBaseDamage() * getBaseDamageMultiplier());
		int raw = getBaseDamage() + ownerShip.getWeaponDamageAddition();
		float mult = getBaseDamageMultiplier() * ownerShip.getWeaponDamageMultiplier();
		return (int)(raw * mult);
	}
	public int getReloadTime(){
		if (ownerShip == null) return (int)(getBaseReloadTime() * getBaseReloadTimeMultiplier());
		int raw = getBaseReloadTime() - ownerShip.getWeaponReloadTimeReduction();
		float mult = getBaseReloadTimeMultiplier() * ownerShip.getWeaponReloadTimeMultiplier();
		return (int)(raw * mult);
	}
	public float getSpeed(){
		if (ownerShip == null) return getBaseSpeed() * getBaseSpeedMultiplier();
		float raw = getBaseSpeed() + ownerShip.getWeaponSpeedAddition();
		float mult = getBaseSpeedMultiplier() * ownerShip.getWeaponSpeedMultiplier();
		return raw * mult;
	}
	public float getAcceleration(){
		if (ownerShip == null) return getBaseAcceleration() * getBaseAccelerationMultiplier();
		float raw = getBaseAcceleration() + ownerShip.getWeaponAccelerationAddition();
		float mult = getBaseAccelerationMultiplier() * 
		ownerShip.getWeaponAccelerationMultiplier();
		return raw * mult;
	}
	
	//Get Methods
	public Ship getOwnerShip(){
		return ownerShip;
	}
	public String getBaseName() {
		return getBaseWeapon().getName();
	}
	public String getStats() {
		String stats = "Stats:";
		String bases = "";
		bases = bases + "\nDamage: " + getBaseDamage();
		bases = bases + "\nReload Time: " + getBaseReloadTime();
		bases = bases + "\nSpeed: " + getBaseSpeed();
		if (getAcceleration() != 0) bases = bases + "\nAcceleration: " + getBaseAcceleration();
		String mults = "";
		if (getBaseDamageMultiplier() != 1.0) mults = mults + "\nDamage Multiplier: x" + getBaseDamageMultiplier();
		if (getBaseReloadTimeMultiplier() != 1.0) mults = mults + "\nReload Time Multiplier: x" + getBaseReloadTimeMultiplier();
		if (getBaseSpeedMultiplier() != 1.0) mults = mults + "\nSpeed Multiplier: x" + getBaseSpeedMultiplier();
		if (getBaseAccelerationMultiplier() != 1.0) mults = mults + "\nAcceleration Multiplier: x" + getBaseAccelerationMultiplier();
		stats = stats + bases;
		if (!mults.equals("")) stats = stats + "\n" + mults;
		stats = stats + "\n\nBarrel Type: " + getRequiredBarrelType().getScreenName();
		return stats;
	}
	public String getDetails() {
		return getName() + "\n\n" + getSummary() + "\n\n" + getStats() +
		"\n\nSpecial Effects: " + getSpecialEffectsDescription();
	}
	public String getLevelString() {
		switch(getLevel()) {
			case(1): return "I";
			case(2): return "II";
			case(3): return "III";
			case(4): return "IV";
			case(5): return "V";
			case(6): return "VI";
			case(7): return "VII";
			case(8): return "VIII";
			case(9): return "IX";
			case(10): return "X";
			case(11): return "\u03A9";
			default: return "ERROR. Weapon Level is not a valid number: " + getLevel() + "?";
		}
	}
	public int getLevel() {
		return 1;
	}
	public List<Purchasable> getPurchasableUpgrades() {
		if (purchasableUpgrades == null) {
			purchasableUpgrades = constructPurchasableUpgrades();
		} 
		return purchasableUpgrades;
	}
	
	//Abstract Methods
	public abstract List<Purchasable> constructPurchasableUpgrades();
	public abstract BarrelType getRequiredBarrelType();
	public abstract int getBaseDamage();
	public abstract int getBaseReloadTime();
	public abstract float getBaseSpeed();
	public abstract float getBaseAcceleration();
	public abstract float getBaseDamageMultiplier();
	public abstract float getBaseReloadTimeMultiplier();
	public abstract float getBaseSpeedMultiplier();
	public abstract float getBaseAccelerationMultiplier();
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract int getTier();
	public abstract List<Purchasable> getPurchasableEvolutions();
	public abstract Bitmap[] getAnimationBitmaps(GamePanel panel);
	public abstract int getAnimationFramePeriod();
	public abstract int getButtonIconID();
	public abstract Weapon getBaseWeapon();
	public abstract String getName();
	public abstract String getSummary();
	public abstract String getSpecialEffectsDescription();
	public abstract String getUpgradeFlowChart();
}

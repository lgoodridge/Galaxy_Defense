package com.fffan911.galaxy_defense.Model.Actors;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.Accessory;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;
import com.fffan911.galaxy_defense.Model.Elements.Element;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Weapons.SpecialWeapon;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponFactory;
import com.fffan911.galaxy_defense.Utility.MathUtility;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public abstract class Ship extends Actor {
	//Composite Collections
	private Composite[] allComposites;
	private WeaponBarrel[] allWeaponBarrels;
	private Weapon[] ownedWeapons;
	private ArrayList<Accessory> ownedAccessories;
	//Equipped Composites
	private Composite equippedBody;
	private Composite equippedArmor;
	private Composite equippedShield;
	private Composite equippedCore;
	//Currently Equipped Weapon and Barrel
	private WeaponBarrel equippedWeaponBarrel;
	private Weapon equippedWeapon;
	//Current Status
	private List<Element> activeElements;
	//Attributes
	private float health;
	private float armor;
	private float shields;
	private int shieldsRechargeDelayTimeRemaining;
	//Constants
	private static final String TAG = "Ship";
	
	//Constructor
	public Ship(GamePanel panel, Position initialPosition) {
		super(panel, initialPosition);
		this.equippedBody = constructBody();
		this.equippedArmor = constructArmor();
		this.equippedShield = constructShield();
		this.equippedCore = constructCore();
		this.allComposites = constructComposites();
		this.allWeaponBarrels = constructWeaponBarrels();
		this.ownedWeapons = constructOwnedWeapons();
		this.ownedAccessories = constructAccessories();
		this.equippedWeaponBarrel = null;
		this.equippedWeapon = null;
		this.activeElements = new ArrayList<Element>();
		this.health = getMaxHealth();
		this.armor = getMaxArmor();
		this.shields = getMaxShields();
		this.shieldsRechargeDelayTimeRemaining = 0;
	}
	
	//Construct Methods
	private final Composite[] constructComposites() {
		Composite[] composites = new Composite[4];
		composites[0] = equippedBody;
		composites[1] = equippedArmor;
		composites[2] = equippedShield;
		composites[3] = equippedCore;
		return composites;
	}
	
	//Actor Methods
	@Override
	public void update(long updateTimeDiff) {
		super.update(updateTimeDiff);
		for (Element element : activeElements) {
			element.update(updateTimeDiff, this);
		}
		if (shieldsRechargeDelayTimeRemaining == 0) {
			float mult = (float)updateTimeDiff / 1000.0f;
			addShields((int)(getShieldRechargeRate() * mult));
		} else {
			shieldsRechargeDelayTimeRemaining -= updateTimeDiff;
			if (shieldsRechargeDelayTimeRemaining < 0) shieldsRechargeDelayTimeRemaining = 0;
		}
	}
	
	//Shooting Methods
	public void shoot() {
		if (equippedWeaponBarrel.barrelTypeMatches(BarrelType.DOUBLE)) {
			sendDoubleWeaponSpecsToFactory(equippedWeapon);
		} else {
			sendWeaponSpecsToFactory(equippedWeapon);
		}
	}
	public void shootSpecialWeapon(SpecialWeapon specialWeapon) {
		final Weapon previouslyEquippedWeapon = equippedWeapon;
		equipWeapon(specialWeapon);
		specialWeapon.launchSpecialAttack(this);
		equipWeapon(previouslyEquippedWeapon);
	}
	private void sendWeaponSpecsToFactory(Weapon weapon) {
		WeaponFactory.getInstance().createWeaponActor(weapon, getPanel(), 
		getWeaponInitialPosition(weapon));
	}
	private void sendDoubleWeaponSpecsToFactory(Weapon weapon) {
		WeaponFactory.getInstance().createDoubleWeaponActor(weapon, getPanel(),
		getDoubleWeaponInitialPosition(weapon));
	}
	public void equipWeapon(Weapon weapon) {
		setEquippedWeapon(weapon);
		setEquippedWeaponBarrel(findWeaponBarrel(equippedWeapon.getRequiredBarrelType()));
	}
	
	//Repair and Damage Methods
	public void repair(int amount) {
		int healthRestored = Math.min(amount, getHealthDeficit());
		int remainingAfterHealth = amount - healthRestored;
		int armorRestored = Math.min(remainingAfterHealth, getArmorDeficit());
		if (healthRestored > 0) addHealth(healthRestored);
		if (armorRestored > 0) addArmor(armorRestored);
		Log.d(TAG, getClass().getSimpleName() + " repaired " + amount + " hps. Shields: " + 
		getShields() + " , Armor: " + (getArmor() - armorRestored) + " => " + getArmor() + 
		" , Health: " + (getHealth() - healthRestored) + " => " + getHealth());
	}
	public void fullRepair() {
		repair(getTotalDeficit());
		shields = getMaxShields();
	}
	public void damage(int amount) {
		shieldsRechargeDelayTimeRemaining = getShieldDelay();
		int shieldsDamage = Math.min(amount, getShields());
		int remainingAfterShields = amount - shieldsDamage;
		int armorDamage = Math.min(remainingAfterShields, getArmor());
		int remainingAfterArmor = remainingAfterShields - armorDamage;
		int healthDamage  = Math.min(remainingAfterArmor, getHealth());
		Log.d(TAG, getClass().getSimpleName() + " was damaged for " + amount + 
		" hps. Shields: " + getShields() + " => " + (getShields() - shieldsDamage) + 
		" , Armor: " + getArmor() + " => " + (getArmor() - armorDamage) + " , Health: " + 
		getHealth() + " => " + (getHealth() - healthDamage));
		if (shieldsDamage > 0) remShields(shieldsDamage);
		if (armorDamage > 0) remArmor(armorDamage);
		if (healthDamage > 0) remHealth(healthDamage);
	}
	public void kill() {
		Log.d(TAG, getClass().getSimpleName() + " has received a fatal blow.");
		damage((int)(shields + armor + health));
	}
	public void clearElements() {
		activeElements.clear();
	}
	
	//Add and Remove Health Methods
	public void addHealth(int amount) {
		health += amount;
		if (health > getMaxHealth()) health = getMaxHealth();
	}
	public void addArmor(int amount) {
		armor += amount;
		if (armor > getMaxArmor()) armor = getMaxArmor();
	}
	public void addShields(int amount) {
		shields += amount;
		if (shields > getMaxShields()) shields = getMaxShields();
	}
	public void addElement(Element element) {
		activeElements.add(element);
	}
	public void remHealth(int amount) {
		health -= amount;
		if (health < 0) health = 0;
		if (health == 0) {
			Log.d(TAG, getClass().getSimpleName() + " has been killed.");
			deref();
		}
	}
	public void remArmor(int amount) {
		armor -= amount;
		if (armor < 0) armor = 0;
	}
	public void remShields(int amount) {
		shields -= amount;
		if (shields < 0) shields = 0;
	}
	public void remElement(Element element) {
		activeElements.remove(element);
	}
	
	//Boolean Methods
	public boolean hasFullHealth() {
		return getHealth() == getMaxHealth();
	}
	public boolean hasFullArmor() {
		return getArmor() == getMaxArmor();
	}
	public boolean hasFullShields() {
		return getShields() == getMaxShields();
	}
	public boolean hasEmptyHealth() {
		return getHealth() == 0;
	}
	public boolean hasEmptyArmor() {
		return getArmor() == 0;
	}
	public boolean hasEmptyShields() {
		return getShields() == 0;
	}
	public boolean isAlive() {
		return getHealth() > 0;
	}
	
	//Calculate Methods
	public float[] calculateWeaponInitialPositionInfo(Weapon weapon, float degrees){
		int xMid = (getLeftEdge() + getRightEdge()) / 2;
		float alpha = (180 - degrees) / 2;
		double length = (getCurrentBitmap().getHeight() / 2) + (weapon.getHeight() / 2);
		double dHyp = length * Math.sin(degrees * Math.PI / 180) / 
		Math.sin(alpha * Math.PI / 180);
		if (alpha == 0) dHyp = 2 * length;
		double dx = dHyp * Math.sin(alpha * Math.PI / 180);
		double dy = dHyp * Math.cos(alpha * Math.PI / 180);
		int yTop = getTopEdge() - (weapon.getHeight() / 2);
		int convX = xMid + (int)dx;
		int convY = yTop + (int)dy;
		float[] posInfo = {convX, convY, weapon.getSpeed() * MathUtility.sin(degrees), 
		-weapon.getSpeed() * MathUtility.cos(degrees), weapon.getAcceleration() *
		MathUtility.sin(degrees), -weapon.getAcceleration() * MathUtility.cos(degrees), 
		degrees};
		return posInfo;
	}
	public float[][] calculateDoubleWeaponInitialPositionInfo(Weapon weapon, float degrees) {
		int xMid = (getLeftEdge() + getRightEdge()) / 2;
		int distanceBetween = getRightEdge() - getLeftEdge() - weapon.getWidth();
		float alpha = (180 - degrees) / 2;
		double length = (getCurrentBitmap().getHeight() / 2) + (weapon.getHeight() / 2);
		double dHyp = length * Math.sin(degrees * Math.PI / 180) / 
		Math.sin(alpha * Math.PI / 180);
		if (alpha == 0) dHyp = 2 * length;
		double dx = dHyp * Math.sin(alpha * Math.PI / 180);
		double dy = dHyp * Math.cos(alpha * Math.PI / 180);
		int yTop = getTopEdge() - (weapon.getHeight() / 2);
		int leftX = xMid + (int)dx - (int)(MathUtility.cos(degrees) * distanceBetween / 2);
		int leftY = yTop - (int)dy - (int)(MathUtility.sin(degrees) * distanceBetween / 2);
		float[] leftPosInfo = {leftX, leftY, weapon.getSpeed() * MathUtility.sin(degrees), 
		-weapon.getSpeed() * MathUtility.cos(degrees), weapon.getAcceleration() *
		MathUtility.sin(degrees), -weapon.getAcceleration() * MathUtility.cos(degrees), 
		degrees};
		int rightX = leftX + (int)(MathUtility.cos(degrees) * distanceBetween);
		int rightY = leftY + (int)(MathUtility.sin(degrees) * distanceBetween);
		float[] rightPosInfo = {rightX, rightY, weapon.getSpeed() * MathUtility.sin(degrees), 
		-weapon.getSpeed() * MathUtility.cos(degrees), weapon.getAcceleration() *
		MathUtility.sin(degrees), -weapon.getAcceleration() * MathUtility.cos(degrees), 
		degrees};
		float[][] posInfo = {leftPosInfo, rightPosInfo};
		return posInfo;
	}
	
	//Find Methods
	public WeaponBarrel findWeaponBarrel(BarrelType barrelType) {
		for (WeaponBarrel weaponBarrel : allWeaponBarrels) 
			if (weaponBarrel.barrelTypeMatches(barrelType))
				return weaponBarrel;
		return null;
	}
	
	//Set Methods
	public void setEquippedWeaponBarrel(WeaponBarrel weaponBarrel) {
		equippedWeaponBarrel = weaponBarrel;
	}
	public void setEquippedWeapon(Weapon weapon) {
		equippedWeapon = weapon;
	}
	
	//Complex Get Methods
	public int getHealthDeficit() {
		return getMaxHealth() - getHealth();
	}
	public int getArmorDeficit() {
		return getMaxArmor() - getArmor();
	}
	public int getShieldsDeficit() {
		return getMaxShields() - getShields();
	}
	public int getTotalDeficit() {
		return getHealthDeficit() + getArmorDeficit() + getShieldsDeficit();
	}
	public int getHealthPercentage() {
		return getHealth() * 100 / getMaxHealth();
	}
	public int getArmorPercentage() {
		return getArmor() * 100 / getMaxArmor();
	}
	public int getShieldsPercentage() {
		return getShields() * 100 / getMaxShields();
	}
	public float[] getWeaponInitialPosition(Weapon weapon) {
		return calculateWeaponInitialPositionInfo(weapon, getPosition().getDegrees());
	}
	public float[][] getDoubleWeaponInitialPosition(Weapon weapon) {
		return calculateDoubleWeaponInitialPositionInfo(weapon, getPosition().getDegrees());
	}
	public Element getElement(String elementName) {
		for (Element element : activeElements) if (element.getName().equals(elementName)) return element;
		return null;
	}
	
	//Get Methods
	public int getHealth() {
		return (int)(health);
	}
	public int getArmor() {
		return (int)(armor);
	}
	public int getShields() {
		return (int)(shields);
	}
	public int getShieldsRechargeDelayTimeRemaining() {
		return shieldsRechargeDelayTimeRemaining;
	}
	public Composite getEquippedBody() {
		return equippedBody;
	}
	public Composite getEquippedArmor() {
		return equippedArmor;
	}
	public Composite getEquippedShield() {
		return equippedShield;
	}
	public Composite getEquippedCore() {
		return equippedCore;
	}
	public WeaponBarrel getEquippedWeaponBarrel() {
		return equippedWeaponBarrel;
	}
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	public Composite[] getAllComposites() {
		return allComposites;
	}
	public WeaponBarrel[] getAllWeaponBarrels() {
		return allWeaponBarrels;
	}
	public Weapon[] getOwnedWeapons() {
		return ownedWeapons;
	}
	public ArrayList<Accessory> getOwnedAccessories() {
		return ownedAccessories;
	}
	public List<Element> getActiveElements() {
		return activeElements;
	}
	
	//Get Equipment Stat Contribution Methods
	public int getEquipmentMaxHealthAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getMaxHealthAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getMaxHealthAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getMaxHealthAddition();
		return raw;
	}
	public int getEquipmentMaxArmorAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getMaxArmorAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getMaxArmorAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getMaxArmorAddition();
		return raw;
	}
	public int getEquipmentMaxShieldsAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getMaxShieldsAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getMaxShieldsAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getMaxShieldsAddition();
		return raw;
	}
	public int getEquipmentShieldDelayAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getShieldDelayAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getShieldDelayAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getShieldDelayAddition();
		return raw;
	}
	public int getEquipmentShieldRechargeRateAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getShieldRechargeRateAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getShieldRechargeRateAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getShieldRechargeRateAddition();
		return raw;
	}
	public float getEquipmentSpeedAddition() {
		float raw = 0.0f;
		for (Composite c : allComposites) raw += c.getMaxSpeedAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getMaxSpeedAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getMaxSpeedAddition();
		return raw;
	}
	public int getEquipmentWeaponDamageAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getWeaponDamageAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getWeaponDamageAddition();
		raw += equippedWeaponBarrel.getWeaponDamageAddition();
		return raw;
	}
	public float getEquipmentWeaponReloadTimeReduction() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getWeaponReloadTimeReduction();
		for (Accessory ac : ownedAccessories) raw += ac.getWeaponReloadTimeReduction();
		raw += equippedWeaponBarrel.getWeaponReloadTimeReduction();
		return raw;
	}
	public float getEquipmentWeaponSpeedAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getWeaponSpeedAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getWeaponSpeedAddition();
		raw += equippedWeaponBarrel.getWeaponSpeedAddition();
		return raw;
	}
	public float getEquipmentWeaponAccelerationAddition() {
		int raw = 0;
		for (Composite c : allComposites) raw += c.getWeaponAccelerationAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getWeaponAccelerationAddition();
		raw += equippedWeaponBarrel.getWeaponAccelerationAddition();
		return raw;
	}
	public float getEquipmentMaxHealthMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getMaxHealthMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getMaxHealthMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getMaxHealthMultiplier();
		return mult;
	}
	public float getEquipmentMaxArmorMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getMaxArmorMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getMaxArmorMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getMaxArmorMultiplier();
		return mult;
	}
	public float getEquipmentMaxShieldsMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getMaxShieldsMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getMaxShieldsMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getMaxShieldsMultiplier();
		return mult;
	}
	public float getEquipmentShieldDelayMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getShieldDelayMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getShieldDelayMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getShieldDelayMultiplier();
		return mult;
	}
	public float getEquipmentShieldRechargeRateMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getShieldRechargeRateMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getShieldRechargeRateMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getShieldRechargeRateMultiplier();
		return mult;
	}
	public float getEquipmentSpeedMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getMaxSpeedMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getMaxSpeedMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getMaxSpeedMultiplier();
		return mult;
	}
	public float getEquipmentWeaponDamageMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getWeaponDamageMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getWeaponDamageMultiplier();
		mult *= equippedWeaponBarrel.getWeaponDamageMultiplier();
		return mult;
	}
	public float getEquipmentWeaponReloadTimeMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getWeaponReloadTimeMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getWeaponReloadTimeMultiplier();
		mult *= equippedWeaponBarrel.getWeaponReloadTimeMultiplier();
		return mult;
	}
	public float getEquipmentWeaponSpeedMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getWeaponSpeedMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getWeaponSpeedMultiplier();
		mult *= equippedWeaponBarrel.getWeaponSpeedMultiplier();
		return mult;
	}
	public float getEquipmentWeaponAccelerationMultiplier() {
		float mult = 1.0f;
		for (Composite c : allComposites) mult *= c.getWeaponAccelerationMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getWeaponAccelerationMultiplier();
		mult *= equippedWeaponBarrel.getWeaponAccelerationMultiplier();
		return mult;
	}
	
	//Get Final Stats Methods
	public int getMaxHealth() {
		int raw = getBaseMaxHealth();
		raw += getEquipmentMaxHealthAddition();
		for (Element e : activeElements) raw += e.getMaxHealthAddition();
		float mult = getBaseMaxHealthMultiplier();
		mult *= getEquipmentMaxHealthMultiplier();
		for (Element e : activeElements) mult *= e.getMaxHealthMultiplier();
		return (int)(raw * mult);
	}
	public int getMaxArmor() {
		int raw = getBaseMaxArmor();
		raw += getEquipmentMaxArmorAddition();
		for (Element e : activeElements) raw += e.getMaxArmorAddition();
		float mult = getBaseMaxArmorMultiplier();
		mult *= getEquipmentMaxArmorMultiplier();
		for (Element e : activeElements) mult *= e.getMaxArmorMultiplier();
		return (int)(raw * mult);
	}
	public int getMaxShields() {
		int raw = getBaseMaxShields();
		raw += getEquipmentMaxShieldsAddition();
		for (Element e : activeElements) raw += e.getMaxShieldsAddition();
		float mult = getBaseMaxShieldsMultiplier();
		mult *= getEquipmentMaxArmorMultiplier();
		for (Element e : activeElements) mult *= e.getMaxShieldsMultiplier();
		return (int)(raw * mult);
	}
	public int getShieldDelay() {
		int raw = getBaseShieldDelay();
		for (Composite c : allComposites) raw += c.getShieldDelayAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getShieldDelayAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getShieldDelayAddition();
		float mult = getBaseShieldDelayMultiplier();
		for (Composite c : allComposites) mult *= c.getShieldDelayMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getShieldDelayMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getShieldDelayMultiplier();
		return (int)(raw * mult);
	}
	public int getShieldRechargeRate() {
		int raw = getBaseShieldRechargeRate();
		for (Composite c : allComposites) raw += c.getShieldRechargeRateAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getShieldRechargeRateAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getShieldRechargeRateAddition();
		float mult = getBaseShieldRechargeRateMultiplier();
		for (Composite c : allComposites) mult *= c.getShieldRechargeRateMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getShieldRechargeRateMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getShieldRechargeRateMultiplier();
		return (int)(raw * mult);
	}
	public float getMaxSpeed() {
		float raw = getBaseMaxSpeed();
		for (Composite c : allComposites) raw += c.getMaxSpeedAddition();
		for (WeaponBarrel wb : allWeaponBarrels) raw += wb.getMaxSpeedAddition();
		for (Accessory ac : ownedAccessories) raw += ac.getMaxSpeedAddition();
		float mult = getBaseMaxSpeedMultiplier();
		for (Composite c : allComposites) mult *= c.getMaxSpeedMultiplier();
		for (WeaponBarrel wb : allWeaponBarrels) mult *= wb.getMaxSpeedMultiplier();
		for (Accessory ac : ownedAccessories) mult *= ac.getMaxSpeedMultiplier();
		return raw * mult;
	}
	public float getMaxRotateSpeed(){
		return 400.0f;
	}
	
	//Get Weapon Modifer Methods
	public int getWeaponDamageAddition() {
		int value = getBaseWeaponDamageAddition();
		for (Composite c : allComposites) value += c.getWeaponDamageAddition();
		for (Accessory ac : ownedAccessories) value += ac.getWeaponDamageAddition();
		value += equippedWeaponBarrel.getWeaponDamageAddition();
		return value;
	}
	public int getWeaponReloadTimeReduction() {
		int value = getBaseWeaponReloadTimeReduction();
		for (Composite c : allComposites) value += c.getWeaponReloadTimeReduction();
		for (Accessory ac : ownedAccessories) value += ac.getWeaponReloadTimeReduction();
		value += equippedWeaponBarrel.getWeaponReloadTimeReduction();
		return value;
	}
	public float getWeaponSpeedAddition() {
		float value = getBaseWeaponSpeedAddition();
		for (Composite c : allComposites) value += c.getWeaponSpeedAddition();
		for (Accessory ac : ownedAccessories) value += ac.getWeaponSpeedAddition();
		value += equippedWeaponBarrel.getWeaponSpeedAddition();
		return value;
	}
	public float getWeaponAccelerationAddition() {
		float value = getBaseWeaponAccelerationAddition();
		for (Composite c : allComposites) value += c.getWeaponAccelerationAddition();
		for (Accessory ac : ownedAccessories) value += ac.getWeaponAccelerationAddition();
		value += equippedWeaponBarrel.getWeaponAccelerationAddition();
		return value;
	}
	public float getWeaponDamageMultiplier() {
		float value = getBaseWeaponDamageMultiplier();
		for (Composite c : allComposites) value *= c.getWeaponDamageMultiplier();
		for (Accessory ac : ownedAccessories) value *= ac.getWeaponDamageMultiplier();
		value *= equippedWeaponBarrel.getWeaponDamageMultiplier();
		return value;
	}
	public float getWeaponReloadTimeMultiplier() {
		float value = getBaseWeaponReloadTimeMultiplier();
		for (Composite c : allComposites) value *= c.getWeaponReloadTimeMultiplier();
		for (Accessory ac : ownedAccessories) value *= ac.getWeaponReloadTimeMultiplier();
		value *= equippedWeaponBarrel.getWeaponReloadTimeMultiplier();
		return value;
	}
	public float getWeaponSpeedMultiplier() {
		float value = getBaseWeaponSpeedMultiplier();
		for (Composite c : allComposites) value *= c.getWeaponSpeedMultiplier();
		for (Accessory ac : ownedAccessories) value *= ac.getWeaponSpeedMultiplier();
		value *= equippedWeaponBarrel.getWeaponSpeedMultiplier();
		return value;
	}
	public float getWeaponAccelerationMultiplier() {
		float value = getBaseWeaponAccelerationMultiplier();
		for (Composite c : allComposites) value *= c.getWeaponAccelerationMultiplier();
		for (Accessory ac : ownedAccessories) value *= ac.getWeaponAccelerationMultiplier();
		value *= equippedWeaponBarrel.getWeaponAccelerationMultiplier();
		return value;
	}
	
	//Abstract Construct Methods
	public abstract Composite constructBody();
	public abstract Composite constructArmor();
	public abstract Composite constructShield();
	public abstract Composite constructCore();
	public abstract Weapon[] constructOwnedWeapons();
	public abstract WeaponBarrel[] constructWeaponBarrels();
	public abstract ArrayList<Accessory> constructAccessories();
	//Abstract Health Stat Base Methods
	public abstract int getBaseMaxHealth();
	public abstract int getBaseMaxArmor();
	public abstract int getBaseMaxShields();
	public abstract int getBaseShieldDelay();
	public abstract int getBaseShieldRechargeRate();
	public abstract float getBaseMaxHealthMultiplier();
	public abstract float getBaseMaxArmorMultiplier();
	public abstract float getBaseMaxShieldsMultiplier();
	public abstract float getBaseShieldDelayMultiplier();
	public abstract float getBaseShieldRechargeRateMultiplier();
	//Abstract Other Stat Base Methods
	public abstract float getBaseMaxSpeed();
	public abstract float getBaseMaxSpeedMultiplier();
	//Abstract Weapon Stat Modifier Methods
	public abstract int getBaseWeaponDamageAddition();
	public abstract int getBaseWeaponReloadTimeReduction();
	public abstract float getBaseWeaponSpeedAddition(); 
	public abstract float getBaseWeaponAccelerationAddition();
	public abstract float getBaseWeaponDamageMultiplier();
	public abstract float getBaseWeaponReloadTimeMultiplier();
	public abstract float getBaseWeaponSpeedMultiplier();
	public abstract float getBaseWeaponAccelerationMultiplier();
}

package com.fffan911.galaxy_defense.Model.Data;

import java.util.ArrayList;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.Accessory;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.FlashCCUAccessory;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Armor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Body;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonArmor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonBody;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonWeaponBarrel;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Core;
import com.fffan911.galaxy_defense.Model.Composites.Parts.EMCore;
import com.fffan911.galaxy_defense.Model.Composites.Parts.EMShield;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Shield;
import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.CompositeUpgrade;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.ReinforcedArmorUpgrade;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.WeaponBarrelUpgrade;
import com.fffan911.galaxy_defense.Model.Weapons.Beam;
import com.fffan911.galaxy_defense.Model.Weapons.Laser;
import com.fffan911.galaxy_defense.Model.Weapons.PlasmaCannon;
import com.fffan911.galaxy_defense.Model.Weapons.SpecialWeapon;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponEvolutions.FluxCannon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades.WeaponUpgrade;

public class PlayerData {
	//Instance
	private static PlayerData instance;
	//References
	private Composite equippedBody;
	private Composite equippedArmor;
	private Composite equippedShield;
	private Composite equippedCore;
	private WeaponBarrel equippedSingleWeaponBarrel;
	private WeaponBarrel equippedDoubleWeaponBarrel;
	private WeaponBarrel equippedLauncherWeaponBarrel;
	private WeaponBarrel voidWeaponBarrel;
	private ArrayList<Accessory> ownedAccessories;
	private Weapon[] ownedWeapons;
	private Weapon ownedSpecialWeapon;
	//Attributes
	private int tier;
	private int money;
	private int etherium;
	private int specialsRemaining;
	//Game Health Attributes
	private int playerHealth;
	private int playerArmor;
	private int playerShields;
	private int playerHealthPercentage;
	private int playerArmorPercentage;
	private int playerShieldsPercentage;
	
	//Singleton Constructor
	private PlayerData() {
		this.equippedBody = new CarbonBody();
		this.equippedArmor = new CarbonArmor();
		this.equippedShield = new EMShield();
		this.equippedCore = new EMCore();
		this.equippedSingleWeaponBarrel = new CarbonWeaponBarrel(BarrelType.SINGLE);
		this.equippedDoubleWeaponBarrel = new CarbonWeaponBarrel(BarrelType.DOUBLE);
		this.equippedLauncherWeaponBarrel = new CarbonWeaponBarrel(BarrelType.LAUNCHER);
		this.voidWeaponBarrel = new CarbonWeaponBarrel(BarrelType.VOID);
		this.ownedAccessories = new ArrayList<Accessory>();
		this.ownedWeapons = new Weapon[6];
		this.ownedSpecialWeapon = null;
		this.tier = 1;
		this.money = 6000;
		this.etherium = 1000;
		this.specialsRemaining = 5;
		updatePlayerHealthData(0, 0, 0);
		updatePlayerHealthPercentageData(100, 100, 100);
		setWeaponInSlot(new Beam(), 1);
		setWeaponInSlot(new Laser(), 2);
		setWeaponInSlot(new PlasmaCannon(), 3);
		setWeaponInSlot(new FluxCannon(new PlasmaCannon()), 4);
	}
	
	//Singleton Method
	public static PlayerData getInstance() {
		if (instance == null) {
			instance = new PlayerData();
		}
		return instance;
	}
	
	//Update Methods
	public final void updatePlayerHealthData(int currHealth, int currArmor, int currShields) {
		setPlayerHealth(currHealth);
		setPlayerArmor(currArmor);
		setPlayerShields(currShields);
	}
	public final void updatePlayerHealthPercentageData(int currHealthPercentage, 
	int currArmorPercentage, int currShieldsPercentage) {
		setPlayerHealthPercentage(currHealthPercentage);
		setPlayerArmorPercentage(currArmorPercentage);
		setPlayerShieldsPercentage(currShieldsPercentage);
	}
	
	//Clear Methods
	public final void clearPlayerHealthData() {
		updatePlayerHealthData(0, 0, 0);
		updatePlayerHealthPercentageData(0, 0, 0);
	}
	
	//Upgrade Methods
	public void upgradeBody(CompositeUpgrade bodyUpgrade) {
		bodyUpgrade.setInnerComposite(equippedBody);
		setEquippedBody(bodyUpgrade);
	}
	public void upgradeArmor(CompositeUpgrade armorUpgrade) {
		armorUpgrade.setInnerComposite(equippedArmor);
		setEquippedArmor(armorUpgrade);
	}
	public void upgradeShield(CompositeUpgrade shieldUpgrade) {
		shieldUpgrade.setInnerComposite(equippedShield);
		setEquippedShield(shieldUpgrade);
	}
	public void upgradeCore(CompositeUpgrade coreUpgrade) {
		coreUpgrade.setInnerComposite(equippedCore);
		setEquippedCore(coreUpgrade);
	}
	public void upgradeSingleWeaponBarrel(WeaponBarrelUpgrade singleWeaponBarrelUpgrade) {
		singleWeaponBarrelUpgrade.setInnerWeaponBarrel(equippedSingleWeaponBarrel);
		setEquippedSingleWeaponBarrel(singleWeaponBarrelUpgrade);
	}
	public void upgradeDoubleWeaponBarrel(WeaponBarrelUpgrade doubleWeaponBarrelUpgrade) {
		doubleWeaponBarrelUpgrade.setInnerWeaponBarrel(equippedDoubleWeaponBarrel);
		setEquippedDoubleWeaponBarrel(doubleWeaponBarrelUpgrade);
	}
	public void upgradeLauncherWeaponBarrel(WeaponBarrelUpgrade launcherWeaponBarrelUpgrade) {
		launcherWeaponBarrelUpgrade.setInnerWeaponBarrel(equippedLauncherWeaponBarrel);
		setEquippedLauncherWeaponBarrel(launcherWeaponBarrelUpgrade);
	}
	public void upgradeWeaponInSlot(WeaponUpgrade weaponUpgrade, int slot) {
		weaponUpgrade.setInnerWeapon(getWeaponFromSlot(slot));
		setWeaponInSlot(weaponUpgrade, slot);
	}
	public void upgradeSpecialWeapon(WeaponUpgrade specialWeaponUpgrade) {
		specialWeaponUpgrade.setInnerWeapon(ownedSpecialWeapon);
		setSpecialWeapon(specialWeaponUpgrade);
	}
	
	//Replace Methods
	public void replaceBody(Body newBody) {
		setEquippedBody(newBody);
	}
	public void replaceArmor(Armor newArmor) {
		setEquippedArmor(newArmor);
	}
	public void replaceShield(Shield newShield) {
		setEquippedShield(newShield);
	}
	public void replaceCore(Core newCore) {
		setEquippedCore(newCore);
	}
	public void replaceSingleWeaponBarrel(WeaponBarrel newSingleWeaponBarrel) {
		setEquippedSingleWeaponBarrel(newSingleWeaponBarrel);
	}
	public void replaceDoubleWeaponBarrel(WeaponBarrel newDoubleWeaponBarrel) {
		setEquippedDoubleWeaponBarrel(newDoubleWeaponBarrel);
	}
	public void replaceLauncherWeaponBarrel(WeaponBarrel newLauncherWeaponBarrel) {
		setEquippedLauncherWeaponBarrel(newLauncherWeaponBarrel);
	}
	public void replaceWeaponInSlot(Weapon newWeapon, int slot) {
		setWeaponInSlot(newWeapon, slot);
	}
	public void replaceSpecialWeapon(Weapon newSpecialWeapon) {
		setSpecialWeapon(newSpecialWeapon);
	}
	
	//Increase and Decrease Methods
	public void increaseTier() {
		tier++;
	}
	public void decreaseTier() {
		tier--;
	}
	
	//Add and Remove Methods
	public void addAccessory(Accessory newAccessory) {
		ownedAccessories.add(newAccessory);
	}
	public void addMoney(int amount) {
		money += amount;
	}
	public void addEtherium(int amount) {
		etherium += amount;
	}
	public void addSpecialsRemaining(int amount) {
		specialsRemaining += amount;
	}
	public void removeAccessory(String accessoryName) {
		if (hasAccessory(accessoryName)) {
			ownedAccessories.remove(getAccessory(accessoryName));
		}
	}
	public void remMoney(int amount) {
		money -= amount;
	}
	public void remEtherium(int amount) {
		etherium -= amount;
	}
	public void remSpecialsRemaining(int amount) {
		specialsRemaining -= amount;
	}
	
	//Boolean Methods
	public boolean hasAccessory(String accessoryName) {
		return getAccessory(accessoryName) != null;
	}
	public boolean hasWeaponInSlot(int slot) {
		return getWeaponFromSlot(slot) != null;
	}
	public boolean hasAvailableWeaponSlot() {
		return getFirstAvailableWeaponSlot() != -1;
	}
	public boolean hasSpecialsRemaining() {
		return ownedSpecialWeapon != null && specialsRemaining > 0;
	}
	
	//Set Methods
	private void setEquippedBody(Composite newBody) {
		equippedBody = newBody;
	}
	private void setEquippedArmor(Composite newArmor) {
		equippedArmor = newArmor;
	}
	private void setEquippedShield(Composite newShield) {
		equippedShield = newShield;
	}
	private void setEquippedCore(Composite newCore) {
		equippedCore = newCore;
	}
	private void setEquippedSingleWeaponBarrel(WeaponBarrel newSingleWeaponBarrel) {
		equippedSingleWeaponBarrel = newSingleWeaponBarrel;
	}
	private void setEquippedDoubleWeaponBarrel(WeaponBarrel newDoubleWeaponBarrel) {
		equippedDoubleWeaponBarrel = newDoubleWeaponBarrel;
	}
	private void setEquippedLauncherWeaponBarrel(WeaponBarrel newLauncherWeaponBarrel) {
		equippedLauncherWeaponBarrel = newLauncherWeaponBarrel;
	}
	private void setWeaponInSlot(Weapon weapon, int slot) {
		ownedWeapons[slot - 1] = weapon;
	}
	private void setSpecialWeapon(Weapon specialWeapon) {
		ownedSpecialWeapon = specialWeapon;
	}
	public void setTier(int newTier) {
		tier = newTier;
	}
	public void setMoney(int newMoney) {
		money = newMoney;
	}
	public void setEtherium(int newEtherium) {
		etherium = newEtherium;
	}
	public void setSpecialsRemaining(int newSpecialsRemaining) {
		specialsRemaining = newSpecialsRemaining;
	}
	public void setPlayerHealth(int newHealth) {
		playerHealth = newHealth;
	}
	public void setPlayerArmor(int newArmor) {
		playerArmor = newArmor;
	}
	public void setPlayerShields(int newShields) {
		playerShields = newShields;
	}
	public void setPlayerHealthPercentage(int newHealthPercentage) {
		playerHealthPercentage = newHealthPercentage;
	}
	public void setPlayerArmorPercentage(int newArmorPercentage) {
		playerArmorPercentage = newArmorPercentage;
	}
	public void setPlayerShieldsPercentage(int newShieldsPercentage) {
		playerShieldsPercentage = newShieldsPercentage;
	}
	
	//Get Methods
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
	public WeaponBarrel getEquippedSingleWeaponBarrel() {
		return equippedSingleWeaponBarrel;
	}
	public WeaponBarrel getEquippedDoubleWeaponBarrel() {
		return equippedDoubleWeaponBarrel;
	}
	public WeaponBarrel getEquippedLauncherWeaponBarrel() {
		return equippedLauncherWeaponBarrel;
	}
	public WeaponBarrel getVoidWeaponBarrel() {
		return voidWeaponBarrel;
	}
	public Accessory getAccessory(String accessoryName) {
		for (Accessory accessory : ownedAccessories) {
			if (accessory.namesMatch(accessoryName)) return accessory;
		}
		return null;
	}
	public ArrayList<Accessory> getAllOwnedAccessories() {
		return ownedAccessories;
	}
	public Weapon getWeaponFromSlot(int slot) {
		return ownedWeapons[slot - 1];
	}
	public Weapon[] getAllOwnedWeapons() {
		return ownedWeapons;
	}
	public SpecialWeapon getSpecialWeapon() {
		return (SpecialWeapon)ownedSpecialWeapon;
	}
	public int getFirstAvailableWeaponSlot() {
		for (int i = 1; i < 7; i++) {
			if (!hasWeaponInSlot(i)) return i;
		}
		return -1;
	}
	public int getTier() {
		return tier;
	}
	public int getMoney() {
		return money;
	}
	public int getEtherium() {
		return etherium;
	}
	public int getSpecialsRemaining() {
		return specialsRemaining;
	}
	public int getPlayerHealth() {
		return playerHealth;
	}
	public int getPlayerArmor() {
		return playerArmor;
	}
	public int getPlayerShields() {
		return playerShields;
	}
	public int getPlayerHealthPercentage() {
		return playerHealthPercentage;
	}
	public int getPlayerArmorPercentage() {
		return playerArmorPercentage;
	}
	public int getPlayerShieldsPercentage() {
		return playerShieldsPercentage;
	}
}

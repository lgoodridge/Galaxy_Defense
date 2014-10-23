package com.fffan911.galaxy_defense.Model.Purchasables;

import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.CompositeArea;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.Accessory;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Armor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Body;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Core;
import com.fffan911.galaxy_defense.Model.Composites.Parts.Shield;
import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.CompositeUpgrade;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.Upgrade;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.WeaponBarrelUpgrade;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.KeyItems.KeyItem;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponEvolutions.WeaponEvolution;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades.WeaponUpgrade;

public class PurchasableTemplate extends Purchasable {
	//References
	private PurchasableType purchasableType;
	private Composite storedComposite;
	private CompositeArea compositeArea;
	private Weapon storedWeapon;
	private Accessory storedAccessory;
	private KeyItem storedKeyItem;
	//Attributes
	private int tier;
	private int cost;
	private int etheriumCost;
	//Constants
	private static final String TAG = "PurchasableTemplate";
	
	//Constructor
	public PurchasableTemplate(Composite storedComposite, CompositeArea compositeArea,
	PurchasableType purchasableType, int tier, int cost, int etheriumCost) {
		this.storedComposite = storedComposite;
		this.compositeArea = compositeArea;
		this.purchasableType = purchasableType;
		this.tier = tier;
		this.cost = cost;
		this.etheriumCost = etheriumCost;
	}
	public PurchasableTemplate(Weapon storedWeapon, PurchasableType purchasableType,
	int tier, int cost, int etheriumCost) {
		this.storedWeapon = storedWeapon;
		this.purchasableType = purchasableType;
		this.tier = tier;
		this.cost = cost;
		this.etheriumCost = etheriumCost;
	}
	public PurchasableTemplate(Accessory storedAccessory, PurchasableType purchasableType,
	int tier, int cost, int etheriumCost) {
		this.storedAccessory = storedAccessory;
		this.purchasableType = purchasableType;
		this.tier = tier;
		this.cost = cost;
		this.etheriumCost = etheriumCost;
	}
	public PurchasableTemplate(KeyItem storedKeyItem, PurchasableType purchasableType,
	int tier, int cost, int etheriumCost) {
		this.storedKeyItem = storedKeyItem;
		this.purchasableType = purchasableType;
		this.tier = tier;
		this.cost = cost;
		this.etheriumCost = etheriumCost;
	}
	
	//Purchasable Methods
	@Override
	public void activatePurchase() {
		switch (purchasableType) {
			case COMPOSITE_REPLACEMENT:
				switch (compositeArea) {
					case BODY:
						PlayerData.getInstance().replaceBody((Body)storedComposite);
						break;
					case ARMOR:
						PlayerData.getInstance().replaceArmor((Armor)storedComposite);
						break;
					case SHIELD:
						PlayerData.getInstance().replaceShield((Shield)storedComposite);
						break;
					case CORE:
						PlayerData.getInstance().replaceCore((Core)storedComposite);
						break;
					case SINGLE_WEAPON_BARREL:
						PlayerData.getInstance().replaceSingleWeaponBarrel((WeaponBarrel)storedComposite);
						break;
					case DOUBLE_WEAPON_BARREL:
						PlayerData.getInstance().replaceDoubleWeaponBarrel((WeaponBarrel)storedComposite);
						break;
					case LAUNCHER_WEAPON_BARREL:
						PlayerData.getInstance().replaceLauncherWeaponBarrel((WeaponBarrel)storedComposite);
						break;
					default:
						break;
				}
				break;
			case COMPOSITE_UPGRADE:
				switch (compositeArea) {
					case BODY:
						PlayerData.getInstance().upgradeBody((CompositeUpgrade)storedComposite);
						break;
					case ARMOR:
						PlayerData.getInstance().upgradeArmor((CompositeUpgrade)storedComposite);
						break;
					case SHIELD:
						PlayerData.getInstance().upgradeShield((CompositeUpgrade)storedComposite);
						break;
					case CORE:
						PlayerData.getInstance().upgradeCore((CompositeUpgrade)storedComposite);
						break;
					case SINGLE_WEAPON_BARREL:
						PlayerData.getInstance().upgradeSingleWeaponBarrel((WeaponBarrelUpgrade)storedComposite);
						break;
					case DOUBLE_WEAPON_BARREL:
						PlayerData.getInstance().upgradeDoubleWeaponBarrel((WeaponBarrelUpgrade)storedComposite);
						break;
					case LAUNCHER_WEAPON_BARREL:
						PlayerData.getInstance().upgradeLauncherWeaponBarrel((WeaponBarrelUpgrade)storedComposite);
						break;
					default:
						break;
				}
				break;
			case WEAPON_REPLACEMENT:
				PlayerData.getInstance().replaceWeaponInSlot(storedWeapon, weaponSlot);
				break;
			case WEAPON_UPGRADE:
				PlayerData.getInstance().upgradeWeaponInSlot((WeaponUpgrade)storedWeapon, weaponSlot);
				break;
			case WEAPON_EVOLUTION:
				PlayerData.getInstance().upgradeWeaponInSlot((WeaponEvolution)storedWeapon, weaponSlot);
				break;
			case SPECIAL_REPLACEMENT:
				PlayerData.getInstance().replaceSpecialWeapon(storedWeapon);
				break;
			case SPECIAL_UPGRADE:
				PlayerData.getInstance().upgradeSpecialWeapon((WeaponUpgrade)storedWeapon);
				break;
			case SPECIAL_EVOLUTION:
				PlayerData.getInstance().upgradeSpecialWeapon((WeaponEvolution)storedWeapon);
				break;
			case ACCESSORY:
				PlayerData.getInstance().addAccessory(storedAccessory);
				break;
			case KEY_ITEM:
				GameData.getInstance().addKeyItem(storedKeyItem);
				break;
			default:
				break;
		}
	}
	
	//Get Methods
	@Override
	public PurchasableType getType() {
		return purchasableType;
	}
	@Override
	public int getTier() {
		return tier;
	}
	@Override
	public int getCost() {
		return cost;
	}
	@Override
	public int getEtheriumCost() {
		return etheriumCost;
	}
	@Override
	public String getName() {
		switch (purchasableType) {
			case COMPOSITE_REPLACEMENT:
				return storedComposite.getName();
			case COMPOSITE_UPGRADE:
				Upgrade compUpgrade = (Upgrade)storedComposite;
				return compUpgrade.getUpgradeName();
			case WEAPON_REPLACEMENT:
				return storedWeapon.getName();
			case WEAPON_UPGRADE:
				Upgrade wepUpgrade = (Upgrade)storedWeapon;
				return wepUpgrade.getUpgradeName();
			case WEAPON_EVOLUTION:
				Upgrade wepEvolution = (Upgrade)storedWeapon;
				return wepEvolution.getUpgradeName();
			case SPECIAL_REPLACEMENT:
				return storedWeapon.getName();
			case SPECIAL_UPGRADE:
				Upgrade specialUpgrade = (Upgrade)storedWeapon;
				return specialUpgrade.getUpgradeName();
			case SPECIAL_EVOLUTION:
				Upgrade specialEvolution = (Upgrade)storedWeapon;
				return specialEvolution.getUpgradeName();
			case ACCESSORY:
				return storedAccessory.getName();
			case KEY_ITEM:
				return storedKeyItem.getName();
			default:
				return "";
		}
	}
	@Override
	public String getDetails() {
		switch (purchasableType) {
			case COMPOSITE_REPLACEMENT:
				return storedComposite.getDetails();
			case COMPOSITE_UPGRADE:
				Upgrade compUpgrade = (Upgrade)storedComposite;
				return compUpgrade.getUpgradeDetails();
			case WEAPON_REPLACEMENT:
				return storedWeapon.getDetails();
			case WEAPON_UPGRADE:
				Upgrade wepUpgrade = (Upgrade)storedWeapon;
				return wepUpgrade.getUpgradeDetails();
			case WEAPON_EVOLUTION:
				Upgrade wepEvolution = (Upgrade)storedWeapon;
				return wepEvolution.getUpgradeDetails();
			case SPECIAL_REPLACEMENT:
				return storedWeapon.getDetails();
			case SPECIAL_UPGRADE:
				Upgrade specialUpgrade = (Upgrade)storedWeapon;
				return specialUpgrade.getUpgradeDetails();
			case SPECIAL_EVOLUTION:
				Upgrade specialEvolution = (Upgrade)storedWeapon;
				return specialEvolution.getUpgradeDetails();
			case ACCESSORY:
				return storedAccessory.getDetails();
			case KEY_ITEM:
				return storedKeyItem.getDetails();
			default:
				return "";
		}
	}
}

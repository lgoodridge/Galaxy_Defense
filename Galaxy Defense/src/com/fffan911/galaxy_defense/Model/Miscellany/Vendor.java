package com.fffan911.galaxy_defense.Model.Miscellany;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.CompositeArea;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.FlashCCUAccessory;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonArmor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonBody;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonWeaponBarrel;
import com.fffan911.galaxy_defense.Model.Composites.Parts.EMCore;
import com.fffan911.galaxy_defense.Model.Composites.Parts.EMShield;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidArmor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidBody;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidCore;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidShield;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidWeaponBarrel;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableTemplate;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableType;
import com.fffan911.galaxy_defense.Model.Weapons.HomingMissile;
import com.fffan911.galaxy_defense.Model.Weapons.Laser;

public class Vendor {
	//Instance
	private static Vendor instance;
	//Purhcasable Arrays
	private ArrayList<Purchasable> allBodyPurchasables;
	private ArrayList<Purchasable> allArmorPurchasables;
	private ArrayList<Purchasable> allShieldPurchasables;
	private ArrayList<Purchasable> allCorePurchasables;
	private ArrayList<Purchasable> allSingleWeaponBarrelPurchasables;
	private ArrayList<Purchasable> allDoubleWeaponBarrelPurchasables;
	private ArrayList<Purchasable> allLauncherWeaponBarrelPurchasables;
	private ArrayList<Purchasable> allAccessoryPurchasables;
	private ArrayList<Purchasable> allLimitedEditionPurchasables;
	private ArrayList<Purchasable> allStandardWeaponPurchasables;
	private ArrayList<Purchasable> allSpecialWeaponPurchasables;
	
	//Singleton Constructor
	private Vendor() {
		constructBodyPurchasables();
		constructArmorPurchasables();
		constructShieldPurchasables();
		constructCorePurchasables();
		constructSingleWeaponBarrelPurchasables();
		constructDoubleWeaponBarrelPurchasables();
		constructLauncherWeaponBarrelPurchasables();
		constructAccessoryPurchasables();
		constructLimitedEditionPurchasables();
		constructStandardWeaponPurchasables();
		constructSpecialWeaponPurchasables();
	}
	
	//Singleton Method
	public static Vendor getInstance() {
		if (instance == null) {
			instance = new Vendor();
		}
		return instance;
	}
	
	//Construct Methods
	
	/* Template:
	 * public PurchasableTemplate(Composite storedComposite, CompositeArea compositeArea,
	 * PurchasableType purchasableType, int tier, int cost, int etheriumCost, int buttonIconID) */
	
	private final void constructBodyPurchasables() {
		allBodyPurchasables = new ArrayList<Purchasable>();
		allBodyPurchasables.add(new PurchasableTemplate(new VoidBody(), CompositeArea.BODY,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
		allBodyPurchasables.add(new PurchasableTemplate(new VoidBody(), CompositeArea.BODY,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 125000, 0));
		allBodyPurchasables.add(new PurchasableTemplate(new CarbonBody(), CompositeArea.BODY,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 5000, 200));
	}
	private final void constructArmorPurchasables() {
		allArmorPurchasables = new ArrayList<Purchasable>();
		allArmorPurchasables.add(new PurchasableTemplate(new VoidArmor(), CompositeArea.ARMOR,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
		allArmorPurchasables.add(new PurchasableTemplate(new CarbonArmor(), CompositeArea.ARMOR,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
	}
	private final void constructShieldPurchasables() {
		allShieldPurchasables = new ArrayList<Purchasable>();
		allShieldPurchasables.add(new PurchasableTemplate(new VoidShield(), CompositeArea.SHIELD,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
		allShieldPurchasables.add(new PurchasableTemplate(new EMShield(), CompositeArea.SHIELD,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 900));
	}
	private final void constructCorePurchasables() {
		allCorePurchasables = new ArrayList<Purchasable>();
		allCorePurchasables.add(new PurchasableTemplate(new VoidCore(), CompositeArea.CORE,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
		allCorePurchasables.add(new PurchasableTemplate(new EMCore(), CompositeArea.CORE,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
	}
	private final void constructSingleWeaponBarrelPurchasables() {
		allSingleWeaponBarrelPurchasables = new ArrayList<Purchasable>();
		allSingleWeaponBarrelPurchasables.add(new PurchasableTemplate(new VoidWeaponBarrel(BarrelType.SINGLE), CompositeArea.SINGLE_WEAPON_BARREL,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
		allSingleWeaponBarrelPurchasables.add(new PurchasableTemplate(new CarbonWeaponBarrel(BarrelType.SINGLE), CompositeArea.SINGLE_WEAPON_BARREL,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
	}
	private final void constructDoubleWeaponBarrelPurchasables() {
		allDoubleWeaponBarrelPurchasables = new ArrayList<Purchasable>();
		allDoubleWeaponBarrelPurchasables.add(new PurchasableTemplate(new VoidWeaponBarrel(BarrelType.DOUBLE), CompositeArea.DOUBLE_WEAPON_BARREL,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
		allDoubleWeaponBarrelPurchasables.add(new PurchasableTemplate(new CarbonWeaponBarrel(BarrelType.DOUBLE), CompositeArea.DOUBLE_WEAPON_BARREL,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
	}
	private final void constructLauncherWeaponBarrelPurchasables() {
		allLauncherWeaponBarrelPurchasables = new ArrayList<Purchasable>();
		allLauncherWeaponBarrelPurchasables.add(new PurchasableTemplate(new VoidWeaponBarrel(BarrelType.LAUNCHER), CompositeArea.LAUNCHER_WEAPON_BARREL,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
		allLauncherWeaponBarrelPurchasables.add(new PurchasableTemplate(new CarbonWeaponBarrel(BarrelType.LAUNCHER), CompositeArea.LAUNCHER_WEAPON_BARREL,
		PurchasableType.COMPOSITE_REPLACEMENT, 0, 0, 0));
	}
	private final void constructAccessoryPurchasables() {
		allAccessoryPurchasables = new ArrayList<Purchasable>();
		allAccessoryPurchasables.add(new PurchasableTemplate(new FlashCCUAccessory(),
		PurchasableType.ACCESSORY, 0, 5000, 0));
	}
	private final void constructLimitedEditionPurchasables() {
		allLimitedEditionPurchasables = new ArrayList<Purchasable>();
	}
	private final void constructStandardWeaponPurchasables() {
		allStandardWeaponPurchasables = new ArrayList<Purchasable>();
		allStandardWeaponPurchasables.add(new PurchasableTemplate(new Laser(),
		PurchasableType.WEAPON_REPLACEMENT, 0, 0, 0));
	}
	private final void constructSpecialWeaponPurchasables() {
		allSpecialWeaponPurchasables = new ArrayList<Purchasable>();
		allSpecialWeaponPurchasables.add(new PurchasableTemplate(new HomingMissile(),
		PurchasableType.SPECIAL_REPLACEMENT, 0, 0, 0));
	}
	
	//Refresh Methods
	public final void refreshPurchasables() {
		constructBodyPurchasables();
		constructArmorPurchasables();
		constructShieldPurchasables();
		constructCorePurchasables();
		constructSingleWeaponBarrelPurchasables();
		constructDoubleWeaponBarrelPurchasables();
		constructLauncherWeaponBarrelPurchasables();
		constructStandardWeaponPurchasables();
		constructSpecialWeaponPurchasables();
	}
	
	//Get Methods
	public List<Purchasable> getAvailableBodyPurchasables() {
		ArrayList<Purchasable> availableBodyPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allBodyPurchasables) {
			if (purchasable.isUnlocked()) availableBodyPurchasables.add(purchasable);
		}
		return availableBodyPurchasables;
	}
	public List<Purchasable> getAvailableArmorPurchasables() {
		ArrayList<Purchasable> availableArmorPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allArmorPurchasables) {
			if (purchasable.isUnlocked()) availableArmorPurchasables.add(purchasable);
		}
		return availableArmorPurchasables;
	}
	public List<Purchasable> getAvailableShieldPurchasables() {
		ArrayList<Purchasable> availableShieldPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allShieldPurchasables) {
			if (purchasable.isUnlocked()) availableShieldPurchasables.add(purchasable);
		}
		return availableShieldPurchasables;
	}
	public List<Purchasable> getAvailableCorePurchasables() {
		ArrayList<Purchasable> availableCorePurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allCorePurchasables) {
			if (purchasable.isUnlocked()) availableCorePurchasables.add(purchasable);
		}
		return availableCorePurchasables;
	}
	public List<Purchasable> getAvailableSingleWeaponBarrelPurchasables() {
		ArrayList<Purchasable> availableSingleWeaponBarrelPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allSingleWeaponBarrelPurchasables) {
			if (purchasable.isUnlocked()) availableSingleWeaponBarrelPurchasables.add(purchasable);
		}
		return availableSingleWeaponBarrelPurchasables;
	}
	public List<Purchasable> getAvailableDoubleWeaponBarrelPurchasables() {
		ArrayList<Purchasable> availableDoubleWeaponBarrelPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allDoubleWeaponBarrelPurchasables) {
			if (purchasable.isUnlocked()) availableDoubleWeaponBarrelPurchasables.add(purchasable);
		}
		return availableDoubleWeaponBarrelPurchasables;
	}
	public List<Purchasable> getAvailableLauncherWeaponBarrelPurchasables() {
		ArrayList<Purchasable> availableLauncherWeaponBarrelPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allLauncherWeaponBarrelPurchasables) {
			if (purchasable.isUnlocked()) availableLauncherWeaponBarrelPurchasables.add(purchasable);
		}
		return availableLauncherWeaponBarrelPurchasables;
	}
	public List<Purchasable> getAvailableAccessoryPurchasables() {
		ArrayList<Purchasable> availableAccessoryPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allAccessoryPurchasables) {
			if (purchasable.isUnlocked()  && !purchasable.alreadyPurchased()) availableAccessoryPurchasables.add(purchasable);
		}
		return availableAccessoryPurchasables;
	}
	public List<Purchasable> getAvailableLimitedEditionPurchasables() {
		ArrayList<Purchasable> availableLimitedEditionPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allLimitedEditionPurchasables) {
			if (purchasable.isUnlocked()  && !purchasable.alreadyPurchased()) availableLimitedEditionPurchasables.add(purchasable);
		}
		return availableLimitedEditionPurchasables;
	}
	public List<Purchasable> getAvailableStandardWeaponPurchasables() {
		ArrayList<Purchasable> availableStandardWeaponPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allStandardWeaponPurchasables) {
			if (purchasable.isUnlocked()) availableStandardWeaponPurchasables.add(purchasable);
		}
		return availableStandardWeaponPurchasables;
	}
	public List<Purchasable> getAvailableSpecialWeaponPurchasables() {
		ArrayList<Purchasable> availableSpecialWeaponPurchasables = new ArrayList<Purchasable>();
		for (Purchasable purchasable : allSpecialWeaponPurchasables) {
			if (purchasable.isUnlocked() && !purchasable.alreadyPurchased()) availableSpecialWeaponPurchasables.add(purchasable);
		}
		return availableSpecialWeaponPurchasables;
	}
}

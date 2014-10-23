package com.fffan911.galaxy_defense.Model.Composites.Parts;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.CompositeArea;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.ReinforcedArmorUpgrade;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableTemplate;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableType;

public class CarbonArmor extends Armor {
	//Constants
	private static final String TAG = "CarbonArmor";
	
	//Get Methods
	@Override
	public int getMaxArmorAddition() {
		return 300;
	}
	@Override
	public float getMaxArmorMultiplier() {
		return 1.0f;
	}
	@Override
	public float getMaxSpeedAddition() {
		return 0;
	}
	@Override
	public float getMaxSpeedMultiplier() {
		return 1.0f;
	}
	@Override
	public Composite getBaseComposite() {
		return this;
	}
	@Override
	public int getTier() {
		return 1;
	}
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		ArrayList<Purchasable> purchasableUpgrades = new ArrayList<Purchasable>();
		
		Purchasable reinforcedArmorUpgrade = new PurchasableTemplate(new ReinforcedArmorUpgrade(), CompositeArea.ARMOR,
		PurchasableType.COMPOSITE_UPGRADE, 0, 0, 0);
		purchasableUpgrades.add(reinforcedArmorUpgrade);
		
		return purchasableUpgrades;
	}
	@Override
	public String getName() {
		return "Carbon Armor";
	}
	@Override
	public String getSummary() {
		return "A protective layer of armor made out of carbon fiber. " +
		"Standard issue on most extraterrestial ships.";
	}
	@Override
	public String getSpecialEffectsDescription() {
		return "No Special Effects";
	}
	@Override
	public String getUpgradeFlowChart() {
		return "Base";
	}
}

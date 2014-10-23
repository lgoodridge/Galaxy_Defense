package com.fffan911.galaxy_defense.Model.Weapons.WeaponEvolutions;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableTemplate;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableType;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades.SpeedReducerWeaponUpgrade;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class FluxCannon extends WeaponEvolution {
	//Constants
	private static final String TAG = "FluxCannon";
	
	//Constructor
	public FluxCannon(Weapon innerWeapon, Ship innerShip) {
		super(innerWeapon, innerShip);
	}
	public FluxCannon(Weapon innerWeapon) {
		super(innerWeapon);
	}
	public FluxCannon() {
		super();
	}
	
	//Upgrade Methods
	@Override
	public int getBaseDamage() {
		return super.getBaseDamage() + 100;
	}
	@Override
	public float getBaseSpeed() {
		return super.getBaseSpeed() + 150.0f;
	}
	@Override
	public String getUpgradeFlowChartName() {
		return "Evolution: Flux Cannon";
	}
	@Override
	public String getUpgradeSummary() {
		return "Evolves Plasma Cannon into Flux Cannon";
	}
	public String getUpgradeEffectsDescription() {
		return "Significantly increases the speed and damage potential of the plasma cannon.";
	}
	
	//Evolution Methods
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		ArrayList<Purchasable> purchasableUpgrades = new ArrayList<Purchasable>();
		
		Purchasable speedReducerUpgrade = new PurchasableTemplate(new SpeedReducerWeaponUpgrade(),
		PurchasableType.WEAPON_UPGRADE, 0, 250, 0);
		purchasableUpgrades.add(speedReducerUpgrade);
		
		return purchasableUpgrades;
	}
	@Override
	public List<Purchasable> getPurchasableEvolutions() {
		ArrayList<Purchasable> purchasableEvolutions = new ArrayList<Purchasable>();
		return purchasableEvolutions;
	}
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		Bitmap[] bitmapArray = new Bitmap[2];
		bitmapArray[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.flux_cannon), getWidth(), getHeight(), true);
		bitmapArray[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.flux_cannon_two), getWidth(), getHeight(), true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return 50;
	}
	@Override
	public int getButtonIconID() {
		return R.drawable.flux_cannon_icon;
	}
	@Override
	public Weapon getBaseWeapon() {
		return this;
	}
	@Override
	public String getName() {
		return "Flux Cannon";
	}
	@Override
	public String getSummary() {
		return "A double barreled cannon that shoots overcharged plasma beams.";
	}
}

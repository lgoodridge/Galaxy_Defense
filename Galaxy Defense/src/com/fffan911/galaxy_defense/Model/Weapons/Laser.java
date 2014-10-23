package com.fffan911.galaxy_defense.Model.Weapons;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableTemplate;
import com.fffan911.galaxy_defense.Model.Purchasables.PurchasableType;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponEvolutions.FluxCannon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades.SpeedReducerWeaponUpgrade;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class Laser extends Weapon {
	//Constants
	private static final String TAG = "Laser";
	
	//Constructor
	public Laser(Ship ship) {
		super(ship);
	}
	public Laser() {
		super();
	}
	
	//Construct Method
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		ArrayList<Purchasable> purchasableUpgrades = new ArrayList<Purchasable>();
		
		Purchasable speedReducerUpgrade = new PurchasableTemplate(new SpeedReducerWeaponUpgrade(),
		PurchasableType.WEAPON_UPGRADE, 0, 0, 0);
		purchasableUpgrades.add(speedReducerUpgrade);
				
		return purchasableUpgrades;
	}
	
	//Get Methods
	@Override
	public BarrelType getRequiredBarrelType() {
		return BarrelType.SINGLE;
	}
	@Override
	public int getBaseDamage() {
		return 100;
	}
	@Override
	public int getBaseReloadTime() {
		return 300;
	}
	@Override
	public float getBaseSpeed() {
		return 400.0f;
	}
	@Override
	public float getBaseAcceleration() {
		return 1.0f;
	}
	@Override
	public float getBaseDamageMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseReloadTimeMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseSpeedMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseAccelerationMultiplier() {
		return 1.0f;
	}
	@Override
	public int getWidth() {
		return 20;
	}
	@Override
	public int getHeight() {
		return 40;
	}
	@Override
	public int getTier() {
		return 1;
	}
	@Override
	public List<Purchasable> getPurchasableEvolutions() {
		ArrayList<Purchasable> purchasableEvolutions = new ArrayList<Purchasable>();
		
		Purchasable fluxCannonEvolution = new PurchasableTemplate(new FluxCannon(),
		PurchasableType.WEAPON_EVOLUTION, 0, 500, 0);
		purchasableEvolutions.add(fluxCannonEvolution);
		
		return purchasableEvolutions;
	}
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		Bitmap[] bitmapArray = new Bitmap[2];
		bitmapArray[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.laser), getWidth(), getHeight(), true);
		bitmapArray[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.laser_two), getWidth(), getHeight(), true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return 50;
	}
	@Override
	public int getButtonIconID() {
		return R.drawable.laser_icon;
	}
	@Override
	public Weapon getBaseWeapon() {
		return this;
	}
	@Override
	public String getName() {
		return "Laser";
	}
	@Override
	public String getSummary() {
		return "A simple laser. The most basic firearm this side of the galaxy.";
	}
	@Override
	public String getSpecialEffectsDescription() {
		return "No Special Effects";
	}
	@Override
	public String getUpgradeFlowChart() {
		return "Base: Laser";
	}
}

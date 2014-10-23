package com.fffan911.galaxy_defense.Model.Weapons;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class PlasmaCannon extends Weapon {
	//Constants
	private static final String TAG = "PlasmaCannon";
	
	//Constructor
	public PlasmaCannon(Ship ship) {
		super(ship);
	}
	public PlasmaCannon() {
		super();
	}
	
	//Construct Method
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		ArrayList<Purchasable> purchasableUpgrades = new ArrayList<Purchasable>();
		return purchasableUpgrades;
	}
	
	//Get Methods
	@Override
	public BarrelType getRequiredBarrelType() {
		return BarrelType.DOUBLE;
	}
	@Override
	public int getBaseDamage() {
		return 150;
	}
	@Override
	public int getBaseReloadTime() {
		return 500;
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
		return purchasableEvolutions;
	}
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		Bitmap[] bitmapArray = new Bitmap[2];
		bitmapArray[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.plasma_cannon), getWidth(), getHeight(), true);
		bitmapArray[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.plasma_cannon_two), getWidth(), getHeight(), true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return 50;
	}
	@Override
	public int getButtonIconID() {
		return R.drawable.plasma_cannon_icon;
	}
	@Override
	public Weapon getBaseWeapon() {
		return this;
	}
	@Override
	public String getName() {
		return "Plasma Cannon";
	}
	@Override
	public String getSummary() {
		return "A double barreled cannon that shoots concentrated plasma beams.";
	}
	@Override
	public String getSpecialEffectsDescription() {
		return "No Special Effects";
	}
	@Override
	public String getUpgradeFlowChart() {
		return "Base: Plasma Cannon";
	}
}

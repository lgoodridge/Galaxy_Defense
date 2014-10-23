package com.fffan911.galaxy_defense.Model.Actors;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.Accessory;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonArmor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonBody;
import com.fffan911.galaxy_defense.Model.Composites.Parts.CarbonWeaponBarrel;
import com.fffan911.galaxy_defense.Model.Composites.Parts.EMCore;
import com.fffan911.galaxy_defense.Model.Composites.Parts.EMShield;
import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.ExtendedBarrelWeaponBarrelUpgrade;
import com.fffan911.galaxy_defense.Model.Composites.Upgrades.ReinforcedArmorUpgrade;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Weapons.SpecialWeapon;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.Utility.Animation;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class PlayerShip extends Ship {
	//Attributes
	private boolean isShooting;
	private long specialReloadTimeRemaining;
	//Constants
	public static final int SIZE = 80;
	private static final long SPECIAL_RELOAD_TIME = 3000l;
	private static final String TAG = "PlayerShip";
	
	//Constructor
	public PlayerShip(GamePanel panel) {
		super(panel, panel.getPlayerShipStartingPosition());
		equipWeapon(getOwnedWeapons()[0]);
		this.isShooting = false;
		this.specialReloadTimeRemaining = 0l;
	}
	
	//Construct Methods
	@Override
	public final Composite constructBody() {
		return PlayerData.getInstance().getEquippedBody();
	}
	@Override
	public final Composite constructArmor() {
		return PlayerData.getInstance().getEquippedArmor();
	}
	@Override
	public final Composite constructShield() {
		return PlayerData.getInstance().getEquippedShield();
	}
	@Override
	public final Composite constructCore() {
		return PlayerData.getInstance().getEquippedCore();
	}
	@Override
	public final WeaponBarrel[] constructWeaponBarrels() {
		WeaponBarrel[] weaponBarrels = new WeaponBarrel[4];
		weaponBarrels[0] = PlayerData.getInstance().getEquippedSingleWeaponBarrel();
		weaponBarrels[1] = PlayerData.getInstance().getEquippedDoubleWeaponBarrel();
		weaponBarrels[2] = PlayerData.getInstance().getEquippedLauncherWeaponBarrel();
		weaponBarrels[3] = PlayerData.getInstance().getVoidWeaponBarrel();
		return (WeaponBarrel[])weaponBarrels;
	}
	@Override
	public final Weapon[] constructOwnedWeapons() {
		Weapon[] ownedWeapons = PlayerData.getInstance().getAllOwnedWeapons();
		for (int i = 0; i < ownedWeapons.length; i++) {
			if (ownedWeapons[i] != null) ownedWeapons[i].setOwnerShip(this);
		}
		return ownedWeapons;
	}
	@Override
	public final ArrayList<Accessory> constructAccessories() {
		return PlayerData.getInstance().getAllOwnedAccessories();
	}
	
	//Actor Methods
	@Override
	public void update(long updateTimeDiff) {
		super.update(updateTimeDiff);
		if (isShooting) shoot();
		for (WeaponBarrel weaponBarrel : getAllWeaponBarrels()) {
			weaponBarrel.remReloadTime((int)updateTimeDiff);
		}
		remSpecialReloadTimeRemaining(updateTimeDiff);
		PlayerData.getInstance().updatePlayerHealthData(getHealth(), 
		getArmor(), getShields());
		PlayerData.getInstance().updatePlayerHealthPercentageData(getHealthPercentage(),
		getArmorPercentage(), getShieldsPercentage());
	}
	@Override
	public void deref(){
		super.deref();
		getPanel().unlinkPlayerShip();
		for (int i = 0; i < getOwnedWeapons().length; i++) {
			if (getOwnedWeapons()[i] != null) getOwnedWeapons()[i].setOwnerShip(null);
		}
		PlayerData.getInstance().clearPlayerHealthData();
	}
	@Override
	public void handleCollision(Actor actor) {}
	@Override
	public void handleBoundsCollision(String edge) {
		if (edge.equals("Left")) {
			getPosition().setX(getPanel().getLeft() + getWidth()/2);
		} 
		if (edge.equals("Right")) {
			getPosition().setX(getPanel().getRight() - getWidth()/2);
		}
		if (edge.equals("Top")) {
			getPosition().setY(getPanel().getTop() + getHeight()/2);
		}
		if (edge.equals("Bottom")) {
			getPosition().setY(getPanel().getBottom() - getHeight()/2);
		}
	}
	
	//Ship Methods
	@Override
	public void shoot() {
		if (getEquippedWeaponBarrel().isReadyToFire()) {
			super.shoot();
			getEquippedWeaponBarrel().addReloadTime(getEquippedWeapon().getReloadTime());
		}
	}
	public void shootSpecialWeapon() {
		if (PlayerData.getInstance().hasSpecialsRemaining() && isSpecialWeaponReady()) {
			Log.d(TAG, "Firing Special Weapon!");
			shootSpecialWeapon(PlayerData.getInstance().getSpecialWeapon());
			setSpecialReloadTimeRemaining(SPECIAL_RELOAD_TIME);
			PlayerData.getInstance().remSpecialsRemaining(1);
		}
	}
	
	//Add + Remove Methods
	private void remSpecialReloadTimeRemaining(long amount) {
		specialReloadTimeRemaining -= amount;
		if (specialReloadTimeRemaining < 0) specialReloadTimeRemaining = 0;
	}
	
	//Boolean Methods
	public boolean isShooting() {
		return isShooting;
	}
	public boolean isSpecialWeaponReady() {
		return specialReloadTimeRemaining == 0l;
	}
	
	//Set Methods
	public void setIsShooting(boolean bool) {
		isShooting = bool;
	}
	public void setSpecialReloadTimeRemaining(long timeRemaining) {
		specialReloadTimeRemaining = timeRemaining;
	}
	
	//Ship Get Methods
	@Override
	public int getBaseMaxHealth() {
		return 0;
	}
	@Override
	public int getBaseMaxArmor() {
		return 0;
	}
	@Override
	public int getBaseMaxShields() {
		return 0;
	}
	@Override
	public int getBaseShieldDelay() {
		return 0;
	}
	@Override
	public int getBaseShieldRechargeRate() {
		return 0;
	}
	@Override
	public float getBaseMaxHealthMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseMaxArmorMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseMaxShieldsMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseShieldDelayMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseShieldRechargeRateMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseMaxSpeed() {
		return 200.0f;
	}
	@Override
	public float getBaseMaxSpeedMultiplier() {
		return 1.0f;
	}
	@Override
	public int getBaseWeaponDamageAddition() {
		return 0;
	}
	@Override
	public int getBaseWeaponReloadTimeReduction() {
		return 0;
	}
	@Override
	public float getBaseWeaponSpeedAddition() {
		return 0;
	}
	@Override
	public float getBaseWeaponAccelerationAddition() {
		return 0;
	}
	@Override
	public float getBaseWeaponDamageMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseWeaponReloadTimeMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseWeaponSpeedMultiplier() {
		return 1.0f;
	}
	@Override
	public float getBaseWeaponAccelerationMultiplier() {
		return 1.0f;
	}
	
	//Actor Get Methods
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		Bitmap[] bitmapArray = new Bitmap[1];
		bitmapArray[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.player_ship), SIZE, SIZE, true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return Animation.SINGLE_FRAME;
	}
	@Override
	public int getScoreValue() {
		return 0;
	}
	@Override
	public String getName() {
		return "Player Ship";
	}
	@Override
	public String getDescription() {
		return "Your Ship.";
	}
}

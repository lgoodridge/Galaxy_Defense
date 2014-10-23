package com.fffan911.galaxy_defense.Model.Weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Actors.Actor;
import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Actors.WeaponActor;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Utility.Animation;
import com.fffan911.galaxy_defense.Utility.MathUtility;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class HomingMissile extends SpecialWeapon {
	//Attributes
	private Enemy target;
	private boolean isHoming;
	private long calibrationPeriod;
	//Constants
	private static final long CALIBRATION_TIME = 500l;
	private static final String TAG = "HomingMissile";
	
	//Constructor
	public HomingMissile(Ship ship) {
		super(ship);
		this.isHoming = false;
		this.calibrationPeriod = CALIBRATION_TIME;
	}
	public HomingMissile() {
		super();
		this.isHoming = false;
		this.calibrationPeriod = CALIBRATION_TIME;
	}
	
	//Construct Method
	@Override
	public List<Purchasable> constructPurchasableUpgrades() {
		ArrayList<Purchasable> purchasableUpgrades = new ArrayList<Purchasable>();
		return purchasableUpgrades;
	}
	
	//Actor Methods
	@Override
	public void update(long updateTimeDiff, WeaponActor weaponActor) {
		//If the missile is still calibrating - don't do anything
		if (isCalibrating()) {
			calibrationPeriod -= updateTimeDiff;
			if (calibrationPeriod < 0) calibrationPeriod = 0;
			return;
		}
		//If we don't have a target - search for one
		if (isHoming == false) {
			Map<Enemy, Double> targetsMap = new HashMap<Enemy, Double>();
			for (Actor onscreenActor : weaponActor.getPanel().getLinkedActors()) {
				if (onscreenActor instanceof Enemy) {
					Enemy onscreenEnemy = (Enemy) onscreenActor;
					//NOTE: The missile wants to track the LOWEST score
					double score = weaponActor.distanceFrom(onscreenEnemy) / onscreenEnemy.getTier();
					targetsMap.put(onscreenEnemy, score);
				}
			}
			if (targetsMap.isEmpty()) return;
			double bestScore = Collections.min(targetsMap.values());
			for (Enemy potentialTarget : targetsMap.keySet()) {
				if (targetsMap.get(potentialTarget) == bestScore) {
					isHoming = true;
					target = potentialTarget;
					weaponActor.getAnimation().setCurrentFrameNumber(2);
				}
			}
		// If we have a target
		} else {
			//But the target got unlinked somehow - start searching for another one
			if (!weaponActor.getPanel().isActorLinked(target)) {
				isHoming = false;
				target = null;
				weaponActor.getAnimation().setCurrentFrameNumber(1);
			//Track the target
			} else {
				float dX = target.getX() - weaponActor.getX();
				float dY = weaponActor.getY() - target.getY();
				float degrees = MathUtility.displacementToDegrees(dX, dY);
				weaponActor.getPosition().rotateTo(degrees, 400.0f);
				weaponActor.getPosition().moveTo(target.getX(), target.getY());
			}
		}
	}
	
	//Action Methods
	@Override
	public void launchSpecialAttack(Ship ship) {
		ship.shoot();
	}
	
	//Boolean Methods
	private boolean isCalibrating() {
		return calibrationPeriod > 0l;
	}
	
	//Weapon Stats Methods
	@Override
	public int getBaseDamage() {
		return 1000;
	}
	@Override
	public float getBaseSpeed() {
		return 100.0f;
	}
	@Override
	public float getBaseAcceleration() {
		return 400.0f;
	}
	@Override
	public float getBaseDamageMultiplier() {
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
		return 30;
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
		(panel.getResources(), R.drawable.homing_missile_one), getWidth(), getHeight(), true);
		bitmapArray[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.homing_missile_two), getWidth(), getHeight(), true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return Animation.SINGLE_FRAME;
	}
	@Override
	public Weapon getBaseWeapon() {
		return this;
	}
	@Override
	public String getName() {
		return "Homing Missile";
	}
	@Override
	public String getSummary() {
		return "A missile with an advanced targeting system. Searches for and homes in " +
		"on selected targets";
	}
	@Override
	public String getSpecialEffectsDescription() {
		return "Homes in on enemies";
	}
	@Override
	public String getUpgradeFlowChart() {
		return "Base: Homing Missile";
	}
}

package com.fffan911.galaxy_defense.Model.Actors.Enemies;

import java.util.ArrayList;
import java.util.HashMap;

import com.fffan911.galaxy_defense.Model.Actors.Actor;
import com.fffan911.galaxy_defense.Model.Actors.Ship;
import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.AIs.AI;
import com.fffan911.galaxy_defense.Model.Composites.AIs.AsteroidsAI;
import com.fffan911.galaxy_defense.Model.Composites.AIs.BattleAI;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.Accessory;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidArmor;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidBody;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidCore;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidShield;
import com.fffan911.galaxy_defense.Model.Composites.Parts.VoidWeaponBarrel;
import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Data.GameState;
import com.fffan911.galaxy_defense.Model.Miscellany.Leveler;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public abstract class Enemy extends Ship {
	//References
	private AI equippedAI;
	//Attributes
	private int level;
	
	//Constructor
	public Enemy(GamePanel panel, Position initialPosition, int level){
		super(panel, initialPosition);
		this.equippedAI = constructAI();
		this.level = level;
		addHealth(getHealthDeficit());
		addArmor(getArmorDeficit());
		addShields(getShieldsDeficit());
	}
	public Enemy(GamePanel panel, Position initialPosition) {
		this(panel, initialPosition, 1);
	}
	
	//Construct Methods
	public final AI constructAI() {
		if (GameData.getInstance().getGameState() == GameState.ASTEROIDS) {
			return constructAsteroidsAI();
		} else {
			return constructBattleAI();
		}
	}
	@Override
	public Composite constructBody() {
		return new VoidBody();
	}
	@Override
	public Composite constructArmor() {
		return new VoidArmor();
	}
	@Override
	public Composite constructShield() {
		return new VoidShield();
	}
	@Override
	public Composite constructCore() {
		return new VoidCore();
	}
	@Override
	public Weapon[] constructOwnedWeapons() {
		return Leveler.getInstance().getOwnedWeaponsAtLevel(getOwnedWeaponTemplate(), level);
	}
	@Override
	public WeaponBarrel[] constructWeaponBarrels() {
		WeaponBarrel[] weaponBarrels = new WeaponBarrel[BarrelType.values().length];
		for (int i = 0; i < BarrelType.values().length; i++) {
			weaponBarrels[i] = new VoidWeaponBarrel(BarrelType.values()[i]);
		}
		return weaponBarrels;
	}
	@Override
	public ArrayList<Accessory> constructAccessories() {
		return new ArrayList<Accessory>();
	}
	
	//Actor Methods
	@Override
	public void update(long updateTimeDiff) {
		super.update(updateTimeDiff);
		equippedAI.update(updateTimeDiff);
	}
	@Override
	public void handleCollision(Actor actor) {
		equippedAI.handleCollision(actor);
	}
	@Override
	public void handleBoundsCollision(String edge) {
		equippedAI.handleBoundsCollision(edge);
	}
	@Override
	public void deref() {
		super.deref();
		equippedAI.deref();
		GameData.getInstance().addScore(getScoreValue());
	}
	
	//Set Methods
	public void setEquippedAI(AI newAI) {
		equippedAI = newAI;
	}
	
	//Get Methods
	public AI getEquipppedAI() {
		return equippedAI;
	}
	public int getLevel() {
		return level;
	}
	
	/* Tell enemy weapons to go in opposite direction */
	@Override
	public float[] getWeaponInitialPosition(Weapon weapon) {
		return calculateWeaponInitialPositionInfo(weapon, getPosition().getDegrees() + 180.0f);
	}
	@Override
	public float[][] getDoubleWeaponInitialPosition(Weapon weapon) {
		return calculateDoubleWeaponInitialPositionInfo(weapon, 
		getPosition().getDegrees() + 180.0f);
	}
	
	//Get Stat Base Methods
	public int getBaseMaxHealth() {
		return Leveler.getInstance().getStatAtLevel(getBaseMaxHealthTemplate(), level);
	}
	public int getBaseMaxArmor() {
		return Leveler.getInstance().getStatAtLevel(getBaseMaxArmorTemplate(), level);
	}
	public int getBaseMaxShields() {
		return Leveler.getInstance().getStatAtLevel(getBaseMaxShieldsTemplate(), level);
	}
	public int getBaseShieldDelay() {
		return Leveler.getInstance().getStatAtLevel(getBaseShieldDelayTemplate(), level);
	}
	public int getBaseShieldRechargeRate() {
		return Leveler.getInstance().getStatAtLevel(getBaseShieldRechargeRateTemplate(), level);
	}
	public float getBaseMaxHealthMultiplier() {
		return 1.0f;
	}
	public float getBaseMaxArmorMultiplier() {
		return 1.0f;
	}
	public float getBaseMaxShieldsMultiplier() {
		return 1.0f;
	}
	public float getBaseShieldDelayMultiplier() {
		return 1.0f;
	}
	public float getBaseShieldRechargeRateMultiplier() {
		return 1.0f;
	}
	//Get Other Stat Base Methods
	public float getBaseMaxSpeed() {
		return Leveler.getInstance().getStatAtLevel(getBaseMaxSpeedTemplate(), level);
	}
	public float getBaseMaxSpeedMultiplier() {
		return 1.0f;
	}
	//Get Weapon Stat Modifier Methods
	public int getBaseWeaponDamageAddition() {
		return Leveler.getInstance().getStatAtLevel(getBaseWeaponDamageAdditionTemplate(), level);
	}
	public int getBaseWeaponReloadTimeReduction() {
		return Leveler.getInstance().getStatAtLevel(getBaseWeaponReloadTimeReductionTemplate(), level);
	}
	public float getBaseWeaponSpeedAddition() {
		return Leveler.getInstance().getStatAtLevel(getBaseWeaponSpeedAdditionTemplate(), level);
	}
	public float getBaseWeaponAccelerationAddition() {
		return Leveler.getInstance().getStatAtLevel(getBaseWeaponAccelerationAdditionTemplate(), level);
	}
	public float getBaseWeaponDamageMultiplier() {
		return 1.0f;
	}
	public float getBaseWeaponReloadTimeMultiplier() {
		return 1.0f;
	}
	public float getBaseWeaponSpeedMultiplier() {
		return 1.0f;
	}
	public float getBaseWeaponAccelerationMultiplier() {
		return 1.0f;
	}
	public int getScoreValue() {
		return Leveler.getInstance().getScoreValueAtLevel(getBaseScoreValue(), level);
	}
	
	//Abstract Methods
	public abstract AsteroidsAI constructAsteroidsAI();
	public abstract BattleAI constructBattleAI();
	public abstract HashMap<Weapon, Integer> getOwnedWeaponTemplate();
	public abstract int[] getBaseMaxHealthTemplate();
	public abstract int[] getBaseMaxArmorTemplate();
	public abstract int[] getBaseMaxShieldsTemplate();
	public abstract int[] getBaseShieldDelayTemplate();
	public abstract int[] getBaseShieldRechargeRateTemplate();
	public abstract float[] getBaseMaxSpeedTemplate();
	public abstract int[] getBaseWeaponDamageAdditionTemplate();
	public abstract int[] getBaseWeaponReloadTimeReductionTemplate();
	public abstract float[] getBaseWeaponSpeedAdditionTemplate(); 
	public abstract float[] getBaseWeaponAccelerationAdditionTemplate();
	public abstract int getBaseScoreValue();
	public abstract int getTier();
}

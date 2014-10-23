package com.fffan911.galaxy_defense.Model.Actors;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;

import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class WeaponActor extends Actor{
	//References
	private Weapon weapon;
	private Actor lastHitActor;
	//Constants
	private static final String TAG = "WeaponActor";
	
	//Constructor
	public WeaponActor(){
		setMatrix(new Matrix());
		lastHitActor = null;
	}
	
	//Initialize Methods
	public final void initializeOnPanel(Weapon weapon, GamePanel panel, 
	Position initialPosition) {
		setWeapon(weapon);
		setPanel(panel);
		setPosition(initialPosition);
		setAnimation(constructAnimation(panel));
		setLastHitActor(weapon.getOwnerShip());
		panel.linkActor(this);
	}
	
	//Collision Methods
	@Override
	public void handleCollision(Actor actor){
		weapon.handleCollision(this, actor);
		setLastHitActor(actor);
	}
	@Override
	public void handleBoundsCollision(String edge){
		deref();
	}
	
	//Actor Methods
	@Override
	public void update(long updateTimeDiff) {
		super.update(updateTimeDiff);
		weapon.update(updateTimeDiff, this);
	}
	
	//Set Methods
	private void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public final void setLastHitActor(Actor newActor) {
		this.lastHitActor = newActor;
	}
	
	//Get Methods
	public Weapon getWeapon(){
		return weapon;
	}
	public Actor getLastHitActor() {
		return lastHitActor;
	}
	
	//Actor Get Methods
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		return weapon.getAnimationBitmaps(panel);
	}
	@Override
	public int getAnimationFramePeriod() {
		return weapon.getAnimationFramePeriod();
	}
	@Override
	public int getScoreValue() {
		return 0;
	}
	@Override
	public String getName() {
		return weapon.getName();
	}
	@Override
	public String getDescription() {
		return weapon.getSummary();
	}
}

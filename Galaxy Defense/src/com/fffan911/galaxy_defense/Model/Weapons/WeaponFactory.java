package com.fffan911.galaxy_defense.Model.Weapons;

import android.util.Log;

import com.fffan911.galaxy_defense.Model.Actors.WeaponActor;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class WeaponFactory {
	//Instance
	private static WeaponFactory instance;
	//References
	private WeaponActor[] weaponActors;
	private Position[] positions;
	//Attributes
	private int currIndex;
	//Constants
	private static final int NUM_ACTORS = 99;
	private static final String TAG = "WeaponFactory";
	
	//Singleton Constructor
	private WeaponFactory() {
		weaponActors = new WeaponActor[NUM_ACTORS];
		positions = new Position[NUM_ACTORS];
		for (int i = 0; i < NUM_ACTORS; i++) { 
			weaponActors[i] = new WeaponActor();
			positions[i] = new Position(0, 0);
		}
		currIndex = 0;
	}
	
	//Singleton Method
	public static WeaponFactory getInstance() {
		if (instance == null) {
			instance = new WeaponFactory();
		}
		return instance;
	}
	
	//Factory Methods
	public synchronized void createWeaponActor(Weapon weapon, GamePanel panel, float[] posInfo) {
		loadPositionInfo(posInfo);
		weaponActors[currIndex].initializeOnPanel((Weapon)weapon.clone(), panel, positions[currIndex]);
		incIndex();
	}
	public synchronized void createDoubleWeaponActor(Weapon weapon, GamePanel panel,
	float[][] posInfo) {
		float[] leftPosInfo = posInfo[0];
		float[] rightPosInfo = posInfo[1];
		loadPositionInfo(leftPosInfo);
		incIndex();
		loadPositionInfo(rightPosInfo);
		decIndex();
		weaponActors[currIndex].initializeOnPanel(weapon, panel, positions[currIndex]);
		incIndex();
		weaponActors[currIndex].initializeOnPanel(weapon, panel, positions[currIndex]);
		incIndex();
	}
	
	//Load Methods
	public void loadPositionInfo(float[] posInfo) {
		positions[currIndex].setX((int)(posInfo[0]));
		positions[currIndex].setY((int)(posInfo[1]));
		positions[currIndex].setXSpeed(posInfo[2]);
		positions[currIndex].setYSpeed(posInfo[3]);
		positions[currIndex].setXAcceleration(posInfo[4]);
		positions[currIndex].setYAcceleration(posInfo[5]);
		positions[currIndex].setDegrees(posInfo[6]);
	}
	
	//Inc and Dec Methods
	public void incIndex() {
		currIndex++;
		if (currIndex >= NUM_ACTORS) currIndex = 0;
	}
	public void decIndex() {
		currIndex--;
		if (currIndex < 0) currIndex = NUM_ACTORS - 1;
	}
}

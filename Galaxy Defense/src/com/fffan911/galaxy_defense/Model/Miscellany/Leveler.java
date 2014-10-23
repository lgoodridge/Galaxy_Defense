package com.fffan911.galaxy_defense.Model.Miscellany;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

import com.fffan911.galaxy_defense.Model.Weapons.Weapon;

public class Leveler {
	//Instance
	private static Leveler instance;
	
	//Singleton Constructor
	private Leveler() {}
	
	//Singleton Methods
	public static Leveler getInstance() {
		if (instance == null) {
			instance = new Leveler();
		}
		return instance;
	}
	
	//Leveling Methods
	public int getScoreValueAtLevel(int base, int level) {
		float multiplierAddition = level / 10.0f;
		float multiplier = 1.0f + multiplierAddition;
		return (int)(base * multiplier);
	}
	public int getStatAtLevel(int[] template, int level) {
		int singlesDigit = level % 10;
		int doublesDigit = level / 10;
		if (doublesDigit >= template.length-1) return template[template.length-1];
		int gap = template[doublesDigit + 1] - template[doublesDigit];
		int singleLevelIncrement = gap / 10;
		int stat = template[doublesDigit];
		for (int i = 0; i < singlesDigit; i++) stat += singleLevelIncrement;
		return stat;
	}
	public float getStatAtLevel(float[] template, int level) {
		int singlesDigit = level % 10;
		int doublesDigit = level / 10;
		if (doublesDigit >= template.length-1) return template[template.length-1];
		float gap = template[doublesDigit + 1] - template[doublesDigit];
		float singleLevelIncrement = gap / 10;
		float stat = template[doublesDigit];
		for (int i = 0; i < singlesDigit; i++) stat += singleLevelIncrement;
		return stat;
	}
	public Weapon[] getOwnedWeaponsAtLevel(HashMap<Weapon, Integer> template, int level) {
		ArrayList<Weapon> weaponAL = new ArrayList<Weapon>();
		for (Weapon weapon : template.keySet()) {
			if (template.get(weapon) <= level) weaponAL.add(weapon);
		}
		Weapon[] weaponArray = new Weapon[weaponAL.size()];
		for (int i = 0; i < weaponAL.size(); i++) {
			weaponArray[i] = (Weapon)(weaponAL.get(i));
		}
		return weaponArray;
	}
}

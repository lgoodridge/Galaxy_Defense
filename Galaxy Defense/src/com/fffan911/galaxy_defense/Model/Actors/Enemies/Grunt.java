package com.fffan911.galaxy_defense.Model.Actors.Enemies;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Composites.AIs.AsteroidsAI;
import com.fffan911.galaxy_defense.Model.Composites.AIs.BattleAI;
import com.fffan911.galaxy_defense.Model.Composites.AIs.StandardAsteroidsAI;
import com.fffan911.galaxy_defense.Model.Composites.AIs.StandardBattleAI;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Weapons.Beam;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class Grunt extends Enemy {
	//Constants
	private static final String TAG = "Grunt";
	
	//Constructor
	public Grunt(GamePanel panel, Position initialPosition, int level) {
		super(panel, initialPosition, level);
	}
	public Grunt(GamePanel panel, Position initialPosition) {
		super(panel, initialPosition);
	}
	
	//Construct Methods
	@Override
	public AsteroidsAI constructAsteroidsAI() {
		return new StandardAsteroidsAI(this);
	}
	@Override
	public BattleAI constructBattleAI() {
		return new StandardBattleAI(this);
	}
	@Override
	public HashMap<Weapon, Integer> getOwnedWeaponTemplate() {
		HashMap<Weapon, Integer> template = new HashMap<Weapon, Integer>();
		template.put(new Beam(this), 0);
		return template;
	}
	@Override
	public int[] getBaseMaxHealthTemplate() {
		int[] template =  {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100};
		return template;
	}
	@Override
	public int[] getBaseMaxArmorTemplate() {
		int[] template =  {0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 500};
		return template;
	}
	@Override
	public int[] getBaseMaxShieldsTemplate() {
		int[] template =  {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		return template;
	}
	@Override
	public int[] getBaseShieldDelayTemplate() {
		int[] template =  {5000, 4900, 4800, 4700, 4600, 4500, 4400, 4300, 4200, 4100, 4000};
		return template;
	}
	@Override
	public int[] getBaseShieldRechargeRateTemplate() {
		int[] template =  {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		return template;
	}
	@Override
	public float[] getBaseMaxSpeedTemplate() {
		float[] template =  {100.0f, 110.0f, 120.0f, 130.0f, 140.0f, 150.0f,
		160.0f, 170.0f, 180.0f, 190.0f, 200.0f};
		return template;
	}
	@Override
	public int[] getBaseWeaponDamageAdditionTemplate() {
		int[] template =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		return template;
	}
	@Override
	public int[] getBaseWeaponReloadTimeReductionTemplate() {
		int[] template =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		return template;
	}
	@Override
	public float[] getBaseWeaponSpeedAdditionTemplate() {
		float[] template =  {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
		return template;
	}
	@Override
	public float[] getBaseWeaponAccelerationAdditionTemplate() {
		float[] template =  {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
		return template;
	}
	@Override
	public int getBaseScoreValue() {
		return 500;
	}
	@Override
	public int getTier() {
		return 1;
	}
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		Bitmap[] bitmapArray = new Bitmap[2];
		bitmapArray[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.grunt), 60, 50, true);
		bitmapArray[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.grunt_two), 60, 50, true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return 500;
	}
	@Override
	public String getName() {
		return "Grunt";
	}
	@Override
	public String getDescription() {
		return "A mere grunt in the invader forces. Weak and unimpressive.";
	}
}

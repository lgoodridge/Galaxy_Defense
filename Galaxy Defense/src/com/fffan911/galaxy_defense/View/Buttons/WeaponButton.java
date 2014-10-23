package com.fffan911.galaxy_defense.View.Buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.WeaponButtonController;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;

public class WeaponButton extends Button{
	//References
	private Controller controller;
	private Weapon storedWeapon;
	//Attributes
	private boolean hasBeenInitialized;
	private static int instanceNum = 1;
	//Constants
	private final static int MAX_WEAPON_BUTTONS = 6;
	private final static String TAG = "WeaponButton";
	
	//Constructor
	public WeaponButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.hasBeenInitialized = false;
		setController(new WeaponButtonController(this));
		setText("WEP " + instanceNum);
		storeWeapon(PlayerData.getInstance().getWeaponFromSlot(instanceNum));
		incInstanceNum();
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me){
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Draw Methods
	@Override
	protected void onDraw(Canvas canvas) {
		if(!hasBeenInitialized) {
			if (hasStoredWeapon()) {
				setupBackground();
				setupWeaponIcon();
			}
			hasBeenInitialized = true;
		}
		super.onDraw(canvas);
	}
	
	//Setup Methods
	public void setupBackground() {
		BarrelType barrelType = storedWeapon.getRequiredBarrelType();
		int drawableID = R.drawable.yellow_button_background;
		if (barrelType == BarrelType.SINGLE) drawableID = R.drawable.blue_button_background;
		if (barrelType == BarrelType.DOUBLE) drawableID = R.drawable.green_button_background;
		if (barrelType == BarrelType.LAUNCHER) drawableID = R.drawable.purple_button_background;
		setBackgroundDrawable(getResources().getDrawable(drawableID));
	}
	public void setupWeaponIcon() {
		setText("");
		int buttonIconID = storedWeapon.getButtonIconID();
		Bitmap buttonIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(getResources(), buttonIconID), getWidth() * 7 / 10, getHeight(), true);
		BitmapDrawable buttonIconDrawable = new BitmapDrawable(getResources(), buttonIconBitmap);
		setCompoundDrawablesWithIntrinsicBounds(buttonIconDrawable, null, null, null);
	}
	
	//Store Methods
	public void storeWeapon(Weapon weapon) {
		if (weapon == null) return;
		setStoredWeapon(weapon);
	}
	
	//Inc + Dec Methods
	private final void incInstanceNum(){
		instanceNum++;
		if (instanceNum > MAX_WEAPON_BUTTONS) instanceNum = 1;
	}
	
	//Boolean Methods
	public boolean hasStoredWeapon() {
		return storedWeapon != null;
	}
	
	//Set Methods
	private final void setController(Controller controller){
		this.controller = controller;
	}
	private final void setStoredWeapon(Weapon weapon) {
		this.storedWeapon = weapon;
	}
	
	//Get Methods
	public Weapon getStoredWeapon() {
		return storedWeapon;
	}
}

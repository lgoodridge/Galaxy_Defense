package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.InformationButtonController;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.widget.Button;

public class InformationButton extends Button {
	//References
	private Controller controller;
	private String informationText;
	private Weapon storedWeapon;
	private boolean hasBeenInitialized;
	//Constants
	private static final String TAG = "InformationButton";
	
	//Constructors
	public InformationButton(Context context, String informationText, 
	String displayString) {
		super(context);
		setController(new InformationButtonController(this));
		setInformationText(informationText);
		setupBackground(displayString);
		setText(displayString);
		this.hasBeenInitialized = true;
	}
	public InformationButton(Context context, String informationText,
	Weapon weapon) {
		super(context);
		setController(new InformationButtonController(this));
		setInformationText(informationText);
		setupBackground(weapon);
		this.storedWeapon = weapon;
		this.hasBeenInitialized = false;
	}
	public InformationButton(Context context, String displayString) {
		this(context, "", displayString);
	}
	public InformationButton(Context context, Weapon weapon) {
		this(context, "", weapon);
	}
	
	//Draw Methods
	@Override
	protected void onDraw(Canvas canvas) {
		if (!hasBeenInitialized) {
			if (hasStoredWeapon()) {
				setupWeaponIcon(storedWeapon);
			}
			hasBeenInitialized = true;
		}
		super.onDraw(canvas);
	}
	
	//Setup Methods
	public void setupBackground(String displayString) {
		int drawableID = R.drawable.purple_button_background;
		if (displayString.equals("SHIP")) drawableID = R.drawable.purple_button_background;
		if (displayString.equals("PARTS")) drawableID = R.drawable.green_button_background;
		if (displayString.equals("SPECIAL")) drawableID = R.drawable.blue_button_background;
		setBackgroundDrawable(getResources().getDrawable(drawableID));
	}
	public void setupBackground(Weapon weapon) {
		BarrelType barrelType = weapon.getRequiredBarrelType();
		int drawableID = R.drawable.yellow_button_background;
		if (barrelType == BarrelType.SINGLE) drawableID = R.drawable.blue_button_background;
		if (barrelType == BarrelType.DOUBLE) drawableID = R.drawable.green_button_background;
		if (barrelType == BarrelType.LAUNCHER) drawableID = R.drawable.purple_button_background;
		setBackgroundDrawable(getResources().getDrawable(drawableID));
	}
	public void setupWeaponIcon(Weapon weapon) {
		setText("");
		int buttonIconID = weapon.getButtonIconID();
		Bitmap buttonIconBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(getResources(), buttonIconID), getWidth() * 7 / 10, getHeight(), true);
		BitmapDrawable buttonIconDrawable = new BitmapDrawable(getResources(), buttonIconBitmap);
		setCompoundDrawablesWithIntrinsicBounds(buttonIconDrawable, null, null, null);
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Boolean Methods
	public boolean hasStoredWeapon() {
		return storedWeapon != null;
	}
		
	
	//Set Methods
	private final void setController(Controller controller) {
		this.controller = controller;
	}
	public void setInformationText(String informationText) {
		this.informationText = informationText;
	}
	
	//Get Methods
	public String getInformationText() {
		return informationText;
	}
	public Weapon getStoredWeapon() {
		return storedWeapon;
	}
}

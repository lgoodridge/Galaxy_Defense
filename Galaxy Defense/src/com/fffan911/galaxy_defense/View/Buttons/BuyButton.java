package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.BuyButtonController;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class BuyButton extends Button {
	//References
	private Controller controller;
	private Purchasable storedPurchasable;
	private boolean hasWeaponPurchasableStored;
	//Constants
	private static final String TAG = "BuyButton";
	
	//Constructor
	public BuyButton(Context context) {
		super(context);
		setController(new BuyButtonController(this));
		setText("Buy");
		setBackgroundDrawable(getResources().getDrawable(R.drawable.yellow_button_background));
		storedPurchasable = null;
		hasWeaponPurchasableStored = false;
	}
	public BuyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new BuyButtonController(this));
		setText("Buy");
		setBackgroundDrawable(getResources().getDrawable(R.drawable.yellow_button_background));
		storedPurchasable = null;
		hasWeaponPurchasableStored = false;
	}
	public BuyButton(Context context, Purchasable purchasable) {
		this(context);
		setStoredPurchasable(purchasable);
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private final void setController(Controller controller) {
		this.controller = controller;
	}
	public void setStoredPurchasable(Purchasable purchasable) {
		this.storedPurchasable = purchasable;
	}
	public void setHasWeaponPurchasableStored(boolean bool) {
		this.hasWeaponPurchasableStored = bool;
	}
	
	//Boolean Methods
	public boolean hasWeaponPurchasableStored() {
		return hasWeaponPurchasableStored;
	}
	
	//Get Methods
	public Purchasable getStoredPurchasable() {
		return storedPurchasable;
	}
}

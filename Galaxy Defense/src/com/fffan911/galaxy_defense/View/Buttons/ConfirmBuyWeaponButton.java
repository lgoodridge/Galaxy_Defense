package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.ConfirmBuyWeaponButtonController;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class ConfirmBuyWeaponButton extends Button {
	//References
	private Controller controller;
	private Purchasable storedPurchasable;
	//Constants
	private static final String TAG = "ConfirmBuyWeaponButton";
	
	//Constructor
	public ConfirmBuyWeaponButton(Context context) {
		super(context);
		setController(new ConfirmBuyWeaponButtonController(this));
		setText("Confirm");
		storedPurchasable = null;
	}
	public ConfirmBuyWeaponButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new ConfirmBuyWeaponButtonController(this));
		setText("Confirm");
		storedPurchasable = null;
	}
	public ConfirmBuyWeaponButton(Context context, Purchasable purchasable) {
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
	
	//Get Methods
	public Purchasable getStoredPurchasable() {
		return storedPurchasable;
	}
}

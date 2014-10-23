package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintUIProxy;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;

public class SpecialButtonController extends Controller {
	//Constants
	private final static String TAG = "SpecialButtonController";
	
	//Constructor
	public SpecialButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			BlueprintProxyUser bpu = (BlueprintProxyUser)(getView().getContext());
			BlueprintUIProxy blueprintUIProxy = bpu.getUIProxy();
			PlayerShip playerShip = blueprintUIProxy.getDisplayPanel().getPlayerShip();
			PlayerData.getInstance().addSpecialsRemaining(1);
			playerShip.shootSpecialWeapon();
		} 
		return true;
	}
}

package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintUIProxy;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;

public class BlueprintFireButtonController extends Controller {
	//Constants
	private final static String TAG = "BlueprintFireButtonController";
	
	//Constructor
	public BlueprintFireButtonController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			BlueprintProxyUser bpu = (BlueprintProxyUser)(getView().getContext());
			BlueprintUIProxy blueprintUIProxy = bpu.getUIProxy();
			PlayerShip playerShip = blueprintUIProxy.getDisplayPanel().getPlayerShip();
			if (playerShip != null) playerShip.setIsShooting(true);
		} else if (me.getAction() == MotionEvent.ACTION_UP) {
			BlueprintProxyUser bpu = (BlueprintProxyUser)(getView().getContext());
			BlueprintUIProxy blueprintUIProxy = bpu.getUIProxy();
			PlayerShip playerShip = blueprintUIProxy.getDisplayPanel().getPlayerShip();
			if (playerShip != null) playerShip.setIsShooting(false);
		}
		return true;
	}
}

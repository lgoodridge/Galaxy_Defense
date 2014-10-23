package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class HealthBarController extends Controller{
	//Constants
	private static final String TAG = "HealthBarController";
	
	//Constructor
	public HealthBarController(View view){
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me){
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			//Damage Player Ship
			GameProxyUser gpu = (GameProxyUser)(getView().getContext());
			GamePanel panel = gpu.getUIProxy().getGamePanel();
			if (!panel.playerShipExists()) return true;
			panel.getPlayerShip().damage(10);
		}
		return true;
	}
}

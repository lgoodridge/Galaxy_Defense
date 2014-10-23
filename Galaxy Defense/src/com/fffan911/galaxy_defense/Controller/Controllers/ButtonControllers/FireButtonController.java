package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GameUIProxy;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Miscellany.OnPauseListener;

public class FireButtonController extends Controller implements OnPauseListener{
	//Constants
	private final static String TAG = "FireButtonController";
	
	//Constructor
	public FireButtonController(View view){
		super(view);
		GameData.getInstance().addOnPauseListener(this);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			GameProxyUser gpu = (GameProxyUser)(getView().getContext());
			GameUIProxy gameUIProxy = gpu.getUIProxy();
			PlayerShip playerShip = gameUIProxy.getGamePanel().getPlayerShip();
			if (playerShip != null) playerShip.setIsShooting(true);
		} else if (me.getAction() == MotionEvent.ACTION_UP) {
			GameProxyUser gpu = (GameProxyUser)(getView().getContext());
			GameUIProxy gameUIProxy = gpu.getUIProxy();
			PlayerShip playerShip = gameUIProxy.getGamePanel().getPlayerShip();
			if (playerShip != null) playerShip.setIsShooting(false);
		}
		return true;
	}
	
	//OnPauselistener Methods
	@Override
	public void onPause() {
		getView().setEnabled(false);
	}
	@Override
	public void onUnpause() {
		getView().setEnabled(true);
	}
}

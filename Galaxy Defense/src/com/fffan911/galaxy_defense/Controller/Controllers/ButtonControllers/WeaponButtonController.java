package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GameUIProxy;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Miscellany.OnPauseListener;
import com.fffan911.galaxy_defense.View.Buttons.WeaponButton;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class WeaponButtonController extends Controller implements OnPauseListener{
	//Constants
	private final static String TAG = "WeaponButtonController";
	
	//Constructor
	public WeaponButtonController(View view){
		super(view);
		GameData.getInstance().addOnPauseListener(this);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		//Ensure Game is not Paused
		if (GameData.getInstance().isPaused()) return true;
		//Process Touch Event
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			WeaponButton weaponButton = (WeaponButton)(getView());
			if (!weaponButton.hasStoredWeapon()) return true;
			GameProxyUser gpu = (GameProxyUser)(getView().getContext());
			GameUIProxy gameUIProxy = gpu.getUIProxy();
			GamePanel panel = gameUIProxy.getGamePanel();
			if (!panel.playerShipExists()) return true;
			panel.getPlayerShip().equipWeapon(weaponButton.getStoredWeapon());
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

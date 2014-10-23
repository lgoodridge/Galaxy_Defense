package com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintUIProxy;
import com.fffan911.galaxy_defense.View.Buttons.InformationButton;

public class InformationButtonController extends Controller {
	//Constants
	private static final String TAG = "InformationButtonController";
	
	//Constructor
	public InformationButtonController(View view) {
		super(view);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d(TAG, "Touched.");
			InformationButton informationButton = (InformationButton)(getView());
			BlueprintProxyUser blueprintProxyUser = (BlueprintProxyUser)(getView().getContext());
			BlueprintUIProxy blueprintUIProxy = blueprintProxyUser.getUIProxy();
			blueprintUIProxy.getInformationTextView().setText(informationButton.getInformationText());
			if (informationButton.getStoredWeapon() != null) blueprintUIProxy.getDisplayPanel().
			getPlayerShip().equipWeapon(informationButton.getStoredWeapon());
		}
		return true;
	}
}

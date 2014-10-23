package com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers;

import android.content.Context;
import android.view.MenuItem;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuUIProxy;

public class MainMenuMenuController extends MenuController {
	//Constants
	private static final String TAG = "MainMenuMenuController";
	
	//Constructor
	public MainMenuMenuController(Context context){
		super(context);
	}
	
	//Menu Controller Method
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		MainMenuProxyUser mainMenuProxyUser = (MainMenuProxyUser)(getContext());
		MainMenuProxy mainMenuProxy = mainMenuProxyUser.getProxy();
		MainMenuUIProxy mainMenuUIProxy = mainMenuProxyUser.getUIProxy();
		switch (menuItem.getItemId()) {
		case R.id.credits_menu_item:
			mainMenuUIProxy.displayCreditsPopup();
			break;
		case R.id.exit_app_menu_item:
			mainMenuProxy.exitApp();
			break;
		default:
			logMenuItemNotHandledMessage();
		}
		return true;
	}
}

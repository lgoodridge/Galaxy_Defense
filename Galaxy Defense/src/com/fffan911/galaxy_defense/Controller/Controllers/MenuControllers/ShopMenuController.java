package com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericUIProxy;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;

import android.content.Context;
import android.view.MenuItem;

public class ShopMenuController extends MenuController {
	//Constants
	private static final String TAG = "ShopMenuController";
	
	//Constructor
	public ShopMenuController(Context context){
		super(context);
	}
	
	//Menu Controller Method
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		GenericProxyUser genericProxyUser = (GenericProxyUser)(getContext());
		GenericProxy genericProxy = genericProxyUser.getProxy();
		switch (menuItem.getItemId()) {
		case R.id.save_menu_item:
			logMenuItemNotHandledMessage();
			break;
		case R.id.main_menu_menu_item:
			genericProxy.switchToMainMenu();
			break;
		case R.id.exit_app_menu_item:
			genericProxy.exitApp();
			break;
		default:
			logMenuItemNotHandledMessage();
		}
		return true;
	}
}

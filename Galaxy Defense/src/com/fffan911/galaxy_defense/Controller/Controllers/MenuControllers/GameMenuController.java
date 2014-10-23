package com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers;

import android.content.Context;
import android.view.MenuItem;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Activities.GameActivity;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericUIProxy;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;

public class GameMenuController extends MenuController {
	//Constants
	private static final String TAG = "GameMenuController";
	
	//Constructor
	public GameMenuController(Context context){
		super(context);
	}
	
	//Menu Controller Method
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		GenericProxyUser genericProxyUser = (GenericProxyUser)(getContext());
		GenericProxy genericProxy = genericProxyUser.getProxy();
		GenericUIProxy genericUIProxy = genericProxyUser.getUIProxy();
		switch (menuItem.getItemId()) {
		case R.id.options_menu_item:
			genericUIProxy.displayOptionsPopup();
			break;
		case R.id.controls_menu_item:
			genericUIProxy.displayControlsPopup();
			break;
		case R.id.save_menu_item:
			logMenuItemNotHandledMessage();
			break;
		case R.id.main_menu_menu_item:
			StageManager.getInstance().stopCurrentStage();
			genericProxy.switchToMainMenu();
			break;
		case R.id.exit_app_menu_item:
			StageManager.getInstance().stopCurrentStage();
			genericProxy.exitApp();
			break;
		default:
			logMenuItemNotHandledMessage();
		}
		return true;
	}
}

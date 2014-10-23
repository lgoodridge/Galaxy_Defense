package com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;

public abstract class MenuController {
	//References
	private Context context;
	//Constants
	private static final String TAG = "MenuController";
	
	//Constructor
	public MenuController(Context context){
		this.context = context;
	}
	
	//Get Methods
	public Context getContext(){
		return context;
	}
	
	//Log Methods
	public void logMenuItemNotHandledMessage(){
		Log.e(TAG, "ERROR: Menu Item not expected by controller. Failed to Handle.");
	}
	
	//Abstract Methods
	public abstract boolean onOptionsItemSelected(MenuItem menuItem);
}

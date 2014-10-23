package com.fffan911.galaxy_defense.Controller.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers.MainMenuMenuController;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.MainMenuUIProxy;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;

public class MainMenuActivity extends Activity implements MainMenuProxyUser {
	//References
	private MainMenuMenuController menuController;
	private MainMenuProxy mainMenuProxy;
	private MainMenuUIProxy mainMenuUIProxy;
	//Constants
	private static final String TAG = "MainMenuActivity";
	
	//Constructor
	public MainMenuActivity(){
		super();
	}
	
	//Necessary Activity Methods
	@Override
	public void onCreate(Bundle savedInstanceState){
		//Setup Activity
		Log.d(TAG, "Creating Main Menu Activity...");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//Init References
		menuController = new MainMenuMenuController(this);
		mainMenuProxy = new MainMenuProxy(this);
		mainMenuUIProxy = new MainMenuUIProxy(this);
		//Set Content View
		setContentView(R.layout.main_menu_layout);
		//Update Stage Manager
		StageManager.getInstance().setCurrentActivity(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + " Menu...");
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main_menu_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return menuController.onOptionsItemSelected(item);
	}
	@Override
    public void onDestroy(){
    	Log.d(TAG, "Destroying Main Menu Activity...");
    	mainMenuUIProxy.closeAllPopups();
    	super.onDestroy();
    }
    public void onStop(){
    	Log.d(TAG, "Stopping Main Menu Activity...");
    	super.onStop();
    }
	
	//Get Methods
    @Override
    public MainMenuProxy getProxy(){
    	return mainMenuProxy;
    }
    @Override
	public MainMenuUIProxy getUIProxy(){
		return mainMenuUIProxy;
	}
}

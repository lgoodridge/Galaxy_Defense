package com.fffan911.galaxy_defense.Controller.Activities;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers.BlueprintMenuController;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintUIProxy;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class BlueprintActivity extends FragmentActivity implements BlueprintProxyUser {
	//References
	private BlueprintMenuController menuController;
	private BlueprintProxy blueprintProxy;
	private BlueprintUIProxy blueprintUIProxy;
	//Constants
	private static final String TAG = "BlueprintActivity";
	
	//FragmentActivity Methods
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//Setup Activity
		Log.d(TAG, "Creating Blueprint Activity...");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//Init References
		menuController = new BlueprintMenuController(this);
		blueprintProxy = new BlueprintProxy(this);
		blueprintUIProxy = new BlueprintUIProxy(this);
		//Set Content View
		setContentView(R.layout.blueprint_layout);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + " Menu...");
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.blueprint_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return menuController.onOptionsItemSelected(item);
	}
	@Override
	public void onDestroy(){
		Log.d(TAG, "Destroying " + getClass().getSimpleName() + "...");
		blueprintUIProxy.closeAllPopups();
		super.onDestroy();
	}
	@Override
	public void onStop(){
		Log.d(TAG, "Stopping " + getClass().getSimpleName() + "...");
		super.onStop();
	}
	
	//Get Methods
	public BlueprintProxy getProxy() {
		return blueprintProxy;
	}
	public BlueprintUIProxy getUIProxy() {
		return blueprintUIProxy;
	}
}

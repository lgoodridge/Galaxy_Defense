package com.fffan911.galaxy_defense.Controller.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers.MenuController;
import com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers.ShopMenuController;
import com.fffan911.galaxy_defense.Controller.Fragments.ShopMiscellanyFragment;
import com.fffan911.galaxy_defense.Controller.Fragments.ShopShipFragment;
import com.fffan911.galaxy_defense.Controller.Fragments.ShopWeaponsFragment;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.ShopUIProxy;
import com.fffan911.galaxy_defense.Model.Miscellany.TabManager;

public class ShopActivity extends FragmentActivity implements ShopProxyUser {
	//Tab Management Objects
	private TabHost tabHost;
	private TabManager tabManager;
	//References
	private MenuController menuController;
	private ShopProxy shopProxy;
	private ShopUIProxy shopUIProxy;
	//Constants
	private static final String TAG = "ShopActivity";
	
	//Necessary Activity Methods
	@Override
	protected void onCreate(Bundle savedInstanceState){
		Log.d(TAG, "Creating Shop Activity...");
		super.onCreate(savedInstanceState);
		
		//Some Options
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.shop_layout);
		
		//Init References
		menuController = new ShopMenuController(this);
		shopProxy = new ShopProxy(this);
		shopUIProxy = new ShopUIProxy(this);
		
		//Setting Up Tabhost
		tabHost = (TabHost)findViewById(android.R.id.tabhost);
		tabHost.setup();
		
		//Setting Up Tabs
		tabManager = new TabManager(this, tabHost, R.id.realtabcontent);
		tabManager.addTab(tabHost.newTabSpec("Ship").setIndicator("Ship",
				getResources().getDrawable(R.drawable.ic_tab_ship)),
				ShopShipFragment.class, null);
		tabManager.addTab(tabHost.newTabSpec("Weapons").setIndicator("Weapons", 
				getResources().getDrawable(R.drawable.ic_tab_weapons)),
				ShopWeaponsFragment.class, null);
		tabManager.addTab(tabHost.newTabSpec("Miscellany").setIndicator("Misc.",
				getResources().getDrawable(R.drawable.ic_tab_miscellany)),
				ShopMiscellanyFragment.class, null);
		
		if (savedInstanceState != null) {
			tabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}
	}
	@Override
	protected void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putString("tab", tabHost.getCurrentTabTag());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + " Menu...");
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.shop_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return menuController.onOptionsItemSelected(item);
	}
	@Override
	protected void onDestroy(){
		Log.d(TAG, "Destroying Shop Activity...");
		super.onDestroy();
	}
	@Override
	protected void onStop(){
		Log.d(TAG, "Stopping Shop Activity...");
		super.onStop();
	}
	
	//Refresh Methods
	@Override
	public void refreshCurrentTab() {
		switch(tabHost.getCurrentTab()) {
			case 0:
				refreshShipTab();
				break;
			case 1:
				refreshWeaponsTab();
				break;
			case 2:
				refreshMiscellanyTab();
				break;
		}
	}
	@Override
	public void refreshShipTab() {
		tabHost.setCurrentTab(2);
		tabHost.setCurrentTab(0);
	}
	@Override
	public void refreshWeaponsTab() {
		tabHost.setCurrentTab(2);
		tabHost.setCurrentTab(1);
	}
	@Override
	public void refreshMiscellanyTab() {
		tabHost.setCurrentTab(1);
		tabHost.setCurrentTab(2);
	}
	
	//Generic Proxy User Methods
	@Override
	public ShopProxy getProxy() {
		return shopProxy;
	}
	@Override
	public ShopUIProxy getUIProxy() {
		return shopUIProxy;
	}
}

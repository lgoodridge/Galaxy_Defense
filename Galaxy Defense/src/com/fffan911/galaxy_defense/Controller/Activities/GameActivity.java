package com.fffan911.galaxy_defense.Controller.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.MenuControllers.GameMenuController;
import com.fffan911.galaxy_defense.Controller.Proxies.GameProxy;
import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GameUIProxy;

public abstract class GameActivity extends FragmentActivity implements GameProxyUser {
	//References
	private GameMenuController menuController;
	private GameProxy gameProxy;
	private GameUIProxy gameUIProxy;
	//Multi-touch Attributes
	private int mlPointer;
	private int slPointer;
	private int mlLastAction;
	private int slLastAction;
	//Constants
	private final static String TAG = "GameActivity";
	
	//FragmentActivity methods
	@Override
	public void onCreate(Bundle savedInstanceState){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + "...");
		super.onCreate(savedInstanceState);
		//Set Some Options
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//Init References
		menuController = new GameMenuController(this);
		gameProxy = new GameProxy(this);
		gameUIProxy = new GameUIProxy(this);
		//Init Multi-touch Attributes
		mlPointer = -1;
		slPointer = -1;
		mlLastAction = -1;
		slLastAction = -1;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + " Menu...");
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.game_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return menuController.onOptionsItemSelected(item);
	}
	@Override
	public void onDestroy(){
		Log.d(TAG, "Destroying " + getClass().getSimpleName() + "...");
		gameUIProxy.closeAllPopups();
		super.onDestroy();
	}
	@Override
	public void onStop(){
		Log.d(TAG, "Stopping " + getClass().getSimpleName() + "...");
		super.onStop();
	}
	
	//Enabling Multitouch
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		//Setting up Layout and Event Variables
		ViewGroup mainLayout = getMainLayout();
		ViewGroup sideLayout = getSideLayout();
		
		int div = mainLayout.getWidth();
		int count = ev.getPointerCount();
		
		//TargetPointer - whether the pointer that changed is the first or second finger
		int targetPointer = 0;
		int action = ev.getActionMasked();
		
		//If its the second finger, change the action + set targetPointer
		if (action == MotionEvent.ACTION_POINTER_UP){
			action = MotionEvent.ACTION_UP;
			targetPointer = 1;
		}
		if (action == MotionEvent.ACTION_POINTER_DOWN){
			action = MotionEvent.ACTION_DOWN;
			targetPointer = 1;
		}
		
		//If we have multitouch, update the one that changed, other one gets its last action
		if (count >= 2) {
			//If ml changed
			if (mlPointer == targetPointer) {
				mainLayout.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(),
				System.currentTimeMillis(), action, ev.getX(mlPointer), 
				ev.getY(mlPointer), 0));
				sideLayout.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(),
				System.currentTimeMillis(), slLastAction, ev.getX(slPointer) - div, 
				ev.getY(slPointer), 0));
				mlLastAction = action;
			//If sl changed
			} else {
				mainLayout.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(),
				System.currentTimeMillis(), mlLastAction, ev.getX(mlPointer), 
				ev.getY(mlPointer), 0));
				sideLayout.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(),
				System.currentTimeMillis(), action, ev.getX(slPointer) - div, 
				ev.getY(slPointer), 0));
				slLastAction = action;
			}
			return true;
		}
		
		//For single touch:
		
		//If touch is on ml side
		if (ev.getX() <= div){
			mlPointer = 0;
			slPointer = 1;
			
			mainLayout.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(),
			System.currentTimeMillis(), ev.getActionMasked(), ev.getX(), ev.getY(), 
			0));
			
			mlLastAction = action;
		//If touch is on sl side
		} else {
			mlPointer = 1;
			slPointer = 0;
			
			sideLayout.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(),
			System.currentTimeMillis(), ev.getActionMasked(), ev.getX() - div, ev.getY(), 
			0));
			
			slLastAction = action;
		}
		
	    return true;
	}
	
	//Get Methods
	@Override
	public GameProxy getProxy(){
		return gameProxy;
	}
	@Override
	public GameUIProxy getUIProxy(){
		return gameUIProxy;
	}
	
	//Abstract Methods
	public abstract ViewGroup getMainLayout();
	public abstract ViewGroup getSideLayout();
}

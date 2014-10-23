package com.fffan911.galaxy_defense.Controller.Activities;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Weapons.Laser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class TitleScreenActivity extends Activity {
	//Constants
	private static final String TAG = "TitleScreenActivity";
	
	//Constructor
	public TitleScreenActivity(){
		super();
	}
	
	//Necessary Activity Methods
	@Override
	public void onCreate(Bundle savedInstanceState){
		Log.d(TAG, "Creating Title Screen Activity...");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.title_screen_layout);
	}
	@Override
    public void onDestroy(){
    	Log.d(TAG, "Destroying Title Screen Activity...");
    	super.onDestroy();
    }
    public void onStop(){
    	Log.d(TAG, "Stopping Title Screen Activity...");
    	super.onStop();
    }
}

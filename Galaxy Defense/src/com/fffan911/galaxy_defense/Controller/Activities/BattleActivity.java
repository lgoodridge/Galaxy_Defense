package com.fffan911.galaxy_defense.Controller.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class BattleActivity extends GameActivity {
	//Constants
	private static final String TAG = "BattleActivity";
	
	//Activity Methods
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_layout);
		//Update StageManager
		Log.d(TAG, "Updating Stage Manager...");
		StageManager.getInstance().setCurrentActivity(this);
	}
	
	//GameActivity Methods
	@Override
	public ViewGroup getMainLayout(){
		return (ViewGroup)findViewById(R.id.battle_fragment);
	}
	@Override
	public ViewGroup getSideLayout(){
		return (ViewGroup)findViewById(R.id.battle_side_fragment);
	}
}

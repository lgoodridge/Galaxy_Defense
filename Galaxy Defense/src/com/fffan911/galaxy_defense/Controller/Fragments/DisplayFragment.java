package com.fffan911.galaxy_defense.Controller.Fragments;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintUIProxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DisplayFragment extends Fragment {
	//Constants
	private static final String TAG = "DisplayFragment";
	
	//Fragment Methods
	@Override
	public void onCreate(Bundle savedInstanceState){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + "...");
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	Bundle savedInstanceState){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + " View...");
		super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.display_fragment_layout, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		Log.d(TAG, "Parent Activity successfully created...");
		super.onActivityCreated(savedInstanceState);
		//Create the ship for the display panel
		BlueprintProxyUser bpu = (BlueprintProxyUser)(getActivity());
		BlueprintUIProxy blueprintUIProxy = bpu.getUIProxy();
		blueprintUIProxy.getDisplayPanel().createPlayerShip();
		//blueprintUIProxy.getDisplayPanel().linkActor
		//(blueprintUIProxy.getDisplayPanel().getPlayerShip());
	}
	@Override
	public void onDestroy(){
		Log.d(TAG, "Destroying " + getClass().getSimpleName() + "...");
		super.onDestroy();
	}
	@Override
	public void onStop(){
		Log.d(TAG, "Stopping " + getClass().getSimpleName() + "...");
		super.onStop();
	}
	
}

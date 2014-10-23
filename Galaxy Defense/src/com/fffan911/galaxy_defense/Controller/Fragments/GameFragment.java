package com.fffan911.galaxy_defense.Controller.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class GameFragment extends Fragment {
	//Constants
	private static final String TAG = "GameFragment";
	
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
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		Log.d(TAG, "Parent Activity successfully created...");
		super.onActivityCreated(savedInstanceState);
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
